package io.flogo.builder.model.structure_views.layers.processing.kernels.strides;

import io.flogo.builder.model.structure_views.layers.processing.Kernel;

public record TwoDimensionsStride(int xStrideStepSize, int yStrideStepSize) implements Kernel.Stride {
}
