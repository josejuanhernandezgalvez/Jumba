package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.flogo.builder.model.laboratory.SubstituteView;
import io.flogo.model.RecurrentSection;
import io.intino.magritte.framework.Layer;

public class RNNLayerView extends RecurrentLayerView {
    public RNNLayerView(OutputView previousLayerOutput, OneDimensionOutputView thisLayerOutput, int numLayers, OutputType outputType, boolean bidirectional) {
        super(previousLayerOutput, thisLayerOutput, numLayers, outputType, bidirectional);
    }

    public static RNNLayerView from(Layer layer, OutputView outputView) {
        RecurrentSection.Block.RNN rnn = (RecurrentSection.Block.RNN) layer;
        return new RNNLayerView(outputView, output(rnn), rnn.stackedRecurrentSections(), outputType(rnn), rnn.bidirectional());
    }

    private static OneDimensionOutputView output(RecurrentSection.Block.RNN lstm) {
        return new OneDimensionOutputView(lstm.output().x());
    }

    private static OutputType outputType(RecurrentSection.Block.RNN rnn) {
        return OutputType.valueOf(rnn.outputType().toString());
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
