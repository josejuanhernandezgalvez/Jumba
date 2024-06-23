package io.flogo.builder.model.renderers.architecture;

import io.flogo.builder.CompilationContext;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.SectionView;
import io.flogo.model.Section;
import io.intino.magritte.framework.Layer;

public abstract class SectionRenderer<U extends SectionView> {
    private final LayerRenderer layerRenderer;

    public SectionRenderer() {
        this.layerRenderer = new LayerRenderer();
    }

    public abstract U render(Section section, OutputView input, CompilationContext context);

    public LayerView render(Layer layer, OutputView previousOutput, CompilationContext context) {
        return layerRenderer.render(layer, previousOutput, context);
    }

    public static class SectionOrchestratorRenderer extends SectionRenderer<SectionView> {
        @SuppressWarnings("all")
        private final String PackageRoute = "io.flogo.builder.model.renderers.architecture.sectionrenderers.";

        @Override
        public SectionView render(Section section, OutputView input, CompilationContext context) {
            return rendererFor(section).render(section, input, context);
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
