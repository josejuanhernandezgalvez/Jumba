package io.flogo.builder.model.architecture.blocks.link;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.layers.link.FlattenLayerView;

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
