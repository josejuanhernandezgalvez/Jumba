package io.flogo.builder.model.views.blocks.link;

import io.flogo.builder.model.views.BlockView;
import io.flogo.builder.model.views.LayerView;
import io.flogo.builder.model.views.layers.link.FlattenLayerView;

import java.util.List;

public class FlattenBlockView implements BlockView {
    private final FlattenLayerView layer;

    public FlattenBlockView(FlattenLayerView layer) {
        this.layer = layer;
    }

    public List<LayerView> layers() {
        return List.of(layer);
    }
}
