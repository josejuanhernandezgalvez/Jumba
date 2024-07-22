package io.jumba.builder.model.laboratory.optimizers;

import io.jumba.builder.model.laboratory.OptimizerView;
import io.jumba.model.AMSGrad;
import io.jumba.model.Optimizer;

public class AMSGradView implements OptimizerView {
    public final double learningRate;
    public final double beta0;
    public final double beta1;
    public final double weightDecay;
    public final double eps;

    public AMSGradView(double learningRate, double beta0, double beta1, double weightDecay, double eps) {
        this.learningRate = learningRate;
        this.beta0 = beta0;
        this.beta1 = beta1;
        this.weightDecay = weightDecay;
        this.eps = eps;
    }

    public static OptimizerView from(Optimizer optimizer) {
        return new AMSGradView(((AMSGrad) optimizer).lr(),
                ((AMSGrad) optimizer).beta0(),
                ((AMSGrad) optimizer).beta1(),
                ((AMSGrad) optimizer).weightDecay(),
                ((AMSGrad) optimizer).eps());
    }
}
