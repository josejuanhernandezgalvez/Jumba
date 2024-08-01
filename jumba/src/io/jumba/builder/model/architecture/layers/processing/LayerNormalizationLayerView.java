package io.jumba.builder.model.architecture.layers.processing;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.model.architecture.LayerView;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.ProcessingLayerView;
import io.intino.magritte.framework.Layer;

public class LayerNormalizationLayerView implements ProcessingLayerView {
    public final OutputView output;
    public final double eps;
    private boolean mutable;

    public LayerNormalizationLayerView(OutputView output, double eps) {
        this.output = output;
        this.eps = eps;
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput, CompilationContext context) {
        return new LayerNormalizationLayerView(previousOutput, eps(layer)).setMutable(LayerView.getMutable(layer));
    }

    private ProcessingLayerView setMutable(boolean mutable) {
        this.mutable = mutable;
        return this;
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

    @Override
    public boolean isMutable() {
        return mutable;
    }
}
