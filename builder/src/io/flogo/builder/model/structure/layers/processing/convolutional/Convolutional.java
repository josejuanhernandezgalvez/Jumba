package io.flogo.builder.model.structure.layers.processing.convolutional;

import io.flogo.builder.model.structure.Output;
import io.flogo.builder.model.structure.layers.ProcessingLayer;
import io.flogo.builder.model.structure.layers.output.ThreeDimensionsOutput;
import org.antlr.v4.runtime.misc.Pair;

public abstract class Convolutional implements ProcessingLayer {
    public final Pair<Integer, Integer> kernel;
    public final int stride;
    public final int padding;
    public final Output output;

    public Convolutional(ThreeDimensionsOutput previous, ThreeDimensionsOutput output) {
        this.kernel = kernel(previous, output);
        this.stride = stride(previous, output);
        this.padding = padding(previous, output);
        this.output = output;
    }

    @Override
    public Output output() {
        return output;
    }

    private Pair<Integer, Integer> kernel(ThreeDimensionsOutput previous, ThreeDimensionsOutput output) {
        return new Pair<>(previous.x() - output.x(), previous.y() - output.y());
    }

    private int stride(ThreeDimensionsOutput previous, ThreeDimensionsOutput output) {
        return 1;
    }

    private int padding(ThreeDimensionsOutput previous, ThreeDimensionsOutput output) {
        return 0;
    }
}
