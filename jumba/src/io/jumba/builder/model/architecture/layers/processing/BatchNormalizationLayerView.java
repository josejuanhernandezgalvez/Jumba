package io.jumba.builder.model.architecture.layers.processing;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.model.architecture.LayerView;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.ProcessingLayerView;
import io.intino.magritte.framework.Layer;

public class BatchNormalizationLayerView implements ProcessingLayerView {
    public final OutputView output;
    public final double momentum;
    public final double eps;
    private boolean mutable;

    public BatchNormalizationLayerView(OutputView output, double momentum, double eps) {
        this.output = output;
        this.momentum = momentum;
        this.eps = eps;
        this.mutable = false;
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput, CompilationContext context) {
        return new BatchNormalizationLayerView(previousOutput, momentum(layer), eps(layer)).setMutable(LayerView.getMutable(layer));
    }

    private ProcessingLayerView setMutable(boolean mutable) {
        this.mutable = mutable;
        return this;
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

    @Override
    public boolean isMutable() {
        return mutable;
    }
}
