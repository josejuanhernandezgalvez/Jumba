package io.jumba.builder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CompilationContext {
    List<WarningMessage> messages = new ArrayList<>();
    private final CompilerConfiguration configuration;
    private final List<File> sources;
    private final List<OutputItem> compiledFiles;

    public List<WarningMessage> getMessages() {
        return messages;
    }

    public CompilerConfiguration getConfiguration() {
        return configuration;
    }

    public List<File> getSources() {
        return sources;
    }

    public List<OutputItem> getCompiledFiles() {
        return compiledFiles;
    }

    public CompilationContext(CompilerConfiguration configuration, List<File> sources, List<OutputItem> compiledFiles) {
        this.configuration = configuration;
        this.sources = sources;
        this.compiledFiles = compiledFiles;
    }

    public List<WarningMessage> warningMessages() {
        return messages;
    }
}
