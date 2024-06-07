package io.flogo.builder.operations;

import io.flogo.builder.model.FlogoDTO;
import io.flogo.builder.model.architecture.ArchitectureView;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class FlogoRenderer {
    private final ArchitectureRenderer architectureRenderer;
    private final LaboratoryRenderer laboratoryRenderer;
    private final String path;

    public FlogoRenderer(String path) {
        this.architectureRenderer = new ArchitectureRenderer();
        this.laboratoryRenderer = new LaboratoryRenderer();
        this.path = path;
    }

    public void render(FlogoDTO flogoDTO) {
        if (!Files.exists(Path.of(path, flogoDTO.architectureView().name))) mkdir(flogoDTO.architectureView().name);
        write(path + "laboratory.py", laboratoryRenderer.render(flogoDTO.laboratoryView(), flogoDTO.architectureView().name));
        for (ArchitectureView collapsedArchitectureView : flogoDTO.collapsedArchitectureViews())
            write(path + flogoDTO.architectureView().name + "/" + collapsedArchitectureView.name + ".py", architectureRenderer.render(collapsedArchitectureView, "pytorch"));
    }

    private void mkdir(String name) {
        try {
            Files.createDirectory(Path.of(path + name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void write(String path, String content) {
        try (Writer writer = new FileWriter(path)) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
