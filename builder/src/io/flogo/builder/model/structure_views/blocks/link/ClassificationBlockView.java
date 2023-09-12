package io.flogo.builder.model.structure_views.blocks.link;

import io.flogo.builder.model.structure_views.BlockView;
import io.flogo.builder.model.structure_views.LayerView;
import io.flogo.builder.model.structure_views.layers.link.SoftmaxLayerView;

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
