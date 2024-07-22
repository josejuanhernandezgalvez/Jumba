package io.jumba.builder.model.laboratory;

public interface EarlyStopperView extends ParameterView {
    String packageRoute = "io.jumba.builder.model.laboratory.earlystoppers.";

    int patience();
    double threshold();
}
