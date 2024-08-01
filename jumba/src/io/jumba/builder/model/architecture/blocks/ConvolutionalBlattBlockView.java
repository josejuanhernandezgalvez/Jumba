package io.jumba.builder.model.architecture.blocks;

import io.jumba.builder.model.architecture.BlockView;
import io.jumba.builder.model.architecture.LayerView;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.ActivationLayerView;
import io.jumba.builder.model.architecture.layers.output.ThreeDimensionsOutputView;
import io.jumba.builder.model.architecture.layers.processing.ConvolutionalLayerView;
import io.jumba.model.ConvolutionalSection;

import java.util.List;

public class ConvolutionalBlattBlockView implements BlockView {
    public final OutputView previousOutput;
    public final OutputView thisOutput;
    public final ConvolutionalLayerView processingLayerView;
    public final ActivationLayerView activationLayerView;

    public ConvolutionalBlattBlockView(OutputView input, ConvolutionalSection.BlattBlock block) {
        previousOutput = input;
        processingLayerView = new ConvolutionalLayerView(input, new ThreeDimensionsOutputView(block.output().x(), block.output().y(), block.output().z()));
        activationLayerView = ActivationLayerView.from(block.activation().name(), processingLayerView.getOutputView());
        thisOutput = processingLayerView.getOutputView();
    }

    @Override
    public OutputView output() {
        return thisOutput;
    }

    @Override
    public List<LayerView> layerViews() {
        return List.of();
    }
}
