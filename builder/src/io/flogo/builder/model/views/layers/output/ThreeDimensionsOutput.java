package io.flogo.builder.model.views.layers.output;

import io.flogo.blatt.model.ConvolutionalSection;
import io.flogo.builder.model.views.Output;

import java.util.List;
import java.util.Objects;

public final class ThreeDimensionsOutput implements Output {
    private final int x;
    private final int y;
    private final int z;

    public ThreeDimensionsOutput(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public ThreeDimensionsOutput(List<Object> objects) {
        this.x = (int) objects.get(0);
        this.y = (int) objects.get(1);
        this.z = (int) objects.get(2);
    }

    public ThreeDimensionsOutput(ConvolutionalSection.Block.Convolutional.Output output) {
        this.x = output.x();
        this.y = output.y();
        this.z = output.z();
    }

    public ThreeDimensionsOutput(ConvolutionalSection.Block.MaxPool.Output output, int z) {
        this.x = output.x();
        this.y = output.y();
        this.z = z;
    }

    public ThreeDimensionsOutput(ConvolutionalSection.Block.AvgPool.Output output, int z) {
        this.x = output.x();
        this.y = output.y();
        this.z = z;
    }

    @Override
    public int dimensions() {
        return 3;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public int z() {
        return z;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ThreeDimensionsOutput) obj;
        return this.x == that.x &&
                this.y == that.y &&
                this.z == that.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "ThreeDimensionsOutput[" +
                "x=" + x + ", " +
                "y=" + y + ", " +
                "z=" + z + ']';
    }

}
