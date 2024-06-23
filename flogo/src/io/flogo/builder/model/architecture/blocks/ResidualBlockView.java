package io.flogo.builder.model.architecture.blocks;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.architecture.layers.processing.ConvolutionalLayerView;
import io.flogo.builder.model.architecture.layers.processing.LinearLayerView;

import java.util.List;

public class ResidualBlockView implements BlockView {
    private final List<LayerView> layerViews;
    public final ShorcutView shortCut;

    public ResidualBlockView(List<LayerView> layerViews, ShorcutView facetLayerViews) {
        this.layerViews = layerViews;
        this.shortCut = facetLayerViews;
    }

    public static ResidualBlockView from(List<LayerView> layerViews, ShorcutView facetLayerViews) {
        return new ResidualBlockView(layerViews, facetLayerViews);
    }

    @Override
    public OutputView output() {
        return layerViews.getLast().getOutputView();
    }

    @Override
    public List<LayerView> layerViews() {
        return layerViews;
    }

    public static class ShorcutView {
        public final List<LayerView> layerViews;

        public ShorcutView(List<LayerView> layerViews) {
            this.layerViews = layerViews;
        }

        public static ShorcutView from(List<LayerView> layerViews, OutputView outputView) {
            if (!layerViews.getLast().getOutputView().equals(outputView) && !(layerViews.getLast() instanceof VLayerView)) add(layerViews, outputView);
            return new ShorcutView(layerViews);
        }

        private static void add(List<LayerView> layerViews, OutputView outputView) {
            switch (outputView.dimensions()) {
                case 1 -> layerViews.add(new LinearLayerView(layerViews.getLast().getOutputView(), outputView));
                case 3 -> layerViews.add(new ConvolutionalLayerView(layerViews.getLast().getOutputView(), outputView));
                default -> throw new RuntimeException("Not available layers for " + outputView.dimensions() + " dimension/s");
            }
        }

        public static ShorcutView from(String type, OutputView inputView, OutputView outputView) {
            if (type.equals("Default")) return new ShorcutView(defaultConnection(inputView, outputView));
            if (type.equals("BottleNeck")) return new ShorcutView(bottleneckConnection(inputView, outputView));
            throw new RuntimeException("Not Residual connection for " + type);
        }

        private static List<LayerView> bottleneckConnection(OutputView inputView, OutputView outputView) {
            return null;
        }

        private static List<LayerView> defaultConnection(OutputView inputView, OutputView outputView) {
            return switch (inputView.dimensions()) {
                case 1 -> List.of(new LinearLayerView(inputView, outputView));
                case 3 -> List.of(new ConvolutionalLayerView(inputView, outputView));
                default -> throw new RuntimeException("Not available layers for " + inputView.dimensions() + " dimension/s");
            };
        }
    }


}
