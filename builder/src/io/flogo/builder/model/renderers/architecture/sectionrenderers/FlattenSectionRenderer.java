package io.flogo.builder.model.renderers.architecture.sectionrenderers;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.link.FlattenLayerView;
import io.flogo.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.flogo.builder.model.architecture.sections.link.FlattenSectionView;
import io.flogo.builder.model.renderers.architecture.SectionRenderer;
import io.flogo.model.Section;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class FlattenSectionRenderer extends SectionRenderer<FlattenSectionView> {

    @Override
    public FlattenSectionView render(Section section, OutputView input) {
        return new FlattenSectionView(
                new BlockView(List.of(new FlattenLayerView(input, toOneDimension(input)))));
    }

    private OneDimensionOutputView toOneDimension(OutputView previousLayerOutput) {
        return new OneDimensionOutputView(
                Arrays.stream(previousLayerOutput.getClass().getDeclaredFields())
                        .map(field -> getValue(field, previousLayerOutput))
                        .reduce(1, (a, b) -> a * b));
    }

    private static int getValue(Field field, OutputView previousLayerOutput) {
        try {
            field.setAccessible(true);
            return (int) field.get(previousLayerOutput);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
