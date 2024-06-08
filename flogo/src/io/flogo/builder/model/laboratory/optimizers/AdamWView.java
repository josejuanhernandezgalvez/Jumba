package io.flogo.builder.model.laboratory.optimizers;

import io.flogo.builder.model.laboratory.OptimizerView;
import io.flogo.model.AdamW;
import io.flogo.model.Optimizer;

public class AdamWView implements OptimizerView {
    public final double learningRate;
    public final double beta0;
    public final double beta1;
    public final double eps;
    public final double weightDecay;
    public final boolean amsgrad;

    public AdamWView(double learningRate, double beta0, double beta1, double eps, double weightDecay, boolean amsgrad) {
        this.learningRate = learningRate;
        this.beta0 = beta0;
        this.beta1 = beta1;
        this.eps = eps;
        this.weightDecay = weightDecay;
        this.amsgrad = amsgrad;
    }

    public static OptimizerView from(Optimizer optimizer) {
        return new AdamWView(
                ((AdamW) optimizer).lr(),
                ((AdamW) optimizer).betas() == null ? 0.9 : ((AdamW) optimizer).betas().beta0(),
                ((AdamW) optimizer).betas() == null ? 0.999 : ((AdamW) optimizer).betas().beta1(),
                ((AdamW) optimizer).weightDecay(),
                ((AdamW) optimizer).weightDecay(),
                ((AdamW) optimizer).amsgrad());
    }
}
