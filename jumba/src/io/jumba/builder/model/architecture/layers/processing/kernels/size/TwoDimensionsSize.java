package io.jumba.builder.model.architecture.layers.processing.kernels.size;

import io.jumba.builder.model.architecture.layers.processing.Kernel;

public record TwoDimensionsSize(int xSize, int ySize) implements Kernel.Size {
    @Override
    public Integer[] asArray() {
        return new Integer[]{xSize, ySize};
    }
}
