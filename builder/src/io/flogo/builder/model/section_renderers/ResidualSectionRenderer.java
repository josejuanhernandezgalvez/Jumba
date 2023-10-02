package io.flogo.builder.model.section_renderers;

import io.flogo.blatt.model.ResidualSection;
import io.flogo.blatt.model.Section;
import io.flogo.builder.model.SectionRenderer;
import io.flogo.builder.model.section_renderers.stage.FirstStageRenderer;
import io.flogo.builder.model.structure_views.Output;
import io.flogo.builder.model.structure_views.SectionView;
import io.flogo.builder.model.structure_views.blocks.processing.ConvolutionalBlockView;
import io.flogo.builder.model.structure_views.blocks.processing.residual.ResidualBlockView;
import io.flogo.builder.model.structure_views.layers.output.ThreeDimensionsOutput;
import io.flogo.builder.model.structure_views.layers.processing.AvgPoolLayerView;
import io.flogo.builder.model.structure_views.layers.processing.kernels.PoolTwoDimensionsKernel;
import io.flogo.builder.model.structure_views.layers.processing.kernels.paddings.TwoDimensionsPadding;
import io.flogo.builder.model.structure_views.layers.processing.kernels.size.TwoDimensionsSize;
import io.flogo.builder.model.structure_views.layers.processing.kernels.strides.TwoDimensionsStride;
import io.flogo.builder.model.structure_views.sections.processing.ResidualSectionView;

import java.util.List;
import java.util.stream.Collectors;

import static io.flogo.blatt.model.ResidualSection.*;

public class ResidualSectionRenderer implements SectionRenderer {
    ThreeDimensionsOutput previousOutput;
    private final int multiplicationFactor = 2;

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
        AvgPoolLayerView pool = new AvgPoolLayerView(
                new PoolTwoDimensionsKernel(
                        new TwoDimensionsSize(7, 7),
                        new TwoDimensionsStride(1, 1),
                        new TwoDimensionsPadding(0, 0)),
                previousOutput);
        previousOutput = (ThreeDimensionsOutput) pool.getLayerOutput();
        return new ConvolutionalBlockView(List.of(pool));
    }

    private ResidualBlockView lastBlock() {
        return null;
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

    private static class LastStageRenderer {
        public static ConvolutionalBlockView render(LastStage firstStage) {
            return null;
        }

        private static class DefaultLastStageView {

        }
    }
}
