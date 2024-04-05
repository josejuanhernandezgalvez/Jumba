package io.flogo.builder.model.laboratory.optimizers;

import io.flogo.builder.model.laboratory.OptimizerView;
import io.flogo.model.RAdam;
import io.flogo.model.Optimizer;

public class RAdamView implements OptimizerView {
    public final double learningRate;
    public final double beta0;
    public final double beta1;
    public final double eps;
    public final double weightDecay;
    public final boolean decoupledWeightDecay;

    public RAdamView(double learningRate, double beta0, double beta1, double eps, double weightDecay, boolean decoupledWeightDecay) {
        this.learningRate = learningRate;
        this.beta0 = beta0;
        this.beta1 = beta1;
        this.eps = eps;
        this.weightDecay = weightDecay;
        this.decoupledWeightDecay = decoupledWeightDecay;
    }

    public static OptimizerView from(Optimizer optimizer) {
        return new RAdamView(
                ((RAdam) optimizer).lr(),
                ((RAdam) optimizer).betas() == null ? 0.9 : ((RAdam) optimizer).betas().beta0(),
                ((RAdam) optimizer).betas() == null ? 0.999 : ((RAdam) optimizer).betas().beta1(),
                ((RAdam) optimizer).eps(),
                ((RAdam) optimizer).weightDecay(),
                ((RAdam) optimizer).decoupledWeightDecay()
        );
    }
}
