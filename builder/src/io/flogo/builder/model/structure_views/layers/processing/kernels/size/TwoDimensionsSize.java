package io.flogo.builder.model.structure_views.layers.processing.kernels.size;

import io.flogo.builder.model.structure_views.layers.processing.Kernel;

public record TwoDimensionsSize(int xSize, int ySize) implements Kernel.Size {
}
