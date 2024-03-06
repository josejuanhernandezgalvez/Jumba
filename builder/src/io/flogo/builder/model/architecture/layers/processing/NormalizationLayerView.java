package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ProcessingLayerView;
import io.intino.magritte.framework.Layer;

public class NormalizationLayerView implements ProcessingLayerView {
    public final OutputView output;
    public final double momentum;
    public final double eps;

    public NormalizationLayerView(OutputView output, double momentum, double eps) {
        this.output = output;
        this.momentum = momentum;
        this.eps = eps;
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput) {
        return new NormalizationLayerView(previousOutput, momentum(layer), eps(layer));
    }

    private static double momentum(Layer layer) {
        try {
            return (double) layer.getClass().getDeclaredMethod("momentum").invoke(layer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static double eps(Layer layer) {
        try {
            return (double) layer.getClass().getDeclaredMethod("eps").invoke(layer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OutputView getOutputView() {
        return output;
    }
}
