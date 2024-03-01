package io.flogo.builder.model.laboratory.lossfunctions;

import io.flogo.model.LossFunction;
import io.flogo.builder.model.laboratory.LossFunctionView;

    public class CrossEntropyLossView implements LossFunctionView {
    public static LossFunctionView from(LossFunction lossFunction) {
        return new CrossEntropyLossView();
    }
}
