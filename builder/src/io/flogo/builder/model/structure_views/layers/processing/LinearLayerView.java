package io.flogo.builder.model.structure_views.layers.processing;

import io.flogo.blatt.model.LinearSection;
import io.flogo.builder.model.structure_views.Output;
import io.flogo.builder.model.structure_views.layers.ProcessingLayerView;
import io.flogo.builder.model.structure_views.layers.output.OneDimensionOutput;
import io.intino.magritte.framework.Layer;

public record LinearLayerView(OneDimensionOutput previousLayerOutput, OneDimensionOutput thisLayerOutput) implements ProcessingLayerView {
    public static ProcessingLayerView from(Layer layer, Output previousOutput) {
        return new LinearLayerView((OneDimensionOutput) previousOutput, getOutputFor(layer));
    }

    private static OneDimensionOutput getOutputFor(Layer layer) {
        return new OneDimensionOutput(getX((LinearSection.Block.Linear) layer));
    }

    private static int getX(LinearSection.Block.Linear layer) {
        return layer.outputList().get(0).x();
    }

    @Override
    public Output getLayerOutput() {
        return thisLayerOutput;
    }
}
