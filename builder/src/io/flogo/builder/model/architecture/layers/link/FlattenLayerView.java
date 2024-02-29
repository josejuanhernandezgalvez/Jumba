package io.flogo.builder.model.architecture.layers.link;

import io.flogo.builder.model.architecture.Output;
import io.flogo.builder.model.architecture.layers.LinkLayerView;
import io.flogo.builder.model.architecture.layers.output.OneDimensionOutput;

public class FlattenLayerView implements LinkLayerView {
    public final int startDimension;
    public final int endDimension;
    public final Output previousLayerOutput;
    public final OneDimensionOutput thisLayerOutput;

    public FlattenLayerView(Output previousLayerOutput, OneDimensionOutput thisLayerOutput) {
        this.startDimension = previousLayerOutput.dimensions();
        this.endDimension = thisLayerOutput.dimensions();
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
    }
}
