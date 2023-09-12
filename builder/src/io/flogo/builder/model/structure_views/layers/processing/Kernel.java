package io.flogo.builder.model.structure_views.layers.processing;

public interface Kernel  {
    Size size();
    Stride stride();
    Padding padding();

    interface Size {
    }

    interface Stride {
    }

    interface Padding{
    }
}
