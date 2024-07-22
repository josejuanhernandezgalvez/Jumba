package io.jumba.builder.model.laboratory.optimizers;

import io.jumba.builder.model.laboratory.OptimizerView;
import io.jumba.model.Optimizer;
import io.jumba.model.RProp;

public class RPropView implements OptimizerView {
    public final double learningRate;
    public final double eta0;
    public final double eta1;
    public final double stepSize0;
    public final double stepSize1;

    public RPropView(double learningRate, double eta0, double eta1, double stepSize0, double stepSize1) {
        this.learningRate = learningRate;
        this.eta0 = eta0;
        this.eta1 = eta1;
        this.stepSize0 = stepSize0;
        this.stepSize1 = stepSize1;
    }

    public static OptimizerView from(Optimizer optimizer) {
        return new RPropView(
                ((RProp) optimizer).lr(),
                ((RProp) optimizer).etas() == null ? 0.9 : ((RProp) optimizer).etas().eta0(),
                ((RProp) optimizer).etas() == null ? 0.999 : ((RProp) optimizer).etas().eta1(),
                ((RProp) optimizer).stepSizes() == null ? 0.000001 : ((RProp) optimizer).stepSizes().step0(),
                ((RProp) optimizer).stepSizes() == null ? 50 : ((RProp) optimizer).stepSizes().step1()
        );
    }
}
