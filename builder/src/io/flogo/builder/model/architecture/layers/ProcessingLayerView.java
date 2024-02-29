package io.flogo.builder.model.architecture.layers;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.Output;

public interface ProcessingLayerView extends LayerView {
    String ProcessingLayersViewPackage = "io.flogo.builder.model.architecture.layers.processing.";
    Output getLayerOutput();
}
