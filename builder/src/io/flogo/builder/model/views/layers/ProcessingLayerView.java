package io.flogo.builder.model.views.layers;

import io.flogo.builder.model.views.LayerView;
import io.flogo.builder.model.views.Output;

public interface ProcessingLayerView extends LayerView {
    String ProcessingLayersViewPackage = "io.flogo.builder.model.views.layers.processing.";
    Output getLayerOutput();
}
