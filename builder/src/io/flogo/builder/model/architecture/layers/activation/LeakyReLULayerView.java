package io.flogo.builder.model.architecture.layers.activation;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ActivationLayerView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.laboratory.SubstituteView;
import io.intino.magritte.framework.Layer;

import java.lang.reflect.Field;

public final class LeakyReLULayerView implements ActivationLayerView {
    public final int alpha;
    public final OutputView outputView;

    public LeakyReLULayerView(int alpha, OutputView outputView) {
        this.alpha = alpha;
        this.outputView = outputView;
    }

    public static ActivationLayerView from(Layer layer, OutputView outputView) {
        return new LeakyReLULayerView(getAlphaFrom(layer), outputView);
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
    public LayerView from(VLayerView vLayerView, SubstituteView substituteViews) {
        return null;
    }

    @Override
    public LayerView from(LayerView previous) {
        return null;
    }
}
