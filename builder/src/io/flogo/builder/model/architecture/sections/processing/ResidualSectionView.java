package io.flogo.builder.model.architecture.sections.processing;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.SectionView;

import java.util.ArrayList;
import java.util.List;

public class ResidualSectionView implements SectionView {
    public final BlockView firstStage;
    public final List<BlockView> blockViews;
    public final BlockView lastStage;


    public ResidualSectionView(BlockView firstStage, List<BlockView> blockViews, BlockView lastStage) {
        this.firstStage = firstStage;
        this.blockViews = blockViews;
        this.lastStage = lastStage;
    }

    @Override
    public List<BlockView> blocks() {
        return new ArrayList<>(blockViews);
    }

    @Override
    public OutputView output() {
        return lastStage.output();
    }
}
