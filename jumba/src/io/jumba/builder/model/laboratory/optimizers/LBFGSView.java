package io.jumba.builder.model.laboratory.optimizers;

import io.jumba.builder.model.laboratory.OptimizerView;
import io.jumba.model.LBFGS;
import io.jumba.model.Optimizer;

public class LBFGSView implements OptimizerView {
    public final double learningRate;
    public final int maxIter;
    public final double toleranceGrad;
    public final double toleranceChange;
    public final double historySize;

    public LBFGSView(double learningRate, int maxIter, double toleranceGrad, double toleranceChange, double historySize) {
        this.learningRate = learningRate;
        this.maxIter = maxIter;
        this.toleranceGrad = toleranceGrad;
        this.toleranceChange = toleranceChange;
        this.historySize = historySize;
    }

    public static OptimizerView from(Optimizer optimizer) {
        return new LBFGSView(
                ((LBFGS) optimizer).lr(),
                ((LBFGS) optimizer).maxIter(),
                ((LBFGS) optimizer).toleranceGrad(),
                ((LBFGS) optimizer).toleranceChange(),
                ((LBFGS) optimizer).historySize()
        );
    }
}
