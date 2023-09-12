package io.flogo.builder.model.structure_views.layers.processing.kernels.paddings;

import io.flogo.builder.model.structure_views.layers.processing.Kernel;

public record TwoDimensionsPadding(int xPaddingFrameSize, int yPaddingFrameSize) implements Kernel.Padding {
}
