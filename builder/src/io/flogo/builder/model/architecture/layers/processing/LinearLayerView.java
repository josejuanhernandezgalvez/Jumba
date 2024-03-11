package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ProcessingLayerView;
import io.flogo.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.flogo.model.LinearSection;
import io.intino.magritte.framework.Layer;

public final class LinearLayerView implements ProcessingLayerView {
    public final OutputView previousLayerOutput;
    public final OutputView thisLayerOutput;

    public LinearLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput) {
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput) {
        return new LinearLayerView(previousOutput, getOutputFor(layer));
    }

    private static OneDimensionOutputView getOutputFor(Layer layer) {
        return new OneDimensionOutputView(getX((LinearSection.Block.Linear) layer));
    }

    private static int getX(LinearSection.Block.Linear layer) {
        return layer.output().x();
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput;
    }
}
