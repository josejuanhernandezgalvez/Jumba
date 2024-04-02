package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;

public abstract class RecurrentLayerView implements LayerView {
    public final OutputView previousLayerOutput;
    public final OutputView thisLayerOutput;
    public final int numLayers;
    public final OutputType outputType;
    public final boolean bidirectional;

    public RecurrentLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput, int numLayers, OutputType outputType, boolean bidirectional) {
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
        this.numLayers = numLayers;
        this.outputType = outputType;
        this.bidirectional = bidirectional;
    }

    public enum OutputType {
        LastHiddenState, HiddenStates, CellStates, LastCellState
    }
}
