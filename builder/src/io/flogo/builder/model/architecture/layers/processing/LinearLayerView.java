package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.model.LinearSection;
import io.flogo.builder.model.architecture.Output;
import io.flogo.builder.model.architecture.layers.ProcessingLayerView;
import io.flogo.builder.model.architecture.layers.output.OneDimensionOutput;
import io.intino.magritte.framework.Layer;

public record LinearLayerView(OneDimensionOutput previousLayerOutput, OneDimensionOutput thisLayerOutput) implements ProcessingLayerView {
    public static ProcessingLayerView from(Layer layer, Output previousOutput) {
        return new LinearLayerView((OneDimensionOutput) previousOutput, getOutputFor(layer));
    }

    private static OneDimensionOutput getOutputFor(Layer layer) {
        return new OneDimensionOutput(getX((LinearSection.Block.Linear) layer));
    }

    private static int getX(LinearSection.Block.Linear layer) {
        return layer.output().x();
    }

    @Override
    public Output getLayerOutput() {
        return thisLayerOutput;
    }
}
