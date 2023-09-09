package io.flogo.builder.model;

import io.flogo.blatt.model.Section;
import io.flogo.builder.model.views.Output;
import io.flogo.builder.model.views.SectionView;

public interface SectionRenderer extends Renderer {
    SectionRenderer init(Output output);
    SectionView render(Section section);
    Output sectionOutput();
}
