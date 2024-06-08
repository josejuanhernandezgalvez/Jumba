package io.flogo.builder.model.laboratory;

import java.util.List;

public class ExperimentView {
    public final String name;
    public final LossFunctionView lossFunctionView;
    public final OptimizerView optimizerView;
    public final List<MaterializationView> substitutes;

    public ExperimentView(String name, LossFunctionView lossFunctionView, OptimizerView optimizerView, List<MaterializationView> substitutes) {
        this.name = name;
        this.lossFunctionView = lossFunctionView;
        this.optimizerView = optimizerView;
        this.substitutes = substitutes;
    }
}
