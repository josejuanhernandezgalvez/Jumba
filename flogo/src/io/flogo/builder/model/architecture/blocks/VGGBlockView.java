package io.flogo.builder.model.architecture.blocks;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.output.ThreeDimensionsOutputView;

import java.util.List;

public class VGGBlockView implements BlockView {
    private final ThreeDimensionsOutputView previousOutput;
    private final ThreeDimensionsOutputView output;

    public VGGBlockView(OutputView previousOutput) {
        this.previousOutput = (ThreeDimensionsOutputView) previousOutput;
        this.output = new ThreeDimensionsOutputView(this.previousOutput.x() / 2, this.previousOutput.y() / 2, this.previousOutput.z() * 2);
    }

    @Override
    public OutputView output() {
        return this.output;
    }

    @Override
    public List<LayerView> layerViews() {
        return List.of();
    }
}
