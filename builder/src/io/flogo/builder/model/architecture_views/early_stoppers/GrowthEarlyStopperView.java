package io.flogo.builder.model.architecture_views.early_stoppers;

import io.flogo.blatt.model.EarlyStopper;
import io.flogo.builder.model.architecture_views.EarlyStopperView;

public class GrowthEarlyStopperView implements EarlyStopperView {
    private final int patience;
    private final double threshold;

    public GrowthEarlyStopperView(int patience, double threshold) {
        this.patience = patience;
        this.threshold = threshold;
    }

    public static GrowthEarlyStopperView from(EarlyStopper stopper) {
        return new GrowthEarlyStopperView(stopper.patience(),
                                          stopper.threshold());
    }
}
