package io.jumba.builder.operations;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.OutputItem;
import io.jumba.builder.model.FlogoDTO;
import io.jumba.builder.model.architecture.ArchitectureView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FlogoRenderer {
    private final ArchitectureRenderer architectureRenderer;
    private final LaboratoryRenderer laboratoryRenderer;
    private final String path;
    private final CompilationContext context;

    public FlogoRenderer(String path, CompilationContext context) {
        this.architectureRenderer = new ArchitectureRenderer();
        this.laboratoryRenderer = new LaboratoryRenderer();
        this.context = context;
        this.path = path;
        new File(path).mkdirs();
    }

    public void render(FlogoDTO flogoDTO) {
        if (!Files.exists(Path.of(path, flogoDTO.architectureView().name))) mkdir(flogoDTO.architectureView().name);
        write(Path.of(path, "laboratory.py"), laboratoryRenderer.render(flogoDTO.laboratoryView(), flogoDTO.architectureView().name));
        context.getSources().forEach(s -> context.getCompiledFiles().add(new OutputItem(s.getAbsolutePath(), path + "laboratory.py")));
        for (ArchitectureView collapsedArchitectureView : flogoDTO.collapsedArchitectureViews()) {
            write(Path.of(path, flogoDTO.architectureView().name, collapsedArchitectureView.name + ".py"), architectureRenderer.render(collapsedArchitectureView, "pytorch"));
            context.getSources().forEach(s -> context.getCompiledFiles().add(new OutputItem(s.getAbsolutePath(), path + flogoDTO.architectureView().name + "/" + collapsedArchitectureView.name + ".py")));
        }
    }

    private void mkdir(String name) {
        try {
            Files.createDirectory(Path.of(path, name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void write(Path path, String content) {
        try {
            Files.writeString(path, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
