package io.flogo.builder.model.structure.layers.processing.convolutional.normalizations;

import io.flogo.builder.model.structure.Output;
import io.flogo.builder.model.structure.layers.processing.convolutional.ConvolutionalOutputLayer;
import io.flogo.builder.model.structure.layers.input.ThreeDimensionsInputSize;
import io.flogo.builder.model.structure.layers.processing.convolutional.ConvolutionalParameters;

public class NormalizationOutputLayer implements ConvolutionalOutputLayer {

    @Override
    public Output output() {
        return null;
    }

    @Override
    public ConvolutionalParameters parameters() {
        return null;
    }

    @Override
    public ConvolutionalParameters parameters(ThreeDimensionsInputSize threeDimensionsInputSize) {
        return null;
    }
}
