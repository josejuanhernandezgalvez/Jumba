package io.flogo.builder.model.renderers.architecture.sectionrenderers;

import io.flogo.builder.CompilationContext;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.blocks.SimpleBlockView;
import io.flogo.builder.model.architecture.layers.link.FlattenLayerView;
import io.flogo.builder.model.architecture.layers.output.UndeterminedOutputView;
import io.flogo.builder.model.architecture.sections.link.FlattenSectionView;
import io.flogo.builder.model.renderers.architecture.SectionRenderer;
import io.flogo.model.Section;

import java.util.List;

import static io.flogo.builder.model.architecture.layers.link.FlattenLayerView.toOneDimension;

public class FlattenSectionRenderer extends SectionRenderer<FlattenSectionView> {

    @Override
    public FlattenSectionView render(Section section, OutputView previousLayerOutput, CompilationContext context) {
        return new FlattenSectionView(
                List.of(new SimpleBlockView(List.of(
                        isDetermined(previousLayerOutput) ?
                                new FlattenLayerView(previousLayerOutput, toOneDimension(previousLayerOutput)) :
                                new FlattenLayerView(previousLayerOutput, new UndeterminedOutputView())))), previousLayerOutput);
    }

    private static boolean isDetermined(OutputView previousLayerOutput) {
        return !previousLayerOutput.getClass().equals(UndeterminedOutputView.class);
    }

}
