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
import io.flogo.model.ConvolutionalSection.Block.MaxPool;
import io.intino.magritte.framework.Layer;

public class MaxPoolLayerView extends PoolLayerView {

    public MaxPoolLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput) {
        super(previousLayerOutput, thisLayerOutput);
    }

    public MaxPoolLayerView(Kernel kernel, OutputView previousLayerOutput) {
        super(kernel, previousLayerOutput);
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput.getClass().equals(ThreeDimensionsOutputView.class) ? thisLayerOutput : new UndeterminedOutputView();
    }

    @Override
    public LayerView from(LayerView previous) {
        return thisLayerOutput instanceof UndeterminedOutputView ?
                new MaxPoolLayerView(previous.getOutputView(), thisLayerOutput) :
                new MaxPoolLayerView(this.kernel, previous.getOutputView());
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput) {
        if (hasNotOutput(layer))
            return new MaxPoolLayerView(kernel(layer), previousOutput);
        return new MaxPoolLayerView(previousOutput, thisOutput(layer, previousOutput));
    }

    public static LayerView createFromSubstitute(LayerView previous, SubstituteView substituteView) {
        return null;
    }

    private static PoolTwoDimensionsKernel kernel(Layer layer) {
        return new PoolTwoDimensionsKernel(
                new TwoDimensionsSize(((MaxPool) layer).kernel().size().x(), ((MaxPool) layer).kernel().size().y()),
                new TwoDimensionsStride(((MaxPool) layer).kernel().stride().x(), ((MaxPool) layer).kernel().stride().y()),
                new TwoDimensionsPadding(((MaxPool) layer).kernel().padding().x(), ((MaxPool) layer).kernel().padding().y()));
    }
}
