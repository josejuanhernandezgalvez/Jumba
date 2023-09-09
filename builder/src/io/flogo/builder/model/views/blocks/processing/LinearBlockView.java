package io.flogo.builder.model.views.blocks.processing;

import io.flogo.builder.model.views.BlockView;
import io.flogo.builder.model.views.LayerView;

import java.util.List;

public record LinearBlockView(List<LayerView> layerViews) implements BlockView {
}
