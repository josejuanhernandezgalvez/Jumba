package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ProcessingLayerView;
import io.flogo.builder.model.architecture.layers.output.ThreeDimensionsOutputView;
import io.flogo.builder.model.architecture.layers.output.UndeterminedOutputView;
import io.flogo.builder.model.architecture.layers.processing.kernels.PoolTwoDimensionsKernel;
import io.flogo.builder.model.architecture.layers.processing.kernels.paddings.TwoDimensionsPadding;
import io.flogo.builder.model.architecture.layers.processing.kernels.size.TwoDimensionsSize;
import io.flogo.builder.model.architecture.layers.processing.kernels.strides.TwoDimensionsStride;
import io.flogo.builder.model.laboratory.SubstituteView;
import io.flogo.model.ConvolutionalSection.Block.AvgPool;
import io.intino.magritte.framework.Layer;

public class AvgPoolLayerView extends PoolLayerView {

    public AvgPoolLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput) {
        super(previousLayerOutput, thisLayerOutput);
    }

    public AvgPoolLayerView(Kernel kernel, OutputView previousLayerOutput) {
        super(kernel, previousLayerOutput);
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput.getClass().equals(ThreeDimensionsOutputView.class) ? thisLayerOutput : new UndeterminedOutputView();
    }

    @Override
    public LayerView from(LayerView previous) {
        return thisLayerOutput instanceof UndeterminedOutputView ?
                new AvgPoolLayerView(previous.getOutputView(), thisLayerOutput) :
                new AvgPoolLayerView(this.kernel, previous.getOutputView());
    }

    public static LayerView createFromSubstitute(LayerView previous, SubstituteView substituteView) {
        return null;
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput) {
        if (hasNotOutput(layer))
            return new AvgPoolLayerView(kernel(layer), previousOutput);
        return new AvgPoolLayerView(previousOutput, thisOutput(layer, previousOutput));
    }

    private static PoolTwoDimensionsKernel kernel(Layer layer) {
        return new PoolTwoDimensionsKernel(
                new TwoDimensionsSize(((AvgPool) layer).kernel().size().x(), ((AvgPool) layer).kernel().size().y()),
                new TwoDimensionsStride(((AvgPool) layer).kernel().stride().x(), ((AvgPool) layer).kernel().stride().y()),
                new TwoDimensionsPadding(((AvgPool) layer).kernel().padding().x(), ((AvgPool) layer).kernel().padding().y()));
    }
}
