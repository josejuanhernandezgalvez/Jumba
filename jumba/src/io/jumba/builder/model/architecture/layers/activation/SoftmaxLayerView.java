package io.jumba.builder.model.architecture.layers.activation;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.model.architecture.LayerView;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.ActivationLayerView;
import io.intino.magritte.framework.Layer;

public class SoftmaxLayerView implements ActivationLayerView {
    private final OutputView outputView;
    private boolean mutable;

    public SoftmaxLayerView(OutputView outputView) {
        this.outputView = outputView;
    }

    public static ActivationLayerView from(Layer layer, OutputView outputView, CompilationContext context) {
        return new SoftmaxLayerView(outputView).setMutable(LayerView.getMutable(layer));
    }

    private ActivationLayerView setMutable(boolean mutable) {
        this.mutable = mutable;
        return this;
    }

    @Override
    public OutputView getOutputView() {
        return outputView;
    }

    @Override
    public boolean isMutable() {
        return false;
    }
}
