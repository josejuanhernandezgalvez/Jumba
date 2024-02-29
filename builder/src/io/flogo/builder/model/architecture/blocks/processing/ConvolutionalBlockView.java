package io.flogo.builder.model.architecture.blocks.processing;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;

import java.util.List;

public record ConvolutionalBlockView(List<LayerView> layerViews) implements BlockView {
    public List<LayerView> layerViews() {
        return this.layerViews;
    }
}

