package io.flogo.builder.model.views.layers.processing.kernels.size;

import io.flogo.builder.model.views.layers.processing.Kernel;

public record TwoDimensionsSize(int xSize, int ySize) implements Kernel.Size {
}
