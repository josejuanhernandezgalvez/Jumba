package io.flogo.builder.model;

import io.flogo.builder.model.architecture.ArchitectureView;
import io.flogo.builder.model.architecture.SectionView;
import io.flogo.builder.model.laboratory.SubstituteView;

import java.util.List;

public class ExperimentArchitecture extends ArchitectureView {

    public ExperimentArchitecture(ArchitectureView architectureView, List<SubstituteView> substitutes) {
        super(createSections(architectureView, substitutes));
    }

    private static List<SectionView> createSections(ArchitectureView architectureView, List<SubstituteView> substitutes) {

        return null;
    }

    public static class Builder {
        private ArchitectureView architectureView;
        private List<SubstituteView> substitutes;

        public Builder from(ArchitectureView architectureView) {
            this.architectureView = architectureView;
            return this;
        }

        public Builder substitutes(List<SubstituteView> substitutes) {
            this.substitutes = substitutes;
            return this;
        }

        public ArchitectureView collapse() {
            return new ExperimentArchitecture(this.architectureView, this.substitutes);
        }
    }
}
