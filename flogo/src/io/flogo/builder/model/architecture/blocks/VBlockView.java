package io.flogo.builder.model.architecture.blocks;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.output.UndeterminedOutputView;

import java.util.List;

public class VBlockView implements BlockView {
    private final String id;
    private final OutputView previosuOutput;

    public VBlockView(OutputView input, String id) {
        this.previosuOutput = input;
        this.id = id;
    }

    @Override
    public OutputView output() {
        return new UndeterminedOutputView();
    }

    @Override
    public List<LayerView> layerViews() {
        return List.of();
    }
}
