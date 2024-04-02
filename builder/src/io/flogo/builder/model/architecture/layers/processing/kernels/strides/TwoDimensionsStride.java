package io.flogo.builder.model.architecture.layers.processing.kernels.strides;

import io.flogo.builder.model.architecture.layers.processing.Kernel;

public record TwoDimensionsStride(int xStrideStepSize, int yStrideStepSize) implements Kernel.Stride {
    @Override
    public Integer[] asArray() {
        return new Integer[]{xStrideStepSize, yStrideStepSize};
    }
}
