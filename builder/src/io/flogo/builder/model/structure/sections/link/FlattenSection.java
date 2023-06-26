package io.flogo.builder.model.structure.sections.link;

import io.flogo.builder.model.structure.Block;
import io.flogo.builder.model.structure.Section;

import java.util.List;

public class FlattenSection implements Section {
    private final List<Block> blocks;

    public FlattenSection(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public List<Block> blocks() {
        return blocks;
    }
}
