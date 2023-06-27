package io.flogo.builder.model.structure.layers.processing.linear;

import io.flogo.builder.model.structure.Output;
import io.flogo.builder.model.structure.layers.ProcessingLayer;
import io.flogo.builder.model.structure.layers.output.OneDimensionOutput;

public class LinearProcessingLayer implements ProcessingLayer {
    public final int inputSize;
    public final int outputSize;
    public final OneDimensionOutput output;

    public LinearProcessingLayer(OneDimensionOutput previous, OneDimensionOutput output) {
        this.inputSize = previous.x();
        this.outputSize = output.x();
        this.output = output;
    }

    @Override
    public Output output() {
        return output;
    }
}
