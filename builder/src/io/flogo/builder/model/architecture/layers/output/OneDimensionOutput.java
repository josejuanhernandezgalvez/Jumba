package io.flogo.builder.model.architecture.layers.output;

import io.flogo.builder.model.architecture.Output;

import java.util.List;
import java.util.Objects;

public final class OneDimensionOutput implements Output {
    private final int x;

    public OneDimensionOutput(int x) {
        this.x = x;
    }

    public OneDimensionOutput(List<Object> objects) {
        this.x = (int) objects.get(0);
    }

    @Override
    public int dimensions() {
        return 1;
    }

    public int x() {
        return x;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (OneDimensionOutput) obj;
        return this.x == that.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x);
    }

    @Override
    public String toString() {
        return "OneDimensionOutput[" +
                "x=" + x + ']';
    }

}
