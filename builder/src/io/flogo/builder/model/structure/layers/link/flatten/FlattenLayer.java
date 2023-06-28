package io.flogo.builder.model.structure.layers.link.flatten;

import io.flogo.builder.model.structure.Output;
import io.flogo.builder.model.structure.layers.link.LinkLayer;
import io.flogo.builder.model.structure.layers.output.OneDimensionOutput;
import io.flogo.builder.model.structure.layers.output.ThreeDimensionsOutput;

public class FlattenLayer implements LinkLayer {
    public final int startDim;
    public final int endDim;

    public FlattenLayer(ThreeDimensionsOutput previous) {
        this.startDim = previous.z();
        this.endDim = 1;
    }

    @Override
    public Output output() {
        return new OneDimensionOutput(endDim);
    }

}
