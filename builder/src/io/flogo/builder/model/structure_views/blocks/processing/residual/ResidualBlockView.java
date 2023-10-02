package io.flogo.builder.model.structure_views.blocks.processing.residual;

import io.flogo.builder.model.structure_views.BlockView;
import io.flogo.builder.model.structure_views.layers.output.ThreeDimensionsOutput;

public class ResidualBlockView implements BlockView {
    public final int inChannels;
    private final ThreeDimensionsOutput previousOutput;
    private ThreeDimensionsOutput thisOutput;
    public final int expansion;
    public final int hiddenSize;

    public ResidualBlockView(ThreeDimensionsOutput previousOutput, int expansion, int hiddenSize) {
        this.inChannels = previousOutput.x();
        this.previousOutput = previousOutput;
        this.expansion = expansion;
        this.hiddenSize = hiddenSize;
    }

    public ResidualBlockView add(ThreeDimensionsOutput layerOutput) {
        this.thisOutput = layerOutput;
        return this;
    }
}
