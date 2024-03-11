package io.flogo.builder.model.renderers.architecture;

import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.SectionView;
import io.flogo.model.Section;
import io.intino.magritte.framework.Layer;

import java.lang.reflect.Method;

public abstract class SectionRenderer<U extends SectionView> {
    private final LayerRenderer layerRenderer;

    public SectionRenderer() {
        this.layerRenderer = new LayerRenderer();
    }

    public abstract U render(Section section, OutputView input);

    public LayerView render(Layer layer, OutputView previousOutput) {
        return layerRenderer.render(layer, previousOutput);
    }

    private static class LayerRenderer {
        private static final String ActivationLayersViewPackage = "io.flogo.builder.model.architecture.layers.activation.";
        private static final String ProcessingLayersViewPackage = "io.flogo.builder.model.architecture.layers.processing.";
        private static final String LayersViewPackage = "io.flogo.builder.model.architecture.layers.";

        public LayerView render(Layer layer, OutputView previousOutput) {
            return layer(layer, previousOutput);
        }

        private static LayerView layer(Layer layer, OutputView previousOutput) {
            try {
                return (LayerView) getMethodToCreateView(layer).invoke(null, layer, previousOutput);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private static Method getMethodToCreateView(Layer layer) throws Exception {
            return Class.forName(className(layer)).getDeclaredMethod("from", Layer.class, OutputView.class);
        }

        private static String className(Layer layer) {
            return !layer.getClass().getName().endsWith("VLayer") ? packageName(layer) + layerName(layer) + "LayerView" : LayersViewPackage + "VLayerView";
        }

        private static String layerName(Layer layer) {
            return layer.getClass().toString().split("\\$")[2];
        }

        private static String packageName(Layer layer) {
            return isActivationLayer(layer) ? ActivationLayersViewPackage : ProcessingLayersViewPackage;
        }

        private static boolean isActivationLayer(Layer layer) {
            return layer.core$().conceptList().get(1).toString().split("\\$")[2].startsWith("ActivationLayer");
        }
    }


    public static class SectionOrchestratorRenderer extends SectionRenderer<SectionView> {

        @SuppressWarnings("all")
        private final String PackageRoute = "io.flogo.builder.model.renderers.architecture.sectionrenderers.";

        @Override
        public SectionView render(Section section, OutputView input) {
            return rendererFor(section).render(section, input);
        }

        private SectionRenderer<? extends SectionView> rendererFor(Section section) {
            try {
                return (SectionRenderer<? extends SectionView>) Class.forName(getOutputClassNameFor(section))
                        .getConstructors()[0]
                        .newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private String getOutputClassNameFor(Section section) {
            return PackageRoute + typeOf(section) + "Renderer";
        }

        private static String typeOf(Section section) {
            return section.core$().conceptList().getFirst().toString().split("\\{")[0];
        }
    }
}
