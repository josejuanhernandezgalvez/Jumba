package io.flogo.builder.model;

import io.flogo.blatt.model.Section;
import io.flogo.builder.model.structure_views.Output;
import io.flogo.builder.model.structure_views.SectionView;

public interface SectionRenderer extends Renderer {
    String packageRoute = "io.flogo.builder.model.section_renderers.";

    SectionRenderer init(Output output);
    SectionView render(Section section);
    Output sectionOutput();
}
