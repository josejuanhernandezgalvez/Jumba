package io.flogo.builder.model.architecture.layers.activation;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ActivationLayerView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.laboratory.MaterializationView;
import io.intino.magritte.framework.Layer;

public class GLULayerView implements ActivationLayerView {
    public final OutputView outputView;

    public GLULayerView(OutputView outputView) {
        this.outputView = outputView;
    }

    public static ActivationLayerView from(Layer layer, OutputView outputView) {
        return new GLULayerView(outputView);
    }

    public static ActivationLayerView createFromSubstitute(LayerView previous, MaterializationView materializationView) {
        return new GLULayerView(previous instanceof VLayerView vLayerView ? vLayerView.previousLayerOutput : previous.getOutputView());
    }

    @Override
    public OutputView getOutputView() {
        return outputView;
    }

    @Override
    public LayerView from(OutputView previous) {
        return new GLULayerView(previous == null ? this.outputView : previous);
    }
}
