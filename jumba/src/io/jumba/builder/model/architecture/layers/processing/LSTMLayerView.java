package io.jumba.builder.model.architecture.layers.processing;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.jumba.builder.model.architecture.layers.output.TwoDimensionsOutputView;
import io.jumba.model.RecurrentSection;
import io.intino.magritte.framework.Layer;

import java.util.List;

public class LSTMLayerView extends RecurrentLayerView {
    public LSTMLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput, int hiddenSize, int numLayers, OutputType outputType, boolean bidirectional, double dropout, List<Reduce> reduce) {
        super(previousLayerOutput, thisLayerOutput, hiddenSize, numLayers, outputType, bidirectional, dropout, reduce);
    }

    public static LSTMLayerView from(Layer layer, OutputView previousOutputView, CompilationContext context) {
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

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput instanceof OneDimensionOutputView ? thisLayerOutput : new OneDimensionOutputView(((TwoDimensionsOutputView) thisLayerOutput).y());
    }
}
