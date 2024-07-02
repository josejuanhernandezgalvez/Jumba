package io.flogo.builder.model.architecture.blocks;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.model.ConvolutionalSection;

import java.util.List;

public class BlattBlockView implements BlockView {
    private final OutputView previousOutput;

    public BlattBlockView(OutputView input, ConvolutionalSection.BlattBlock block) {
        previousOutput = input;
    }

    @Override
    public OutputView output() {
        return null;
    }

    @Override
    public List<LayerView> layerViews() {
        return List.of();
    }
}
