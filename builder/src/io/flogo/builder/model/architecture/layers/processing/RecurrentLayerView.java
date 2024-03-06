package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.layers.output.OneDimensionOutputView;

public abstract class RecurrentLayerView implements LayerView {
    public final OneDimensionOutputView previousLayerOuptut;
    public final OneDimensionOutputView thisLayerOutput;
    public final int numLayers;
    public final String outputElement;
    public final boolean bidirectional;

    public RecurrentLayerView(OneDimensionOutputView previousLayerOutput, OneDimensionOutputView thisLayerOutput, int numLayers, String outputElement, boolean bidirectional) {
        this.previousLayerOuptut = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
        this.numLayers = numLayers;
        this.outputElement = outputElement;
        this.bidirectional = bidirectional;
    }
}
