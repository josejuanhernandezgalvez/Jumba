package io.flogo.builder.model.architecture.sections.processing;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.SectionView;
import io.flogo.builder.model.architecture.blocks.processing.ConvolutionalBlockView;

import java.util.ArrayList;
import java.util.List;

public class ConvolutionalSectionView implements SectionView {
    public final List<ConvolutionalBlockView> blocks;
    public List<LayerView> layerViews;

    public ConvolutionalSectionView(List<ConvolutionalBlockView> blocks) {
        this.blocks = blocks;
        this.layerViews = null;
    }

    public List<LayerView> layers() {
        if (layerViews == null) this.layerViews = createLayerList();
        return layerViews;
    }

    private List<LayerView> createLayerList() {
        return blocks.stream().map(ConvolutionalBlockView::layerViews).flatMap(List::stream).toList();
    }

    @Override
    public List<BlockView> blocks() {
        return new ArrayList<>(blocks);
    }
}
