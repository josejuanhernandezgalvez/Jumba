package io.jumba.builder.model.laboratory.strategies;

import io.jumba.builder.model.laboratory.StrategyView;
import io.jumba.model.Strategy;

public class RegressionStrategyView implements StrategyView {

    public static StrategyView from(Strategy strategy) {
        return new RegressionStrategyView();
    }
}
