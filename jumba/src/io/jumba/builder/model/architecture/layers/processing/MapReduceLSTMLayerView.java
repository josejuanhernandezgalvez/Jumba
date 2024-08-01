package io.jumba.builder.model.architecture.layers.processing;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.model.architecture.LayerView;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.jumba.builder.model.architecture.layers.output.TwoDimensionsOutputView;
import io.jumba.model.RecurrentSection;
import io.intino.magritte.framework.Layer;

import java.util.List;

public class MapReduceLSTMLayerView extends MapReduceRecurrentLayerView {
    private boolean mutable;

    public MapReduceLSTMLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput, int hiddenSize, int numLayers, OutputType outputType, boolean bidirectional, double dropout, List<Reduce> reduce) {
        super(previousLayerOutput, thisLayerOutput, hiddenSize, numLayers, outputType, bidirectional, dropout, reduce);
    }

    public static MapReduceLSTMLayerView from(Layer layer, OutputView previousOutputView, CompilationContext context) {
        try {
            RecurrentSection.MapReduce.Unit.LSTM lstm = (RecurrentSection.MapReduce.Unit.LSTM) layer;
            return new MapReduceLSTMLayerView(previousOutputView,
                    operations(layer, previousOutputView).getLast().getOutputView(),
                    (Integer) lstm.outputType().getClass().getMethod("output").invoke(lstm.outputType()).getClass().getMethod("x").invoke(lstm.outputType().getClass().getMethod("output").invoke(lstm.outputType())),
                    lstm.numLayers(),
                    outputType(lstm),
                    lstm.bidirectional(),
                    lstm.dropout(),
                    operations(lstm, previousOutputView)).setMutable(LayerView.getMutable(layer));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private MapReduceLSTMLayerView setMutable(boolean mutable) {
        this.mutable = mutable;
        return this;
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput instanceof OneDimensionOutputView ? thisLayerOutput : new OneDimensionOutputView(((TwoDimensionsOutputView) thisLayerOutput).y());
    }

    @Override
    public boolean isMutable() {
        return mutable;
    }
}
