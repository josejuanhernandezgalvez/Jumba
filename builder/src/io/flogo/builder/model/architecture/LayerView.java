package io.flogo.builder.model.architecture;

import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.laboratory.SubstituteView;

public interface LayerView {
    OutputView getOutputView();

    LayerView from(VLayerView vLayerView, SubstituteView substituteViews);

    LayerView from(LayerView previous);

}
