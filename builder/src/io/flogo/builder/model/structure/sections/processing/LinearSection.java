package io.flogo.builder.model.structure.sections.processing;

import io.flogo.builder.model.structure.Block;
import io.flogo.builder.model.structure.Section;

import java.util.List;

public class LinearSection implements Section {
    private final List<Block> blocks;

    public LinearSection(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public List<Block> blocks() {
        return blocks;
    }
}
