package io.flogo.builder.model.architecture.layers.processing.kernels.size;

import io.flogo.builder.model.architecture.layers.processing.Kernel;

public record TwoDimensionsSize(int xSize, int ySize) implements Kernel.Size {
}
