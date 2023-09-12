package io.flogo.builder.model.structure_views.layers;

import io.flogo.builder.model.structure_views.LayerView;
import io.flogo.builder.model.structure_views.Output;

public interface ProcessingLayerView extends LayerView {
    String ProcessingLayersViewPackage = "io.flogo.builder.model.structure_views.layers.processing.";
    Output getLayerOutput();
}
