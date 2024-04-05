package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.flogo.builder.model.architecture.layers.output.TwoDimensionsOutputView;
import io.intino.magritte.framework.Layer;

import java.lang.reflect.Method;

public abstract class RecurrentLayerView implements LayerView {
    public final OutputView previousLayerOutput;
    public final OutputView thisLayerOutput;
    public final int numLayers;
    public final OutputTypeView outputTypeView;
    public final boolean bidirectional;
    public final double dropout;

    public RecurrentLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput, int numLayers, OutputTypeView outputTypeView, boolean bidirectional, double dropout) {
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
        this.numLayers = numLayers;
        this.outputTypeView = outputTypeView;
        this.bidirectional = bidirectional;
        this.dropout = dropout;
    }

    public enum OutputTypeView {
        EndSequence {
            @Override
            OutputView output(Layer lstm, OutputView input, boolean bidirectional) {
                return new TwoDimensionsOutputView(bidirectional ? OutputTypeView.getX(lstm) * 2 : OutputTypeView.getX(lstm), ((TwoDimensionsOutputView) input).y());
            }
        }, CellStates {
            @Override
            OutputView output(Layer layer, OutputView previousOutput, boolean bidirectional) {
                return new TwoDimensionsOutputView(OutputTypeView.getX(layer), bidirectional ? OutputTypeView.getNumberLayers(layer) * 2 : OutputTypeView.getNumberLayers(layer));
            }
        }, HiddenStates {
            @Override
            OutputView output(Layer layer, OutputView previousOutput, boolean bidirectional) {
                return new TwoDimensionsOutputView(OutputTypeView.getX(layer), bidirectional ? OutputTypeView.getNumberLayers(layer) * 2 : OutputTypeView.getNumberLayers(layer));
            }
        }, LastHiddenState {
            @Override
            OutputView output(Layer layer, OutputView previousOutput, boolean bidirectional) {
                return new OneDimensionOutputView(bidirectional ? OutputTypeView.getX(layer) * 2 : OutputTypeView.getX(layer));
            }
        }, LastCellState {
            @Override
            OutputView output(Layer layer, OutputView previousOutput, boolean bidirectional) {
                return new OneDimensionOutputView(bidirectional ? OutputTypeView.getX(layer) * 2 : OutputTypeView.getX(layer));
            }
        };

        abstract OutputView output(Layer lstm, OutputView previousOutput, boolean bidirectional);

        private static int getX(Layer layer){
            try {
                return (int) getOutput(layer).invoke(layer.getClass().getDeclaredMethod("outputType").invoke(layer)).getClass()
                        .getMethod("x").invoke(getOutput(layer).invoke(layer.getClass().getDeclaredMethod("outputType").invoke(layer)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private static int getNumberLayers(Layer layer) {
            try {
                return (int) layer.getClass().getMethod("numLayers").invoke(layer);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private static Method getOutput(Layer layer) {
            try {
                return layer.getClass().getDeclaredMethod("outputType").invoke(layer).getClass().getMethod("output");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
