package io.jumba.builder.model.architecture.layers.processing;

import io.jumba.builder.model.architecture.layers.ProcessingLayerView;
import io.intino.magritte.framework.Layer;

public abstract class ThreeDimensionLayerView implements ProcessingLayerView {

    protected static boolean hasNotOutput(Layer layer) {
        try {
            return layer.getClass().getDeclaredMethod("output").invoke(layer) == null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected static int getValue(Object output, String argument) {
        try {
            return (int) output.getClass().getMethod(argument).invoke(output);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
