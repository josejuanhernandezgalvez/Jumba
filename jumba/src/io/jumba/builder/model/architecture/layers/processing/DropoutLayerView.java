package io.jumba.builder.model.architecture.layers.processing;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.model.architecture.LayerView;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.ProcessingLayerView;
import io.intino.magritte.framework.Layer;

public final class DropoutLayerView implements ProcessingLayerView {
    public final double probability;
    public final OutputView output;
    private boolean mutable;

    public DropoutLayerView(OutputView output, double probability) {
        this.probability = probability;
        this.output = output;
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput, CompilationContext context) {
        return new DropoutLayerView(previousOutput, probability(layer)).setMutable(LayerView.getMutable(layer));
    }

    private ProcessingLayerView setMutable(boolean mutable) {
        this.mutable = mutable;
        return this;
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

    @Override
    public boolean isMutable() {
        return mutable;
    }
}
