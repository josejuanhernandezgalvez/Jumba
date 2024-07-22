package io.jumba.builder.model.architecture.layers.processing;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.ProcessingLayerView;
import io.jumba.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.intino.magritte.framework.Layer;

public final class LinearLayerView implements ProcessingLayerView {
    public final OutputView previousLayerOutput;
    public final OutputView thisLayerOutput;

    public LinearLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput) {
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput, CompilationContext context) {
        return new LinearLayerView(previousOutput, new OneDimensionOutputView(getX(layer)));
    }

    private static int getX(Layer layer) {
        try {
            return (int) layer.getClass().getMethod("output").invoke(layer).getClass()
                    .getMethod("x").invoke(layer.getClass().getMethod("output").invoke(layer));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput;
    }
}
