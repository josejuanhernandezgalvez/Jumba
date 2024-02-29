package io.flogo.builder.model.evolution.lossfunctions;

import io.flogo.model.LossFunction;
import io.flogo.builder.model.evolution.LossFunctionView;

public class MAELossView implements LossFunctionView {
    public static LossFunctionView from(LossFunction lossFunction) {
        return new MAELossView();
    }
}
