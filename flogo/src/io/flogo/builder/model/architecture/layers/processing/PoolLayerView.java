package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.output.ThreeDimensionsOutputView;
import io.flogo.builder.model.architecture.layers.output.TwoDimensionsOutputView;
import io.flogo.builder.model.architecture.layers.output.UndeterminedOutputView;
import io.flogo.builder.model.architecture.layers.processing.kernels.UndeterminedKernel;
import io.intino.magritte.framework.Layer;

import static io.flogo.builder.model.architecture.layers.processing.kernels.PoolTwoDimensionsKernel.kernelFor;

public abstract class PoolLayerView extends ThreeDimensionLayerView {
    public final Kernel kernel;
    protected final OutputView previousLayerOutput;
    protected final OutputView thisLayerOutput;

    public PoolLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput) {
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
        this.kernel = isDetermined(previousLayerOutput) ?
                kernelFor((ThreeDimensionsOutputView) previousLayerOutput, (ThreeDimensionsOutputView) thisLayerOutput) :
                new UndeterminedKernel();
    }

    public PoolLayerView(Kernel kernel, OutputView previousLayerOutput) {
        this.kernel = kernel;
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = isDetermined(previousLayerOutput) ?
                calculateLayerOutput((ThreeDimensionsOutputView) previousLayerOutput, this.kernel) :
                new UndeterminedOutputView();
    }

    protected ThreeDimensionsOutputView calculateLayerOutput(ThreeDimensionsOutputView previousLayerOutput, Kernel kernel) {
        return new ThreeDimensionsOutputView(calculateX(previousLayerOutput, kernel), calculateY(previousLayerOutput, kernel), previousLayerOutput.z());
    }

    protected static OutputView thisOutput(Layer layer, OutputView previousOutput) {
        try {
            Object output = layer.getClass().getMethod("output").invoke(layer);
            return isDetermined(previousOutput) ?
                    new ThreeDimensionsOutputView(getValue(output, "x"), getValue(output, "y"), getValue(previousOutput, "z")) :
                    new TwoDimensionsOutputView(getValue(output, "x"), getValue(output, "y"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
