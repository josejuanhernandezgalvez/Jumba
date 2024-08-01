package io.jumba.builder.model.architecture.layers.activation;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.model.architecture.LayerView;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.ActivationLayerView;
import io.intino.magritte.framework.Layer;

public class SELULayerView implements ActivationLayerView {
    private final OutputView outputView;
    private boolean mutable;

    public SELULayerView(OutputView outputView) {
        this.outputView = outputView;
    }

    public static ActivationLayerView from(Layer layer, OutputView outputView, CompilationContext context) {
        return new SELULayerView(outputView).setMutable(LayerView.getMutable(layer));
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
        return mutable;
    }
}
