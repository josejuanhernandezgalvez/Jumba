package io.jumba.builder.model.architecture.layers.link;

import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.LinkLayerView;
import io.jumba.builder.model.architecture.layers.output.OneDimensionOutputView;

import java.lang.reflect.Field;
import java.util.Arrays;

public class FlattenLayerView implements LinkLayerView {
    public final int fromDimension;
    public final int toDimension;
    public final OutputView previousLayerOutput;
    public final OutputView thisLayerOutput;

    public FlattenLayerView(OutputView previousLayerOutput, OutputView thisLayerOutput) {
        this.fromDimension = previousLayerOutput.dimensions();
        this.toDimension = thisLayerOutput.dimensions();
        this.previousLayerOutput = previousLayerOutput;
        this.thisLayerOutput = thisLayerOutput;
    }

    public static OneDimensionOutputView toOneDimension(OutputView previousLayerOutput) {
        return new OneDimensionOutputView(
                Arrays.stream(previousLayerOutput.getClass().getDeclaredFields())
                        .map(field -> getValue(field, previousLayerOutput))
                        .reduce(1, (a, b) -> a * b));
    }

    private static int getValue(Field field, OutputView previousLayerOutput) {
        try {
            field.setAccessible(true);
            return (int) field.get(previousLayerOutput);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OutputView getOutputView() {
        return thisLayerOutput;
    }
}
