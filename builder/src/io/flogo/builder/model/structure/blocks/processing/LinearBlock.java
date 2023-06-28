package io.flogo.builder.model.structure.blocks.processing;

import io.flogo.builder.model.structure.Block;
import io.flogo.builder.model.structure.Layer;

import java.util.List;

public record LinearBlock(List<Layer> layers) implements Block {
    public List<Layer> layers() {
        return this.layers;
    }
}
