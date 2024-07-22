package io.jumba.builder.model.laboratory.lossfunctions;

import io.jumba.builder.model.laboratory.LossFunctionView;
import io.jumba.model.HingeEmbeddingLoss;
import io.jumba.model.LossFunction;

public class HingeEmbeddingLossView implements LossFunctionView {
    public final double margin;

    public HingeEmbeddingLossView(double margin) {
        this.margin = margin;
    }

    public static LossFunctionView from(LossFunction lossFunction) {
        return new HingeEmbeddingLossView(((HingeEmbeddingLoss) lossFunction).margin());
    }
}
