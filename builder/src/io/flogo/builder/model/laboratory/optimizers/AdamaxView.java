package io.flogo.builder.model.laboratory.optimizers;

import io.flogo.builder.model.laboratory.OptimizerView;
import io.flogo.model.Adamax;
import io.flogo.model.Optimizer;

public class AdamaxView implements OptimizerView {
    public final double learningRate;
    public final double beta0;
    public final double beta1;
    public final double eps;
    public final double weightDecay;

    public AdamaxView(double learningRate, double beta0, double beta1, double eps, double weightDecay) {
        this.learningRate = learningRate;
        this.beta0 = beta0;
        this.beta1 = beta1;
        this.eps = eps;
        this.weightDecay = weightDecay;
    }

    public static OptimizerView from(Optimizer optimizer) {
        return new AdamaxView(
                ((Adamax) optimizer).lr(),
                ((Adamax) optimizer).betas() == null ? 0.9 : ((Adamax) optimizer).betas().beta0(),
                ((Adamax) optimizer).betas() == null ? 0.999 : ((Adamax) optimizer).betas().beta1(),
                ((Adamax) optimizer).eps(),
                ((Adamax) optimizer).weightDecay()
        );
    }
}
