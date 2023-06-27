package io.flogo.builder.model.structure.layers.processing.convolutional.normalizations;

import io.flogo.builder.model.structure.layers.output.ThreeDimensionsOutput;

public class NormalizationLayer {
    public final double momentum;
    public final double eps;
    public final int inChannels;
    public final int outChannels;

    public NormalizationLayer(ThreeDimensionsOutput previous, ThreeDimensionsOutput output, double momentum, double eps) {
        this.inChannels = previous.z();
        this.outChannels = output.z();
        this.momentum = momentum;
        this.eps = eps;
    }

}
