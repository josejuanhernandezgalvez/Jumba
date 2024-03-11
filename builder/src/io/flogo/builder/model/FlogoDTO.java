package io.flogo.builder.model;

import io.flogo.builder.model.architecture.ArchitectureView;
import io.flogo.builder.model.laboratory.LaboratoryView;

public record FlogoDTO(ArchitectureView architectureView, LaboratoryView laboratoryView,
                       ArchitectureView collapsedArchitectureView) {

}
