package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ProcessingLayerView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.architecture.layers.output.ThreeDimensionsOutputView;
import io.flogo.builder.model.architecture.layers.output.UndeterminedOutputView;
import io.flogo.builder.model.architecture.layers.processing.kernels.ConvolutionTwoDimensionsKernel;
import io.flogo.builder.model.architecture.layers.processing.kernels.UndeterminedKernel;
import io.flogo.builder.model.architecture.layers.processing.kernels.paddings.TwoDimensionsPadding;
import io.flogo.builder.model.architecture.layers.processing.kernels.size.TwoDimensionsSize;
import io.flogo.builder.model.architecture.layers.processing.kernels.strides.TwoDimensionsStride;
import io.flogo.builder.model.laboratory.SubstituteView;
import io.flogo.model.ConvolutionalSection.Block.Convolutional;
import io.flogo.model.Laboratory;
import io.intino.magritte.framework.Layer;

import static io.flogo.builder.model.architecture.layers.processing.kernels.ConvolutionTwoDimensionsKernel.kernelFor;

public class ConvolutionalLayerView extends ThreeDimensionLayerView {
    public final Kernel kernel;
    public final OutputView previousLayerOutput;
    public final OutputView thisLayerOutput;
    private final int outChannels;

    public ConvolutionalLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput) {
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
        this.kernel = isDetermined(previousLayerOutput) ?
                kernelFor((ThreeDimensionsOutputView) previousLayerOutput, (ThreeDimensionsOutputView) thisLayerOutput) :
                new UndeterminedKernel();
        this.outChannels = thisLayerOutput.asArray()[2];
    }

    public ConvolutionalLayerView(ConvolutionTwoDimensionsKernel kernel, OutputView previousLayerOutput, int outChannels) {
        this.kernel = kernel;
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = isDetermined(previousLayerOutput) ?
                calculateLayerOutput((ThreeDimensionsOutputView) previousLayerOutput, outChannels) :
                new UndeterminedOutputView();
        this.outChannels = outChannels;
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput;
    }

    @Override
    public LayerView from(OutputView previous) {
        return this.kernel instanceof UndeterminedKernel ?
                new ConvolutionalLayerView(previous, thisLayerOutput) :
                new ConvolutionalLayerView((ConvolutionTwoDimensionsKernel) this.kernel, previous, outChannels);
    }

    private ThreeDimensionsOutputView calculateLayerOutput(ThreeDimensionsOutputView previousLayerOutput, int outChannels) {
        return new ThreeDimensionsOutputView(calculateX(previousLayerOutput, this.kernel), calculateY(previousLayerOutput, this.kernel), outChannels);
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput) {
        if (hasNotOutput(layer))
            return new ConvolutionalLayerView(kernel((Convolutional) layer), previousOutput, ((Convolutional) layer).outChannels().z());
        return new ConvolutionalLayerView(previousOutput, thisOutput(layer));
    }

    public static LayerView createFromSubstitute(LayerView previous, SubstituteView substituteView) {
        return ((Laboratory.Experiment.Substitute.Convolutional) substituteView.layer).output() == null ?
                new ConvolutionalLayerView(
                        kernel(substituteView.layer),
                        previous instanceof VLayerView vLayerView ? vLayerView.previousLayerOutput : previous.getOutputView(),
                        ((Laboratory.Experiment.Substitute.Convolutional) substituteView.layer).outChannels().z()) :
                new ConvolutionalLayerView(
                        new ThreeDimensionsOutputView(
                                previous instanceof VLayerView ? getValue(((VLayerView) previous).previousLayerOutput, "x") : getValue(previous.getOutputView(), "x"),
                                previous instanceof VLayerView ? getValue(((VLayerView) previous).previousLayerOutput, "y") : getValue(previous.getOutputView(), "y"),
                                previous instanceof VLayerView ? getValue(((VLayerView) previous).previousLayerOutput, "z") : getValue(previous.getOutputView(), "z")),
                        new ThreeDimensionsOutputView(
                                getValue(((Laboratory.Experiment.Substitute.Convolutional) substituteView.layer).output(), "x"),
                                getValue(((Laboratory.Experiment.Substitute.Convolutional) substituteView.layer).output(), "y"),
                                getValue(((Laboratory.Experiment.Substitute.Convolutional) substituteView.layer).output(), "z")
                        ));
    }

    private static ConvolutionTwoDimensionsKernel kernel(Laboratory.Experiment.Substitute.Layer layer) {
        Laboratory.Experiment.Substitute.Convolutional.Kernel kernel = ((Laboratory.Experiment.Substitute.Convolutional) layer).kernel();
        return new ConvolutionTwoDimensionsKernel(
                new TwoDimensionsSize(kernel.size().x(), kernel.size().y()),
                new TwoDimensionsStride(kernel.stride().x(), kernel.stride().y()),
                new TwoDimensionsPadding(kernel.padding().x(), kernel.padding().y()));
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
}
