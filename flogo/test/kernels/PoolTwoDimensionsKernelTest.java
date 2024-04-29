package kernels;

import io.flogo.builder.model.architecture.layers.output.ThreeDimensionsOutputView;
import io.flogo.builder.model.architecture.layers.processing.kernels.PoolTwoDimensionsKernel;
import io.flogo.builder.model.architecture.layers.processing.kernels.paddings.TwoDimensionsPadding;
import io.flogo.builder.model.architecture.layers.processing.kernels.size.TwoDimensionsSize;
import io.flogo.builder.model.architecture.layers.processing.kernels.strides.TwoDimensionsStride;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PoolTwoDimensionsKernelTest {

    @Test
    public void should_return_kernel_of_size_2_by_2_and_stride_2_by_2() {
        PoolTwoDimensionsKernel kernel = PoolTwoDimensionsKernel.kernelFor(
                new ThreeDimensionsOutputView(22, 22, 3),
                new ThreeDimensionsOutputView(11, 11, 3));
        PoolTwoDimensionsKernel expected = new PoolTwoDimensionsKernel(
                new TwoDimensionsSize(2, 2),
                new TwoDimensionsStride(2, 2),
                new TwoDimensionsPadding(0, 0));
        assertThat(kernel).isEqualTo(expected);
    }

    @Test
    public void should_return_kernel_of_size_3_by_3_and_stride_3_by_3() {
        PoolTwoDimensionsKernel kernel = PoolTwoDimensionsKernel.kernelFor(
                new ThreeDimensionsOutputView(21, 21, 3),
                new ThreeDimensionsOutputView(7, 7, 3));
        PoolTwoDimensionsKernel expected = new PoolTwoDimensionsKernel(
                new TwoDimensionsSize(3, 3),
                new TwoDimensionsStride(3, 3),
                new TwoDimensionsPadding(0, 0));
        assertThat(kernel).isEqualTo(expected);
    }

    @Test
    public void should_return_kernel_of_size_5_by_5_and_stride_5_by_5() {
        PoolTwoDimensionsKernel kernel = PoolTwoDimensionsKernel.kernelFor(
                new ThreeDimensionsOutputView(50, 50, 3),
                new ThreeDimensionsOutputView(10, 10, 3));
        PoolTwoDimensionsKernel expected = new PoolTwoDimensionsKernel(
                new TwoDimensionsSize(5, 5),
                new TwoDimensionsStride(5, 5),
                new TwoDimensionsPadding(0, 0));
        assertThat(kernel).isEqualTo(expected);
    }

    @Test
    public void should_return_kernel_of_size_2_by_2_and_stride_2_by_2_and_padding_1_by_1() {
        PoolTwoDimensionsKernel kernel = PoolTwoDimensionsKernel.kernelFor(
                new ThreeDimensionsOutputView(22, 22, 3),
                new ThreeDimensionsOutputView(12, 12, 3));
        PoolTwoDimensionsKernel expected = new PoolTwoDimensionsKernel(
                new TwoDimensionsSize(2, 2),
                new TwoDimensionsStride(2, 2),
                new TwoDimensionsPadding(1, 0));
        assertThat(kernel).isEqualTo(expected);
    }

    @Test
    public void should_return_kernel_of_size_1_by_1_and_stride_1_by_1_and_padding_1_by_1() {
        PoolTwoDimensionsKernel kernel = PoolTwoDimensionsKernel.kernelFor(
                new ThreeDimensionsOutputView(50, 50, 3),
                new ThreeDimensionsOutputView(51, 51, 3));
        PoolTwoDimensionsKernel expected = new PoolTwoDimensionsKernel(
                new TwoDimensionsSize(1, 1),
                new TwoDimensionsStride(1, 1),
                new TwoDimensionsPadding(1, 0));
        assertThat(kernel).isEqualTo(expected);
    }

    @Test
    public void should_return_kernel_of_size_1_by_1_and_stride_1_by_1_and_padding_5_by_5() {
        PoolTwoDimensionsKernel kernel = PoolTwoDimensionsKernel.kernelFor(
                new ThreeDimensionsOutputView(50, 50, 3),
                new ThreeDimensionsOutputView(55, 55, 3));
        PoolTwoDimensionsKernel expected = new PoolTwoDimensionsKernel(
                new TwoDimensionsSize(1, 1),
                new TwoDimensionsStride(1, 1),
                new TwoDimensionsPadding(3, 2));
        assertThat(kernel).isEqualTo(expected);
    }

    @Test
    public void should_return_kernel_of_size_3_by_3_and_stride_3_by_3_and_padding_4_by_4() {
        PoolTwoDimensionsKernel kernel = PoolTwoDimensionsKernel.kernelFor(
                new ThreeDimensionsOutputView(50, 50, 3),
                new ThreeDimensionsOutputView(20, 20, 3));
        PoolTwoDimensionsKernel expected = new PoolTwoDimensionsKernel(
                new TwoDimensionsSize(3, 3),
                new TwoDimensionsStride(3, 3),
                new TwoDimensionsPadding(2, 2));
        assertThat(kernel).isEqualTo(expected);
    }
}
