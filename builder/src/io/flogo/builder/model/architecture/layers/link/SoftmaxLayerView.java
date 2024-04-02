package io.flogo.builder.model.architecture.layers.link;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.LinkLayerView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.laboratory.SubstituteView;

public class SoftmaxLayerView implements LinkLayerView {
    public final OutputView outputView;

    public SoftmaxLayerView(OutputView thisLayerOutput) {
        this.outputView = thisLayerOutput;
    }

    @Override
    public OutputView getOutputView() {
        return outputView;
    }

    @Override
    public LayerView from(VLayerView vLayerView, SubstituteView substituteViews) {
        return null;
    }

    @Override
    public LayerView from(LayerView previous) {
        return null;
    }
}
