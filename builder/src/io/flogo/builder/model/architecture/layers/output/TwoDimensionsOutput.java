package io.flogo.builder.model.architecture.layers.output;

import io.flogo.builder.model.architecture.Output;

import java.util.List;
import java.util.Objects;

public final class TwoDimensionsOutput implements Output {
    private final int x;
    private final int y;

    public TwoDimensionsOutput(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public TwoDimensionsOutput(List<Object> objects) {
        this.x = (int) objects.get(0);
        this.y = (int) objects.get(1);
    }

    @Override
    public int dimensions() {
        return 2;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (TwoDimensionsOutput) obj;
        return this.x == that.x &&
                this.y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "TwoDimensionsOutput[" +
                "x=" + x + ", " +
                "y=" + y + ']';
    }

}
