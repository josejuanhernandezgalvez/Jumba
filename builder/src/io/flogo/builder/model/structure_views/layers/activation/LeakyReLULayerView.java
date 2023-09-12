package io.flogo.builder.model.structure_views.layers.activation;

import io.flogo.builder.model.structure_views.layers.ActivationLayerView;
import io.intino.magritte.framework.Layer;

import java.lang.reflect.Field;

public record LeakyReLULayerView(int alpha) implements ActivationLayerView {
    public static ActivationLayerView from(Layer layer) {
        return new LeakyReLULayerView(getAlphaFrom(layer));
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
}
