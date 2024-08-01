package io.jumba.builder.model.architecture.layers.processing;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.model.architecture.LayerView;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.ProcessingLayerView;
import io.jumba.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.intino.magritte.framework.Layer;

public final class LinearLayerView implements ProcessingLayerView {
    public final OutputView previousLayerOutput;
    public final OutputView thisLayerOutput;
    public boolean mutable;

    public LinearLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput) {
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
        this.mutable = false;
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput, CompilationContext context) {
        return new LinearLayerView(previousOutput, new OneDimensionOutputView(getX(layer))).setMutable(LayerView.getMutable(layer));
    }

    private ProcessingLayerView setMutable(boolean mutable) {
        this.mutable = mutable;
        return this;
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

    @Override
    public boolean isMutable() {
        return mutable;
    }
}
