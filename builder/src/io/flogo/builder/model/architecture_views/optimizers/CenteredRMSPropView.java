package io.flogo.builder.model.architecture_views.optimizers;

import io.flogo.blatt.model.CenteredRMSProp;
import io.flogo.blatt.model.Optimizer;
import io.flogo.builder.model.architecture_views.OptimizerView;

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
