package io.flogo.builder.model.architecture.layers.processing.kernels;

import io.flogo.builder.model.architecture.layers.processing.Kernel;
import io.flogo.builder.model.architecture.layers.processing.kernels.paddings.TwoDimensionsPadding;
import io.flogo.builder.model.architecture.layers.processing.kernels.size.TwoDimensionsSize;
import io.flogo.builder.model.architecture.layers.processing.kernels.strides.TwoDimensionsStride;
import io.flogo.builder.model.architecture.layers.output.ThreeDimensionsOutput;

public record ConvolutionTwoDimensionsKernel(Size size, Stride stride, Padding padding) implements Kernel {

    public static ConvolutionTwoDimensionsKernel kernelFor(ThreeDimensionsOutput previousOutput, ThreeDimensionsOutput thisOutput) {
        return new ConvolutionTwoDimensionsKernel(sizeFor(previousOutput, thisOutput),
                                                  strideFor(previousOutput, thisOutput),
                                                  paddingFor(previousOutput, thisOutput));
    }

    private static Stride strideFor(ThreeDimensionsOutput previousOutput, ThreeDimensionsOutput thisOutput) {
        return new TwoDimensionsStride(1,
                                       1);
    }

    private static TwoDimensionsSize sizeFor(ThreeDimensionsOutput previousOutput, ThreeDimensionsOutput thisOutput) {
        return new TwoDimensionsSize(
                !isGreater(thisOutput.x(), previousOutput.x()) ? previousOutput.x() - thisOutput.x() + 1 : 1,
                !isGreater(thisOutput.y(), previousOutput.y()) ? previousOutput.y() - thisOutput.y() + 1 : 1);
    }

    private static TwoDimensionsPadding paddingFor(ThreeDimensionsOutput previousOutput, ThreeDimensionsOutput thisOutput) {
        return new TwoDimensionsPadding(
                isGreater(thisOutput.x(), previousOutput.x()) ? thisOutput.x() - previousOutput.x() : 0,
                isGreater(thisOutput.y(), previousOutput.y()) ? thisOutput.y() - previousOutput.y() : 0);
    }

    private static boolean isGreater(int x, int y) {
        return x > y;
    }
}
