package io.flogo.builder.model.views.blocks.processing;

import io.flogo.builder.model.views.BlockView;
import io.flogo.builder.model.views.layers.ActivationLayerView;
import io.flogo.builder.model.views.layers.output.OneDimensionOutput;

public class ResidualBlockView implements BlockView {
    public final int inputChannels;
    public final int outputChannels;
    public final ActivationLayerView activationLayer;
    public final int repetitions;


    public ResidualBlockView(OneDimensionOutput previous, OneDimensionOutput output, ActivationLayerView activationLayer, int repetitions) {
        this.inputChannels = previous.x();
        this.outputChannels = output.x();
        this.activationLayer = activationLayer;
        this.repetitions = repetitions;
    }
}
