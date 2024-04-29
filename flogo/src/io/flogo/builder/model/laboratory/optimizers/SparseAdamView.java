package io.flogo.builder.model.laboratory.optimizers;

import io.flogo.builder.model.laboratory.OptimizerView;
import io.flogo.model.Optimizer;
import io.flogo.model.SparseAdam;

public class SparseAdamView implements OptimizerView {
    public final double learningRate;
    public final double beta0;
    public final double beta1;
    public final double eps;

    public SparseAdamView(double learningRate, double beta0, double beta1, double eps) {
        this.learningRate = learningRate;
        this.beta0 = beta0;
        this.beta1 = beta1;
        this.eps = eps;
    }

    public static OptimizerView from(Optimizer optimizer) {
        return new SparseAdamView(
                ((SparseAdam) optimizer).lr(),
                ((SparseAdam) optimizer).betas() == null ? 0.9 : ((SparseAdam) optimizer).betas().beta0(),
                ((SparseAdam) optimizer).betas() == null ? 0.999 : ((SparseAdam) optimizer).betas().beta1(),
                ((SparseAdam) optimizer).eps()
        );
    }
}
