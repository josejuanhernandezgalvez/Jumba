package io.jumba.builder.model.architecture.sections.processing;

import io.jumba.builder.model.architecture.BlockView;
import io.jumba.builder.model.architecture.LayerView;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.SectionView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LinearSectionView implements SectionView {
    public final List<BlockView> blocks;
    public List<LayerView> layerViews;
    public final OutputView input;

    public LinearSectionView(List<BlockView> blocks, OutputView input) {
        this.blocks = blocks;
        this.layerViews = blocks.stream().map(BlockView::layerViews).flatMap(Collection::stream).toList();
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
