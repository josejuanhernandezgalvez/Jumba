package io.flogo.builder.model.structure.blocks.processing.recurrentBlocks;

import io.flogo.builder.model.structure.blocks.processing.RecurrentBlock;
import io.flogo.builder.model.structure.layers.output.OneDimensionOutput;

public class RNN extends RecurrentBlock {
    public RNN(OneDimensionOutput inputSize, OneDimensionOutput hiddenSize, int numLayers) {
        super(inputSize, hiddenSize, numLayers);
    }
}
