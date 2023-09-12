package io.flogo.builder.model.architecture_views.loss_functions;

import io.flogo.blatt.model.LossFunction;
import io.flogo.blatt.model.TripletMarginLoss;
import io.flogo.builder.model.architecture_views.LossFunctionView;

public class TripletMarginLossView implements LossFunctionView{
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
