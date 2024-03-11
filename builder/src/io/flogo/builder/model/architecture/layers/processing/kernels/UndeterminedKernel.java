package io.flogo.builder.model.architecture.layers.processing.kernels;

import io.flogo.builder.model.architecture.layers.processing.Kernel;

public class UndeterminedKernel implements Kernel {

    @Override
    public Size size() {
        return null;
    }

    @Override
    public Stride stride() {
        return null;
    }

    @Override
    public Padding padding() {
        return null;
    }
}
