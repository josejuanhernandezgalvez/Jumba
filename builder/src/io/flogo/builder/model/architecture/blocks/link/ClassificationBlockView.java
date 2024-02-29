package io.flogo.builder.model.architecture.blocks.link;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.layers.link.SoftmaxLayerView;

import java.util.List;

public class ClassificationBlockView implements BlockView {
    private final SoftmaxLayerView layer;

    public ClassificationBlockView(SoftmaxLayerView layer) {
        this.layer = layer;
    }

    public List<LayerView> layers() {
        return List.of(layer);
    }
}
