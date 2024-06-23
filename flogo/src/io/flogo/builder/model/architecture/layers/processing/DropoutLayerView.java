package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.CompilationContext;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ProcessingLayerView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.laboratory.MaterializationView;
import io.intino.magritte.framework.Layer;

public final class DropoutLayerView implements ProcessingLayerView {
    public final double probability;
    public final OutputView output;

    public DropoutLayerView(OutputView output, double probability) {
        this.probability = probability;
        this.output = output;
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput, CompilationContext context) {
        return new DropoutLayerView(previousOutput, probability(layer));
    }

    public static LayerView createFromMaterialization(LayerView previous, MaterializationView materializationView) {
        return new DropoutLayerView(previous instanceof VLayerView vLayerView ? vLayerView.previousLayerOutput : previous.getOutputView(), probability(materializationView.layer));
    }

    private static double probability(Layer layer) {
        try {
            return (double) layer.getClass().getDeclaredMethod("probability").invoke(layer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OutputView getOutputView() {
        return output;
    }

    @Override
    public LayerView from(OutputView previous) {
        return new DropoutLayerView(previous == null ? this.output: previous, this.probability);
    }
}
