package io.flogo.builder.model.evolution.optimizers;

import io.flogo.model.Optimizer;
import io.flogo.model.RMSProp;
import io.flogo.builder.model.evolution.OptimizerView;

public class RMSPropView implements OptimizerView {
    public final double learningRate;
    public final double momentum;
    public final double alpha;
    public final double eps;
    public final double weightDecay;

    public RMSPropView(double learningRate, double momentum, double alpha, double eps, double weightDecay) {
        this.learningRate = learningRate;
        this.momentum = momentum;
        this.alpha = alpha;
        this.eps = eps;
        this.weightDecay = weightDecay;
    }

    public static OptimizerView from(Optimizer optimizer) {
        return new RMSPropView(((RMSProp) optimizer).lr(),
                               ((RMSProp) optimizer).momentum(),
                               ((RMSProp) optimizer).alpha(),
                               ((RMSProp) optimizer).eps(),
                               ((RMSProp) optimizer).weightDecay());
    }
}
