package io.flogo.builder;

import io.flogo.builder.model.ExperimentArchitecture;
import io.flogo.builder.model.FlogoDTO;
import io.flogo.builder.model.architecture.ArchitectureView;
import io.flogo.builder.model.laboratory.ExperimentView;
import io.flogo.builder.model.laboratory.LaboratoryView;
import io.flogo.builder.model.renderers.architecture.ArchitectureViewRenderer;
import io.flogo.builder.model.renderers.laboratory.LaboratoryViewRenderer;
import io.flogo.builder.operations.FlogoRenderer;
import io.flogo.model.FlogoGraph;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import static io.intino.tara.builder.shared.TaraBuildConstants.PRESENTABLE_MESSAGE;

public class FlogoCompiler {
    private final CompilerConfiguration configuration;
    private final List<CompilerMessage> collector;
    private static final Logger LOG = Logger.getGlobal();
    private static final int Name = 0;
    private static final int FatherName = 1;
    private static final int Type = 2;


    public FlogoCompiler(CompilerConfiguration configuration, List<CompilerMessage> collector) {
        this.configuration = configuration;
        this.collector = collector;
    }

    public List<OutputItem> compile(List<File> sources) {
        List<OutputItem> compiledFiles = Collections.synchronizedList(new ArrayList<>());
        if (configuration.isVerbose())
            configuration.out().println(PRESENTABLE_MESSAGE + "Flogo: Compiling model...");
        GraphLoader graphLoader = new GraphLoader();
        FlogoGraph graph = graphLoader.loadGraph(configuration, sources);
        if (graph == null) return compiledFiles;
        if (configuration.isVerbose())
            configuration.out().println(PRESENTABLE_MESSAGE + "Flogo: Rendering classes...");
        CompilationContext context = new CompilationContext(configuration, sources, compiledFiles);
        try {
            render(graph, context);
            return compiledFiles;
        } catch (Exception e) {
            processCompilationException(e);
        } finally {
            addWarnings(context.warningMessages());
        }
        return compiledFiles;
    }

    private void processCompilationException(Exception e) {
        if (e instanceof BlattException) {
            addErrorMessage((BlattException) e);
            return;
        }
        LOG.severe(e.getMessage());
        addMessageWithoutLocation(e.getMessage(), true);
    }

    private void addMessageWithoutLocation(String message, boolean error) {
        collector.add(new CompilerMessage(error ? CompilerMessage.ERROR : CompilerMessage.WARNING, message, null, -1, -1));
    }

    private void addErrorMessage(BlattException exception) {
        collector.add(new CompilerMessage(CompilerMessage.ERROR, exception.getMessage(), "null", -1, -1));
    }

    private void addWarnings(List<WarningMessage> warningMessages) {
        warningMessages.forEach(w -> collector.add(new CompilerMessage(CompilerMessage.WARNING, w.message(), w.owner() == null ? "null" : w.owner().getAbsolutePath(), w.line(), w.column())));
    }

    private void render(FlogoGraph graph, CompilationContext context) {
        ArchitectureView architectureView = new ArchitectureViewRenderer().render(graph.architecture());
        LaboratoryView laboratoryView = new LaboratoryViewRenderer().render(graph.laboratory());
        FlogoRenderer flogoRenderer = new FlogoRenderer("", ""); //TODO add your path
        for (ExperimentView experimentView : laboratoryView.experimentViews()) {
            FlogoDTO flogoDTO = new FlogoDTO(
                    architectureView,
                    laboratoryView,
                    new ExperimentArchitecture.Builder()
                            .from(architectureView)
                            .substitutes(experimentView.substitutes)
                            .name(experimentView.name)
                            .collapse());
            // flogoRenderer.render(flogoDTO);
        }
        System.out.println(laboratoryView);
        System.out.println(architectureView.sections());
    }
}
