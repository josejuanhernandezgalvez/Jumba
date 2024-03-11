package io.flogo.builder.model.renderers.architecture.sectionrenderers;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.layers.link.SoftmaxLayerView;
import io.flogo.builder.model.architecture.layers.output.UndeterminedOutputView;
import io.flogo.builder.model.architecture.sections.link.ClassificationSectionView;
import io.flogo.builder.model.renderers.architecture.SectionRenderer;
import io.flogo.model.Section;

import java.util.List;

public class SoftmaxSectionRenderer extends SectionRenderer<ClassificationSectionView> {

    @Override
    public ClassificationSectionView render(Section section, OutputView previousLayerOutput) {
        return new ClassificationSectionView(
                new BlockView(List.of(
                        isDetermined(previousLayerOutput) ?
                                new SoftmaxLayerView(previousLayerOutput) :
                                new SoftmaxLayerView(new UndeterminedOutputView()))));
    }

    private static boolean isDetermined(OutputView previousLayerOutput) {
        return !previousLayerOutput.getClass().equals(UndeterminedOutputView.class);
    }
}
