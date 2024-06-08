package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ProcessingLayerView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.architecture.layers.output.ThreeDimensionsOutputView;
import io.flogo.builder.model.architecture.layers.output.UndeterminedOutputView;
import io.flogo.builder.model.architecture.layers.processing.kernels.PoolTwoDimensionsKernel;
import io.flogo.builder.model.architecture.layers.processing.kernels.UndeterminedKernel;
import io.flogo.builder.model.architecture.layers.processing.kernels.paddings.TwoDimensionsPadding;
import io.flogo.builder.model.architecture.layers.processing.kernels.size.TwoDimensionsSize;
import io.flogo.builder.model.architecture.layers.processing.kernels.strides.TwoDimensionsStride;
import io.flogo.builder.model.laboratory.MaterializationView;
import io.flogo.model.ConvolutionalSection.Block.MaxPool;
import io.flogo.model.Laboratory;
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
        if (thisLayerOutput instanceof UndeterminedOutputView) return thisLayerOutput;
        return thisLayerOutput.getClass().equals(ThreeDimensionsOutputView.class) ? ((PoolTwoDimensionsKernel) this.kernel).outputFor((ThreeDimensionsOutputView) previousLayerOutput) : new UndeterminedOutputView();
    }

    @Override
    public LayerView from(OutputView previous) {
        return thisLayerOutput instanceof UndeterminedOutputView ?
                new MaxPoolLayerView(this.kernel, previous) :
                kernel instanceof UndeterminedKernel ?
                        new MaxPoolLayerView(
                                new ThreeDimensionsOutputView(
                                        getValue(previous, "x"),
                                        getValue(previous, "y"),
                                        getValue(previous, "z")),
                                new ThreeDimensionsOutputView(
                                        getValue(thisLayerOutput, "x"),
                                        getValue(thisLayerOutput, "y"),
                                        getValue(previous, "z"))) :
                        new MaxPoolLayerView(this.kernel, previous);
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput) {
        if (hasNotOutput(layer))
            return new MaxPoolLayerView(kernel((MaxPool) layer), previousOutput);
        return new MaxPoolLayerView(previousOutput, thisOutput(layer, previousOutput));
    }

    public static LayerView createFromSubstitute(LayerView previous, MaterializationView materializationView) {
        return ((Laboratory.Experiment.Materialization.MaxPool) materializationView.layer).output() == null ?
                new MaxPoolLayerView(kernel((Laboratory.Experiment.Materialization.MaxPool) materializationView.layer), previous instanceof VLayerView vLayerView ? vLayerView.previousLayerOutput : previous.getOutputView()) :
                new MaxPoolLayerView(
                        new ThreeDimensionsOutputView(
                                ((Laboratory.Experiment.Materialization.MaxPool) materializationView.layer).output().x(),
                                ((Laboratory.Experiment.Materialization.MaxPool) materializationView.layer).output().y(),
                                previous instanceof VLayerView vLayerView ? getValue(vLayerView.previousLayerOutput, "z") : getValue(previous.getOutputView(), "z")),
                        new ThreeDimensionsOutputView(
                                previous instanceof VLayerView vLayerView ? getValue(vLayerView.previousLayerOutput, "x") : getValue(previous.getOutputView(), "x"),
                                previous instanceof VLayerView vLayerView ? getValue(vLayerView.previousLayerOutput, "y") : getValue(previous.getOutputView(), "y"),
                                previous instanceof VLayerView vLayerView ? getValue(vLayerView.previousLayerOutput, "z") : getValue(previous.getOutputView(), "z"))
                        );
    }

    private static PoolTwoDimensionsKernel kernel(Laboratory.Experiment.Materialization.MaxPool pool) {
        return new PoolTwoDimensionsKernel(
                new TwoDimensionsSize(pool.kernel().size().x(), pool.kernel().size().y()),
                new TwoDimensionsStride(pool.kernel().stride().x(), pool.kernel().stride().y()),
                new TwoDimensionsPadding(pool.kernel().padding().x(), pool.kernel().padding().y()));
    }

    private static PoolTwoDimensionsKernel kernel(MaxPool layer) {
        return new PoolTwoDimensionsKernel(
                new TwoDimensionsSize(layer.kernel().size().x(), layer.kernel().size().y()),
                new TwoDimensionsStride(layer.kernel().stride().x(), layer.kernel().stride().y()),
                new TwoDimensionsPadding(layer.kernel().padding().x(), layer.kernel().padding().y()));
    }
}
