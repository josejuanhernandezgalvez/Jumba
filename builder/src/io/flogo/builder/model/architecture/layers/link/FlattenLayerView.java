package io.flogo.builder.model.architecture.layers.link;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.LinkLayerView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.laboratory.SubstituteView;

public class FlattenLayerView implements LinkLayerView {
    public final int fromDimension;
    public final int toDimension;
    public final OutputView previousLayerOutput;
    public final OutputView thisLayerOutput;

    public FlattenLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput) {
        this.fromDimension = previousLayerOutput.dimensions();
        this.toDimension = thisLayerOutput.dimensions();
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput;
    }

    @Override
    public LayerView from(VLayerView vLayerView, SubstituteView substituteViews) {
        return null;
    }

    @Override
    public LayerView from(LayerView previous) {
        return null;
    }
}
