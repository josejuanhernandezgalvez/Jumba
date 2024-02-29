package io.flogo.builder.model.architecture.blocks.processing.residual;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.layers.output.ThreeDimensionsOutput;

public class ResidualBlockView implements BlockView {
    public final int inChannels;
    private final ThreeDimensionsOutput previousOutput;
    private ThreeDimensionsOutput thisOutput;
    public final int expansion;
    public final int hiddenSize;

    public ResidualBlockView(ThreeDimensionsOutput previousOutput, int expansion, int hiddenSize) {
        this.inChannels = previousOutput.z();
        this.previousOutput = previousOutput;
        this.expansion = expansion;
        this.hiddenSize = hiddenSize;
    }

    public ResidualBlockView add(ThreeDimensionsOutput layerOutput) {
        this.thisOutput = layerOutput;
        return this;
    }
}
