package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.model.ConvolutionalSection.Block.Normalization;
import io.flogo.builder.model.architecture.Output;
import io.flogo.builder.model.architecture.layers.ProcessingLayerView;
import io.flogo.builder.model.architecture.layers.output.ThreeDimensionsOutput;
import io.intino.magritte.framework.Layer;

public class NormalizationLayerView implements ProcessingLayerView {
    public final ThreeDimensionsOutput output;
    public final int features;
    public final double momentum;
    public final double eps;

    public NormalizationLayerView(ThreeDimensionsOutput output, double momentum, double eps) {
        this.output = output;
        this.features = output.z();
        this.momentum = momentum;
        this.eps = eps;
    }

    public static ProcessingLayerView from(Layer layer, Output previousOutput) {
        return new NormalizationLayerView((ThreeDimensionsOutput) previousOutput, getMomentum(layer), getEps(layer));
    }

    private static double getMomentum(Layer layer) {
        return ((Normalization) layer).momentum();
    }

    private static double getEps(Layer layer) {
        return ((Normalization) layer).momentum();
    }

    @Override
    public Output getLayerOutput() {
        return output;
    }
}
