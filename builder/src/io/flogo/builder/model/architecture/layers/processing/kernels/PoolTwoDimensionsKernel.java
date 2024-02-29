package io.flogo.builder.model.architecture.layers.processing.kernels;

import io.flogo.builder.model.architecture.layers.processing.Kernel;
import io.flogo.builder.model.architecture.layers.output.ThreeDimensionsOutput;
import io.flogo.builder.model.architecture.layers.processing.kernels.paddings.TwoDimensionsPadding;
import io.flogo.builder.model.architecture.layers.processing.kernels.size.TwoDimensionsSize;
import io.flogo.builder.model.architecture.layers.processing.kernels.strides.TwoDimensionsStride;

public record PoolTwoDimensionsKernel(Size size, Stride stride, Padding padding) implements Kernel {

    public static PoolTwoDimensionsKernel kernelFor(ThreeDimensionsOutput previousOutput, ThreeDimensionsOutput thisOutput) {
        return new PoolTwoDimensionsKernel(sizeFor(previousOutput, thisOutput),
                                           strideFor(previousOutput, thisOutput),
                                           paddingFor(previousOutput, thisOutput));
    }

    private static TwoDimensionsStride strideFor(ThreeDimensionsOutput previousOutput, ThreeDimensionsOutput thisOutput) {
        return new TwoDimensionsStride(sizeFor(previousOutput, thisOutput).xSize(),
                                       sizeFor(previousOutput, thisOutput).ySize());
    }

    private static TwoDimensionsSize sizeFor(ThreeDimensionsOutput previousOutput, ThreeDimensionsOutput thisOutput) {
        return new TwoDimensionsSize((int) Math.ceil((double) previousOutput.x() / thisOutput.x()),
                                     (int) Math.ceil((double) previousOutput.y() / thisOutput.y()));
    }

    private static TwoDimensionsPadding paddingFor(ThreeDimensionsOutput previousOutput, ThreeDimensionsOutput thisOutput) {
        return new TwoDimensionsPadding(thisOutput.x() - (previousOutput.x() / sizeFor(previousOutput, thisOutput).xSize()),
                                        thisOutput.x() - (previousOutput.x() / sizeFor(previousOutput, thisOutput).ySize()));
    }
}
