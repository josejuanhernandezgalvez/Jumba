package io.flogo.builder.model;

import io.flogo.builder.model.architecture.ArchitectureView;
import io.flogo.builder.model.laboratory.LaboratoryView;

import java.util.List;

public record FlogoDTO(ArchitectureView architectureView, List<ArchitectureView> collapsedArchitectureViews,
                       LaboratoryView laboratoryView) {

}
