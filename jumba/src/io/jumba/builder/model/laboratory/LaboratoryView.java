package io.jumba.builder.model.laboratory;

public record LaboratoryView(String name, int eras, int epochs, LossFunctionView lossFunctionView, OptimizerView optimizerView,
                             CheckPointSaverView checkPointSaverView, EarlyStopperView earlyStopperView,
                             DatasetView datasetView,
                             StrategyView strategyView, DeviceView deviceView) {

    public enum DeviceView {
        CPU {
            @Override
            public int value() {
                return 0;
            }
        }, GPU {
            @Override
            public int value() {
                return 1;
            }
        }, MPS {
            @Override
            public int value() {
                return 2;
            }
        }, Default {
            @Override
            public int value() {
                return -1;
            }
        };

        public abstract int value();
    }
}
