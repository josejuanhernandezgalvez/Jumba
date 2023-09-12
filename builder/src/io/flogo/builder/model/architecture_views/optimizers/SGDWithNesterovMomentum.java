package io.flogo.builder.model.architecture_views.optimizers;

import io.flogo.blatt.model.Optimizer;
import io.flogo.builder.model.architecture_views.OptimizerView;

public class SGDWithNesterovMomentum implements OptimizerView {
    public final double learningRate;
    public final double momentum;
    public final double momentumDecay;
    public final double weightDecay;

    public SGDWithNesterovMomentum(double learningRate, double momentum, double momentumDecay, double weightDecay) {
        this.learningRate = learningRate;
        this.momentum = momentum;
        this.momentumDecay = momentumDecay;
        this.weightDecay = weightDecay;
    }


    public static OptimizerView from(Optimizer optimizer) {
        return new SGDWithNesterovMomentum(((io.flogo.blatt.model.SGDWithNesterovMomentum) optimizer).lr(),
                                           ((io.flogo.blatt.model.SGDWithNesterovMomentum) optimizer).momentum(),
                                           ((io.flogo.blatt.model.SGDWithNesterovMomentum) optimizer).momentumDecay(),
                                           ((io.flogo.blatt.model.SGDWithNesterovMomentum) optimizer).weightDecay());
    }
}
