package io.jumba.builder.model.architecture.layers.processing;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.model.architecture.LayerView;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.ProcessingLayerView;
import io.jumba.builder.model.architecture.layers.output.ThreeDimensionsOutputView;
import io.jumba.builder.model.architecture.layers.processing.kernels.PoolTwoDimensionsKernel;
import io.jumba.builder.model.architecture.layers.processing.kernels.paddings.TwoDimensionsPadding;
import io.jumba.builder.model.architecture.layers.processing.kernels.size.TwoDimensionsSize;
import io.jumba.builder.model.architecture.layers.processing.kernels.strides.TwoDimensionsStride;
import io.jumba.model.ConvolutionalSection.Block.AvgPool;
import io.intino.magritte.framework.Layer;

public class AvgPoolLayerView extends PoolLayerView {

    public AvgPoolLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput) {
        super(previousLayerOutput, thisLayerOutput);
    }

    public AvgPoolLayerView(Kernel kernel, OutputView previousLayerOutput) {
        super(kernel, previousLayerOutput);
    }


    public static ProcessingLayerView from(Layer layer, OutputView previousOutput, CompilationContext context) {
        if (hasNotOutput(layer))
            return new AvgPoolLayerView(kernel((AvgPool) layer), previousOutput);
        PoolLayerView avgPoolLayerView = new AvgPoolLayerView(previousOutput, thisOutput(layer, previousOutput)).setMutable(LayerView.getMutable(layer));
        if (!thisOutput(layer, previousOutput).equals(avgPoolLayerView.getOutputView()))
            System.out.println(layer.getClass().getSimpleName() + " output has been modified from " + thisOutput(layer, previousOutput) + " to " + avgPoolLayerView.getOutputView()); // TODO log it don't sout it
        return avgPoolLayerView;
    }

    private static PoolTwoDimensionsKernel kernel(AvgPool layer) {
        return new PoolTwoDimensionsKernel(
                new TwoDimensionsSize(layer.kernel().size().x(), layer.kernel().size().y()),
                new TwoDimensionsStride(layer.kernel().stride().x(), layer.kernel().stride().y()),
                new TwoDimensionsPadding(layer.kernel().padding().x(), layer.kernel().padding().y()));
    }

    @Override
    public OutputView getOutputView() {
        return ((PoolTwoDimensionsKernel) this.kernel).outputFor((ThreeDimensionsOutputView) previousLayerOutput);
    }

    @Override
    public boolean isMutable() {
        return mutable;
    }
}
