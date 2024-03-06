package io.flogo.builder.model.architecture.layers.activation;

import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ActivationLayerView;
import io.intino.magritte.framework.Layer;

public class SiLULayerView implements ActivationLayerView {
    private final OutputView outputView;

    public SiLULayerView(OutputView outputView) {
        this.outputView = outputView;
    }

    public static ActivationLayerView from(Layer layer, OutputView outputView) {
        return new SiLULayerView(outputView);
    }

    @Override
    public OutputView getOutputView() {
        return outputView;
    }
}
