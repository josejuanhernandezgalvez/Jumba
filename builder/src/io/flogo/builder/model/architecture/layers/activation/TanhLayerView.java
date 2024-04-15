package io.flogo.builder.model.architecture.layers.activation;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ActivationLayerView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.laboratory.SubstituteView;
import io.intino.magritte.framework.Layer;

public class TanhLayerView implements ActivationLayerView {
    private final OutputView outputView;

    public TanhLayerView(OutputView outputView) {
        this.outputView = outputView;
    }

    public static ActivationLayerView from(Layer layer, OutputView outputView) {
        return new TanhLayerView(outputView);
    }

    public static ActivationLayerView createFromSubstitute(LayerView previous, SubstituteView substituteView) {
        return new TanhLayerView(previous instanceof VLayerView vLayerView ? vLayerView.previousLayerOutput : previous.getOutputView());
    }

    @Override
    public OutputView getOutputView() {
        return outputView;
    }

    @Override
    public LayerView from(OutputView previous) {
        return new TanhLayerView(previous == null ? this.outputView : previous);
    }
}
