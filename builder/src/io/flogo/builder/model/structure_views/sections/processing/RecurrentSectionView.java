package io.flogo.builder.model.structure_views.sections.processing;

import io.flogo.builder.model.structure_views.BlockView;
import io.flogo.builder.model.structure_views.SectionView;

import java.util.List;

public class RecurrentSectionView implements SectionView {
    public final BlockView blockView;

    public RecurrentSectionView(BlockView blockViews) {
        this.blockView = blockViews;
    }

    @Override
    public List<BlockView> blocks() {
        return List.of(blockView);
    }
}
