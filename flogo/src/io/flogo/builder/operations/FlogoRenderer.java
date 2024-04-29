package io.flogo.builder.operations;

import io.flogo.builder.model.FlogoDTO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class FlogoRenderer {
    private final ArchitectureRenderer architectureRenderer;
    private final LaboratoryRenderer laboratoryRenderer;
    private final String pathForLaboratory;
    private final String pathForArchitecture;

    public FlogoRenderer(String pathForLaboratory, String pathForArchitecture) {
        this.architectureRenderer = new ArchitectureRenderer();
        this.laboratoryRenderer = new LaboratoryRenderer();
        this.pathForLaboratory = pathForLaboratory;
        this.pathForArchitecture = pathForArchitecture;
    }

    public void render(FlogoDTO flogoDTO) {
        if (!Files.exists(Path.of(pathForArchitecture + flogoDTO.architectureView().name))) mkdir(flogoDTO.architectureView().name);
        write(pathForLaboratory + flogoDTO.collapsedArchitectureView().name + "-laboratory.py", laboratoryRenderer.render(flogoDTO.laboratoryView(), flogoDTO.architectureView().name));
        write(pathForArchitecture + flogoDTO.architectureView().name + "/" + flogoDTO.collapsedArchitectureView().name + ".py", architectureRenderer.render(flogoDTO.collapsedArchitectureView(), "pytorch"));
    }

    private void mkdir(String name) {
        try {
            Files.createDirectory(Path.of(pathForArchitecture + name));
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
