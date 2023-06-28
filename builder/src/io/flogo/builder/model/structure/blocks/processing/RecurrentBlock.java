package io.flogo.builder.model.structure.blocks.processing;

import io.flogo.builder.model.structure.Block;
import io.flogo.builder.model.structure.layers.output.OneDimensionOutput;

public abstract class RecurrentBlock implements Block {
    public final int inputSize;
    public final int outputSize;
    public final int numLayers;

    public RecurrentBlock(OneDimensionOutput inputSize, OneDimensionOutput outputSize, int numLayers) {
        this.inputSize = inputSize.x();
        this.outputSize = outputSize.x();
        this.numLayers = numLayers;
    }
}
