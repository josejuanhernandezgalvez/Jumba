package io.flogo.builder.model.architecture.layers;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.output.UndeterminedOutputView;
import io.intino.magritte.framework.Layer;

public class VLayerView implements LayerView {
    public final String id;
    public final OutputView previousLayerOutput;
    public final OutputView thisLayerOutput;

    public VLayerView(String id, OutputView previousLayerOutput, OutputView thisLayerOutput) {
        this.id = id;
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput;
    }

    @Override
    public LayerView from(LayerView previous) {
        return null;
    }

    public static VLayerView from(Layer layer, OutputView outputView) {
        return new VLayerView(id(layer), outputView, new UndeterminedOutputView());
    }

    private static String id(Layer layer) {
        try {
            return (String) layer.getClass().getMethod("id").invoke(layer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
