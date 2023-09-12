package io.flogo.builder.model.section_renderers;

import io.flogo.blatt.model.Section;
import io.flogo.builder.model.SectionRenderer;
import io.flogo.builder.model.structure_views.Output;
import io.flogo.builder.model.structure_views.SectionView;
import io.flogo.builder.model.structure_views.blocks.link.ClassificationBlockView;
import io.flogo.builder.model.structure_views.layers.link.SoftmaxLayerView;
import io.flogo.builder.model.structure_views.sections.link.ClassificationSectionView;

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
