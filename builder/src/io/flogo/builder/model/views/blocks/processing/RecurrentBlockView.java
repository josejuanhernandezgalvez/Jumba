package io.flogo.builder.model.views.blocks.processing;

import io.flogo.builder.model.views.BlockView;
import io.flogo.builder.model.views.layers.output.OneDimensionOutput;

public abstract class RecurrentBlockView implements BlockView {
    public final int inputSize;
    public final int outputSize;
    public final int numLayers;

    public RecurrentBlockView(OneDimensionOutput inputSize, OneDimensionOutput outputSize, int numLayers) {
        this.inputSize = inputSize.x();
        this.outputSize = outputSize.x();
        this.numLayers = numLayers;
    }
}
