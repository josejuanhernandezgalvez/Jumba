package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.CompilationContext;
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
    public RNNLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput, int hiddenSize, int numLayers, OutputType outputType, boolean bidirectional, double dropout, List<Reduce> reduce) {
        super(previousLayerOutput, thisLayerOutput, hiddenSize, numLayers, outputType, bidirectional, dropout, reduce);
    }

    public static RNNLayerView from(Layer layer, OutputView previousOutputView, CompilationContext context) {
        RecurrentSection.Block.RNN rnn = (RecurrentSection.Block.RNN) layer;
        try {
            return new RNNLayerView(previousOutputView,
                    operations(layer, previousOutputView).getLast().getOutputView(),
                    (Integer) rnn.outputType().getClass().getMethod("output").invoke(rnn.outputType()).getClass().getMethod("x").invoke(rnn.outputType().getClass().getMethod("output").invoke(rnn.outputType())),
                    rnn.numLayers(),
                    outputType(rnn),
                    rnn.bidirectional(),
                    rnn.dropout(),
                    operations(rnn, previousOutputView));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static LayerView createFromMaterialization(LayerView previous, MaterializationView materializationView) {
        try {
            return new RNNLayerView(previousOutputView(previous),
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
        return new RNNLayerView(previous == null ? previousLayerOutput : previous,
                thisLayerOutput,
                hiddenSize,
                numLayers,
                outputType,
                bidirectional,
                dropout,
                reduce);
    }
}
