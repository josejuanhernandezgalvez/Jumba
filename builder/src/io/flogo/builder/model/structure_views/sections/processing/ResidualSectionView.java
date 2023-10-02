package io.flogo.builder.model.structure_views.sections.processing;

import io.flogo.builder.model.structure_views.BlockView;
import io.flogo.builder.model.structure_views.SectionView;
import io.flogo.builder.model.structure_views.blocks.processing.ConvolutionalBlockView;
import io.flogo.builder.model.structure_views.blocks.processing.residual.ResidualBlockView;

import java.util.ArrayList;
import java.util.List;

public class ResidualSectionView implements SectionView {
    public final ConvolutionalBlockView firstStage;
    public final List<ResidualBlockView> blockViews;
    public final ConvolutionalBlockView finalStage;


    public ResidualSectionView(ConvolutionalBlockView firstStage, List<ResidualBlockView> blockViews, ConvolutionalBlockView finalStage) {
        this.firstStage = firstStage;
        this.blockViews = blockViews;
        this.finalStage = finalStage;
    }

    @Override
    public List<BlockView> blocks() {
        return new ArrayList<>(blockViews);
    }
}
