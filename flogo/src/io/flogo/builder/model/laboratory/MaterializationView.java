package io.flogo.builder.model.laboratory;

import io.flogo.model.Laboratory;

public class MaterializationView {
    public final String id;
    public final Laboratory.Experiment.Materialization.Layer layer;

    public MaterializationView(String id, Laboratory.Experiment.Materialization.Layer layer) {
        this.id = id;
        this.layer = layer;
    }
}
