package io.flogo.builder.model.views.blocks.link;

import io.flogo.builder.model.views.BlockView;
import io.flogo.builder.model.views.LayerView;
import io.flogo.builder.model.views.layers.link.SoftmaxLayerView;

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
