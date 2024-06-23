package io.flogo.builder.model.architecture.layers;

import io.flogo.builder.CompilationContext;
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

    public VLayerView(VLayerView vLayerView) {
        this.id = vLayerView.id;
        this.previousLayerOutput = vLayerView.previousLayerOutput;
        this.thisLayerOutput = vLayerView.thisLayerOutput;
    }

    public static VLayerView from(Layer layer, OutputView outputView, CompilationContext context) {
        return new VLayerView(id(layer), outputView, new UndeterminedOutputView());
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput;
    }

    @Override
    public LayerView from(OutputView previous) {
        return null;
    }

    private static String id(Layer layer) {
        try {
            return (String) layer.getClass().getMethod("id").invoke(layer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
