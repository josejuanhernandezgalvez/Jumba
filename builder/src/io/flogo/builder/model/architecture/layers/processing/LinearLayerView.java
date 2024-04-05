package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.ProcessingLayerView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.flogo.builder.model.laboratory.SubstituteView;
import io.flogo.model.Laboratory.Experiment.Substitute;
import io.intino.magritte.framework.Layer;

public final class LinearLayerView implements ProcessingLayerView {
    public final OutputView previousLayerOutput;
    public final OutputView thisLayerOutput;

    public LinearLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput) {
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
    }

    public static ProcessingLayerView from(Layer layer, OutputView previousOutput) {
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

    public static LayerView createFromSubstitute(LayerView previous, SubstituteView substituteView) {
        return new LinearLayerView(previous instanceof VLayerView vLayerView ? vLayerView.previousLayerOutput : previous.getOutputView(), new OneDimensionOutputView(((Substitute.Linear) substituteView.layer).output().x()));
    }

    @Override
    public LayerView from(LayerView previous) {
        return new LinearLayerView(previous == null ? previousLayerOutput: previous.getOutputView(), thisLayerOutput);
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput;
    }
}
