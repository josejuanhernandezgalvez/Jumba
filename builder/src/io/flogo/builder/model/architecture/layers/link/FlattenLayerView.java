package io.flogo.builder.model.architecture.layers.link;

import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.LinkLayerView;
import io.flogo.builder.model.architecture.layers.output.OneDimensionOutputView;

public class FlattenLayerView implements LinkLayerView {
    public final int fromDimension;
    public final int toDimension;
    public final OutputView previousLayerOutput;
    public final OneDimensionOutputView thisLayerOutput;

    public FlattenLayerView(OutputView previousLayerOutput, OneDimensionOutputView thisLayerOutput) {
        this.fromDimension = previousLayerOutput.dimensions();
        this.toDimension = thisLayerOutput.dimensions();
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput;
    }
}
