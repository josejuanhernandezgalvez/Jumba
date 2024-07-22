package io.jumba.builder.model.architecture.layers.processing;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.ProcessingLayerView;
import io.intino.magritte.framework.Layer;

public class LayerNormalizationLayerView implements ProcessingLayerView {
    public final OutputView output;
    public final double eps;

    public LayerNormalizationLayerView(OutputView output, double eps) {
        this.output = output;
        this.eps = eps;
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput, CompilationContext context) {
        return new LayerNormalizationLayerView(previousOutput, eps(layer));
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
