package io.flogo.builder.model.views.layers.activation;

import io.flogo.builder.model.views.layers.ActivationLayerView;
import io.intino.magritte.framework.Layer;

public class MishLayerView implements ActivationLayerView {
    public static ActivationLayerView from(Layer layer) {
        return new MishLayerView();
    }
}
