package io.flogo.builder.model.section_renderers.stage;

import io.flogo.blatt.model.ResidualSection;
import io.flogo.builder.model.structure_views.LayerView;
import io.flogo.builder.model.structure_views.blocks.processing.ConvolutionalBlockView;
import io.flogo.builder.model.structure_views.blocks.processing.residual.ResidualDefaultLastStage;
import io.flogo.builder.model.structure_views.layers.output.ThreeDimensionsOutput;
import io.flogo.builder.model.structure_views.layers.processing.ConvolutionalLayerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LastStageRenderer extends StageRenderer{
    private final static ThreeDimensionsOutput desiredInput1 = new ThreeDimensionsOutput(7, 7, 512);
    private final static ThreeDimensionsOutput desiredInput2 = new ThreeDimensionsOutput(7, 7, 2048);
    private final static ThreeDimensionsOutput desiredOutput = new ThreeDimensionsOutput(1, 1, 512);
    public static ThreeDimensionsOutput output = desiredOutput;


    public static ConvolutionalBlockView render(ResidualSection.LastStage lastStage, ThreeDimensionsOutput previousOutput) {
        if (isDefault(lastStage)) return defaultStage(previousOutput);
        return createStage((ResidualSection.CustomLastStage) lastStage, previousOutput);
    }

    private static ConvolutionalBlockView createStage(ResidualSection.CustomLastStage lastStage, ThreeDimensionsOutput previousOutput) {
        return new ConvolutionalBlockView(createViews(lastStage, previousOutput));
    }

    private static List<LayerView> createViews(ResidualSection.CustomLastStage lastStage, ThreeDimensionsOutput previousOutput) {
        init(previousOutput);
        return lastStage.layerList().stream().map(StageRenderer::processEach).collect(Collectors.toList());
    }

    private static ConvolutionalBlockView defaultStage(ThreeDimensionsOutput input) {
        return isDefaultInput(input) ? ResidualDefaultLastStage.asBlock(input) : adaptedLastStage(input);
    }

    private static boolean isDefaultInput(ThreeDimensionsOutput previousOutput) {
        return previousOutput.equals(desiredInput1) || previousOutput.equals(desiredInput2);
    }

    private static ConvolutionalBlockView adaptedLastStage(ThreeDimensionsOutput input) {
        List<LayerView> result = new ArrayList<>(List.of(new ConvolutionalLayerView(input, desiredInput1)));
        result.addAll(ResidualDefaultLastStage.asList(desiredInput1));
        return new ConvolutionalBlockView(result);
    }

    private static boolean isDefault(ResidualSection.LastStage firstStage) {
        return firstStage.core$().conceptList().get(0).toString().split("\\$")[1].startsWith("Default");
    }
}
