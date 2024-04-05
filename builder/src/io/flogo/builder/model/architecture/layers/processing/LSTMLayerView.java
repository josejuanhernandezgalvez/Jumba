package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
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
        return new LSTMLayerView(previousOutput, output(lstm, previousOutput), lstm.numLayers(), outputType(lstm), lstm.bidirectional(), lstm.dropout());
    }

    public static LayerView createFromSubstitute(LayerView previous, SubstituteView substituteView) {
        return null;
    }

    private static OutputTypeView outputType(RecurrentSection.Block.LSTM lstm) {
        return OutputTypeView.valueOf(Arrays.stream(lstm.outputType().getClass().getName().split("\\$")).toList().getLast());
    }

    private static OutputView output(RecurrentSection.Block.LSTM lstm, OutputView previousOutput) {
        return outputType(lstm).output(lstm, previousOutput);
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput instanceof OneDimensionOutputView ? thisLayerOutput : new OneDimensionOutputView(((TwoDimensionsOutputView) thisLayerOutput).x());
    }

    @Override
    public LayerView from(LayerView previous) {
        return new LSTMLayerView(previous.getOutputView(), thisLayerOutput, numLayers, outputTypeView, bidirectional, dropout);
    }
}
