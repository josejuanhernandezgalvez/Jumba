package io.flogo.builder.model.architecture.layers.activation;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ActivationLayerView;
import io.flogo.builder.model.laboratory.SubstituteView;
import io.intino.magritte.framework.Layer;

public class MishLayerView implements ActivationLayerView {
    public final OutputView outputView;

    public MishLayerView(OutputView outputView) {
        this.outputView = outputView;
    }

    public static ActivationLayerView createFromSubstitute(LayerView previous, SubstituteView substituteView) {
        return new MishLayerView(previous.getOutputView());
    }

    public static ActivationLayerView from(Layer layer, OutputView outputView) {
        return new MishLayerView(outputView);
    }

    @Override
    public OutputView getOutputView() {
        return outputView;
    }

    @Override
    public LayerView from(LayerView previous) {
        return new MishLayerView(previous == null ? this.outputView : previous.getOutputView());
    }
}
