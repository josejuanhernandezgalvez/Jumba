package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.flogo.builder.model.architecture.layers.output.TwoDimensionsOutputView;
import io.flogo.builder.model.laboratory.SubstituteView;
import io.flogo.model.RecurrentSection;
import io.intino.magritte.framework.Layer;

import java.util.Arrays;

public class GRULayerView extends RecurrentLayerView {
    public GRULayerView(OutputView previousLayerOutput, OutputView thisLayerOutput, int numLayers, OutputTypeView outputTypeView, boolean bidirectional, double dropout) {
        super(previousLayerOutput, thisLayerOutput, numLayers, outputTypeView, bidirectional, dropout);
    }

    public static GRULayerView from(Layer layer, OutputView previousOutputView) {
        RecurrentSection.Block.GRU gru = (RecurrentSection.Block.GRU) layer;
        return new GRULayerView(previousOutputView, output(gru, previousOutputView), gru.numLayers(), outputType(gru), gru.bidirectional(), gru.dropout());
    }

    public static LayerView createFromSubstitute(LayerView previous, SubstituteView substituteView) {
        return null;
    }

    private static OutputTypeView outputType(RecurrentSection.Block.GRU gru) {
        return OutputTypeView.valueOf(Arrays.stream(gru.outputType().getClass().getName().split("\\$")).toList().getLast());
    }

    private static OutputView output(RecurrentSection.Block.GRU gru, OutputView previousOutput) {
        return outputType(gru).output(gru, previousOutput);
    }


    @Override
    public OutputView getOutputView() {
        return thisLayerOutput instanceof OneDimensionOutputView ? thisLayerOutput : new OneDimensionOutputView(((TwoDimensionsOutputView) thisLayerOutput).x());
    }

    @Override
    public LayerView from(LayerView previous) {
        return new GRULayerView(previous.getOutputView(), thisLayerOutput, numLayers, outputTypeView, bidirectional, dropout);
    }
}
