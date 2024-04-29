package io.flogo.builder.model.architecture.layers.processing.kernels.paddings;

import io.flogo.builder.model.architecture.layers.processing.Kernel;

public record TwoDimensionsPadding(int xPaddingFrameSize, int yPaddingFrameSize) implements Kernel.Padding {
    @Override
    public Integer[] asArray() {
        return new Integer[]{xPaddingFrameSize, yPaddingFrameSize};
    }
}
