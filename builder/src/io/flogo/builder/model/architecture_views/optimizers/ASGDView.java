package io.flogo.builder.model.architecture_views.optimizers;

import io.flogo.blatt.model.ASGD;
import io.flogo.blatt.model.Optimizer;
import io.flogo.builder.model.architecture_views.OptimizerView;

public class ASGDView implements OptimizerView {
    public final double learningRate;
    public final double learningRateDecay;
    public final double alpha;
    public final double pointToStartAverage;
    public final double weightDecay;

    public ASGDView(double learningRate, double learningRateDecay, double alpha, double pointToStartAverage, double weightDecay) {
        this.learningRate = learningRate;
        this.learningRateDecay = learningRateDecay;
        this.alpha = alpha;
        this.pointToStartAverage = pointToStartAverage;
        this.weightDecay = weightDecay;
    }


    public static OptimizerView from(Optimizer optimizer) {
        return new ASGDView(((ASGD) optimizer).lr(),
                            ((ASGD) optimizer).lrDecay(),
                            ((ASGD) optimizer).alpha(),
                            ((ASGD) optimizer).pointToStartAverage(),
                            ((ASGD) optimizer).weightDecay());
    }
}
