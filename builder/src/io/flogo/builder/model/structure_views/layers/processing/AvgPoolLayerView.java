package io.flogo.builder.model.structure_views.layers.processing;

import io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool;
import io.flogo.builder.model.structure_views.Output;
import io.flogo.builder.model.structure_views.layers.ProcessingLayerView;
import io.flogo.builder.model.structure_views.layers.output.ThreeDimensionsOutput;
import io.flogo.builder.model.structure_views.layers.processing.kernels.PoolTwoDimensionsKernel;
import io.intino.magritte.framework.Layer;

public class AvgPoolLayerView implements ProcessingLayerView {
    public final int inChannels;
    public final int outChannels;
    public final PoolTwoDimensionsKernel kernel;
    private final ThreeDimensionsOutput previousLayerOutput;
    private final ThreeDimensionsOutput thisLayerOutput;

    public AvgPoolLayerView(ThreeDimensionsOutput previousLayerOutput, ThreeDimensionsOutput thisLayerOutput) {
        this.inChannels = previousLayerOutput.z();
        this.outChannels = thisLayerOutput.z();
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
        this.kernel = PoolTwoDimensionsKernel.kernelFor(previousLayerOutput, thisLayerOutput);
    }

    public static ProcessingLayerView from(Layer layer, Output previousOutput) {
        return new AvgPoolLayerView((ThreeDimensionsOutput) previousOutput, thisOutput(layer, previousOutput));
    }

    private static ThreeDimensionsOutput thisOutput(Layer layer, Output previousOutput) {
        return new ThreeDimensionsOutput(((AvgPool) layer).output(), ((ThreeDimensionsOutput) previousOutput).z());
    }

    @Override
    public Output getLayerOutput() {
        return thisLayerOutput;
    }
}
