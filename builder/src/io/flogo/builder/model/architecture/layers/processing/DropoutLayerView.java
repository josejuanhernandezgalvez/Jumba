package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ProcessingLayerView;
import io.intino.magritte.framework.Layer;

import java.lang.reflect.InvocationTargetException;

public final class DropoutLayerView implements ProcessingLayerView {
    public final double probability;
    public final OutputView output;

    public DropoutLayerView(double probability, OutputView output) {
        this.probability = probability;
        this.output = output;
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput) {
        return new DropoutLayerView(probability(layer), previousOutput);
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
