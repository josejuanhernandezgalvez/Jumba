package io.flogo.builder.model.structure.blocks.link;

import io.flogo.builder.model.structure.Block;
import io.flogo.builder.model.structure.Layer;
import io.flogo.builder.model.structure.layers.link.flatten.FlattenLayer;

import java.util.List;

public class FlattenBlock implements Block {
    private final FlattenLayer layer;

    public FlattenBlock(FlattenLayer layer) {
        this.layer = layer;
    }

    public List<Layer> layers() {
        return List.of(layer);
    }
}
