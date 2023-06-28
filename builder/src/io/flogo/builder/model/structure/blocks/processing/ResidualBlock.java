package io.flogo.builder.model.structure.blocks.processing;

import io.flogo.builder.model.structure.Block;
import io.flogo.builder.model.structure.layers.activations.Activation;
import io.flogo.builder.model.structure.layers.output.ThreeDimensionsOutput;

public class ResidualBlock implements Block {
    public final int inChannels;
    public final int outChannels;
    public final ThreeDimensionsOutput output;
    public final Activation activation;
    public final int repetitions;


    public ResidualBlock(int inChannels, int outChannels, ThreeDimensionsOutput output, Activation activation, int repetitions) {
        this.inChannels = inChannels;
        this.outChannels = outChannels;
        this.output = output;
        this.activation = activation;
        this.repetitions = repetitions;
    }
}
