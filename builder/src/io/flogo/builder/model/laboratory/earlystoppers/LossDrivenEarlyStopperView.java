package io.flogo.builder.model.laboratory.earlystoppers;

import io.flogo.builder.model.laboratory.EarlyStopperView;
import io.flogo.model.EarlyStopper;
import io.flogo.model.LossDrivenEarlyStopper;

public class LossDrivenEarlyStopperView implements EarlyStopperView {
    public final int patience;
    public final double threshold;

    public LossDrivenEarlyStopperView(int patience, double threshold) {
        this.patience = patience;
        this.threshold = threshold;
    }

    public static LossDrivenEarlyStopperView from(EarlyStopper stopper) {
        LossDrivenEarlyStopper lossDrivenEarlyStopper = (LossDrivenEarlyStopper) stopper;
        return new LossDrivenEarlyStopperView(lossDrivenEarlyStopper.patience(),
                lossDrivenEarlyStopper.threshold());
    }
}
