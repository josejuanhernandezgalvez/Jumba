package io.flogo.builder.model.views.layers.processing;

import io.flogo.blatt.model.ConvolutionalSection.Block.Convolutional;
import io.flogo.builder.model.views.Output;
import io.flogo.builder.model.views.layers.ProcessingLayerView;
import io.flogo.builder.model.views.layers.output.ThreeDimensionsOutput;
import io.flogo.builder.model.views.layers.processing.kernels.ConvolutionTwoDimensionsKernel;
import io.intino.magritte.framework.Layer;

public class ConvolutionalLayerView implements ProcessingLayerView {
    public final int inChannels;
    public final int outChannels;
    public final ConvolutionTwoDimensionsKernel kernel;
    private final ThreeDimensionsOutput previousLayerOutput;
    private final ThreeDimensionsOutput thisLayerOutput;

    public ConvolutionalLayerView(ThreeDimensionsOutput previousLayerOutput, ThreeDimensionsOutput thisLayerOutput) {
        this.inChannels = previousLayerOutput.z();
        this.outChannels = thisLayerOutput.z();
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
        this.kernel = ConvolutionTwoDimensionsKernel.kernelFor(previousLayerOutput, thisLayerOutput);
    }

    public static ProcessingLayerView from(Layer layer, Output previousOutput) {
        return new ConvolutionalLayerView((ThreeDimensionsOutput) previousOutput, thisOutput(layer));
    }

    private static ThreeDimensionsOutput thisOutput(Layer layer) {
        return new ThreeDimensionsOutput(((Convolutional) layer).output());
    }

    @Override
    public Output getLayerOutput() {
        return thisLayerOutput;
    }
}
