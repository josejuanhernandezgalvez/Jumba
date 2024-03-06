package io.flogo.builder.model.architecture.layers.link;

import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.LinkLayerView;

public class SoftmaxLayerView implements LinkLayerView {
    public final OutputView outputView;

    public SoftmaxLayerView(OutputView thisLayerOutput) {
        this.outputView = thisLayerOutput;
    }

    @Override
    public OutputView getOutputView() {
        return outputView;
    }
}
