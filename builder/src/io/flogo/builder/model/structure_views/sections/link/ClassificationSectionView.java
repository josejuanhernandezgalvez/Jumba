package io.flogo.builder.model.structure_views.sections.link;

import io.flogo.builder.model.structure_views.BlockView;
import io.flogo.builder.model.structure_views.LayerView;
import io.flogo.builder.model.structure_views.SectionView;
import io.flogo.builder.model.structure_views.blocks.link.ClassificationBlockView;

import java.util.ArrayList;
import java.util.List;

public class ClassificationSectionView implements SectionView {
    public final List<ClassificationBlockView> blocks;
    public final List<LayerView> layerViews;

    public ClassificationSectionView(ClassificationBlockView block) {
        this.blocks = List.of(block);
        this.layerViews = layers(block);
    }

    private List<LayerView> layers(ClassificationBlockView block) {
        return block.layers();
    }

    @Override
    public List<BlockView> blocks() {
        return new ArrayList<>(blocks);
    }
}
