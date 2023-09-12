package io.flogo.builder.model.structure_views.blocks.processing.recurrentBlocks;

import io.flogo.builder.model.structure_views.blocks.processing.RecurrentBlockView;
import io.flogo.builder.model.structure_views.layers.output.OneDimensionOutput;

public class RNN extends RecurrentBlockView {
    public RNN(OneDimensionOutput inputSize, OneDimensionOutput hiddenSize, int numLayers) {
        super(inputSize, hiddenSize, numLayers);
    }
}
