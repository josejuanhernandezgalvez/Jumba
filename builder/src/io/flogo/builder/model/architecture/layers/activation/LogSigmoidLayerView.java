package io.flogo.builder.model.architecture.layers.activation;

import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ActivationLayerView;
import io.intino.magritte.framework.Layer;

public class LogSigmoidLayerView implements ActivationLayerView {
    public final OutputView outputView;

    public LogSigmoidLayerView(OutputView outputView) {
        this.outputView = outputView;
    }

    public static ActivationLayerView from(Layer layer, OutputView outputView) {
        return new LogSigmoidLayerView(outputView);
    }

    @Override
    public OutputView getOutputView() {
        return outputView;
    }
}
