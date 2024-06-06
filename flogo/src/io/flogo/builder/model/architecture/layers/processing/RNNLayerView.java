package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.flogo.builder.model.architecture.layers.output.TwoDimensionsOutputView;
import io.flogo.builder.model.laboratory.MaterializationView;
import io.flogo.model.RecurrentSection;
import io.intino.magritte.framework.Layer;

import java.util.List;

public class RNNLayerView extends RecurrentLayerView {
    public RNNLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput, int numLayers, OutputType outputType, boolean bidirectional, double dropout, List<Reduce> reduce) {
        super(previousLayerOutput, thisLayerOutput, numLayers, outputType, bidirectional, dropout, reduce);
    }

    public static RNNLayerView from(Layer layer, OutputView previousOutputView) {
        RecurrentSection.Block.RNN rnn = (RecurrentSection.Block.RNN) layer;
        return new RNNLayerView(previousOutputView,
                operations(layer, previousOutputView).getLast().getOutputView(),
                rnn.numLayers(), outputType(rnn),
                rnn.bidirectional(),
                rnn.dropout(),
                operations(rnn, previousOutputView));
    }

    public static LayerView createFromSubstitute(LayerView previous, MaterializationView materializationView) {
        try {
            return new RNNLayerView(previousOutputView(previous),
                    operations(materializationView.layer, previousOutputView(previous)).getLast().getOutputView(),
                    (Integer) materializationView.layer.getClass().getMethod("numLayers").invoke(materializationView.layer),
                    outputType(materializationView.layer),
                    (Boolean) materializationView.layer.getClass().getMethod("bidirectional").invoke(materializationView.layer),
                    (Double) materializationView.layer.getClass().getMethod("dropout").invoke(materializationView.layer),
                    operations(materializationView.layer, previousOutputView(previous)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static OutputView previousOutputView(LayerView previous) {
        if (previous instanceof VLayerView vLayerView)
            return vLayerView.previousLayerOutput;
        return previous.getOutputView();
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput instanceof OneDimensionOutputView ? thisLayerOutput : new OneDimensionOutputView(((TwoDimensionsOutputView) thisLayerOutput).y());
    }

    @Override
    public LayerView from(OutputView previous) {
        return new RNNLayerView(previous == null ? previousLayerOutput : previous,
                thisLayerOutput,
                numLayers,
                outputType,
                bidirectional,
                dropout,
                reduce);
    }
}
