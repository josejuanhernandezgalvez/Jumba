package io.flogo.builder.model.structure.layers.processing.convolutional;

import io.flogo.builder.model.structure.layers.input.ThreeDimensionsInputSize;
import io.flogo.builder.model.structure.layers.OutputLayer;

public interface ConvolutionalOutputLayer extends OutputLayer {

    ConvolutionalParameters parameters();

    ConvolutionalParameters parameters(ThreeDimensionsInputSize threeDimensionsInputSize);

}
