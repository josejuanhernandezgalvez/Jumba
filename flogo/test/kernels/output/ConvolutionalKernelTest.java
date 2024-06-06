package kernels.output;

import io.flogo.builder.model.architecture.layers.output.ThreeDimensionsOutputView;
import io.flogo.builder.model.architecture.layers.processing.kernels.ConvolutionTwoDimensionsKernel;
import io.flogo.builder.model.architecture.layers.processing.kernels.PoolTwoDimensionsKernel;
import io.flogo.builder.model.architecture.layers.processing.kernels.paddings.TwoDimensionsPadding;
import io.flogo.builder.model.architecture.layers.processing.kernels.size.TwoDimensionsSize;
import io.flogo.builder.model.architecture.layers.processing.kernels.strides.TwoDimensionsStride;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ConvolutionalKernelTest {

    @Test
    public void should_return_kernel_of_size_3_by_3_and_stride_1_by_1() {
        ConvolutionTwoDimensionsKernel kernel = ConvolutionTwoDimensionsKernel.kernelFor(
                new ThreeDimensionsOutputView(22, 22, 3),
                new ThreeDimensionsOutputView(20, 20, 6));
        ConvolutionTwoDimensionsKernel expected = new ConvolutionTwoDimensionsKernel(
                new TwoDimensionsSize(3, 3),
                new TwoDimensionsStride(1, 1),
                new TwoDimensionsPadding(0, 0));
        assertThat(kernel).isEqualTo(expected);
    }

    @Test
    public void should_return_kernel_of_size_1_by_1_and_stride_1_by_1_and_padding_2_by_2() {
        ConvolutionTwoDimensionsKernel kernel = ConvolutionTwoDimensionsKernel.kernelFor(
                new ThreeDimensionsOutputView(22, 22, 3),
                new ThreeDimensionsOutputView(26, 26, 6));
        ConvolutionTwoDimensionsKernel expected = new ConvolutionTwoDimensionsKernel(
                new TwoDimensionsSize(1, 1),
                new TwoDimensionsStride(1, 1),
                new TwoDimensionsPadding(2, 2));
        assertThat(kernel).isEqualTo(expected);
    }

    @Test
    public void should_return_kernel_of_size_1_by_1_and_stride_1_by_1_and_padding_5_by_5() {
        ConvolutionTwoDimensionsKernel kernel = ConvolutionTwoDimensionsKernel.kernelFor(
                new ThreeDimensionsOutputView(40, 40, 3),
                new ThreeDimensionsOutputView(49, 49, 6));
        ConvolutionTwoDimensionsKernel expected = new ConvolutionTwoDimensionsKernel(
                new TwoDimensionsSize(2, 2),
                new TwoDimensionsStride(1, 1),
                new TwoDimensionsPadding(5, 5));
        assertThat(kernel).isEqualTo(expected);
    }

    @Test
    public void should_return_kernel_of_size_4_by_4_and_stride_1_by_1() {
        ConvolutionTwoDimensionsKernel kernel = ConvolutionTwoDimensionsKernel.kernelFor(
                new ThreeDimensionsOutputView(22, 22, 3),
                new ThreeDimensionsOutputView(19, 19, 6));
        ConvolutionTwoDimensionsKernel expected = new ConvolutionTwoDimensionsKernel(
                new TwoDimensionsSize(4, 4),
                new TwoDimensionsStride(1, 1),
                new TwoDimensionsPadding(0, 0));
        assertThat(kernel).isEqualTo(expected);
    }

    @Test
    public void should_return_kernel_of_size_2_by_2_and_stride_1_by_1() {
        ConvolutionTwoDimensionsKernel kernel = ConvolutionTwoDimensionsKernel.kernelFor(
                new ThreeDimensionsOutputView(22, 22, 3),
                new ThreeDimensionsOutputView(21, 21, 6));
        ConvolutionTwoDimensionsKernel expected = new ConvolutionTwoDimensionsKernel(
                new TwoDimensionsSize(2, 2),
                new TwoDimensionsStride(1, 1),
                new TwoDimensionsPadding(0, 0));
        assertThat(kernel).isEqualTo(expected);
    }

    @Test
    public void should_return_kernel_of_size_2_by_2_and_stride_1_by_1_and_padding_1_by_1() {
        ConvolutionTwoDimensionsKernel kernel = ConvolutionTwoDimensionsKernel.kernelFor(
                new ThreeDimensionsOutputView(22, 22, 3),
                new ThreeDimensionsOutputView(23, 23, 6));
        ConvolutionTwoDimensionsKernel expected = new ConvolutionTwoDimensionsKernel(
                new TwoDimensionsSize(2, 2),
                new TwoDimensionsStride(1, 1),
                new TwoDimensionsPadding(1, 1));
        assertThat(kernel).isEqualTo(expected);
    }


    @Test
    public void should_return_kernel_of_size_6_by_6_and_stride_1_by_1() {
        ConvolutionTwoDimensionsKernel kernel = ConvolutionTwoDimensionsKernel.kernelFor(
                new ThreeDimensionsOutputView(22, 22, 3),
                new ThreeDimensionsOutputView(17, 17, 6));
        ConvolutionTwoDimensionsKernel expected = new ConvolutionTwoDimensionsKernel(
                new TwoDimensionsSize(6, 6),
                new TwoDimensionsStride(1, 1),
                new TwoDimensionsPadding(0, 0));
        assertThat(kernel).isEqualTo(expected);
    }


    @Test
    public void should_return_kernel_of_size_3_by_1_and_stride_1_by_2_and_padding_0_by_0() {
        ConvolutionTwoDimensionsKernel kernel = ConvolutionTwoDimensionsKernel.kernelFor(
                new ThreeDimensionsOutputView(40, 40, 3),
                new ThreeDimensionsOutputView(38, 20, 6));
        ConvolutionTwoDimensionsKernel expected = new ConvolutionTwoDimensionsKernel(
                new TwoDimensionsSize(3, 2),
                new TwoDimensionsStride(1, 2),
                new TwoDimensionsPadding(0, 0));
        assertThat(kernel).isEqualTo(expected);
    }

    @Test
    public void should_return_kernel_of_size_2_by_2_and_stride_2_by_2() {
        ConvolutionTwoDimensionsKernel kernel = ConvolutionTwoDimensionsKernel.kernelFor(
                new ThreeDimensionsOutputView(22, 22, 3),
                new ThreeDimensionsOutputView(11, 11, 3));
        ConvolutionTwoDimensionsKernel expected = new ConvolutionTwoDimensionsKernel(
                new TwoDimensionsSize(2, 2),
                new TwoDimensionsStride(2, 2),
                new TwoDimensionsPadding(0, 0));
        assertThat(kernel).isEqualTo(expected);
    }

    @Test
    public void should_return_kernel_of_size_10_by_10_and_stride_10_by_10() {
        ConvolutionTwoDimensionsKernel kernel = ConvolutionTwoDimensionsKernel.kernelFor(
                new ThreeDimensionsOutputView(40, 40, 3),
                new ThreeDimensionsOutputView(10, 10, 3));
        ConvolutionTwoDimensionsKernel expected = new ConvolutionTwoDimensionsKernel(
                new TwoDimensionsSize(4, 4),
                new TwoDimensionsStride(4, 4),
                new TwoDimensionsPadding(0, 0));
        assertThat(kernel).isEqualTo(expected);
    }

    @Test
    public void should_return_kernel_of_size_3_by_3_and_stride_3_by_3_and_padding_4_by_4() {
        ConvolutionTwoDimensionsKernel kernel = ConvolutionTwoDimensionsKernel.kernelFor(
                new ThreeDimensionsOutputView(50, 50, 3),
                new ThreeDimensionsOutputView(18, 18, 3));
        ConvolutionTwoDimensionsKernel expected = new ConvolutionTwoDimensionsKernel(
                new TwoDimensionsSize(3, 3),
                new TwoDimensionsStride(3, 3),
                new TwoDimensionsPadding(2, 2));
        assertThat(kernel).isEqualTo(expected);
    }
}
