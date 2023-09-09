package io.flogo.builder.model.views.layers.link;

import io.flogo.builder.model.views.Output;
import io.flogo.builder.model.views.layers.LinkLayerView;

public class SoftmaxLayerView implements LinkLayerView {
    public final int dimension;

    public SoftmaxLayerView(Output thisLayerOutput) {
        this.dimension = thisLayerOutput.dimensions();
    }
}
