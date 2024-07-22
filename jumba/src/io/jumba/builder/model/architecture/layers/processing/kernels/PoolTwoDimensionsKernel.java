package io.jumba.builder.model.architecture.layers.processing.kernels;

import io.jumba.builder.model.architecture.layers.output.ThreeDimensionsOutputView;
import io.jumba.builder.model.architecture.layers.processing.Kernel;
import io.jumba.builder.model.architecture.layers.processing.kernels.paddings.TwoDimensionsPadding;
import io.jumba.builder.model.architecture.layers.processing.kernels.size.TwoDimensionsSize;
import io.jumba.builder.model.architecture.layers.processing.kernels.strides.TwoDimensionsStride;

import java.util.Map;

public record PoolTwoDimensionsKernel(Size size, Stride stride, Padding padding) implements Kernel {
    private final static int maxStride = 10;
    private final static int maxKernelSize = 10;
    private final static int maxPaddingSize = 50;

    public static PoolTwoDimensionsKernel kernelFor(ThreeDimensionsOutputView previousOutput, ThreeDimensionsOutputView thisOutput) {
        return new PoolTwoDimensionsKernel(sizeFor(previousOutput, thisOutput), strideFor(previousOutput, thisOutput), paddingFor(previousOutput, thisOutput));
    }

    private static TwoDimensionsSize sizeFor(ThreeDimensionsOutputView previousOutput, ThreeDimensionsOutputView thisOutput) {
        TwoDimensionsStride stride = strideFor(previousOutput, thisOutput);
        return new TwoDimensionsSize(
                sizeX(previousOutput, thisOutput, stride),
                sizeY(previousOutput, thisOutput, stride)
        );
    }

    private static int sizeY(ThreeDimensionsOutputView previousOutput, ThreeDimensionsOutputView thisOutput, TwoDimensionsStride stride) {
        int sizeY = 0;
        for (int candidateY = 0; candidateY < maxKernelSize; candidateY++) {
            ThreeDimensionsOutputView outputView = new ConvolutionTwoDimensionsKernel(new TwoDimensionsSize(1, candidateY), stride, new TwoDimensionsPadding(0, 0)).outputFor(previousOutput, 0);
            if (outputView.y() == thisOutput.y()) sizeY = candidateY;
        }
        return thisOutput.y() > previousOutput.y() ? ((thisOutput.y() - previousOutput.y()) % 2 == 0) ? 1 : 2 : sizeY == 0 ? 3 : sizeY;
    }

    private static int sizeX(ThreeDimensionsOutputView previousOutput, ThreeDimensionsOutputView thisOutput, TwoDimensionsStride stride) {
        int sizeX = 0;
        for (int candidateX = 0; candidateX < maxKernelSize; candidateX++) {
            ThreeDimensionsOutputView outputView = new ConvolutionTwoDimensionsKernel(new TwoDimensionsSize(candidateX, 1), stride, new TwoDimensionsPadding(0, 0)).outputFor(previousOutput, 0);
            if (outputView.x() == thisOutput.x()) sizeX = candidateX;
        }
        return thisOutput.x() > previousOutput.x() ? ((thisOutput.x() - previousOutput.x()) % 2 == 0) ? 1 : 2 : sizeX == 0 ? 3 : sizeX;
    }

    private static TwoDimensionsStride strideFor(ThreeDimensionsOutputView previousOutput, ThreeDimensionsOutputView thisOutput) {
        return new TwoDimensionsStride(
                xStrideStepSize(previousOutput, thisOutput),
                yStrideStepSize(previousOutput, thisOutput)
        );
    }

    private static int yStrideStepSize(ThreeDimensionsOutputView previousOutput, ThreeDimensionsOutputView thisOutput) {
        if (thisOutput.y() > previousOutput.y()) return 1;
        Map.Entry<Integer, Integer> min = Map.entry(0, Integer.MAX_VALUE);
        for (int strideCandidate = 1; strideCandidate < maxStride; strideCandidate++) {
            int diff = Math.abs((previousOutput.y() / strideCandidate) - thisOutput.y());
            if (diff < min.getValue()) min = Map.entry(strideCandidate, diff);
        }
        return min.getKey();
    }

