package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ProcessingLayerView;
import io.flogo.builder.model.architecture.layers.output.ThreeDimensionsOutputView;
import io.flogo.builder.model.architecture.layers.output.UndeterminedOutputView;
import io.flogo.builder.model.architecture.layers.processing.kernels.paddings.TwoDimensionsPadding;
import io.flogo.builder.model.architecture.layers.processing.kernels.size.TwoDimensionsSize;
import io.flogo.builder.model.architecture.layers.processing.kernels.strides.TwoDimensionsStride;
import io.intino.magritte.framework.Layer;

public abstract class ThreeDimensionLayerView implements ProcessingLayerView {

    protected static boolean isDetermined(OutputView previousLayerOutput) {
        return !previousLayerOutput.getClass().equals(UndeterminedOutputView.class);
    }

    protected int calculateX(ThreeDimensionsOutputView previousLayerOutput, Kernel kernel) {
        return (previousLayerOutput.x() - ((TwoDimensionsSize) kernel.size()).xSize() + 1 +
                2 * ((TwoDimensionsPadding) kernel.padding()).xPaddingFrameSize()) /
                ((TwoDimensionsStride) kernel.stride()).xStrideStepSize();
    }

    protected int calculateY(ThreeDimensionsOutputView previousLayerOutput, Kernel kernel) {
        return (previousLayerOutput.y() - ((TwoDimensionsSize) kernel.size()).ySize() + 1 +
                2 * ((TwoDimensionsPadding) kernel.padding()).yPaddingFrameSize()) /
                ((TwoDimensionsStride) kernel.stride()).yStrideStepSize();
    }

    protected static boolean hasNotOutput(Layer layer) {
        try {
            return layer.getClass().getDeclaredMethod("output").invoke(layer) == null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected static int getValue(Object output, String argument) {
        try {
            return (int) output.getClass().getMethod(argument).invoke(output);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
