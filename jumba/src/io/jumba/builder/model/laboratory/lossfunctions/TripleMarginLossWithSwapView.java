package io.jumba.builder.model.laboratory.lossfunctions;

import io.jumba.builder.model.laboratory.LossFunctionView;
import io.jumba.model.LossFunction;
import io.jumba.model.TripletMarginLossWithSwap;

public class TripleMarginLossWithSwapView {
    public final double margin;
    public final double normDegree;
    public final double eps;

    public TripleMarginLossWithSwapView(double margin, double normDegree, double eps) {
        this.margin = margin;
        this.normDegree = normDegree;
        this.eps = eps;
    }

    public static LossFunctionView from(LossFunction lossFunction) {
        return new TripletMarginLossView(((TripletMarginLossWithSwap) lossFunction).margin(),
                ((TripletMarginLossWithSwap) lossFunction).normDegree(),
                ((TripletMarginLossWithSwap) lossFunction).eps());
    }
}
