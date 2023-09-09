package io.flogo.builder.model.views.layers.link;

import io.flogo.builder.model.views.Output;
import io.flogo.builder.model.views.layers.LinkLayerView;
import io.flogo.builder.model.views.layers.output.OneDimensionOutput;

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
