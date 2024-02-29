package io.flogo.builder;

import io.flogo.builder.model.architecture.ArchitectureView;
import io.flogo.builder.model.renderers.ArchitectureRenderer;
import io.flogo.builder.model.renderers.EvolutionRenderer;
import io.flogo.builder.model.evolution.EvolutionView;
import io.flogo.model.FlogoGraph;

import java.io.File;
import java.util.*;
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

	private void render(FlogoGraph graph, CompilationContext context) throws BlattException, Exception {
		ArchitectureView architectureView = new ArchitectureRenderer().render(graph.architecture());
		EvolutionView evolutionView = new EvolutionRenderer().render(graph.evolution());
		System.out.println(architectureView.sections());
		System.out.println(evolutionView);
	}
}
