package io.flogo.builder.model.section_renderers.stage;

import io.flogo.blatt.model.ResidualSection;
import io.flogo.builder.model.structure_views.LayerView;
import io.flogo.builder.model.structure_views.blocks.processing.ConvolutionalBlockView;
import io.flogo.builder.model.structure_views.blocks.processing.residual.ResidualDefaultFirstStage;
import io.flogo.builder.model.structure_views.layers.output.ThreeDimensionsOutput;
import io.flogo.builder.model.structure_views.layers.processing.ConvolutionalLayerView;

import java.util.ArrayList;
import java.util.List;

public class FirstStageRenderer {
    private final static ThreeDimensionsOutput desiredInput = new ThreeDimensionsOutput(224, 224, 3);
    private final static ThreeDimensionsOutput desiredOutput = new ThreeDimensionsOutput(56, 56, 64);
    public static ThreeDimensionsOutput output = desiredOutput;


    public static ConvolutionalBlockView render(ResidualSection.FirstStage firstStage, ThreeDimensionsOutput previousOutput) {
        if (isDefault(firstStage)) return defaultStage(previousOutput);
        return createStage((ResidualSection.CustomFirstStage) firstStage);
    }

    private static ConvolutionalBlockView createStage(ResidualSection.CustomFirstStage firstStage) {
        return null;
    }

    private static ConvolutionalBlockView defaultStage(ThreeDimensionsOutput input) {
        return isDefaultInput(input) ? ResidualDefaultFirstStage.asBlock() : adaptedFirstStage(input);
    }

    private static boolean isDefaultInput(ThreeDimensionsOutput previousOutput) {
        return previousOutput.equals(desiredInput);
    }

    private static ConvolutionalBlockView adaptedFirstStage(ThreeDimensionsOutput input) {
        List<LayerView> result = new ArrayList<>(List.of(new ConvolutionalLayerView(input, desiredInput)));
        result.addAll(ResidualDefaultFirstStage.asList());
        return new ConvolutionalBlockView(result);
    }

    private static boolean isDefault(ResidualSection.FirstStage firstStage) {
        return firstStage.core$().conceptList().get(0).toString().split("\\$")[1].startsWith("Default");
    }
}
