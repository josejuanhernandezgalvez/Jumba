package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.flogo.builder.model.architecture.layers.output.TwoDimensionsOutputView;
import io.flogo.builder.model.laboratory.SubstituteView;
import io.flogo.model.RecurrentSection;
import io.intino.magritte.framework.Layer;

import java.util.List;

public class GRULayerView extends RecurrentLayerView {
    public GRULayerView(OutputView previousLayerOutput, OutputView thisLayerOutput, int numLayers, OutputType outputType, boolean bidirectional, double dropout, List<Reduce> reduce) {
        super(previousLayerOutput, thisLayerOutput, numLayers, outputType, bidirectional, dropout, reduce);
    }

    public static GRULayerView from(Layer layer, OutputView previousOutputView) {
        RecurrentSection.Block.GRU gru = (RecurrentSection.Block.GRU) layer;
        return new GRULayerView(previousOutputView,
                operations(layer, previousOutputView).getLast().getOutputView(),
                gru.numLayers(),
                outputType(gru),
                gru.bidirectional(),
                gru.dropout(),
                operations(gru, previousOutputView));
    }

    public static LayerView createFromSubstitute(LayerView previous, SubstituteView substituteView) {
        try {
            return new GRULayerView(previousOutputView(previous),
                    operations(substituteView.layer, previousOutputView(previous)).getLast().getOutputView(),
                    (Integer) substituteView.layer.getClass().getMethod("numLayers").invoke(substituteView.layer),
                    outputType(substituteView.layer),
                    (Boolean) substituteView.layer.getClass().getMethod("bidirectional").invoke(substituteView.layer),
                    (Double) substituteView.layer.getClass().getMethod("dropout").invoke(substituteView.layer),
                    operations(substituteView.layer, previousOutputView(previous)));
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
    public LayerView from(LayerView previous) {
        return new GRULayerView(previous.getOutputView(), thisLayerOutput, numLayers, outputType, bidirectional, dropout, reduce);
    }
}
