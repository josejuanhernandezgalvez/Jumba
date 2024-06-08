package io.flogo.builder.model.architecture.sections.processing;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.SectionView;

import java.util.ArrayList;
import java.util.List;

public class LinearSectionView implements SectionView {
    public final List<BlockView> blocks;
    public List<LayerView> layerViews;
    public final OutputView input;

    public LinearSectionView(List<BlockView> blocks, OutputView input) {
        this.blocks = blocks;
        this.layerViews = null;
        this.input = input;
    }

    public List<LayerView> layers() {
        if (layerViews == null) this.layerViews = createLayerList();
        return layerViews;
    }

    private List<LayerView> createLayerList() {
        return blocks.stream().map(BlockView::layerViews).flatMap(List::stream).toList();
    }

    @Override
    public List<BlockView> blocks() {
        return new ArrayList<>(blocks);
    }

    @Override
    public OutputView output() {
        return blocks.getLast().output();
    }

    @Override
    public OutputView input() {
        return input;
    }
}
