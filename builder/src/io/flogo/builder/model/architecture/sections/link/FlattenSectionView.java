package io.flogo.builder.model.architecture.sections.link;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.SectionView;

import java.util.ArrayList;
import java.util.List;

public class FlattenSectionView implements SectionView {
    public final List<BlockView> blocks;
    public final List<LayerView> layerViews;

    public FlattenSectionView(BlockView block) {
        this.blocks = List.of(block);
        this.layerViews = layers();
    }

    private List<LayerView> layers() {
        return blocks.getFirst().layerViews();
    }

    @Override
    public List<BlockView> blocks() {
        return new ArrayList<>(blocks);
    }

    @Override
    public OutputView output() {
        return blocks.getLast().output();
    }
}
