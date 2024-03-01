package io.flogo.builder.model.laboratory;

import io.flogo.model.Laboratory;

public class SubstituteView {
    public final String id;
    public final Laboratory.Experiment.Substitute.Layer layer;

    public SubstituteView(String id, Laboratory.Experiment.Substitute.Layer layer) {
        this.id = id;
        this.layer = layer;
    }
}
