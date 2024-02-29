package io.flogo.builder.model.architecture.blocks.processing.residual;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.blocks.processing.ConvolutionalBlockView;
import io.flogo.builder.model.architecture.layers.ActivationLayerView;
import io.flogo.builder.model.architecture.layers.activation.ReLULayerView;
import io.flogo.builder.model.architecture.layers.output.ThreeDimensionsOutput;
import io.flogo.builder.model.architecture.layers.processing.ConvolutionalLayerView;
import io.flogo.builder.model.architecture.layers.processing.MaxPoolLayerView;
import io.flogo.builder.model.architecture.layers.processing.kernels.ConvolutionTwoDimensionsKernel;
import io.flogo.builder.model.architecture.layers.processing.kernels.PoolTwoDimensionsKernel;
import io.flogo.builder.model.architecture.layers.processing.kernels.paddings.TwoDimensionsPadding;
import io.flogo.builder.model.architecture.layers.processing.kernels.size.TwoDimensionsSize;
import io.flogo.builder.model.architecture.layers.processing.kernels.strides.TwoDimensionsStride;

import java.util.List;

public class ResidualDefaultFirstStage {
    public static final ThreeDimensionsOutput output = new ThreeDimensionsOutput(112, 112, 64);

    private static final ConvolutionalLayerView firstLayer = new ConvolutionalLayerView(
            3,
            64,
            new ConvolutionTwoDimensionsKernel(new TwoDimensionsSize(7, 7),
                    new TwoDimensionsStride(2, 2),
                    new TwoDimensionsPadding(3, 3)),
            new ThreeDimensionsOutput(224, 224, 3));
    private static final ActivationLayerView secondLayer = new ReLULayerView();
    private static final MaxPoolLayerView thirdLayer = new MaxPoolLayerView(
            new PoolTwoDimensionsKernel(
                    new TwoDimensionsSize(3, 3),
                    new TwoDimensionsStride(2, 2),
                    new TwoDimensionsPadding(1, 1)),
            output);

    public static ConvolutionalBlockView asBlock() {
        return new ConvolutionalBlockView(List.of(firstLayer, secondLayer, thirdLayer));
    }

    public static List<LayerView> asList() {
        return List.of(firstLayer, secondLayer, thirdLayer);
    }
}
