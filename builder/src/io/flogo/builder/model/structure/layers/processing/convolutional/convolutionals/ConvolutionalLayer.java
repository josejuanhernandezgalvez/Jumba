package io.flogo.builder.model.structure.layers.processing.convolutional.convolutionals;

import io.flogo.builder.model.structure.layers.output.ThreeDimensionsOutput;
import io.flogo.builder.model.structure.layers.processing.convolutional.Convolutional;

public class ConvolutionalLayer extends Convolutional {
    public final int channelIn;
    public final int channelOut;

    public ConvolutionalLayer(ThreeDimensionsOutput previous, ThreeDimensionsOutput output) {
        super(previous, output);
        this.channelIn = previous.z();
        this.channelOut = output.z();
    }

}
