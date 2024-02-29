package io.flogo.builder.model.renderers;

import io.flogo.builder.model.Renderer;
import io.flogo.model.Section;
import io.flogo.builder.model.architecture.Output;
import io.flogo.builder.model.architecture.SectionView;

public interface SectionRenderer extends Renderer {
    String packageRoute = "io.flogo.builder.model.renderers.sections.";

    SectionRenderer init(Output output);
    SectionView render(Section section);
    Output sectionOutput();
}
