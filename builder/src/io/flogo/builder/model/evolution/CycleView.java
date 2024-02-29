package io.flogo.builder.model.evolution;

import io.flogo.model.Evolution;
import io.intino.magritte.framework.Layer;

public class CycleView implements ParameterView {
    public final int epochs;
    public final double fit;
    public final double validation;

    public CycleView(int epochs, double fit, double validation) {
        this.epochs = epochs;
        this.fit = fit;
        this.validation = validation;
    }

    public static CycleView from(Layer layer) {
        Evolution.Cycle cycle = (Evolution.Cycle) layer;
        return new CycleView(cycle.epochs(), cycle.fit(), cycle.val());
    }
}
