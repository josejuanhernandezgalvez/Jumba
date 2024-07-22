package io.jumba.builder.model.laboratory;

public interface EarlyStopperView extends ParameterView {
    String packageRoute = "io.flogo.builder.model.laboratory.earlystoppers.";

    int patience();
    double threshold();
}
