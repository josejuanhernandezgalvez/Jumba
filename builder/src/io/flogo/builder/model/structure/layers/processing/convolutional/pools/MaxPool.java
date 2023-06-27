package io.flogo.builder.model.structure.layers.processing.convolutional.pools;

import io.flogo.builder.model.structure.layers.output.ThreeDimensionsOutput;
import io.flogo.builder.model.structure.layers.processing.convolutional.Convolutional;

public class MaxPool extends Convolutional {
    public MaxPool(ThreeDimensionsOutput previous, ThreeDimensionsOutput output) {
        super(previous, output);
    }

}
