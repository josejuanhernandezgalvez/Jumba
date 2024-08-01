package io.jumba.builder.renderers;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.OutputItem;
import io.jumba.builder.model.JumbaDTO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JumbaRenderer {
    private final ArchitectureRenderer architectureRenderer;
    private final LaboratoryRenderer laboratoryRenderer;
    private final String path;
    private final CompilationContext context;

    public JumbaRenderer(String path, CompilationContext context) {
        this.architectureRenderer = new ArchitectureRenderer();
        this.laboratoryRenderer = new LaboratoryRenderer();
        this.context = context;
        this.path = path;
        new File(path).mkdirs();
    }

    public void render(JumbaDTO jumbaDTO) {
        if (!Files.exists(Path.of(path, jumbaDTO.architectureView().name))) mkdir(jumbaDTO.architectureView().name);
        write(Path.of(path, "laboratory.py"), laboratoryRenderer.render(jumbaDTO.laboratoryView(), jumbaDTO.architectureView().name));
        context.getSources().forEach(s -> context.getCompiledFiles().add(new OutputItem(s.getAbsolutePath(), path + "laboratory.py")));
        write(Path.of(path, jumbaDTO.architectureView().name, jumbaDTO.architectureView().name + ".py"), architectureRenderer.render(jumbaDTO.architectureView(), "pytorch"));
        context.getSources().forEach(s -> context.getCompiledFiles().add(new OutputItem(s.getAbsolutePath(), path + jumbaDTO.architectureView().name + "/" + jumbaDTO.architectureView().name + ".py")));
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
