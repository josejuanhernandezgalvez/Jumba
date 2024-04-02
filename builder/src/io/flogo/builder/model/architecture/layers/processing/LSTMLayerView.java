package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.flogo.builder.model.laboratory.SubstituteView;
import io.flogo.model.RecurrentSection;
import io.intino.magritte.framework.Layer;

public class LSTMLayerView extends RecurrentLayerView {
    public LSTMLayerView(OutputView previousLayerOutput, OneDimensionOutputView thisLayerOutput, int numLayers, OutputType outputType, boolean bidirectional) {
        super(previousLayerOutput, thisLayerOutput, numLayers, outputType, bidirectional);
    }

    public static LSTMLayerView from(Layer layer, OutputView previousOutput) {
        RecurrentSection.Block.LSTM lstm = (RecurrentSection.Block.LSTM) layer;
        return new LSTMLayerView(previousOutput, output(lstm), lstm.stackedRecurrentSections(), outputType(lstm), lstm.bidirectional());
    }

    private static OutputType outputType(RecurrentSection.Block.LSTM lstm) {
        return OutputType.valueOf(lstm.outputType().toString());
    }

    private static OneDimensionOutputView output(RecurrentSection.Block.LSTM lstm) {
        return new OneDimensionOutputView(lstm.output().x());
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput;
    }

    @Override
    public LayerView from(VLayerView vLayerView, SubstituteView substituteViews) {
        return null;
    }

    @Override
    public LayerView from(LayerView previous) {
        return null;
    }
}
