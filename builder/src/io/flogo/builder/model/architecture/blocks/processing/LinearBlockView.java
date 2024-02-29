package io.flogo.builder.model.architecture.blocks.processing;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;

import java.util.List;

public record LinearBlockView(List<LayerView> layerViews) implements BlockView {
}
