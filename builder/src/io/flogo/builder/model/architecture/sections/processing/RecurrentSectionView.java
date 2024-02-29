package io.flogo.builder.model.architecture.sections.processing;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.SectionView;

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
