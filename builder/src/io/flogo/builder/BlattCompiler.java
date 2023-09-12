package io.flogo.builder;

import io.flogo.blatt.model.BlattGraph;
import io.flogo.blatt.model.Section;
import io.flogo.builder.model.SectionRenderer;
import io.flogo.builder.model.TrainingRenderer;
import io.flogo.builder.model.architecture_views.TrainingView;
import io.flogo.builder.model.structure_views.Output;
import io.flogo.builder.model.structure_views.SectionView;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static io.intino.magritte.builder.shared.TaraBuildConstants.PRESENTABLE_MESSAGE;

public class BlattCompiler {
	private final CompilerConfiguration configuration;
	private final List<CompilerMessage> collector;
	private static final Logger LOG = Logger.getGlobal();
	private static final int Name = 0;
	private static final int FatherName = 1;
	private static final int Type = 2;


	public BlattCompiler(CompilerConfiguration configuration, List<CompilerMessage> collector) {
		this.configuration = configuration;
		this.collector = collector;
	}

	public List<OutputItem> compile(List<File> sources) {
		List<OutputItem> compiledFiles = Collections.synchronizedList(new ArrayList<>());
		if (configuration.isVerbose())
			configuration.out().println(PRESENTABLE_MESSAGE + "Blattc: Compiling model...");
		GraphLoader graphLoader = new GraphLoader();
		BlattGraph graph = graphLoader.loadGraph(configuration, sources);
		if (graph == null) return compiledFiles;
		if (configuration.isVerbose())
			configuration.out().println(PRESENTABLE_MESSAGE + "Blattc: Rendering classes...");
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
		collector.add(new CompilerMessage(error ? io.intino.magritte.builder.core.CompilerMessage.ERROR : io.intino.magritte.builder.core.CompilerMessage.WARNING, message, null, -1, -1));
	}

	private void addErrorMessage(BlattException exception) {
		collector.add(new CompilerMessage(CompilerMessage.ERROR, exception.getMessage(), "null", -1, -1));
	}

	private void addWarnings(List<WarningMessage> warningMessages) {
		warningMessages.forEach(w -> collector.add(new CompilerMessage(CompilerMessage.WARNING, w.message(), w.owner() == null ? "null" : w.owner().getAbsolutePath(), w.line(), w.column())));
	}

	private void render(BlattGraph graph, CompilationContext context) throws BlattException, Exception {
		AtomicReference<Output> input = new AtomicReference<>(getInputFrom(graph.neuralNetwork(0).section(0)));
		TrainingView trainingView = new TrainingRenderer().render(graph.training(0));
		System.out.println(graph.neuralNetwork(0).sectionList().stream().map(s -> getSectionView(input, s)).toList());
	}

	private SectionView getSectionView(AtomicReference<Output> input, Section section) {
		SectionRenderer sectionRenderer = getRendererFor(section);
		SectionView sectionView = sectionRenderer.init(input.get()).render(section);
		input.set(sectionRenderer.sectionOutput());
		return sectionView;
	}

	private static Output getInputFrom(Section section) throws Exception {
		Object input = section.core$().findNode(getInputClassFor(section)).get(0);
		return determineOutputClass(input).getConstructor(List.class).newInstance(getFieldsOf(input));
	}

	private static Class<Output> determineOutputClass(Object input) {
		for (Class<?> aClass : outputClasses())
			if (aClass.getDeclaredFields().length == getFieldsOf(input).size()) return (Class<Output>) aClass;
		throw new RuntimeException("Input size not valid");
	}

	private static List<Class> outputClasses() {
		return new BufferedReader(new InputStreamReader(Objects.requireNonNull(
				ClassLoader.getSystemClassLoader().getResourceAsStream(Output.directory))))
				.lines()
				.filter(line -> line.endsWith(".class"))
				.map(BlattCompiler::getOutputClass)
				.collect(Collectors.toList());
	}

	private static Class getOutputClass(String outputClassName) {
		try {
			return Class.forName(className(outputClassName));
		} catch (ClassNotFoundException e) { }
		return null;
	}

	private static String className(String name) {
		return Output.packageRoute + name.substring(0, name.lastIndexOf('.'));
	}

	private static Class getInputClassFor(Section section) throws ClassNotFoundException {
		return Class.forName("io.flogo.blatt.model." + extractFrom(section, Name) + "$Input");
	}

	private static List<Object> getFieldsOf(Object input) {
		return Arrays.stream(input.getClass()
				.getDeclaredFields())
				.map(f -> getValue(input, f))
				.toList();
	}

	private static Object getValue(Object input, Field field) {
		try {
			field.setAccessible(true);
			return field.get(input);
		} catch (IllegalAccessException e) { throw new RuntimeException(e); }
	}

	private SectionRenderer getRendererFor(Section section) {
		try {
			return (SectionRenderer) Class.forName(className(section)).getConstructors()[0].newInstance();
		} catch (Exception e) { throw new RuntimeException(e); }
	}

	private String className(Section section) {
		return SectionRenderer.packageRoute + extractFrom(section, Name) + "Renderer";
	}

	private static String extractFrom(Section section, int abstractionIndex) {
		return section.core$().conceptList().get(abstractionIndex).toString().split("\\{")[0];
	}
}