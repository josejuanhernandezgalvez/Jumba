package io.jumba.builder.model.architecture.layers.processing;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.jumba.builder.model.architecture.layers.output.TwoDimensionsOutputView;
import io.jumba.model.RecurrentSection;
import io.intino.magritte.framework.Layer;

import java.util.List;

public class GRULayerView extends RecurrentLayerView {
    public GRULayerView(OutputView previousLayerOutput, OutputView thisLayerOutput, int hiddenSize, int numLayers, OutputType outputType, boolean bidirectional, double dropout, List<Reduce> reduce) {
        super(previousLayerOutput, thisLayerOutput, hiddenSize, numLayers, outputType, bidirectional, dropout, reduce);
    }

    public static GRULayerView from(Layer layer, OutputView previousOutputView, CompilationContext context) {
        RecurrentSection.Block.GRU gru = (RecurrentSection.Block.GRU) layer;
        try {
            return new GRULayerView(previousOutputView,
                    operations(layer, previousOutputView).getLast().getOutputView(),
                    (Integer) gru.outputType().getClass().getMethod("output").invoke(gru.outputType()).getClass().getMethod("x").invoke(gru.outputType().getClass().getMethod("output").invoke(gru.outputType())),
                    gru.numLayers(),
                    outputType(gru),
                    gru.bidirectional(),
                    gru.dropout(),
                    operations(gru, previousOutputView));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput instanceof OneDimensionOutputView ? thisLayerOutput : new OneDimensionOutputView(((TwoDimensionsOutputView) thisLayerOutput).y());
    }
}
