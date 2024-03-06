package io.flogo.builder.model.renderers.architecture.sectionrenderers;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.link.SoftmaxLayerView;
import io.flogo.builder.model.architecture.sections.link.ClassificationSectionView;
import io.flogo.builder.model.renderers.architecture.SectionRenderer;
import io.flogo.model.Section;

import java.util.List;

public class SoftmaxSectionRenderer extends SectionRenderer<ClassificationSectionView> {

    @Override
    public ClassificationSectionView render(Section section, OutputView input) {
        return new ClassificationSectionView(
                new BlockView(List.of(
                        new SoftmaxLayerView(input))));
    }
}
