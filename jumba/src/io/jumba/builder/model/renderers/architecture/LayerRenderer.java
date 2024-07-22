package io.jumba.builder.model.renderers.architecture;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.model.architecture.LayerView;
import io.jumba.builder.model.architecture.OutputView;
import io.intino.magritte.framework.Layer;

import java.lang.reflect.Method;

public class LayerRenderer {
    public static final String ActivationLayersViewPackage = "io.jumba.builder.model.architecture.layers.activation.";
    public static final String ProcessingLayersViewPackage = "io.jumba.builder.model.architecture.layers.processing.";
    public static final String LayersViewPackage = "io.jumba.builder.model.architecture.layers.";

    public LayerView render(Layer layer, OutputView previousOutput, CompilationContext context) {
        return layer(layer, previousOutput, context);
    }

    private static LayerView layer(Layer layer, OutputView previousOutput, CompilationContext context) {
        try {
            return (LayerView) getMethodToCreateView(layer).invoke(null, layer, previousOutput, context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Method getMethodToCreateView(Layer layer) throws Exception {
        return Class.forName(className(layer)).getDeclaredMethod("from", Layer.class, OutputView.class, CompilationContext.class);
    }

    private static String className(Layer layer) {
        return  packageName(layer) + layerName(layer) + "LayerView";
    }

    private static String layerName(Layer layer) {
        return layer.getClass().getSimpleName();
    }

    public static String packageName(Layer layer) {
        return isActivationLayer(layer) ? ActivationLayersViewPackage : ProcessingLayersViewPackage;
    }

    private static boolean isActivationLayer(Layer layer) {
        return layer.core$().conceptList().get(1).toString().contains("ActivationLayer");
    }
}