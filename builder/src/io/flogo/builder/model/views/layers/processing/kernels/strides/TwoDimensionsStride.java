package io.flogo.builder.model.views.layers.processing.kernels.strides;

import io.flogo.builder.model.views.layers.processing.Kernel;

public record TwoDimensionsStride(int xStrideStepSize, int yStrideStepSize) implements Kernel.Stride {
}
