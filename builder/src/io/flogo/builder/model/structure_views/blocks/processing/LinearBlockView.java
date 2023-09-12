package io.flogo.builder.model.structure_views.blocks.processing;

import io.flogo.builder.model.structure_views.BlockView;
import io.flogo.builder.model.structure_views.LayerView;

import java.util.List;

public record LinearBlockView(List<LayerView> layerViews) implements BlockView {
}
