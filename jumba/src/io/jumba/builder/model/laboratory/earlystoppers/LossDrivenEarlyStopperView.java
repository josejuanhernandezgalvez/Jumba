package io.jumba.builder.model.laboratory.earlystoppers;

import io.jumba.builder.model.laboratory.EarlyStopperView;
import io.jumba.model.EarlyStopper;
import io.jumba.model.LossDrivenEarlyStopper;

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

    @Override
    public int patience() {
        return patience;
    }

    @Override
    public double threshold() {
        return threshold;
    }
}
