package io.flogo.builder.model.renderers.sections;

import io.flogo.model.Section;
import io.flogo.builder.model.renderers.SectionRenderer;
import io.flogo.builder.model.architecture.Output;
import io.flogo.builder.model.architecture.SectionView;
import io.flogo.builder.model.architecture.blocks.link.ClassificationBlockView;
import io.flogo.builder.model.architecture.layers.link.SoftmaxLayerView;
import io.flogo.builder.model.architecture.sections.link.ClassificationSectionView;

public class SoftmaxSectionRenderer implements SectionRenderer {
    private Output previousOutput = null;

    @Override
    public SectionRenderer init(Output output) {
        if (output != null) this.previousOutput = output;
        return this;
    }

    @Override
    public SectionView render(Section section) {
        return new ClassificationSectionView(
                    new ClassificationBlockView(
                        new SoftmaxLayerView(previousOutput)));
    }

    @Override
    public Output sectionOutput() {
        return previousOutput;
    }
}
