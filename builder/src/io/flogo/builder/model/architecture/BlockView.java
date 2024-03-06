package io.flogo.builder.model.architecture;

import java.util.List;

public record BlockView(List<LayerView> layerViews) {
    public OutputView output() {
        return layerViews.getLast().getOutputView();
    }
}