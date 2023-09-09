package io.flogo.builder.model.views.layers.processing;

import io.flogo.blatt.model.ConvolutionalSection.Block.MaxPool;
import io.flogo.builder.model.views.Output;
import io.flogo.builder.model.views.layers.ProcessingLayerView;
import io.flogo.builder.model.views.layers.output.ThreeDimensionsOutput;
import io.flogo.builder.model.views.layers.processing.kernels.PoolTwoDimensionsKernel;
import io.intino.magritte.framework.Layer;

public class MaxPoolLayerView implements ProcessingLayerView {
    public final PoolTwoDimensionsKernel kernel;
    private final ThreeDimensionsOutput thisLayerOutput;
    private final ThreeDimensionsOutput previousLayerOutput;

    public MaxPoolLayerView(ThreeDimensionsOutput previousLayerOutput, ThreeDimensionsOutput thisLayerOutput) {
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
        this.kernel = PoolTwoDimensionsKernel.kernelFor(previousLayerOutput, thisLayerOutput);
    }

    public static ProcessingLayerView from(Layer layer, Output previousOutput) {
        return new MaxPoolLayerView((ThreeDimensionsOutput) previousOutput, thisOutput(layer, previousOutput));
    }

    private static ThreeDimensionsOutput thisOutput(Layer layer, Output previousOutput) {
        return new ThreeDimensionsOutput(((MaxPool) layer).output(), ((ThreeDimensionsOutput) previousOutput).z());
    }

    @Override
    public Output getLayerOutput() {
        return thisLayerOutput;
    }
}
