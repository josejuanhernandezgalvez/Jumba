package io.flogo.builder.model.renderers.sections;

import io.flogo.model.RecurrentSection;
import io.flogo.model.Section;
import io.flogo.builder.model.renderers.SectionRenderer;
import io.flogo.builder.model.architecture.Output;
import io.flogo.builder.model.architecture.SectionView;
import io.flogo.builder.model.architecture.blocks.processing.RecurrentBlockView;
import io.flogo.builder.model.architecture.layers.output.OneDimensionOutput;
import io.flogo.builder.model.architecture.sections.processing.RecurrentSectionView;

import java.lang.reflect.Constructor;

public class RecurrentSectionRenderer implements SectionRenderer {
    private OneDimensionOutput previousOutput = null;

    @Override
    public SectionRenderer init(Output output) {
        if (output != null) previousOutput = (OneDimensionOutput) output;
        return this;
    }

    @Override
    public SectionView render(Section section) {
        try {
            return new RecurrentSectionView(blockViewFrom(section));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private RecurrentBlockView blockViewFrom(Section section) throws Exception {
        return getConstructor((RecurrentSection) section)
                .newInstance(inputSize(section),
                             outputSize(section),
                             stackedRecurrentSections(section),
                             outputElement(section),
                             bidirectional(section));
    }

    private boolean bidirectional(Section section) {
        return ((RecurrentSection) section).bidirectional();
    }

    private String outputElement(Section section) {
        return ((RecurrentSection) section).outputElement().type();
    }

    private int stackedRecurrentSections(Section section) {
        return ((RecurrentSection) section).stackedRecurrentSections();
    }

    private OneDimensionOutput outputSize(Section section) {
        return new OneDimensionOutput(((RecurrentSection) section).output().x());
    }

    private OneDimensionOutput inputSize(Section section) {
        return new OneDimensionOutput(((RecurrentSection) section).input().x());
    }

    private static Constructor<RecurrentBlockView> getConstructor(RecurrentSection section) {
        return (Constructor<RecurrentBlockView>) classFor(section).getConstructors()[0];
    }

    private static Class<RecurrentBlockView> classFor(RecurrentSection section) {
        try {
            return (Class<RecurrentBlockView>) Class.forName(RecurrentBlockView.packageRoute + type(section));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No existing recurrent block for type: " + type(section));
        }
    }

    private static String type(RecurrentSection section) {
        return section.type().type();
    }

    @Override
    public Output sectionOutput() {
        return previousOutput;
    }
}
