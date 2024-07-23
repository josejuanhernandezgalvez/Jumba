package io.jumba.builder.model;

import io.jumba.builder.model.architecture.ArchitectureView;
import io.jumba.builder.model.laboratory.LaboratoryView;

public record JumbaDTO(ArchitectureView architectureView, LaboratoryView laboratoryView) {

}
