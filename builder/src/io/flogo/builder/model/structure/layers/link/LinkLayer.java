package io.flogo.builder.model.structure.layers.link;

import io.flogo.builder.model.structure.layers.ProcessingLayer;
import io.flogo.builder.model.structure.Output;

public interface LinkLayer extends ProcessingLayer {
    Output output();
}
