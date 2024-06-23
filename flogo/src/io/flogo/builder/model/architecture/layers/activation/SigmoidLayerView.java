package io.flogo.builder.model.architecture.layers.activation;

import io.flogo.builder.CompilationContext;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ActivationLayerView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.laboratory.MaterializationView;
import io.intino.magritte.framework.Layer;

public class SigmoidLayerView implements ActivationLayerView {
    private final OutputView outputView;

    public SigmoidLayerView(OutputView outputView) {
        this.outputView = outputView;
    }

    public static ActivationLayerView from(Layer layer, OutputView outputView, CompilationContext context) {
        return new SigmoidLayerView(outputView);
    }

    public static ActivationLayerView createFromMaterialization(LayerView previous, MaterializationView materializationView, CompilationContext context) {
        return new SigmoidLayerView(previous instanceof VLayerView vLayerView ? vLayerView.previousLayerOutput : previous.getOutputView());
    }

    @Override
    public OutputView getOutputView() {
        return outputView;
    }

    @Override
    public LayerView from(OutputView previous, CompilationContext context) {
        return new SigmoidLayerView(previous == null ? this.outputView : previous);
    }
}
