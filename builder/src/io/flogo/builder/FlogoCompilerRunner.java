package io.flogo.builder;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static io.flogo.builder.BlattBuildConstants.BUILD_END;
import static io.flogo.builder.BlattBuildConstants.SEPARATOR;
import static io.intino.tara.builder.shared.TaraBuildConstants.*;


class FlogoCompilerRunner {
	private static final Logger LOG = Logger.getGlobal();

	private final boolean verbose;
	private PrintStream out = System.out;

	FlogoCompilerRunner(boolean verbose) {
		this.verbose = verbose;
	}

	void run(File argsFile) {
		final CompilerConfiguration config = new CompilerConfiguration();
		final Map<File, Boolean> sources = new LinkedHashMap<>();
		CompilationInfoExtractor.getInfoFromArgsFile(argsFile, config, sources);
		config.setVerbose(verbose);
		config.out(System.out);
		this.out = config.out();
		if (sources.isEmpty()) return;
		if (verbose) out.println(PRESENTABLE_MESSAGE + "FLogo: loading sources...");
		final List<CompilerMessage> messages = new ArrayList<>();
		List<OutputItem> compiled = compile(config, sources, messages);
		if (verbose) report(sources, compiled);
		processErrors(messages);
		out.println();
		out.print(BUILD_END);
	}

	private List<OutputItem> compile(CompilerConfiguration config, Map<File, Boolean> sources, List<CompilerMessage> messages) {
		return new ArrayList<>(compileSources(config, sources, messages));
	}

	private List<OutputItem> compileSources(CompilerConfiguration config, Map<File, Boolean> sources, List<CompilerMessage> messages) {
		List<OutputItem> outputItems = new FlogoCompiler(config, messages).compile(new ArrayList<>(sources.keySet()));
		out.println();
		return outputItems;
	}

	private void report(Map<File, Boolean> srcFiles, List<OutputItem> compiled) {
		if (compiled.isEmpty()) reportNotCompiledItems(srcFiles);
		else reportCompiledItems(compiled, srcFiles);
		out.println();
	}

	private void processErrors(List<CompilerMessage> compilerMessages) {
		int errorCount = 0;
		for (CompilerMessage message : compilerMessages) {
			if (message.getCategory().equals(BlattCompilerMessageCategories.ERROR)) {
				if (errorCount > 100) continue;
				errorCount++;
			}
			printMessage(message);
		}
	}


	private void printMessage(CompilerMessage message) {
		out.print(MESSAGES_START);
		out.print(message.getCategoryLabel());
		out.print(SEPARATOR);
		out.print(message.getMessage());
		out.print(SEPARATOR);
		out.print(message.getUrl());
		out.print(SEPARATOR);
		out.print(message.getLineNum());
		out.print(SEPARATOR);
		out.print(message.getColumnNum());
		out.print(SEPARATOR);
		out.print(MESSAGES_END);
		out.println();
	}

	private void reportCompiledItems(List<OutputItem> compiledFiles, Map<File, Boolean> srcFiles) {
		for (OutputItem compiledFile : compiledFiles) {
			out.print(COMPILED_START);
			out.print(compiledFile.getOutputPath());
			out.print(SEPARATOR);
			out.print(new File(compiledFile.getSourcePath()).isFile() ? compiledFile.getSourcePath() : srcFiles.keySet().iterator().next().getAbsolutePath());
			out.print(COMPILED_END);
			out.println();
		}
	}

	private void reportNotCompiledItems(Map<File, Boolean> toRecompile) {
		for (File file : toRecompile.keySet()) {
			out.print(TO_RECOMPILE_START);
			out.print(file.getAbsolutePath());
			out.print(TO_RECOMPILE_END);
			out.println();
		}
	}

	public static void cleanOut(CompilerConfiguration configuration) {
		final String generationPackage = (configuration.generationPackage() == null ? configuration.module() : configuration.generationPackage()).replace(".", File.separator);
		File out = new File(configuration.genDirectory(), generationPackage.toLowerCase());
		if (out.exists()) try {
			FileUtils.deleteDirectory(out);
		} catch (IOException e) {
			LOG.severe(e.getMessage());
		}
	}
}
