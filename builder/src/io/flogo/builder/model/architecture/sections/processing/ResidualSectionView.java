package io.flogo.builder.model.architecture.sections.processing;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.SectionView;
import io.flogo.builder.model.architecture.blocks.processing.ConvolutionalBlockView;
import io.flogo.builder.model.architecture.blocks.processing.residual.ResidualBlockView;

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
