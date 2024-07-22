package io.jumba.builder.model.laboratory.lossfunctions;

import io.jumba.builder.model.laboratory.LossFunctionView;
import io.jumba.model.LossFunction;

public class MarginRankingLossView implements LossFunctionView {
    public static LossFunctionView from(LossFunction lossFunction) {
        return new MarginRankingLossView();
    }
}
