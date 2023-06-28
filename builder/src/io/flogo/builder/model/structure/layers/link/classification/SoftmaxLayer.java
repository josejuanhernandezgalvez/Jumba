package io.flogo.builder.model.structure.layers.link.classification;

import io.flogo.builder.model.structure.Output;
import io.flogo.builder.model.structure.layers.link.LinkLayer;
import io.flogo.builder.model.structure.layers.output.OneDimensionOutput;

public class SoftmaxLayer implements LinkLayer {
    public final int startDim;
    public final int endDim;

    public SoftmaxLayer(int endDim) {
        this.startDim = 1;
        this.endDim = endDim;
    }

    @Override
    public Output output() {
        return new OneDimensionOutput(endDim);
    }

}
