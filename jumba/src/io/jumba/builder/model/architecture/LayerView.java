package io.jumba.builder.model.architecture;

import io.intino.magritte.framework.Layer;

public interface LayerView {
    OutputView getOutputView();
    boolean isMutable();

    static boolean getMutable(Layer layer) {
        try {
            return (boolean) layer.getClass().getMethod("isMutable").invoke(layer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
