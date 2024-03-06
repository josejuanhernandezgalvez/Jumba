package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ProcessingLayerView;
import io.flogo.builder.model.architecture.layers.output.ThreeDimensionsOutputView;
import io.flogo.builder.model.architecture.layers.processing.kernels.ConvolutionTwoDimensionsKernel;
import io.flogo.builder.model.architecture.layers.processing.kernels.paddings.TwoDimensionsPadding;
import io.flogo.builder.model.architecture.layers.processing.kernels.size.TwoDimensionsSize;
import io.flogo.builder.model.architecture.layers.processing.kernels.strides.TwoDimensionsStride;
import io.flogo.model.ConvolutionalSection.Block.Convolutional;
import io.intino.magritte.framework.Layer;

public class ConvolutionalLayerView implements ProcessingLayerView {
    public final ConvolutionTwoDimensionsKernel kernel;
    public final ThreeDimensionsOutputView previousLayerOutput;
    public final ThreeDimensionsOutputView thisLayerOutput;

    public ConvolutionalLayerView(ThreeDimensionsOutputView previousLayerOutput, ThreeDimensionsOutputView thisLayerOutput) {
        this.kernel = ConvolutionTwoDimensionsKernel.kernelFor(previousLayerOutput, thisLayerOutput);
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
    }

    public ConvolutionalLayerView(ConvolutionTwoDimensionsKernel kernel, ThreeDimensionsOutputView previousLayerOutput, int outChannels) {
        this.kernel = kernel;
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = calculateLayerOutput(outChannels);
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput;
    }

    private ThreeDimensionsOutputView calculateLayerOutput(int outChannels) {
        return new ThreeDimensionsOutputView(calculateX(), calculateY(), outChannels);
    }

    private int calculateX() {
        return (previousLayerOutput.x() - ((TwoDimensionsSize) kernel.size()).xSize() + 1 +
                2 * ((TwoDimensionsPadding) kernel.padding()).xPaddingFrameSize()) /
                ((TwoDimensionsStride) kernel.stride()).xStrideStepSize();
    }

    private int calculateY() {
        return (previousLayerOutput.y() - ((TwoDimensionsSize) kernel.size()).ySize() + 1 +
                2 * ((TwoDimensionsPadding) kernel.padding()).yPaddingFrameSize()) /
                ((TwoDimensionsStride) kernel.stride()).yStrideStepSize();
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput) {
        if (hasNotOutput(layer))
            return new ConvolutionalLayerView(kernel(layer), cast(previousOutput), outChannels(layer));
        return new ConvolutionalLayerView(cast(previousOutput), thisOutput(layer));
    }

    private static boolean hasNotOutput(Layer layer) {
        try {
            return layer.getClass().getDeclaredMethod("output").invoke(layer) == null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static ConvolutionTwoDimensionsKernel kernel(Layer layer) {
        return new ConvolutionTwoDimensionsKernel(
                new TwoDimensionsSize(((Convolutional) layer).kernel().size().x(), ((Convolutional) layer).kernel().size().y()),
                new TwoDimensionsStride(((Convolutional) layer).kernel().stride().x(), ((Convolutional) layer).kernel().stride().y()),
                new TwoDimensionsPadding(((Convolutional) layer).kernel().padding().x(), ((Convolutional) layer).kernel().padding().y()));
    }

    private static ThreeDimensionsOutputView cast(OutputView previousOutput) {
        return (ThreeDimensionsOutputView) previousOutput;
    }

    private static int outChannels(Layer layer) {
        return ((Convolutional) layer).outChannels().z();
    }

    private static ThreeDimensionsOutputView thisOutput(Layer layer) {
        try {
            Object output = layer.getClass().getMethod("output").invoke(layer);
            return new ThreeDimensionsOutputView(getValue(output, "x"), getValue(output, "y"), getValue(output, "z"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static int getValue(Object output, String argument) throws Exception {
        return (int) output.getClass().getMethod(argument).invoke(output);
    }
}
