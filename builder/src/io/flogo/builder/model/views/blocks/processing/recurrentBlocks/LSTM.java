package io.flogo.builder.model.views.blocks.processing.recurrentBlocks;

import io.flogo.builder.model.views.blocks.processing.RecurrentBlockView;
import io.flogo.builder.model.views.layers.output.OneDimensionOutput;

public class LSTM extends RecurrentBlockView {
    public LSTM(OneDimensionOutput inputSize, OneDimensionOutput hiddenSize, int numLayers) {
        super(inputSize, hiddenSize, numLayers);
    }
}
