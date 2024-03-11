package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;

public abstract class RecurrentLayerView implements LayerView {
    public final OutputView previousLayerOutput;
    public final OutputView thisLayerOutput;
    public final int numLayers;
    public final String outputElement;
    public final boolean bidirectional;

    public RecurrentLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput, int numLayers, String outputElement, boolean bidirectional) {
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
        this.numLayers = numLayers;
        this.outputElement = outputElement;
        this.bidirectional = bidirectional;
    }
}
