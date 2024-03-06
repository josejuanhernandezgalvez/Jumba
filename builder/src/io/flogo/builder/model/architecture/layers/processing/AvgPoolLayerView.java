package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ProcessingLayerView;
import io.flogo.builder.model.architecture.layers.output.ThreeDimensionsOutputView;
import io.flogo.builder.model.architecture.layers.processing.kernels.PoolTwoDimensionsKernel;
import io.flogo.builder.model.architecture.layers.processing.kernels.paddings.TwoDimensionsPadding;
import io.flogo.builder.model.architecture.layers.processing.kernels.size.TwoDimensionsSize;
import io.flogo.builder.model.architecture.layers.processing.kernels.strides.TwoDimensionsStride;
import io.flogo.model.ConvolutionalSection.Block.AvgPool;
import io.intino.magritte.framework.Layer;

public class AvgPoolLayerView implements ProcessingLayerView {
    public final PoolTwoDimensionsKernel kernel;
    private final ThreeDimensionsOutputView previousLayerOutput;
    private final ThreeDimensionsOutputView thisLayerOutput;

    public AvgPoolLayerView(ThreeDimensionsOutputView previousLayerOutput, ThreeDimensionsOutputView thisLayerOutput) {
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
        this.kernel = PoolTwoDimensionsKernel.kernelFor(previousLayerOutput, thisLayerOutput);
    }

    public AvgPoolLayerView(PoolTwoDimensionsKernel kernel, ThreeDimensionsOutputView previousLayerOutput) {
        this.kernel = kernel;
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = calculateLayerOutput();
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput;
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
            return new AvgPoolLayerView(kernel(layer), cast(previousOutput));
        return new AvgPoolLayerView(cast(previousOutput), thisOutput(layer, previousOutput));
    }

    private static ThreeDimensionsOutputView cast(OutputView previousOutput) {
        return (ThreeDimensionsOutputView) previousOutput;
    }

    private static PoolTwoDimensionsKernel kernel(Layer layer) {
        return new PoolTwoDimensionsKernel(
                new TwoDimensionsSize(((AvgPool) layer).kernel().size().x(), ((AvgPool) layer).kernel().size().y()),
                new TwoDimensionsStride(((AvgPool) layer).kernel().stride().x(), ((AvgPool) layer).kernel().stride().y()),
                new TwoDimensionsPadding(((AvgPool) layer).kernel().padding().x(), ((AvgPool) layer).kernel().padding().y()));
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
            return new ThreeDimensionsOutputView(getValue(output, "x"), getValue(output, "y"), getValue(previousOutput, "z"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static int getValue(Object output, String argument) throws Exception {
        return (int) output.getClass().getMethod(argument).invoke(output);
    }
}
