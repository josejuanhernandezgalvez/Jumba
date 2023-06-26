package io.flogo.builder.model.structure.layers.link;

import io.flogo.builder.model.structure.layers.OutputLayer;
import io.flogo.builder.model.structure.Output;

public interface LinkLayer extends OutputLayer {
    Output output();
}
