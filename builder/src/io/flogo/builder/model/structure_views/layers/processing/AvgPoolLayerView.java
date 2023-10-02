package io.flogo.builder.model.structure_views.layers.processing;

import io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool;
import io.flogo.builder.model.structure_views.Output;
import io.flogo.builder.model.structure_views.layers.ProcessingLayerView;
import io.flogo.builder.model.structure_views.layers.output.ThreeDimensionsOutput;
import io.flogo.builder.model.structure_views.layers.processing.kernels.PoolTwoDimensionsKernel;
import io.flogo.builder.model.structure_views.layers.processing.kernels.paddings.TwoDimensionsPadding;
import io.flogo.builder.model.structure_views.layers.processing.kernels.size.TwoDimensionsSize;
import io.flogo.builder.model.structure_views.layers.processing.kernels.strides.TwoDimensionsStride;
import io.intino.magritte.framework.Layer;

public class AvgPoolLayerView implements ProcessingLayerView {
    public final PoolTwoDimensionsKernel kernel;
    private final ThreeDimensionsOutput previousLayerOutput;
    private final ThreeDimensionsOutput thisLayerOutput;

    public AvgPoolLayerView(ThreeDimensionsOutput previousLayerOutput, ThreeDimensionsOutput thisLayerOutput) {
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
        this.kernel = PoolTwoDimensionsKernel.kernelFor(previousLayerOutput, thisLayerOutput);
    }

    public AvgPoolLayerView(PoolTwoDimensionsKernel kernel, ThreeDimensionsOutput previousLayerOutput) {
        this.kernel = kernel;
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = calculateLayerOutput();
    }

    private ThreeDimensionsOutput calculateLayerOutput() {
        return new ThreeDimensionsOutput(getX(), getY(), previousLayerOutput.z());
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
