package io.flogo.builder.model.structure.blocks.processing;

import io.flogo.builder.model.structure.Block;
import io.flogo.builder.model.structure.Layer;

import java.util.List;

public class LinearBlock implements Block {
    private final List<Layer> layers;

    public LinearBlock(List<Layer> layers) {
        this.layers = layers;
    }

    @Override
    public List<Layer> layers() {
        return layers;
    }
}
