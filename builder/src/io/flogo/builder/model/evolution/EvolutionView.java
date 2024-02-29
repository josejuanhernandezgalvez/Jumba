package io.flogo.builder.model.evolution;

public record EvolutionView(LossFunctionView lossFunctionView, OptimizerView optimizerView, CycleView cycleView,
                            CheckPointSaverView checkPointSaverView, EarlyStopperView earlyStopperView, DatasetView datasetView) {
}
