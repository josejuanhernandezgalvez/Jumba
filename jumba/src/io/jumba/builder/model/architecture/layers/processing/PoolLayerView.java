package io.jumba.builder.model.architecture.layers.processing;

import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.output.ThreeDimensionsOutputView;
import io.jumba.builder.model.architecture.layers.processing.kernels.PoolTwoDimensionsKernel;
import io.intino.magritte.framework.Layer;

import static io.jumba.builder.model.architecture.layers.processing.kernels.PoolTwoDimensionsKernel.kernelFor;

public abstract class PoolLayerView extends ThreeDimensionLayerView {
    public final Kernel kernel;
    protected final OutputView previousLayerOutput;
    protected final OutputView thisLayerOutput;

    public PoolLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput) {
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
        this.kernel = kernelFor((ThreeDimensionsOutputView) previousLayerOutput, (ThreeDimensionsOutputView) thisLayerOutput);
    }

    public PoolLayerView(Kernel kernel, OutputView previousLayerOutput) {
        this.kernel = kernel;
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = ((PoolTwoDimensionsKernel) this.kernel).outputFor((ThreeDimensionsOutputView) previousLayerOutput);
    }

    protected static OutputView thisOutput(Layer layer, OutputView previousOutput) {
        try {
            Object output = layer.getClass().getMethod("output").invoke(layer);
            return new ThreeDimensionsOutputView(getValue(output, "x"), getValue(output, "y"), getValue(previousOutput, "z"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
