package io.flogo.builder.model.architecture_views.loss_functions;

import io.flogo.blatt.model.HingeEmbeddingLoss;
import io.flogo.blatt.model.LossFunction;
import io.flogo.builder.model.architecture_views.LossFunctionView;

public class HingeEmbeddingLossView implements LossFunctionView {
    public final double margin;

    public HingeEmbeddingLossView(double margin) {
        this.margin = margin;
    }

    public static LossFunctionView from(LossFunction lossFunction) {
        return new HingeEmbeddingLossView(((HingeEmbeddingLoss) lossFunction).margin());
    }
}
