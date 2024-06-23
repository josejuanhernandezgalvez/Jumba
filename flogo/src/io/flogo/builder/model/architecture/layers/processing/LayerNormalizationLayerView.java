package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.CompilationContext;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ProcessingLayerView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.laboratory.MaterializationView;
import io.intino.magritte.framework.Layer;

public class LayerNormalizationLayerView implements ProcessingLayerView {
    public final OutputView output;
    public final double eps;

    public LayerNormalizationLayerView(OutputView output, double eps) {
        this.output = output;
        this.eps = eps;
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput, CompilationContext context) {
        return new LayerNormalizationLayerView(previousOutput, eps(layer));
    }

    public static LayerView createFromMaterialization(LayerView previous, MaterializationView materializationView, CompilationContext context) {
        return new LayerNormalizationLayerView(previous instanceof VLayerView vLayerView ? vLayerView.previousLayerOutput : previous.getOutputView(), eps(materializationView.layer));
    }

    private static double eps(Layer layer) {
        try {
            return (double) layer.getClass().getDeclaredMethod("eps").invoke(layer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OutputView getOutputView() {
        return output;
    }

    @Override
    public LayerView from(OutputView previous, CompilationContext context) {
        return new LayerNormalizationLayerView(previous == null ? this.output: previous, this.eps);
    }
}