    private static int xStrideStepSize(ThreeDimensionsOutputView previousOutput, ThreeDimensionsOutputView thisOutput) {
        if (thisOutput.x() > previousOutput.x()) return 1;
        Map.Entry<Integer, Integer> min = Map.entry(0, Integer.MAX_VALUE);
        for (int strideCandidate = 1; strideCandidate < maxStride; strideCandidate++) {
            int diff = Math.abs((previousOutput.x() / strideCandidate) - thisOutput.x());
            if (diff < min.getValue()) min = Map.entry(strideCandidate, diff);
        }
        return min.getKey();
    }

    private static TwoDimensionsPadding paddingFor(ThreeDimensionsOutputView previousOutput, ThreeDimensionsOutputView thisOutput) {
        TwoDimensionsStride stride = strideFor(previousOutput, thisOutput);
        TwoDimensionsSize size = sizeFor(previousOutput, thisOutput);
        return new TwoDimensionsPadding(
                thisOutput.x() > previousOutput.x() ? (previousOutput.x() - thisOutput.x()) % 2 == 0 ? (thisOutput.x() - previousOutput.x()) / 2 : 1 + (thisOutput.x() - previousOutput.x()) / 2 : paddingX(previousOutput, thisOutput, size, stride),
                thisOutput.y() > previousOutput.y() ? (previousOutput.y() - thisOutput.y()) % 2 == 0 ? (thisOutput.y() - previousOutput.y()) / 2 : 1 + (thisOutput.y() - previousOutput.y()) / 2 : paddingY(previousOutput, thisOutput, size, stride));
    }

    private static int paddingX(ThreeDimensionsOutputView previousOutput, ThreeDimensionsOutputView thisOutput, TwoDimensionsSize size, TwoDimensionsStride stride) {
        int sizeX = 0;
        for (int candidateX = 0; candidateX < maxPaddingSize; candidateX++) {
            ThreeDimensionsOutputView outputView = new ConvolutionTwoDimensionsKernel(size, stride, new TwoDimensionsPadding(candidateX, 0)).outputFor(previousOutput, 0);
            if (outputView.x() == thisOutput.x()) {
                sizeX = candidateX;
                break;
            }
        }
        return Math.min(sizeX, (int) Math.floor((double) size.xSize() / 2));
    }

    private static int paddingY(ThreeDimensionsOutputView previousOutput, ThreeDimensionsOutputView thisOutput, TwoDimensionsSize size, TwoDimensionsStride stride) {
        int sizeY = 0;
        for (int candidateY = 0; candidateY < maxPaddingSize; candidateY++) {
            ThreeDimensionsOutputView outputView = new ConvolutionTwoDimensionsKernel(size, stride, new TwoDimensionsPadding(candidateY, 0)).outputFor(previousOutput, 0);
            if (outputView.x() == thisOutput.x()) {
                sizeY = candidateY;
                break;
            }
        }
        return Math.min(sizeY, (int) Math.floor((double) size.xSize() / 2));
    }

    public static ThreeDimensionsOutputView outputFor(ThreeDimensionsOutputView input, PoolTwoDimensionsKernel kernel, int OutChannels) {
        return new ThreeDimensionsOutputView(calculateX(input, kernel.size, kernel.padding, kernel.stride), calculateY(input, kernel.size, kernel.padding, kernel.stride), OutChannels);
    }

    public ThreeDimensionsOutputView outputFor(ThreeDimensionsOutputView input) {
        return new ThreeDimensionsOutputView(calculateX(input, this.size, this.padding, this.stride), calculateY(input, this.size, this.padding, this.stride), input.z());
    }

    private static int calculateX(ThreeDimensionsOutputView previousLayerOutput, Size size, Padding padding, Stride stride) {
        return (int) Math.ceil(((double) previousLayerOutput.x() - ((TwoDimensionsSize) size).xSize() + 1 +
                2 * ((TwoDimensionsPadding) padding).xPaddingFrameSize()) /
                ((double) ((TwoDimensionsStride) stride).xStrideStepSize()));
    }

    private static int calculateY(ThreeDimensionsOutputView previousLayerOutput, Size size, Padding padding, Stride stride) {
        return (int) Math.ceil(((double) previousLayerOutput.y() - ((TwoDimensionsSize) size).ySize() + 1 +
                2 * ((TwoDimensionsPadding) padding).yPaddingFrameSize()) /
                ((double) ((TwoDimensionsStride) stride).yStrideStepSize()));
    }
}
