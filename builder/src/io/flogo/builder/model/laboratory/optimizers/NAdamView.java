package io.flogo.builder.model.laboratory.optimizers;

import io.flogo.builder.model.laboratory.OptimizerView;
import io.flogo.model.NAdam;
import io.flogo.model.Optimizer;

public class NAdamView implements OptimizerView {
    public final double learningRate;
    public final double beta0;
    public final double beta1;
    public final double eps;
    public final double weightDecay;
    public final double momentumDecay;
    public final boolean decoupledWeightDecay;

    public NAdamView(double learningRate, double beta0, double beta1, double eps, double weightDecay, double momentumDecay, boolean decoupledWeightDecay) {
        this.learningRate = learningRate;
        this.beta0 = beta0;
        this.beta1 = beta1;
        this.eps = eps;
        this.weightDecay = weightDecay;
        this.momentumDecay = momentumDecay;
        this.decoupledWeightDecay = decoupledWeightDecay;
    }

    public static OptimizerView from(Optimizer optimizer) {
        return new NAdamView(
                ((NAdam) optimizer).lr(),
                ((NAdam) optimizer).betas() == null ? 0.9 : ((NAdam) optimizer).betas().beta0(),
                ((NAdam) optimizer).betas() == null ? 0.999 : ((NAdam) optimizer).betas().beta1(),
                ((NAdam) optimizer).eps(),
                ((NAdam) optimizer).weightDecay(),
                ((NAdam) optimizer).momentumDecay(),
                ((NAdam) optimizer).decoupledWeightDecay()
        );
    }
}
