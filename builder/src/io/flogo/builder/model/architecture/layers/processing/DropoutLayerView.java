package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ProcessingLayerView;
import io.flogo.builder.model.laboratory.SubstituteView;
import io.intino.magritte.framework.Layer;

public final class DropoutLayerView implements ProcessingLayerView {
    public final double probability;
    public final OutputView output;

    public DropoutLayerView(OutputView output, double probability) {
        this.probability = probability;
        this.output = output;
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput) {
        return new DropoutLayerView(previousOutput, probability(layer));
    }

    public static LayerView createFromSubstitute(LayerView previous, SubstituteView substituteView) {
        return new DropoutLayerView(previous.getOutputView(), probability(substituteView.layer));
    }

    @Override
    public LayerView from(LayerView previous) {
        return new DropoutLayerView(previous == null ? this.output: previous.getOutputView(), this.probability);
    }

    private static double probability(Layer layer) {
        try {
            return (double) layer.getClass().getDeclaredMethod("probability").invoke(layer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OutputView getOutputView() {
        return output;
    }
}
