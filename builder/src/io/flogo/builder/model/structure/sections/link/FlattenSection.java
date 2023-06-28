package io.flogo.builder.model.structure.sections.link;

import io.flogo.builder.model.structure.Block;
import io.flogo.builder.model.structure.Layer;
import io.flogo.builder.model.structure.Section;
import io.flogo.builder.model.structure.blocks.link.FlattenBlock;

import java.util.ArrayList;
import java.util.List;

public class FlattenSection implements Section {
    public final List<FlattenBlock> blocks;
    public final List<Layer> layers;

    public FlattenSection(FlattenBlock block) {
        this.blocks = List.of(block);
        this.layers = layers(block);
    }

    private List<Layer> layers(FlattenBlock block) {
        return block.layers();
    }

    @Override
    public List<Block> blocks() {
        return new ArrayList<>(blocks);
    }
}
