package io.flogo.builder.model.laboratory;

import java.util.List;

public record LaboratoryView(String name, int eras, int epochs, LossFunctionView lossFunctionView, OptimizerView optimizerView,
                             CheckPointSaverView checkPointSaverView, EarlyStopperView earlyStopperView,
                             DatasetView datasetView, List<ExperimentView> experimentViews,
                             StrategyView strategyView, DeviceView deviceView) {

    public enum DeviceView {
        CPU, GPU, MPS, Default
    }
}
