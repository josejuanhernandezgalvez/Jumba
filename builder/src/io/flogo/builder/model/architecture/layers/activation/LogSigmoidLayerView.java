package io.flogo.builder.model.architecture.layers.activation;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ActivationLayerView;
import io.flogo.builder.model.laboratory.SubstituteView;
import io.intino.magritte.framework.Layer;

public class LogSigmoidLayerView implements ActivationLayerView {
    public final OutputView outputView;

    public LogSigmoidLayerView(OutputView outputView) {
        this.outputView = outputView;
    }

    @Override
    public LayerView from(LayerView previous) {
        return new LogSigmoidLayerView(previous == null ? this.outputView : previous.getOutputView());
    }

    public static ActivationLayerView createFromSubstitute(LayerView previous, SubstituteView substituteView) {
        return new LogSigmoidLayerView(previous.getOutputView());
    }

    public static ActivationLayerView from(Layer layer, OutputView outputView) {
        return new LogSigmoidLayerView(outputView);
    }

    @Override
    public OutputView getOutputView() {
        return outputView;
    }
}
