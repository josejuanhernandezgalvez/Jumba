package io.flogo.builder.model.architecture.layers.activation;

import io.flogo.builder.model.architecture.layers.ActivationLayerView;
import io.intino.magritte.framework.Layer;

public class GELULayerView implements ActivationLayerView {
    public static ActivationLayerView from(Layer layer) {
        return new GELULayerView();
    }
}
