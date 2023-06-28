package io.flogo.builder.model.structure.blocks.processing.recurrentBlocks;

import io.flogo.builder.model.structure.blocks.processing.RecurrentBlock;
import io.flogo.builder.model.structure.layers.output.OneDimensionOutput;

public class GRU extends RecurrentBlock {
    public GRU(OneDimensionOutput inputSize, OneDimensionOutput hiddenSize, int numLayers) {
        super(inputSize, hiddenSize, numLayers);
    }
}
