package io.flogo.builder.model.renderers.sections;

import io.flogo.model.ResidualSection;
import io.flogo.model.Section;
import io.flogo.builder.model.renderers.SectionRenderer;
import io.flogo.builder.model.renderers.sections.stages.FirstStageRenderer;
import io.flogo.builder.model.renderers.sections.stages.LastStageRenderer;
import io.flogo.builder.model.architecture.Output;
import io.flogo.builder.model.architecture.SectionView;
import io.flogo.builder.model.architecture.blocks.processing.ConvolutionalBlockView;
import io.flogo.builder.model.architecture.blocks.processing.residual.ResidualBlockView;
import io.flogo.builder.model.architecture.layers.output.ThreeDimensionsOutput;
import io.flogo.builder.model.architecture.sections.processing.ResidualSectionView;

import java.util.List;
import java.util.stream.Collectors;

import static io.flogo.model.ResidualSection.*;

public class ResidualSectionRenderer implements SectionRenderer {
    ThreeDimensionsOutput previousOutput;
    private static final int multiplicationFactor = 2;

    @Override
    public SectionRenderer init(Output output) {
        if (output != null) previousOutput = (ThreeDimensionsOutput) output;
        return this;
    }

    @Override
    public SectionView render(Section section) {
        return new ResidualSectionView(
                firstStageView(((ResidualSection) section).firstStage()),
                createBlocks(((ResidualSection) section).residualLayerList()),
                lastStageView(((ResidualSection) section).lastStage()));
    }

    private ConvolutionalBlockView firstStageView(FirstStage firstStage) {
        ConvolutionalBlockView result = FirstStageRenderer.render(firstStage, previousOutput);
        previousOutput = FirstStageRenderer.output;
        return result;
    }

    private List<ResidualBlockView> createBlocks(List<ResidualLayer> blocks) {
        return blocks.stream()
                .map(this::processEach)
                .collect(Collectors.toList());
    }

    private ConvolutionalBlockView lastStageView(LastStage lastStage) {
        ConvolutionalBlockView result = LastStageRenderer.render(lastStage, previousOutput);
        previousOutput = LastStageRenderer.output;
        return result;
    }

    private ResidualBlockView processEach(ResidualLayer residualLayer) {
        ResidualBlockView residualBlockView = createBlock(residualLayer);
        updateOutput();
        return residualBlockView.add(previousOutput);
    }

    private ResidualBlockView createBlock(ResidualLayer residualLayer) {
        return new ResidualBlockView(previousOutput, residualLayer.expansion(), residualLayer.repeat());
    }

    private void updateOutput() {
        previousOutput = new ThreeDimensionsOutput(previousOutput.x() / multiplicationFactor,
                                                   previousOutput.y() / multiplicationFactor,
                                                   previousOutput.z() * multiplicationFactor);
    }

    @Override
    public Output sectionOutput() {
        return previousOutput;
    }
}
