package io.flogo.builder.model.architecture.layers.output;

import io.flogo.builder.model.architecture.OutputView;
import io.flogo.model.ConvolutionalSection;

import java.util.List;
import java.util.Objects;

public final class ThreeDimensionsOutputView implements OutputView {
    private final int x;
    private final int y;
    private final int z;

    public ThreeDimensionsOutputView(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public ThreeDimensionsOutputView(List<Object> objects) {
        this.x = (int) objects.get(0);
        this.y = (int) objects.get(1);
        this.z = (int) objects.get(2);
    }

    public ThreeDimensionsOutputView(ConvolutionalSection.Block.Convolutional.Output output) {
        this.x = output.x();
        this.y = output.y();
        this.z = output.z();
    }

    public ThreeDimensionsOutputView(ConvolutionalSection.Block.MaxPool.Output output, int z) {
        this.x = output.x();
        this.y = output.y();
        this.z = z;
    }

    public ThreeDimensionsOutputView(ConvolutionalSection.Block.AvgPool.Output output, int z) {
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
        var that = (ThreeDimensionsOutputView) obj;
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
