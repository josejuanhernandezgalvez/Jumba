package io.flogo.builder.model.architecture.layers.activation;

import io.flogo.builder.CompilationContext;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ActivationLayerView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.laboratory.MaterializationView;
import io.intino.magritte.framework.Layer;

import java.lang.reflect.Field;

public final class LeakyReLULayerView implements ActivationLayerView {
    public final int alpha;
    public final OutputView outputView;

    public LeakyReLULayerView(int alpha, OutputView outputView) {
        this.alpha = alpha;
        this.outputView = outputView;
    }

    public static ActivationLayerView from(Layer layer, OutputView outputView, CompilationContext context) {
        return new LeakyReLULayerView(getAlphaFrom(layer), outputView);
    }

    public static ActivationLayerView createFromMaterialization(LayerView previous, MaterializationView materializationView, CompilationContext context) {
        return new LeakyReLULayerView(getAlphaFrom(materializationView.layer), previous instanceof VLayerView vLayerView ? vLayerView.previousLayerOutput : previous.getOutputView());
    }

    private static int getAlphaFrom(Layer layer) {
        try {
            Field alpha = layer.getClass().getDeclaredField("alpha");
            alpha.setAccessible(true);
            return (int) alpha.get(layer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OutputView getOutputView() {
        return outputView;
    }

    @Override
    public LayerView from(OutputView previous, CompilationContext context) {
        return new LeakyReLULayerView(this.alpha, previous == null ? this.outputView : previous);
    }
}
