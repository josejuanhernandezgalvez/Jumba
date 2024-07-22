package io.jumba.builder;

import io.jumba.builder.model.architecture.ArchitectureView;
import io.jumba.builder.model.laboratory.LaboratoryView;
import io.jumba.builder.model.renderers.architecture.ArchitectureViewRenderer;
import io.jumba.builder.model.renderers.laboratory.LaboratoryViewRenderer;
import io.intino.magritte.framework.Layer;
import io.intino.magritte.framework.Node;
import io.jumba.model.JumbaGraph;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import static io.intino.builder.BuildConstants.PRESENTABLE_MESSAGE;

public class JumbaCompiler {
    private final CompilerConfiguration configuration;
    private final List<CompilerMessage> collector;
    private static final Logger LOG = Logger.getGlobal();
    private static final int Name = 0;
    private static final int FatherName = 1;
    private static final int Type = 2;


    public JumbaCompiler(CompilerConfiguration configuration, List<CompilerMessage> collector) {
        this.configuration = configuration;
        this.collector = collector;
    }

    public List<OutputItem> compile(List<File> sources) {
        List<OutputItem> compiledFiles = Collections.synchronizedList(new ArrayList<>());
        if (configuration.isVerbose())
            configuration.out().println(PRESENTABLE_MESSAGE + "Jumba: Compiling model...");
        GraphLoader graphLoader = new GraphLoader();
        JumbaGraph graph = graphLoader.loadGraph(configuration, sources);
        if (graph == null) return compiledFiles;
        if (configuration.isVerbose())
            configuration.out().println(PRESENTABLE_MESSAGE + "Jumba: Rendering classes...");
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
        if (e instanceof JumbaException) {
            addErrorMessage((JumbaException) e);
            return;
        }
        LOG.severe(e.getMessage());
        addMessageWithoutLocation(e.getMessage(), true);
    }

    private void addMessageWithoutLocation(String message, boolean error) {
        collector.add(new CompilerMessage(error ? CompilerMessage.ERROR : CompilerMessage.WARNING, message, null, -1, -1));
    }

    private void addErrorMessage(JumbaException exception) {
        collector.add(new CompilerMessage(CompilerMessage.ERROR, exception.getMessage(), "null", -1, -1));
    }

    private void addWarnings(List<WarningMessage> warningMessages) {
        warningMessages.forEach(w -> collector.add(new CompilerMessage(CompilerMessage.WARNING, w.message(), w.owner() == null ? "null" : w.owner().getAbsolutePath(), w.line(), w.column())));
    }

    private void render(JumbaGraph graph, CompilationContext context) {
        ArchitectureView architectureView = new ArchitectureViewRenderer(context).render(graph.architecture());
        LaboratoryView laboratoryView = new LaboratoryViewRenderer().render(graph.laboratory());
        System.out.println(laboratoryView);
        System.out.println(architectureView.sections());
    }


    public String sourceFileOf(Layer layer, CompilationContext context) {
        if (layer == null) return context.getSources().get(0).getAbsolutePath();
        final Node node = layer.core$();
        String stash = node.stash();
        File file = context.getSources().stream().filter(f -> f.getName().replace(".konos", "").equals(stash)).findFirst().orElse(null);
        return file == null ? context.getSources().get(0).getAbsolutePath() : file.getAbsolutePath();
    }
}
