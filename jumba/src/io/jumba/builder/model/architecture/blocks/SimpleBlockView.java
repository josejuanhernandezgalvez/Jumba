package io.jumba.builder.model.architecture.blocks;

import io.jumba.builder.model.architecture.BlockView;
import io.jumba.builder.model.architecture.LayerView;
import io.jumba.builder.model.architecture.OutputView;

import java.util.List;

public class SimpleBlockView implements BlockView {
    private final List<LayerView> layerViews;

    public SimpleBlockView(List<LayerView> layerViews) {
        this.layerViews = layerViews;
    }

    @Override
    public OutputView output() {
        return layerViews.getLast().getOutputView();
    }

    @Override
    public List<LayerView> layerViews() {
        return layerViews;
    }

    public static SimpleBlockView from(List<LayerView> layerViews) {
        return new SimpleBlockView(layerViews);
    }
}
