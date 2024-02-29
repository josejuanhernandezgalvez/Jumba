package io.flogo.builder.model.architecture;

import java.util.List;

public class ArchitectureView {
    private final List<SectionView> sections;

    public ArchitectureView(List<SectionView> sections) {
        this.sections = sections;
    }

    public List<SectionView> sections() {
        return sections;
    }
}
