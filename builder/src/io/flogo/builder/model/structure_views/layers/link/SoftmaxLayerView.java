package io.flogo.builder.model.structure_views.layers.link;

import io.flogo.builder.model.structure_views.Output;
import io.flogo.builder.model.structure_views.layers.LinkLayerView;

public class SoftmaxLayerView implements LinkLayerView {
    public final int dimension;

    public SoftmaxLayerView(Output thisLayerOutput) {
        this.dimension = thisLayerOutput.dimensions();
    }
}
