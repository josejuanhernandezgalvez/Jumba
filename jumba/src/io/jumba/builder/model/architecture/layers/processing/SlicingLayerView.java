package io.jumba.builder.model.architecture.layers.processing;

import io.jumba.builder.model.architecture.LayerView;
import io.jumba.builder.model.architecture.OutputView;

public class SlicingLayerView implements LayerView {
    @Override
    public OutputView getOutputView() {
        return null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }
}
