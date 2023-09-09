package io.flogo.builder.model.renderers;

import io.flogo.blatt.model.Section;
import io.flogo.builder.model.SectionRenderer;
import io.flogo.builder.model.views.Output;
import io.flogo.builder.model.views.SectionView;
import io.flogo.builder.model.views.blocks.link.FlattenBlockView;
import io.flogo.builder.model.views.layers.link.FlattenLayerView;
import io.flogo.builder.model.views.layers.output.OneDimensionOutput;
import io.flogo.builder.model.views.sections.link.FlattenSectionView;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.function.Function;

public class FlattenSectionRenderer implements SectionRenderer {
    private Output previousOutput = null;

    @Override
    public SectionRenderer init(Output output) {
        if (output != null) previousOutput = output;
        return this;
    }

    @Override
    public SectionView render(Section section) {
        FlattenSectionView sectionView = getSectionView();
        assignNewOutput();
        return sectionView;
    }

    @Override
    public Output sectionOutput() {
        return previousOutput;
    }

    private void assignNewOutput() {
        previousOutput = toOneDimension(previousOutput);
    }

    private FlattenSectionView getSectionView() {
        return new FlattenSectionView(new FlattenBlockView(new FlattenLayerView(previousOutput, toOneDimension(previousOutput))));
    }


    private OneDimensionOutput toOneDimension(Output previousLayerOutput) {
        return new OneDimensionOutput(
                Arrays.stream(previousLayerOutput.getClass().getDeclaredFields())
                        .map(getValue(previousLayerOutput))
                        .reduce(1, (a, b) -> a*b));
    }

    private static Function<Field, Integer> getValue(Output previousLayerOutput) {
        return field -> {
            try {
                field.setAccessible(true);
                return (int) field.get(previousLayerOutput);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
