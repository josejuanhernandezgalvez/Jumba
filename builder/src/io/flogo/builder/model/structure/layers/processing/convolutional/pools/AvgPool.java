package io.flogo.builder.model.structure.layers.processing.convolutional.pools;

import io.flogo.builder.model.structure.layers.output.ThreeDimensionsOutput;
import io.flogo.builder.model.structure.layers.processing.convolutional.Convolutional;

public class AvgPool extends Convolutional {
    public AvgPool(ThreeDimensionsOutput previous, ThreeDimensionsOutput output) {
        super(previous, output);
    }

}
