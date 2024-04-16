package io.flogo.builder.model.architecture.blocks;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;

import java.util.List;

public class ResidualBlockView implements BlockView {
    private final List<LayerView> layerViews;
    public final List<LayerView> residualConnection;

    public ResidualBlockView(List<LayerView> layerViews, List<LayerView> facetLayerViews) {
        this.layerViews = layerViews;
        this.residualConnection = facetLayerViews;
    }


    public static ResidualBlockView from(List<LayerView> layerViews, List<LayerView> facetLayerViews) {
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


}
