package io.flogo.builder.model.laboratory.lossfunctions;

import io.flogo.builder.model.laboratory.LossFunctionView;
import io.flogo.model.LossFunction;

public class MAELossView implements LossFunctionView {
    public static LossFunctionView from(LossFunction lossFunction) {
        return new MAELossView();
    }
}
