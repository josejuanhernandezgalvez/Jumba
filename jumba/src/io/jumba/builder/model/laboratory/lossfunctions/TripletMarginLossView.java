package io.jumba.builder.model.laboratory.lossfunctions;

import io.jumba.builder.model.laboratory.LossFunctionView;
import io.jumba.model.LossFunction;
import io.jumba.model.TripletMarginLoss;

public class TripletMarginLossView implements LossFunctionView {
    public final double margin;
    public final double normDegree;
    public final double eps;

    public TripletMarginLossView(double margin, double normDegree, double eps) {
        this.margin = margin;
        this.normDegree = normDegree;
        this.eps = eps;
    }

    public static LossFunctionView from(LossFunction lossFunction) {
        return new TripletMarginLossView(((TripletMarginLoss) lossFunction).margin(),
                ((TripletMarginLoss) lossFunction).normDegree(),
                ((TripletMarginLoss) lossFunction).eps());
    }
}
