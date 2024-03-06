package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ProcessingLayerView;
import io.flogo.builder.model.architecture.layers.output.ThreeDimensionsOutputView;
import io.flogo.builder.model.architecture.layers.processing.kernels.PoolTwoDimensionsKernel;
import io.flogo.builder.model.architecture.layers.processing.kernels.paddings.TwoDimensionsPadding;
import io.flogo.builder.model.architecture.layers.processing.kernels.size.TwoDimensionsSize;
import io.flogo.builder.model.architecture.layers.processing.kernels.strides.TwoDimensionsStride;
import io.flogo.model.ConvolutionalSection.Block.MaxPool;
import io.intino.magritte.framework.Layer;

public class MaxPoolLayerView implements ProcessingLayerView {
    public final PoolTwoDimensionsKernel kernel;
    private final ThreeDimensionsOutputView thisLayerOutput;
    private final ThreeDimensionsOutputView previousLayerOutput;

    public MaxPoolLayerView(ThreeDimensionsOutputView previousLayerOutput, ThreeDimensionsOutputView thisLayerOutput) {
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
        this.kernel = PoolTwoDimensionsKernel.kernelFor(previousLayerOutput, thisLayerOutput);
    }

    public MaxPoolLayerView(PoolTwoDimensionsKernel kernel, ThreeDimensionsOutputView previousLayerOutput) {
        this.kernel = kernel;
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = calculateLayerOutput();
    }

    private ThreeDimensionsOutputView calculateLayerOutput() {
        return new ThreeDimensionsOutputView(getX(), getY(), previousLayerOutput.z());
    }

    private int getX() {
        return (previousLayerOutput.x() - ((TwoDimensionsSize) kernel.size()).xSize() + 1 +
                2 * ((TwoDimensionsPadding) kernel.padding()).xPaddingFrameSize()) /
                ((TwoDimensionsStride) kernel.stride()).xStrideStepSize();
    }

    private int getY() {
        return (previousLayerOutput.y() - ((TwoDimensionsSize) kernel.size()).ySize() + 1 +
                2 * ((TwoDimensionsPadding) kernel.padding()).yPaddingFrameSize()) /
                ((TwoDimensionsStride) kernel.stride()).yStrideStepSize();
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput) {
        if (hasNotOutput(layer))
            return new MaxPoolLayerView(kernel(layer), cast(previousOutput));
        return new AvgPoolLayerView(cast(previousOutput), thisOutput(layer, previousOutput));
    }

    private static ThreeDimensionsOutputView cast(OutputView previousOutput) {
        return (ThreeDimensionsOutputView) previousOutput;
    }

    private static PoolTwoDimensionsKernel kernel(Layer layer) {
        return new PoolTwoDimensionsKernel(
                new TwoDimensionsSize(((MaxPool) layer).kernel().size().x(), ((MaxPool) layer).kernel().size().y()),
                new TwoDimensionsStride(((MaxPool) layer).kernel().stride().x(), ((MaxPool) layer).kernel().stride().y()),
                new TwoDimensionsPadding(((MaxPool) layer).kernel().padding().x(), ((MaxPool) layer).kernel().padding().y()));
    }

    private static boolean hasNotOutput(Layer layer) {
        try {
            return layer.getClass().getDeclaredMethod("output").invoke(layer) == null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private static ThreeDimensionsOutputView thisOutput(Layer layer, OutputView previousOutput) {
        try {
            Object output = layer.getClass().getMethod("output").invoke(layer);
            return new ThreeDimensionsOutputView(getValue(output, "x"), getValue(output, "y"), ((ThreeDimensionsOutputView) previousOutput).z());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static int getValue(Object output, String argument) throws Exception {
        return (int) output.getClass().getMethod(argument).invoke(output);
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput;
    }
}
