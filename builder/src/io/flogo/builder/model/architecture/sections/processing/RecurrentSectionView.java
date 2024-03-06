package io.flogo.builder.model.architecture.sections.processing;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.SectionView;

import java.util.ArrayList;
import java.util.List;

public class RecurrentSectionView implements SectionView {
    public final List<BlockView> blockViews;

    public RecurrentSectionView(List<BlockView> blockViews) {
        this.blockViews = blockViews;
    }

    @Override
    public List<BlockView> blocks() {
        return new ArrayList<>(blockViews);
    }

    @Override
    public OutputView output() {
        return blockViews.getLast().output();
    }
}
