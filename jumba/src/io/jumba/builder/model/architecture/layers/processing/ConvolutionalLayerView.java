package io.jumba.builder.model.architecture.layers.processing;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.ProcessingLayerView;
import io.jumba.builder.model.architecture.layers.output.ThreeDimensionsOutputView;
import io.jumba.builder.model.architecture.layers.processing.kernels.ConvolutionTwoDimensionsKernel;
import io.jumba.builder.model.architecture.layers.processing.kernels.paddings.TwoDimensionsPadding;
import io.jumba.builder.model.architecture.layers.processing.kernels.size.TwoDimensionsSize;
import io.jumba.builder.model.architecture.layers.processing.kernels.strides.TwoDimensionsStride;
import io.jumba.model.ConvolutionalSection.Block.Convolutional;
import io.intino.magritte.framework.Layer;

import static io.jumba.builder.model.architecture.layers.processing.kernels.ConvolutionTwoDimensionsKernel.kernelFor;

public class ConvolutionalLayerView extends ThreeDimensionLayerView {
    public final Kernel kernel;
    public final OutputView previousLayerOutput;
    public final OutputView thisLayerOutput;
    private final int outChannels;

    public ConvolutionalLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput) {
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
        this.kernel = kernelFor((ThreeDimensionsOutputView) previousLayerOutput, (ThreeDimensionsOutputView) thisLayerOutput);
        this.outChannels = thisLayerOutput.asArray()[2];
    }

    public ConvolutionalLayerView(ConvolutionTwoDimensionsKernel kernel, OutputView previousLayerOutput, int outChannels) {
        this.kernel = kernel;
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = ((ConvolutionTwoDimensionsKernel) this.kernel).outputFor((ThreeDimensionsOutputView) previousLayerOutput, outChannels);
        this.outChannels = outChannels;
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput, CompilationContext context) {
        if (hasNotOutput(layer))
            return new ConvolutionalLayerView(kernel((Convolutional) layer), previousOutput, ((Convolutional) layer).outChannels().z());
        ConvolutionalLayerView convolutionalLayerView = new ConvolutionalLayerView(previousOutput, thisOutput(layer));
        if (!thisOutput(layer).equals(convolutionalLayerView.getOutputView()))
            System.out.println(layer.getClass().getSimpleName() + " output has been modified from " + thisOutput(layer) + " to " + convolutionalLayerView.getOutputView()); // TODO log it don't sout it
        return convolutionalLayerView;
    }

    private static ConvolutionTwoDimensionsKernel kernel(Convolutional layer) {
        return new ConvolutionTwoDimensionsKernel(
                new TwoDimensionsSize(layer.kernel().size().x(), layer.kernel().size().y()),
                new TwoDimensionsStride(layer.kernel().stride().x(), layer.kernel().stride().y()),
                new TwoDimensionsPadding(layer.kernel().padding().x(), layer.kernel().padding().y()));
    }

    private static ThreeDimensionsOutputView thisOutput(Layer layer) {
        try {
            Object output = layer.getClass().getMethod("output").invoke(layer);
            return new ThreeDimensionsOutputView(getValue(output, "x"), getValue(output, "y"), getValue(output, "z"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OutputView getOutputView() {
        return ((ConvolutionTwoDimensionsKernel) kernel).outputFor((ThreeDimensionsOutputView) previousLayerOutput, this.outChannels);
    }
}
