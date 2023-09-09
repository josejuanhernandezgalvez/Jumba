package io.flogo.builder.model.views.sections.link;

import io.flogo.builder.model.views.BlockView;
import io.flogo.builder.model.views.LayerView;
import io.flogo.builder.model.views.SectionView;
import io.flogo.builder.model.views.blocks.link.FlattenBlockView;

import java.util.ArrayList;
import java.util.List;

public class FlattenSectionView implements SectionView {
    public final List<FlattenBlockView> blocks;
    public final List<LayerView> layerViews;

    public FlattenSectionView(FlattenBlockView block) {
        this.blocks = List.of(block);
        this.layerViews = layers(block);
    }

    private List<LayerView> layers(FlattenBlockView block) {
        return block.layers();
    }

    @Override
    public List<BlockView> blocks() {
        return new ArrayList<>(blocks);
    }
}
