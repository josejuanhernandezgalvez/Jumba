package io.jumba.builder.model.laboratory;

import io.jumba.model.Laboratory;
import io.intino.magritte.framework.Layer;

public record DatasetView(String name, SplitView split, int batchSize) implements ParameterView {

    public static DatasetView from(Layer layer) {
        Laboratory.Dataset dataset = (Laboratory.Dataset) layer;
        return new DatasetView(dataset.name(), SplitView.from(dataset.split()), dataset.batchSize());
    }

    public static class SplitView {
        public final double train;
        public final double test;
        public final double validation;

        public SplitView(double train, double test, double validation) {
            this.train = train;
            this.test = test;
            this.validation = validation;
        }

        public static SplitView from(Laboratory.Dataset.Split split) {
            return new SplitView(split.train(), split.test(), split.validation());
        }
    }
}
