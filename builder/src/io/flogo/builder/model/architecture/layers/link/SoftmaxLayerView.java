package io.flogo.builder.model.architecture.layers.link;

import io.flogo.builder.model.architecture.Output;
import io.flogo.builder.model.architecture.layers.LinkLayerView;

public class SoftmaxLayerView implements LinkLayerView {
    public final int dimension;

    public SoftmaxLayerView(Output thisLayerOutput) {
        this.dimension = thisLayerOutput.dimensions();
    }
}
