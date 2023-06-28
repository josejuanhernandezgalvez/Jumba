package io.flogo.builder.model.structure.sections.processing;

import io.flogo.builder.model.structure.Block;
import io.flogo.builder.model.structure.Layer;
import io.flogo.builder.model.structure.Section;
import io.flogo.builder.model.structure.blocks.processing.LinearBlock;

import java.util.ArrayList;
import java.util.List;

public class LinearSection implements Section {
    public final List<LinearBlock> blocks;
    public final List<Layer> layers;

    public LinearSection(List<LinearBlock> blocks) {
        this.blocks = blocks;
        this.layers = layers(blocks);
    }

    private List<Layer> layers(List<LinearBlock> blocks) {
        ArrayList<Layer> layers = new ArrayList<>();
        for (LinearBlock block : blocks) layers.addAll(block.layers());
        return layers;
    }

    @Override
    public List<Block> blocks() {
        return new ArrayList<>(blocks);
    }
}
