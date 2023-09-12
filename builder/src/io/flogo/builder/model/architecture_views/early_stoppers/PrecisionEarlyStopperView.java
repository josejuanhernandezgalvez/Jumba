package io.flogo.builder.model.architecture_views.early_stoppers;

import io.flogo.blatt.model.EarlyStopper;
import io.flogo.blatt.model.PrecisionEarlyStopper;
import io.flogo.builder.model.architecture_views.EarlyStopperView;

public class PrecisionEarlyStopperView implements EarlyStopperView {
    private final int patience;
    private final double threshold;

    public PrecisionEarlyStopperView(int patience, double threshold) {
        this.patience = patience;
        this.threshold = threshold;
    }

    public static PrecisionEarlyStopperView from(EarlyStopper stopper) {
        return new PrecisionEarlyStopperView(((PrecisionEarlyStopper) stopper).patience(),
                                             ((PrecisionEarlyStopper) stopper).threshold());
    }
}
