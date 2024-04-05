package io.flogo.builder.model.architecture.layers.activation;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ActivationLayerView;
import io.flogo.builder.model.laboratory.SubstituteView;
import io.intino.magritte.framework.Layer;

public class GELULayerView implements ActivationLayerView {
    public final OutputView outputView;

    public GELULayerView(OutputView outputView) {
        this.outputView = outputView;
    }

    public static ActivationLayerView from(Layer layer, OutputView outputView) {
        return new GELULayerView(outputView);
    }

    public static ActivationLayerView createFromSubstitute(LayerView previous, SubstituteView substituteView) {
        return new GELULayerView(previous.getOutputView());
    }

        @Override
    public OutputView getOutputView() {
        return outputView;
    }

    @Override
    public LayerView from(LayerView previous) {
        return new GELULayerView(previous == null ? this.outputView : previous.getOutputView());
    }
}
