package io.flogo.builder.model.structure_views.blocks.link;

import io.flogo.builder.model.structure_views.BlockView;
import io.flogo.builder.model.structure_views.LayerView;
import io.flogo.builder.model.structure_views.layers.link.FlattenLayerView;

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
