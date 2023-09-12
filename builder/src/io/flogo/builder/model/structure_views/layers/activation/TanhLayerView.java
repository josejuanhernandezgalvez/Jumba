package io.flogo.builder.model.structure_views.layers.activation;

import io.flogo.builder.model.structure_views.layers.ActivationLayerView;
import io.intino.magritte.framework.Layer;

public class TanhLayerView implements ActivationLayerView {
    public static ActivationLayerView from(Layer layer) {
        return new TanhLayerView();
    }
}
