package io.flogo.builder.model.laboratory.optimizers;

import io.flogo.model.CenteredRMSProp;
import io.flogo.model.Optimizer;
import io.flogo.builder.model.laboratory.OptimizerView;

public class CenteredRMSPropView {
    public final double learningRate;
    public final double momentum;
    public final double alpha;
    public final double eps;
    public final double weightDecay;

    public CenteredRMSPropView(double learningRate, double momentum, double alpha, double eps, double weightDecay) {
        this.learningRate = learningRate;
        this.momentum = momentum;
        this.alpha = alpha;
        this.eps = eps;
        this.weightDecay = weightDecay;
    }

    public static OptimizerView from(Optimizer optimizer) {
        return new RMSPropView(((CenteredRMSProp) optimizer).lr(),
                               ((CenteredRMSProp) optimizer).momentum(),
                               ((CenteredRMSProp) optimizer).alpha(),
                               ((CenteredRMSProp) optimizer).eps(),
                               ((CenteredRMSProp) optimizer).weightDecay());

    }
}
