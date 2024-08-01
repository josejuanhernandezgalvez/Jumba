package io.jumba.builder.model.architecture.blocks;

import io.jumba.builder.model.architecture.BlockView;
import io.jumba.builder.model.architecture.LayerView;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.ActivationLayerView;
import io.jumba.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.jumba.builder.model.architecture.layers.processing.LinearLayerView;
import io.jumba.model.LinearSection;

import java.util.List;

public class LinearBlattBlockView implements BlockView {
    public final OutputView previousOutput;
    public final OutputView thisOutput;
    public final LinearLayerView processingLayerView;
    public final ActivationLayerView activationLayerView;

    public LinearBlattBlockView(OutputView input, LinearSection.BlattBlock block) {
        this.previousOutput = input;
        this.processingLayerView = new LinearLayerView(input, new OneDimensionOutputView(block.output().x()));
        this.activationLayerView = ActivationLayerView.from(block.activation().name(), processingLayerView.getOutputView());
        this.thisOutput = new OneDimensionOutputView(block.output().x());
    }


    @Override
    public OutputView output() {
        return thisOutput;
    }

    @Override
    public List<LayerView> layerViews() {
        return List.of(processingLayerView, activationLayerView);
    }
}
