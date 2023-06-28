package io.flogo.builder.model.structure.sections.processing;

import io.flogo.builder.model.structure.Block;
import io.flogo.builder.model.structure.Layer;
import io.flogo.builder.model.structure.Section;
import io.flogo.builder.model.structure.blocks.processing.ConvolutionalBlock;
import io.flogo.builder.model.structure.blocks.processing.LinearBlock;

import java.util.ArrayList;
import java.util.List;

public class ConvolutionalSection implements Section {
    public final List<ConvolutionalBlock> blocks;
    public final List<Layer> layers;

    public ConvolutionalSection(List<ConvolutionalBlock> blocks) {
        this.blocks = blocks;
        this.layers = layers(blocks);
    }

    private List<Layer> layers(List<ConvolutionalBlock> blocks) {
        ArrayList<Layer> layers = new ArrayList<>();
        for (ConvolutionalBlock block : blocks) layers.addAll(block.layers());
        return layers;
    }

    @Override
    public List<Block> blocks() {
        return new ArrayList<>(blocks);
    }
}
