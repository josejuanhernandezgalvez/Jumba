package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ProcessingLayerView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.laboratory.SubstituteView;
import io.intino.magritte.framework.Layer;

public class BatchNormalizationLayerView implements ProcessingLayerView {
    public final OutputView output;
    public final double momentum;
    public final double eps;

    public BatchNormalizationLayerView(OutputView output, double momentum, double eps) {
        this.output = output;
        this.momentum = momentum;
        this.eps = eps;
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput) {
        return new BatchNormalizationLayerView(previousOutput, momentum(layer), eps(layer));
    }

    public static LayerView createFromSubstitute(LayerView previous, SubstituteView substituteView) {
        return new BatchNormalizationLayerView(previous instanceof VLayerView vLayerView ? vLayerView.previousLayerOutput : previous.getOutputView(), momentum(substituteView.layer), eps(substituteView.layer));
    }

    @Override
    public LayerView from(OutputView previous) {
        return new BatchNormalizationLayerView(previous == null ? this.output: previous, this.momentum, this.eps);
    }

    private static double momentum(Layer layer) {
        try {
            return (double) layer.getClass().getDeclaredMethod("momentum").invoke(layer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
}
