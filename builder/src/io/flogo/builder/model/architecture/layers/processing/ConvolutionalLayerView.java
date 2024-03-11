package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ProcessingLayerView;
import io.flogo.builder.model.architecture.layers.output.ThreeDimensionsOutputView;
import io.flogo.builder.model.architecture.layers.output.UndeterminedOutputView;
import io.flogo.builder.model.architecture.layers.processing.kernels.ConvolutionTwoDimensionsKernel;
import io.flogo.builder.model.architecture.layers.processing.kernels.UndeterminedKernel;
import io.flogo.builder.model.architecture.layers.processing.kernels.paddings.TwoDimensionsPadding;
import io.flogo.builder.model.architecture.layers.processing.kernels.size.TwoDimensionsSize;
import io.flogo.builder.model.architecture.layers.processing.kernels.strides.TwoDimensionsStride;
import io.flogo.model.ConvolutionalSection.Block.Convolutional;
import io.intino.magritte.framework.Layer;

import static io.flogo.builder.model.architecture.layers.processing.kernels.ConvolutionTwoDimensionsKernel.kernelFor;

public class ConvolutionalLayerView extends ThreeDimensionLayerView {
    public final Kernel kernel;
    public final OutputView previousLayerOutput;
    public final OutputView thisLayerOutput;

    public ConvolutionalLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput) {
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
        this.kernel = isDetermined(previousLayerOutput) ?
                kernelFor((ThreeDimensionsOutputView) previousLayerOutput, (ThreeDimensionsOutputView) thisLayerOutput) :
                new UndeterminedKernel();
    }

    public ConvolutionalLayerView(ConvolutionTwoDimensionsKernel kernel, OutputView previousLayerOutput, int outChannels) {
        this.kernel = kernel;
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = isDetermined(previousLayerOutput) ?
                calculateLayerOutput((ThreeDimensionsOutputView) previousLayerOutput, outChannels) :
                new UndeterminedOutputView();
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput;
    }

    private ThreeDimensionsOutputView calculateLayerOutput(ThreeDimensionsOutputView previousLayerOutput, int outChannels) {
        return new ThreeDimensionsOutputView(calculateX(previousLayerOutput, this.kernel), calculateY(previousLayerOutput, this.kernel), outChannels);
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput) {
        if (hasNotOutput(layer))
            return new ConvolutionalLayerView(kernel(layer), previousOutput, ((Convolutional) layer).outChannels().z());
        return new ConvolutionalLayerView(previousOutput, thisOutput(layer));
    }

    private static ConvolutionTwoDimensionsKernel kernel(Layer layer) {
        return new ConvolutionTwoDimensionsKernel(
                new TwoDimensionsSize(((Convolutional) layer).kernel().size().x(), ((Convolutional) layer).kernel().size().y()),
                new TwoDimensionsStride(((Convolutional) layer).kernel().stride().x(), ((Convolutional) layer).kernel().stride().y()),
                new TwoDimensionsPadding(((Convolutional) layer).kernel().padding().x(), ((Convolutional) layer).kernel().padding().y()));
    }

    private static ThreeDimensionsOutputView thisOutput(Layer layer) {
        try {
            Object output = layer.getClass().getMethod("output").invoke(layer);
            return new ThreeDimensionsOutputView(getValue(output, "x"), getValue(output, "y"), getValue(output, "z"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
