package io.flogo.builder.model.structure.blocks.link;

import io.flogo.builder.model.structure.Block;
import io.flogo.builder.model.structure.Layer;
import io.flogo.builder.model.structure.layers.link.classification.SoftmaxLayer;

import java.util.List;

public class ClassificationBlock implements Block {
    private final SoftmaxLayer layer;

    public ClassificationBlock(SoftmaxLayer layer) {
        this.layer = layer;
    }

    @Override
    public List<Layer> layers() {
        return List.of(layer);
    }
}
