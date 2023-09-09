package io.flogo.builder.model.views.sections.processing;

import io.flogo.builder.model.views.BlockView;
import io.flogo.builder.model.views.SectionView;

import java.util.List;

public class RecurrentSectionView implements SectionView {
    public final List<BlockView> blockViews;

    public RecurrentSectionView(List<BlockView> blockViews) {
        this.blockViews = blockViews;
    }

    @Override
    public List<BlockView> blocks() {
        return blockViews;
    }
}
