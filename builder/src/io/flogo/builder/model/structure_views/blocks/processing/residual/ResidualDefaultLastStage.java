package io.flogo.builder.model.structure_views.blocks.processing.residual;

import io.flogo.builder.model.structure_views.LayerView;
import io.flogo.builder.model.structure_views.blocks.processing.ConvolutionalBlockView;
import io.flogo.builder.model.structure_views.layers.output.ThreeDimensionsOutput;
import io.flogo.builder.model.structure_views.layers.processing.AvgPoolLayerView;
import io.flogo.builder.model.structure_views.layers.processing.kernels.PoolTwoDimensionsKernel;
import io.flogo.builder.model.structure_views.layers.processing.kernels.paddings.TwoDimensionsPadding;
import io.flogo.builder.model.structure_views.layers.processing.kernels.size.TwoDimensionsSize;
import io.flogo.builder.model.structure_views.layers.processing.kernels.strides.TwoDimensionsStride;

import java.util.List;

public class ResidualDefaultLastStage {


    public static ConvolutionalBlockView asBlock(ThreeDimensionsOutput previousLayerOutput) {
        return new ConvolutionalBlockView(List.of(pool(previousLayerOutput)));
    }

    public static List<LayerView> asList(ThreeDimensionsOutput previousLayerOutput) {
        return List.of(pool(previousLayerOutput));
    }

    private static AvgPoolLayerView pool(ThreeDimensionsOutput previousLayerOutput) {
        return new AvgPoolLayerView(
                new PoolTwoDimensionsKernel(
                        new TwoDimensionsSize(7, 7),
                        new TwoDimensionsStride(1, 1),
                        new TwoDimensionsPadding(0, 0)),
                previousLayerOutput);
    }
}
