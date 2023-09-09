package io.flogo.builder.model.views.blocks.processing.recurrentBlocks;

import io.flogo.builder.model.views.blocks.processing.RecurrentBlockView;
import io.flogo.builder.model.views.layers.output.OneDimensionOutput;

public class RNN extends RecurrentBlockView {
    public RNN(OneDimensionOutput inputSize, OneDimensionOutput hiddenSize, int numLayers) {
        super(inputSize, hiddenSize, numLayers);
    }
}
