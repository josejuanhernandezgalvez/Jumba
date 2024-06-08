package io.flogo.builder.model.laboratory.strategies;

import io.flogo.builder.model.laboratory.StrategyView;
import io.flogo.model.Strategy;

public class RegressionStrategyView implements StrategyView {

    public static StrategyView from(Strategy strategy) {
        return new RegressionStrategyView();
    }
}
