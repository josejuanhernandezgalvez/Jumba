package io.flogo.builder.model.architecture.layers.activation;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ActivationLayerView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.laboratory.SubstituteView;
import io.intino.magritte.framework.Layer;

import java.lang.reflect.Field;
import java.util.Objects;

public final class ELULayerView implements ActivationLayerView {
    public final int alpha;
    public final OutputView outputView;

    public ELULayerView(int alpha, OutputView outputView) {
        this.alpha = alpha;
        this.outputView = outputView;
    }

    public static ActivationLayerView from(Layer layer, OutputView outputView) {
        return new ELULayerView(getAlphaFrom(layer), outputView);
    }

    public static ActivationLayerView createFromSubstitute(LayerView previous, SubstituteView substituteView) {
        return new ELULayerView(getAlphaFrom(substituteView.layer), previous instanceof VLayerView vLayerView ? vLayerView.previousLayerOutput : previous.getOutputView());
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
    public LayerView from(LayerView previous) {
        return new ELULayerView(this.alpha, previous == null ? this.outputView : previous.getOutputView());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ELULayerView) obj;
        return this.alpha == that.alpha &&
                Objects.equals(this.outputView, that.outputView);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alpha, outputView);
    }

    @Override
    public String toString() {
        return "ELULayerView[" +
                "alpha=" + alpha + ", " +
                "outputView=" + outputView + ']';
    }
}
