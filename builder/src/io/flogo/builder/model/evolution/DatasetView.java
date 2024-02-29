package io.flogo.builder.model.evolution;

import io.flogo.model.Evolution.Dataset;
import io.intino.magritte.framework.Layer;

public record DatasetView(String name, String path, double train, double test, int batchSize) implements ParameterView {

    public static DatasetView from(Layer layer) {
        Dataset dataset = (Dataset) layer;
        return new DatasetView(dataset.name(), dataset.path(), dataset.train(), dataset.test(), dataset.batchSize());
    }
}
