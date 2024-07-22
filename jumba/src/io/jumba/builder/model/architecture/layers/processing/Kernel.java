package io.jumba.builder.model.architecture.layers.processing;

public interface Kernel {
    Size size();

    Stride stride();

    Padding padding();

    interface Size {
        Integer[] asArray();
    }

    interface Stride {
        Integer[] asArray();
    }

    interface Padding {
        Integer[] asArray();
    }
}
