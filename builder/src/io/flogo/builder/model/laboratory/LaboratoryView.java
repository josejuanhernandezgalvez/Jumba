package io.flogo.builder.model.laboratory;

import java.util.List;

public record LaboratoryView(LossFunctionView lossFunctionView, OptimizerView optimizerView,
                             CheckPointSaverView checkPointSaverView, EarlyStopperView earlyStopperView,
                             DatasetView datasetView, List<ExperimentView> experimentViews,
                             StrategyView strategyView) {
}
