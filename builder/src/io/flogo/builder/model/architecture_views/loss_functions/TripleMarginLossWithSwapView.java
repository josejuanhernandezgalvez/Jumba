package io.flogo.builder.model.architecture_views.loss_functions;

import io.flogo.blatt.model.LossFunction;
import io.flogo.blatt.model.TripletMarginLossWithSwap;
import io.flogo.builder.model.architecture_views.LossFunctionView;

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
