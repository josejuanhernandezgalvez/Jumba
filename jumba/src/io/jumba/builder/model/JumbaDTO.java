package io.jumba.builder.model;

import io.jumba.builder.model.architecture.ArchitectureView;
import io.jumba.builder.model.laboratory.LaboratoryView;

import java.util.List;

public record JumbaDTO(ArchitectureView architectureView, List<ArchitectureView> collapsedArchitectureViews,
                       LaboratoryView laboratoryView) {

}
