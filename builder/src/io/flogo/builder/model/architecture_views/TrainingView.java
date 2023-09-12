package io.flogo.builder.model.architecture_views;

public record TrainingView(LossFunctionView lossFunctionView, OptimizerView optimizerView, EarlyStopperView earlyStopperView) {
}
