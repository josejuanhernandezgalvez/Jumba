package io.jumba.builder.model.architecture.layers.processing;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.model.architecture.LayerView;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.jumba.builder.model.architecture.layers.output.TwoDimensionsOutputView;
import io.jumba.model.RecurrentSection;
import io.intino.magritte.framework.Layer;

import java.util.List;

public class MapReduceRNNLayerView extends MapReduceRecurrentLayerView {
    private boolean mutable;

    public MapReduceRNNLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput, int hiddenSize, int numLayers, OutputType outputType, boolean bidirectional, double dropout, List<Reduce> reduce) {
        super(previousLayerOutput, thisLayerOutput, hiddenSize, numLayers, outputType, bidirectional, dropout, reduce);
    }

    public static MapReduceRNNLayerView from(Layer layer, OutputView previousOutputView, CompilationContext context) {
        RecurrentSection.MapReduce.Unit.RNN rnn = (RecurrentSection.MapReduce.Unit.RNN) layer;
        try {
            return new MapReduceRNNLayerView(previousOutputView,
                    operations(layer, previousOutputView).getLast().getOutputView(),
                    (Integer) rnn.outputType().getClass().getMethod("output").invoke(rnn.outputType()).getClass().getMethod("x").invoke(rnn.outputType().getClass().getMethod("output").invoke(rnn.outputType())),
                    rnn.numLayers(),
                    outputType(rnn),
                    rnn.bidirectional(),
                    rnn.dropout(),
                    operations(rnn, previousOutputView)).setMutable(LayerView.getMutable(layer));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private MapReduceRNNLayerView setMutable(boolean mutable) {
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
