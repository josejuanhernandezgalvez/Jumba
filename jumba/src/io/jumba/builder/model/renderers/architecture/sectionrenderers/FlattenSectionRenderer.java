package io.jumba.builder.model.renderers.architecture.sectionrenderers;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.SectionView;
import io.jumba.builder.model.architecture.blocks.SimpleBlockView;
import io.jumba.builder.model.architecture.layers.link.FlattenLayerView;
import io.jumba.builder.model.architecture.sections.link.FlattenSectionView;
import io.jumba.builder.model.renderers.architecture.SectionRenderer;
import io.jumba.model.Section;

import java.util.List;

import static io.jumba.builder.model.architecture.layers.link.FlattenLayerView.toOneDimension;

public class FlattenSectionRenderer extends SectionRenderer<FlattenSectionView> {

    @Override
    public FlattenSectionView render(Section section, OutputView previousLayerOutput, CompilationContext context) {
        return new FlattenSectionView(
                List.of(new SimpleBlockView(List.of(
                                new FlattenLayerView(previousLayerOutput, toOneDimension(previousLayerOutput), SectionView.getMutable(section))))),
                previousLayerOutput);
    }
}
