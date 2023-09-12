package io.flogo.builder.model.structure_views.blocks.processing.recurrentBlocks;

import io.flogo.builder.model.structure_views.blocks.processing.RecurrentBlockView;
import io.flogo.builder.model.structure_views.layers.output.OneDimensionOutput;

public class LSTM extends RecurrentBlockView {
    public LSTM(OneDimensionOutput inputSize, OneDimensionOutput hiddenSize, int numLayers) {
        super(inputSize, hiddenSize, numLayers);
    }
}
