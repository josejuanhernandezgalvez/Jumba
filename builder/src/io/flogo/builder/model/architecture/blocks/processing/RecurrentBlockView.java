package io.flogo.builder.model.architecture.blocks.processing;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.layers.output.OneDimensionOutput;

public abstract class RecurrentBlockView implements BlockView {
    public static final String packageRoute = "io.flogo.builder.model.architecture.blocks.processing.recurrentBlocks.";
    public final int inputSize;
    public final int outputSize;
    public final int numLayers;
    public final String outputElement;
    public final boolean bidirectional;

    public RecurrentBlockView(OneDimensionOutput inputSize, OneDimensionOutput outputSize, int numLayers, String outputElement, boolean bidirectional) {
        this.inputSize = inputSize.x();
        this.outputSize = outputSize.x();
        this.numLayers = numLayers;
        this.outputElement = outputElement;
        this.bidirectional = bidirectional;
    }
}
