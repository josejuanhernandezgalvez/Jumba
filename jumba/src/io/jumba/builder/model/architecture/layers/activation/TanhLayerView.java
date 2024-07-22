package io.jumba.builder.model.architecture.layers.activation;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.ActivationLayerView;
import io.intino.magritte.framework.Layer;

public class TanhLayerView implements ActivationLayerView {
    private final OutputView outputView;

    public TanhLayerView(OutputView outputView) {
        this.outputView = outputView;
    }

    public static ActivationLayerView from(Layer layer, OutputView outputView, CompilationContext context) {
        return new TanhLayerView(outputView);
    }

    @Override
    public OutputView getOutputView() {
        return outputView;
    }
}
