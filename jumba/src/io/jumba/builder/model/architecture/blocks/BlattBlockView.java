package io.jumba.builder.model.architecture.blocks;

import io.jumba.builder.model.architecture.BlockView;
import io.jumba.builder.model.architecture.LayerView;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.output.ThreeDimensionsOutputView;
import io.jumba.model.ConvolutionalSection;

import java.util.List;

public class BlattBlockView implements BlockView {
    private final OutputView previousOutput;
    private final ThreeDimensionsOutputView output;

    public BlattBlockView(OutputView input, ConvolutionalSection.BlattBlock block) {
        previousOutput = input;
        output = new ThreeDimensionsOutputView(block.output().x(), block.output().y(), block.output().z());
    }

    @Override
    public OutputView output() {
        return output;
    }

    @Override
    public List<LayerView> layerViews() {
        return List.of();
    }
}
