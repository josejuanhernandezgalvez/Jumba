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

public class LSTMLayerView extends RecurrentLayerView {
    public LSTMLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput, int hiddenSize, int numLayers, OutputType outputType, boolean bidirectional, double dropout, List<Reduce> reduce) {
        super(previousLayerOutput, thisLayerOutput, hiddenSize, numLayers, outputType, bidirectional, dropout, reduce);
    }

    public static LSTMLayerView from(Layer layer, OutputView previousOutputView) {
        RecurrentSection.Block.LSTM lstm = (RecurrentSection.Block.LSTM) layer;
        try {
            return new LSTMLayerView(previousOutputView,
                    operations(layer, previousOutputView).getLast().getOutputView(),
                    (Integer) lstm.outputType().getClass().getMethod("output").invoke(lstm.outputType()).getClass().getMethod("x").invoke(lstm.outputType().getClass().getMethod("output").invoke(lstm.outputType())),
                    lstm.numLayers(),
                    outputType(lstm),
                    lstm.bidirectional(),
                    lstm.dropout(),
                    operations(lstm, previousOutputView));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static LayerView createFromSubstitute(LayerView previous, MaterializationView materializationView) {
        try {
            return new LSTMLayerView(previousOutputView(previous),
                    operations(materializationView.layer, previousOutputView(previous)).getLast().getOutputView(),
                    (Integer) outputType(materializationView.layer).getClass().getMethod("output").invoke(outputType(materializationView.layer)).getClass().getMethod("x").invoke(outputType(materializationView.layer).getClass().getMethod("output").invoke(outputType(materializationView.layer))),
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
        return new LSTMLayerView(previous == null ? previousLayerOutput : previous,
                thisLayerOutput,
                hiddenSize,
                numLayers,
                outputType,
                bidirectional,
                dropout,
                reduce);
    }
}
