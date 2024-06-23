package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.builder.CompilationContext;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.flogo.builder.model.architecture.layers.output.TwoDimensionsOutputView;
import io.intino.magritte.framework.Layer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class RecurrentLayerView implements LayerView {
    public final OutputView previousLayerOutput;
    public final OutputView thisLayerOutput;
    public final int numLayers;
    public final OutputType outputType;
    public final boolean bidirectional;
    public final double dropout;
    public final List<Reduce> reduce;
    public final int hiddenSize;

    public RecurrentLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput, int hiddenSize, int numLayers, OutputType outputType, boolean bidirectional, double dropout, List<Reduce> reduce) {
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
        this.numLayers = numLayers;
        this.outputType = outputType;
        this.bidirectional = bidirectional;
        this.dropout = dropout;
        this.reduce = reduce;
        this.hiddenSize = hiddenSize;
    }

    protected static List<Reduce> operations(Layer layer, OutputView previousLayerOutput) {
        try {
            return new Reduce.Builder()
                    .previousOutput(recurrentLayerOutputView(layer, previousLayerOutput))
                    .layer(layer)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static OutputView recurrentLayerOutputView(Layer layer, OutputView previousLayerOutput) {
        try {
            return new TwoDimensionsOutputView(rowsDim(previousLayerOutput, layer), hiddenDim(layer));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static int rowsDim(OutputView previousLayerOutput, Layer layer) {
        if (isEndSequence(layer)) return ((TwoDimensionsOutputView) previousLayerOutput).x();
        return isBidirectional(layer) ? numLayers(layer) * 2 : numLayers(layer);
    }

    private static int numLayers(Layer layer) {
        try {
            return (Integer) layer.getClass().getMethod("numLayers").invoke(layer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static int hiddenDim(Layer layer) {
        return isBidirectional(layer) && isEndSequence(layer) ? hiddenDimParameter(layer) * 2 : hiddenDimParameter(layer);
    }

    private static boolean isBidirectional(Layer layer) {
        try {
            return (Boolean) layer.getClass().getMethod("bidirectional").invoke(layer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isEndSequence(Layer layer) {
        return outputType(layer) == OutputType.EndSequence;
    }

    private static int hiddenDimParameter(Layer layer) {
        try {
            return (Integer) getOutputType(layer).getClass().getMethod("output").invoke(getOutputType(layer)).getClass().getMethod("x").invoke(getOutputType(layer).getClass().getMethod("output").invoke(getOutputType(layer)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected static OutputType outputType(Layer layer) {
        try {
            return OutputType.valueOf(Arrays.stream(layer.getClass().getMethod("outputType").invoke(layer).getClass().getName().split("\\$")).toList().getLast());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Object getOutputType(Layer layer) {
        try {
            return layer.getClass().getMethod("outputType").invoke(layer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public abstract LayerView from(OutputView previous, CompilationContext context);

    public enum OutputType {
        EndSequence, CellStates, HiddenStates, LastHiddenState, LastCellState
    }

    public static abstract class Reduce {
        public abstract OutputView getOutputView();

        public static class Builder {
            private OutputView previousOutput;
            private OutputType outputType;
            private boolean bidirectional;
            private String reduceOperation;
            private int from;
            private int to;

            public Builder(OutputView previousOutput, OutputType outputType, boolean bidirectional, String reduceOperation, int from, int to) {
                this.previousOutput = previousOutput;
                this.outputType = outputType;
                this.bidirectional = bidirectional;
                this.reduceOperation = reduceOperation;
                this.from = from;
                this.to = to;
            }

            public Builder() {}

            public Builder layer(Layer layer) {
                this.outputType = outputType(layer);
                this.bidirectional = isBidirectional(layer);
                this.reduceOperation = reduceOperation(layer);
                this.from = from(layer);
                this.to = to(layer);
                return this;
            }

            public Builder previousOutput(OutputView previousOutput) {
                this.previousOutput = previousOutput;
                return this;
            }

            public List<Reduce> build() {
                ArrayList<Reduce> result = new ArrayList<>();
                if (sliceCondition()) result.add(new SliceReduce(from, to, previousOutput));
                if (reduceOperation.equals("flatten")) {
                    if (getRows(result) >= 1) result.add(new FlattenReduce(getLastOutputView(result)));
                    return result;
                }
                if (reduceOperation.equals("linear")) {
                    result.add(new LinearReduce(getLastOutputView(result), 1, 1));
                    if (outputType == OutputType.EndSequence && bidirectional)
                        result.add(new LinearReduce(result.getLast().getOutputView(), 2, result.getLast().getOutputView().asArray()[1] / 2));
                    return result;
                }
                return result;
            }

            private OutputView getLastOutputView(ArrayList<Reduce> result) {
                return result.isEmpty() ? previousOutput : result.getLast().getOutputView();
            }

            private int getRows(ArrayList<Reduce> result) {
                return result.isEmpty() ? previousOutput.asArray()[0] : result.getLast().getOutputView().asArray()[0];
            }

            private boolean sliceCondition() {
                return !(from == 1 && to == this.previousOutput.asArray()[0]);
            }

            private int from(Layer layer) {
                try {
                    if (outputType.toString().startsWith("Last"))
                        return bidirectional ? this.previousOutput.asArray()[0] - 1 : this.previousOutput.asArray()[0];
                    int from = (int) getOutputType(layer).getClass().getMethod("from").invoke(getOutputType(layer));
                    return from == 0 ? 1 : Math.max(from, 0);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            private int to(Layer layer) {
                try {
                    if (outputType.toString().startsWith("Last")) return this.previousOutput.asArray()[0];
                    int to = (int) getOutputType(layer).getClass().getMethod("to").invoke(getOutputType(layer));
                    return to == 0 ? this.previousOutput.asArray()[0] : Math.min(to, this.previousOutput.asArray()[0]);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            private String reduceOperation(Layer layer) {
                try {
                    return layer.getClass().getMethod("outputType")
                            .invoke(layer).getClass()
                            .getMethod("reduce")
                            .invoke(layer.getClass().getMethod("outputType").invoke(layer)).toString();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

        }

        public static class SliceReduce extends Reduce {
            public final int from;
            public final int to;
            public final OutputView previousOutputView;
            public final OutputView outputView;

            public SliceReduce(int from, int to, OutputView previousOutputView) {
                this.from = from;
                this.to = to;
                this.previousOutputView = previousOutputView;
                this.outputView = new TwoDimensionsOutputView(dimensionFor(from, to), ((TwoDimensionsOutputView) previousOutputView).y());
            }

            private int dimensionFor(int from, int to) {
                return to - from + 1;
            }

            @Override
            public OutputView getOutputView() {
                return outputView;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                SliceReduce that = (SliceReduce) o;
                return from == that.from && to == that.to && Objects.equals(previousOutputView, that.previousOutputView) && Objects.equals(outputView, that.outputView);
            }

            @Override
            public int hashCode() {
                return Objects.hash(from, to, previousOutputView, outputView);
            }
        }

        public static class FlattenReduce extends Reduce {
            public final int startDimension;
            public final int endDimension;
            public final OutputView previousOutputView;
            public final OutputView outputView;

            public FlattenReduce(OutputView previousOutputView) {
                this.startDimension = previousOutputView.dimensions();
                this.endDimension = 1;
                this.previousOutputView = new TwoDimensionsOutputView(((TwoDimensionsOutputView) previousOutputView).x(), ((TwoDimensionsOutputView) previousOutputView).y());
                this.outputView = new OneDimensionOutputView(((TwoDimensionsOutputView) previousOutputView).x() * ((TwoDimensionsOutputView) previousOutputView).y());
            }

            @Override
            public OutputView getOutputView() {
                return outputView;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                FlattenReduce that = (FlattenReduce) o;
                return startDimension == that.startDimension && endDimension == that.endDimension && Objects.equals(previousOutputView, that.previousOutputView) && Objects.equals(outputView, that.outputView);
            }

            @Override
            public int hashCode() {
                return Objects.hash(startDimension, endDimension, previousOutputView, outputView);
            }
        }

        public static class LinearReduce extends Reduce {
            public final int dimensionToActOn;
            public final OutputView previousOutputView;
            public final OutputView outputView;

            public LinearReduce(OutputView previousOutputView, int dimensionToActOn, int dimensionOutput) {
                this.dimensionToActOn = dimensionToActOn;
                this.previousOutputView = previousOutputView;
                this.outputView = new TwoDimensionsOutputView(
                        dimensionToActOn == 1 ? dimensionOutput : previousOutputView.asArray()[0],
                        dimensionToActOn == 2 ? dimensionOutput : previousOutputView.asArray()[1]);
            }

            @Override
            public OutputView getOutputView() {
                return outputView;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                LinearReduce that = (LinearReduce) o;
                return dimensionToActOn == that.dimensionToActOn && Objects.equals(previousOutputView, that.previousOutputView) && Objects.equals(outputView, that.outputView);
            }

            @Override
            public int hashCode() {
                return Objects.hash(dimensionToActOn, previousOutputView, outputView);
            }
        }
    }
}
