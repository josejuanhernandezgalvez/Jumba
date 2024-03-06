package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.flogo.model.RecurrentSection;
import io.intino.magritte.framework.Layer;

public class LSTMLayerView extends RecurrentLayerView {
    public LSTMLayerView(OneDimensionOutputView previousLayerOutput, OneDimensionOutputView thisLayerOutput, int numLayers, String outputElement, boolean bidirectional) {
        super(previousLayerOutput, thisLayerOutput, numLayers, outputElement, bidirectional);
    }

    public static LSTMLayerView from(Layer layer, OutputView previousOutput) {
        RecurrentSection.Block.LSTM lstm = (RecurrentSection.Block.LSTM) layer;
        return new LSTMLayerView((OneDimensionOutputView) previousOutput, output(lstm), lstm.stackedRecurrentSections(), outputType(lstm), lstm.bidirectional());
    }

    private static String outputType(RecurrentSection.Block.LSTM lstm) {
        return lstm.outputElement() != null ? lstm.outputElement().type() : "lastOutput";
    }

    private static OneDimensionOutputView output(RecurrentSection.Block.LSTM lstm) {
        return new OneDimensionOutputView(lstm.output().x());
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput;
    }
}
