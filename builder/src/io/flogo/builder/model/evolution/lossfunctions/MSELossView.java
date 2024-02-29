package io.flogo.builder.model.evolution.lossfunctions;

import io.flogo.model.LossFunction;
import io.flogo.builder.model.evolution.LossFunctionView;

public class MSELossView implements LossFunctionView {
    public static LossFunctionView from(LossFunction lossFunction) {
        return new MSELossView();
    }
}
