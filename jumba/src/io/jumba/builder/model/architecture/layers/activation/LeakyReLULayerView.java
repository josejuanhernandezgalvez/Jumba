package io.jumba.builder.model.architecture.layers.activation;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.model.architecture.LayerView;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.ActivationLayerView;
import io.intino.magritte.framework.Layer;

import java.lang.reflect.Field;

public final class LeakyReLULayerView implements ActivationLayerView {
    public final int alpha;
    public final OutputView outputView;
    private boolean mutable;

    public LeakyReLULayerView(int alpha, OutputView outputView) {
        this.alpha = alpha;
        this.outputView = outputView;
    }

    public static ActivationLayerView from(Layer layer, OutputView outputView, CompilationContext context) {
        return new LeakyReLULayerView(getAlphaFrom(layer), outputView).setMutable(LayerView.getMutable(layer));
    }

    private ActivationLayerView setMutable(boolean mutable) {
        this.mutable = mutable;
        return this;
    }

    private static int getAlphaFrom(Layer layer) {
        try {
            Field alpha = layer.getClass().getDeclaredField("alpha");
            alpha.setAccessible(true);
            return (int) alpha.get(layer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OutputView getOutputView() {
        return outputView;
    }

    @Override
    public boolean isMutable() {
        return mutable;
    }
}
