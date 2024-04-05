package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.flogo.builder.model.architecture.layers.output.TwoDimensionsOutputView;
import io.flogo.builder.model.laboratory.SubstituteView;
import io.flogo.model.RecurrentSection;
import io.intino.magritte.framework.Layer;

import java.util.Arrays;

public class LSTMLayerView extends RecurrentLayerView {
    public LSTMLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput, int numLayers, OutputTypeView outputTypeView, boolean bidirectional, double dropout) {
        super(previousLayerOutput, thisLayerOutput, numLayers, outputTypeView, bidirectional, dropout);
    }

    public static LSTMLayerView from(Layer layer, OutputView previousOutput) {
        RecurrentSection.Block.LSTM lstm = (RecurrentSection.Block.LSTM) layer;
        return new LSTMLayerView(previousOutput, output(lstm, previousOutput, lstm.bidirectional()), lstm.numLayers(), outputType(lstm), lstm.bidirectional(), lstm.dropout());
    }

    public static LayerView createFromSubstitute(LayerView previous, SubstituteView substituteView) {
        try {
            return new LSTMLayerView(previous(previous), output(substituteView.layer, previous(previous),
                    (Boolean) substituteView.layer.getClass().getMethod("bidirectional").invoke(substituteView.layer)),
                    (Integer) substituteView.layer.getClass().getMethod("numLayers").invoke(substituteView.layer),
                    outputType(substituteView.layer),
                    (Boolean) substituteView.layer.getClass().getMethod("bidirectional").invoke(substituteView.layer),
                    (Double) substituteView.layer.getClass().getMethod("dropout").invoke(substituteView.layer));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static OutputView previous(LayerView previous) {
        if (previous instanceof VLayerView vLayerView)
            return vLayerView.previousLayerOutput;
        return previous.getOutputView();
    }

    private static OutputTypeView outputType(Layer lstm) {
        try {
            return OutputTypeView.valueOf(Arrays.stream(lstm.getClass().getMethod("outputType").invoke(lstm).getClass().getName().split("\\$")).toList().getLast());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static OutputView output(Layer lstm, OutputView previousOutput, boolean bidirectional) {
        return outputType(lstm).output(lstm, previousOutput, bidirectional);
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput instanceof OneDimensionOutputView ? thisLayerOutput : new OneDimensionOutputView(((TwoDimensionsOutputView) thisLayerOutput).x());
    }

    @Override
    public LayerView from(LayerView previous) {
        return new LSTMLayerView(previous == null ? previousLayerOutput : previous.getOutputView(), thisLayerOutput, numLayers, outputTypeView, bidirectional, dropout);
    }
}
