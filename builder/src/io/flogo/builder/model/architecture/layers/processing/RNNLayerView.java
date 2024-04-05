package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.flogo.builder.model.architecture.layers.output.TwoDimensionsOutputView;
import io.flogo.builder.model.laboratory.SubstituteView;
import io.flogo.model.RecurrentSection;
import io.intino.magritte.framework.Layer;

import java.util.Arrays;

public class RNNLayerView extends RecurrentLayerView {
    public RNNLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput, int numLayers, OutputTypeView outputTypeView, boolean bidirectional, double dropout) {
        super(previousLayerOutput, thisLayerOutput, numLayers, outputTypeView, bidirectional, dropout);
    }

    public static RNNLayerView from(Layer layer, OutputView previousOutputView) {
        RecurrentSection.Block.RNN rnn = (RecurrentSection.Block.RNN) layer;
        return new RNNLayerView(previousOutputView, output(rnn, previousOutputView), rnn.numLayers(), outputType(rnn), rnn.bidirectional(), rnn.dropout());
    }

    public static LayerView createFromSubstitute(LayerView previous, SubstituteView substituteView) {
        return null;
    }

    private static OutputTypeView outputType(RecurrentSection.Block.RNN rnn) {
        return OutputTypeView.valueOf(Arrays.stream(rnn.outputType().getClass().getName().split("\\$")).toList().getLast());
    }

    private static OutputView output(RecurrentSection.Block.RNN rnn, OutputView previousOutput) {
        return outputType(rnn).output(rnn, previousOutput);
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput instanceof OneDimensionOutputView ? thisLayerOutput : new OneDimensionOutputView(((TwoDimensionsOutputView) thisLayerOutput).x());
    }

    @Override
    public LayerView from(LayerView previous) {
        return new RNNLayerView(previous == null ? previousLayerOutput : previous.getOutputView(), thisLayerOutput, numLayers, outputTypeView, bidirectional, dropout);
    }
}
