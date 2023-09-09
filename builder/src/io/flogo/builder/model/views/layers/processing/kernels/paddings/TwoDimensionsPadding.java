package io.flogo.builder.model.views.layers.processing.kernels.paddings;

import io.flogo.builder.model.views.layers.processing.Kernel;

public record TwoDimensionsPadding(int xPaddingFrameSize, int yPaddingFrameSize) implements Kernel.Padding {
}
