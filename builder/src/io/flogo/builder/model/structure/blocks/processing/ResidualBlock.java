package io.flogo.builder.model.structure.blocks.processing;

import io.flogo.builder.model.structure.Block;
import io.flogo.builder.model.structure.layers.activations.Activation;
import io.flogo.builder.model.structure.layers.output.OneDimensionOutput;

public class ResidualBlock implements Block {
    public final int inputChannels;
    public final int outputChannels;
    public final Activation activation;
    public final int repetitions;


    public ResidualBlock(OneDimensionOutput previous, OneDimensionOutput output, Activation activation, int repetitions) {
        this.inputChannels = previous.x();
        this.outputChannels = output.x();
        this.activation = activation;
        this.repetitions = repetitions;
    }
}
