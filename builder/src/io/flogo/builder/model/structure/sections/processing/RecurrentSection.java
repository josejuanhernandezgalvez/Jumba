package io.flogo.builder.model.structure.sections.processing;

import io.flogo.builder.model.structure.Block;
import io.flogo.builder.model.structure.Section;

import java.util.List;

public class RecurrentSection implements Section {
    public final List<Block> blocks;

    public RecurrentSection(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public List<Block> blocks() {
        return blocks;
    }
}
