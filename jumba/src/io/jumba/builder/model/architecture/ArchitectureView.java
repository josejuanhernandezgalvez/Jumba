package io.jumba.builder.model.architecture;

import java.util.List;

public class ArchitectureView {
    private final List<SectionView> sections;
    public final String name;

    public ArchitectureView(List<SectionView> sections, String name) {
        this.sections = sections;
        this.name = name;
    }

    public List<SectionView> sections() {
        return sections;
    }
}
