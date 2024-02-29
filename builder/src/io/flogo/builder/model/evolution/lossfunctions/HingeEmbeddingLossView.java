package io.flogo.builder.model.evolution.lossfunctions;

import io.flogo.model.HingeEmbeddingLoss;
import io.flogo.model.LossFunction;
import io.flogo.builder.model.evolution.LossFunctionView;

public class HingeEmbeddingLossView implements LossFunctionView {
    public final double margin;

    public HingeEmbeddingLossView(double margin) {
        this.margin = margin;
    }

    public static LossFunctionView from(LossFunction lossFunction) {
        return new HingeEmbeddingLossView(((HingeEmbeddingLoss) lossFunction).margin());
    }
}
