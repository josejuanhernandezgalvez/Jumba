package kernels.kernel;

import io.jumba.builder.model.architecture.layers.output.ThreeDimensionsOutputView;
import io.jumba.builder.model.architecture.layers.processing.kernels.ConvolutionTwoDimensionsKernel;
import io.jumba.builder.model.architecture.layers.processing.kernels.PoolTwoDimensionsKernel;
import io.jumba.builder.model.architecture.layers.processing.kernels.paddings.TwoDimensionsPadding;
import io.jumba.builder.model.architecture.layers.processing.kernels.size.TwoDimensionsSize;
import io.jumba.builder.model.architecture.layers.processing.kernels.strides.TwoDimensionsStride;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class OutputKernelTest {
    @Test
    public void should_return_kernel_output_126_126_4() {
        ConvolutionTwoDimensionsKernel kernel = new ConvolutionTwoDimensionsKernel(new TwoDimensionsSize(3, 3), new TwoDimensionsStride(1, 1), new TwoDimensionsPadding(0, 0));
        assertThat(kernel.outputFor(new ThreeDimensionsOutputView(128, 128, 3), 4)).isEqualTo(new ThreeDimensionsOutputView(126, 126, 4));
    }

    @Test
    public void should_return_kernel_output_124_124_4() {
        ConvolutionTwoDimensionsKernel kernel = new ConvolutionTwoDimensionsKernel(new TwoDimensionsSize(5, 5), new TwoDimensionsStride(1, 1), new TwoDimensionsPadding(0, 0));
        assertThat(kernel.outputFor(new ThreeDimensionsOutputView(128, 128, 3), 4)).isEqualTo(new ThreeDimensionsOutputView(124, 124, 4));
    }

    @Test
    public void should_return_kernel_output_63_63_4() {
        ConvolutionTwoDimensionsKernel kernel = new ConvolutionTwoDimensionsKernel(new TwoDimensionsSize(3, 3), new TwoDimensionsStride(2, 2), new TwoDimensionsPadding(0, 0));
        assertThat(kernel.outputFor(new ThreeDimensionsOutputView(128, 128, 3), 4)).isEqualTo(new ThreeDimensionsOutputView(63, 63, 4));
    }


    @Test
    public void should_return_kernel_output_130_130_4() {
        ConvolutionTwoDimensionsKernel kernel = new ConvolutionTwoDimensionsKernel(new TwoDimensionsSize(1, 1), new TwoDimensionsStride(1, 1), new TwoDimensionsPadding(1, 1));
        assertThat(kernel.outputFor(new ThreeDimensionsOutputView(128, 128, 3), 4)).isEqualTo(new ThreeDimensionsOutputView(130, 130, 4));
    }

    @Test
    public void should_return_kernel_output_49_49_4() {
        ConvolutionTwoDimensionsKernel kernel = new ConvolutionTwoDimensionsKernel(new TwoDimensionsSize(3, 3), new TwoDimensionsStride(2, 2), new TwoDimensionsPadding(0, 0));
        assertThat(kernel.outputFor(new ThreeDimensionsOutputView(100, 100, 3), 4)).isEqualTo(new ThreeDimensionsOutputView(49, 49, 4));
    }

    @Test
    public void should_return_kernel_output_12_12_4() {
        PoolTwoDimensionsKernel kernel = new PoolTwoDimensionsKernel(new TwoDimensionsSize(5, 5), new TwoDimensionsStride(4, 4), new TwoDimensionsPadding(0, 0));
        assertThat(kernel.outputFor(new ThreeDimensionsOutputView(49, 49, 3))).isEqualTo(new ThreeDimensionsOutputView(12, 12, 3));
    }

    @Test
    public void should_return_kernel_output_4_4_4() {
        ConvolutionTwoDimensionsKernel kernel = new ConvolutionTwoDimensionsKernel(new TwoDimensionsSize(3, 3), new TwoDimensionsStride(3, 3), new TwoDimensionsPadding(0, 0));
        assertThat(kernel.outputFor(new ThreeDimensionsOutputView(12, 12, 3), 4)).isEqualTo(new ThreeDimensionsOutputView(4, 4, 4));
    }


    @Test
    public void should_return_output_2_2() {
        ConvolutionTwoDimensionsKernel kernel = new ConvolutionTwoDimensionsKernel(new TwoDimensionsSize(3, 3), new TwoDimensionsStride(2, 2), new TwoDimensionsPadding(1, 1));
        assertThat(kernel.outputFor(new ThreeDimensionsOutputView(4, 4, 3), 4)).isEqualTo(new ThreeDimensionsOutputView(2, 2, 4));
    }

    @Test
    public void should_return_output_11_11() {
        ConvolutionTwoDimensionsKernel kernel = new ConvolutionTwoDimensionsKernel(new TwoDimensionsSize(1, 1), new TwoDimensionsStride(2, 2), new TwoDimensionsPadding(0, 0));
        assertThat(kernel.outputFor(new ThreeDimensionsOutputView(22, 22, 3), 4)).isEqualTo(new ThreeDimensionsOutputView(11, 11, 4));
    }


    @Test
    public void should_return_output_50_50() {
        ConvolutionTwoDimensionsKernel kernel = new ConvolutionTwoDimensionsKernel(new TwoDimensionsSize(3, 3), new TwoDimensionsStride(3, 3), new TwoDimensionsPadding(2, 2));
        assertThat(kernel.outputFor(new ThreeDimensionsOutputView(50, 50, 3), 4)).isEqualTo(new ThreeDimensionsOutputView(18, 18, 4));
    }

}
