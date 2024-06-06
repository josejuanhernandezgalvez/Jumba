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
import io.flogo.model.ConvolutionalSection.Block.AvgPool;
import io.flogo.model.Laboratory;
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
        if (thisLayerOutput instanceof UndeterminedOutputView) return thisLayerOutput;
        return thisLayerOutput.getClass().equals(ThreeDimensionsOutputView.class) ? ((PoolTwoDimensionsKernel) this.kernel).outputFor((ThreeDimensionsOutputView) previousLayerOutput) : new UndeterminedOutputView();
    }

    @Override
    public LayerView from(OutputView previous) {
        return thisLayerOutput instanceof UndeterminedOutputView ?
                new AvgPoolLayerView(this.kernel, previous) :
                kernel instanceof UndeterminedKernel ?
                        new AvgPoolLayerView(
                                new ThreeDimensionsOutputView(
                                        getValue(previous, "x"),
                                        getValue(previous, "y"),
                                        getValue(previous, "z")),
                                new ThreeDimensionsOutputView(
                                        getValue(thisLayerOutput, "x"),
                                        getValue(thisLayerOutput, "y"),
                                        getValue(previous, "z"))) :
                        new AvgPoolLayerView(this.kernel, previous);
    }

    public static LayerView createFromSubstitute(LayerView previous, MaterializationView materializationView) {
        return ((Laboratory.Experiment.Materialization.AvgPool) materializationView.layer).output() == null ?
                new AvgPoolLayerView(kernel((Laboratory.Experiment.Materialization.AvgPool) materializationView.layer), previous instanceof VLayerView vLayerView ? vLayerView.previousLayerOutput : previous.getOutputView()) :
                new AvgPoolLayerView(
                        new ThreeDimensionsOutputView(
                                ((Laboratory.Experiment.Materialization.AvgPool) materializationView.layer).output().x(),
                                ((Laboratory.Experiment.Materialization.AvgPool) materializationView.layer).output().y(),
                                previous instanceof VLayerView vLayerView ? getValue(vLayerView.previousLayerOutput, "z") : getValue(previous.getOutputView(), "z")),
                        new ThreeDimensionsOutputView(
                                previous instanceof VLayerView vLayerView ? getValue(vLayerView.previousLayerOutput, "x") : getValue(previous.getOutputView(), "x"),
                                previous instanceof VLayerView vLayerView ? getValue(vLayerView.previousLayerOutput, "y") : getValue(previous.getOutputView(), "y"),
                                previous instanceof VLayerView vLayerView ? getValue(vLayerView.previousLayerOutput, "z") : getValue(previous.getOutputView(), "z"))
                );
    }

    private static PoolTwoDimensionsKernel kernel(Laboratory.Experiment.Materialization.AvgPool pool) {
        return new PoolTwoDimensionsKernel(
                new TwoDimensionsSize(pool.kernel().size().x(), pool.kernel().size().y()),
                new TwoDimensionsStride(pool.kernel().stride().x(), pool.kernel().stride().y()),
                new TwoDimensionsPadding(pool.kernel().padding().x(), pool.kernel().padding().y()));
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput) {
        if (hasNotOutput(layer))
            return new AvgPoolLayerView(kernel((AvgPool) layer), previousOutput);
        return new AvgPoolLayerView(previousOutput, thisOutput(layer, previousOutput));
    }

    private static PoolTwoDimensionsKernel kernel(AvgPool layer) {
        return new PoolTwoDimensionsKernel(
                new TwoDimensionsSize(layer.kernel().size().x(), layer.kernel().size().y()),
                new TwoDimensionsStride(layer.kernel().stride().x(), layer.kernel().stride().y()),
                new TwoDimensionsPadding(layer.kernel().padding().x(), layer.kernel().padding().y()));
    }
}
