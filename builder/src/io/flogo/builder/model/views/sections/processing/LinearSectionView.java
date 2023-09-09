package io.flogo.builder.model.views.sections.processing;

import io.flogo.builder.model.views.BlockView;
import io.flogo.builder.model.views.LayerView;
import io.flogo.builder.model.views.SectionView;
import io.flogo.builder.model.views.blocks.processing.LinearBlockView;

import java.util.ArrayList;
import java.util.List;

public class LinearSectionView implements SectionView {
    public final List<LinearBlockView> blocks;
    public List<LayerView> layerViews;

    public LinearSectionView(List<LinearBlockView> blocks) {
        this.blocks = blocks;
        this.layerViews = null;
    }

    public List<LayerView> layers() {
        if (layerViews == null) this.layerViews = createLayerList();
        return layerViews;
    }

    private List<LayerView> createLayerList() {
        return blocks.stream().map(LinearBlockView::layerViews).flatMap(List::stream).toList();
    }

    @Override
    public List<BlockView> blocks() {
        return new ArrayList<>(blocks);
    }
}
