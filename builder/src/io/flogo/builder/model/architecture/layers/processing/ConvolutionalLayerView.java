package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.Output;
import io.flogo.builder.model.architecture.layers.ProcessingLayerView;
import io.flogo.builder.model.architecture.layers.output.ThreeDimensionsOutput;
import io.flogo.builder.model.architecture.layers.processing.kernels.ConvolutionTwoDimensionsKernel;
import io.flogo.builder.model.architecture.layers.processing.kernels.paddings.TwoDimensionsPadding;
import io.flogo.builder.model.architecture.layers.processing.kernels.size.TwoDimensionsSize;
import io.flogo.builder.model.architecture.layers.processing.kernels.strides.TwoDimensionsStride;
import io.flogo.model.ConvolutionalSection.Block.Convolutional;
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

    public ConvolutionalLayerView(int inChannels, int outChannels, ConvolutionTwoDimensionsKernel kernel, ThreeDimensionsOutput previousLayerOutput) {
        this.inChannels = inChannels;
        this.outChannels = outChannels;
        this.kernel = kernel;
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = calculateLayerOutput();
    }

    private ThreeDimensionsOutput calculateLayerOutput() {
        return new ThreeDimensionsOutput(getX(),getY(), outChannels);
    }

    private int getY() {
        return (previousLayerOutput.y() - ((TwoDimensionsSize) kernel.size()).ySize() + 1 +
                2 * ((TwoDimensionsPadding) kernel.padding()).yPaddingFrameSize()) /
                ((TwoDimensionsStride) kernel.stride()).yStrideStepSize();
    }

    private int getX() {
        return (previousLayerOutput.x() - ((TwoDimensionsSize) kernel.size()).xSize() + 1 +
                2 * ((TwoDimensionsPadding) kernel.padding()).xPaddingFrameSize()) /
                ((TwoDimensionsStride) kernel.stride()).xStrideStepSize();
    }

    public static ProcessingLayerView from(Layer layer, Output previousOutput) {
        if (((Convolutional) layer).output() == null)
            return new ConvolutionalLayerView(
                ((ThreeDimensionsOutput) previousOutput).z(),
                ((Convolutional) layer).outChannels().z(),
                kernel(layer),
                (ThreeDimensionsOutput) previousOutput);
        return new ConvolutionalLayerView((ThreeDimensionsOutput) previousOutput, thisOutput(layer));
    }

    private static ConvolutionTwoDimensionsKernel kernel(Layer layer) {
        return new ConvolutionTwoDimensionsKernel(
                new TwoDimensionsSize(((Convolutional) layer).kernel().size().x(), ((Convolutional) layer).kernel().size().y()),
                new TwoDimensionsStride(((Convolutional) layer).kernel().stride().x(), ((Convolutional) layer).kernel().stride().y()),
                new TwoDimensionsPadding(((Convolutional) layer).kernel().padding().x(), ((Convolutional) layer).kernel().padding().y()));
    }

    private static ThreeDimensionsOutput thisOutput(Layer layer) {
        try {
            Object output = layer.getClass().getMethod("output").invoke(layer);
            return new ThreeDimensionsOutput(getValue(output, "x"), getValue(output, "y"), getValue(output, "z"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static int getValue(Object output, String argument) throws Exception {
        return (int) output.getClass().getMethod(argument).invoke(output);
    }

    @Override
    public Output getLayerOutput() {
        return thisLayerOutput;
    }
}
