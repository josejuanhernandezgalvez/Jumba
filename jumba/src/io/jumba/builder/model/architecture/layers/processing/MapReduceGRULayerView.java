package io.jumba.builder.model.architecture.layers.processing;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.model.architecture.LayerView;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.jumba.builder.model.architecture.layers.output.TwoDimensionsOutputView;
import io.jumba.model.RecurrentSection;
import io.intino.magritte.framework.Layer;

import java.util.List;

public class MapReduceGRULayerView extends MapReduceRecurrentLayerView {
    public boolean mutable;

    public MapReduceGRULayerView(OutputView previousLayerOutput, OutputView thisLayerOutput, int hiddenSize, int numLayers, OutputType outputType, boolean bidirectional, double dropout, List<Reduce> reduce) {
        super(previousLayerOutput, thisLayerOutput, hiddenSize, numLayers, outputType, bidirectional, dropout, reduce);
    }

    public static MapReduceGRULayerView from(Layer layer, OutputView previousOutputView, CompilationContext context) {
        RecurrentSection.MapReduce.Unit.GRU gru = (RecurrentSection.MapReduce.Unit.GRU) layer;
        try {
            return new MapReduceGRULayerView(previousOutputView,
                    operations(layer, previousOutputView).getLast().getOutputView(),
                    (Integer) gru.outputType().getClass().getMethod("output").invoke(gru.outputType()).getClass().getMethod("x").invoke(gru.outputType().getClass().getMethod("output").invoke(gru.outputType())),
                    gru.numLayers(),
                    outputType(gru),
                    gru.bidirectional(),
                    gru.dropout(),
                    operations(gru, previousOutputView)).setMutable(LayerView.getMutable(layer));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private MapReduceGRULayerView setMutable(boolean mutable) {
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
