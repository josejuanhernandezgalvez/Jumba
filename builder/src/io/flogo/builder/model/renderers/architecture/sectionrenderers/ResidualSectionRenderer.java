package io.flogo.builder.model.renderers.architecture.sectionrenderers;

import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.sections.processing.ResidualSectionView;
import io.flogo.builder.model.renderers.architecture.SectionRenderer;
import io.flogo.model.ResidualSection;
import io.flogo.model.Section;

public class ResidualSectionRenderer extends SectionRenderer<ResidualSectionView> {
    private static final int factor = 2;

    @Override
    public ResidualSectionView render(Section section, OutputView input) {
        ResidualSection cast = cast(section);
        return null;
    }

    private ResidualSection cast(Section section) {
        return (ResidualSection) section;
    }
}
