package io.flogo.builder.model;

import io.flogo.builder.model.architecture.*;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.laboratory.SubstituteView;
import io.intino.magritte.framework.Layer;

import java.util.*;
import java.util.stream.Collectors;

import static io.flogo.builder.model.renderers.architecture.SectionRenderer.LayerRenderer.ActivationLayersViewPackage;
import static io.flogo.builder.model.renderers.architecture.SectionRenderer.LayerRenderer.ProcessingLayersViewPackage;

public class ExperimentArchitecture extends ArchitectureView {

    public ExperimentArchitecture(ArchitectureView architectureView, List<SubstituteView> substitutes) {
        super(createSections(architectureView, substitutes));
    }

    private static List<SectionView> createSections(ArchitectureView architectureView, List<SubstituteView> substitutes) {
        return architectureView.sections().stream()
                .map(sectionView -> collapseSectionView(sectionView, map(substitutes))).toList();
    }

    private static Map<String, List<SubstituteView>> map(List<SubstituteView> substitutes) {
        return substitutes.stream().collect(Collectors.groupingBy(substituteView -> substituteView.id));
    }

    private static SectionView collapseSectionView(SectionView sectionView, Map<String, List<SubstituteView>> substitutes) {
        try {
            return (SectionView) sectionView.getClass().getConstructors()[0].newInstance(
                    collapsedBlockViewList(sectionView.blocks().iterator(), substitutes, new ArrayList<>()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static List<BlockView> collapsedBlockViewList(Iterator<BlockView> iterator, Map<String, List<SubstituteView>> substitutes, ArrayList<BlockView> result) {
        if (!iterator.hasNext()) return result;
        result.add(collapsedBlockView(iterator.next().layerViews().iterator(), substitutes, new ArrayList<>(), result.isEmpty() ? null : result.getLast().layerViews().getLast()));
        return collapsedBlockViewList(iterator, substitutes, result);
    }

    private static BlockView collapsedBlockView(Iterator<LayerView> iterator, Map<String, List<SubstituteView>> substitutes, ArrayList<LayerView> result, LayerView previous) {
        if (!iterator.hasNext()) return new BlockView(result);
        result.add(collapsedLayerView(iterator.next(), substitutes, previous));
        return collapsedBlockView(iterator, substitutes, result, result.getLast());
    }

    private static LayerView collapsedLayerView(LayerView layerView, Map<String, List<SubstituteView>> substitutes, LayerView previous) {
        try {
            if (layerView instanceof VLayerView vLayerView) {
                return (LayerView) Class.forName(viewClassName(substitutes.get(vLayerView.id).getFirst()))
                        .getMethod("createFromSubstitute", LayerView.class, SubstituteView.class)
                        .invoke(null, previous, substitutes.get(vLayerView.id).getFirst());
            }
            return layerView.from(previous);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String viewClassName(SubstituteView substitute) {
        return packageName(substitute.layer) + layerName(substitute.layer) + "LayerView";
    }

    public static String packageName(Layer layer) {
        return isActivationLayer(layer) ? ActivationLayersViewPackage : ProcessingLayersViewPackage;
    }

    private static String layerName(Layer substitute) {
        return Arrays.stream(substitute.getClass().getName().split("\\$")).toList().getLast();
    }

    private static boolean isActivationLayer(Layer layer) {
        return layer.core$().conceptList().get(1).toString().split("\\$")[3].startsWith("ActivationLayer");
    }


    public static class Builder {
        private ArchitectureView architectureView;
        private List<SubstituteView> substitutes;

        public Builder from(ArchitectureView architectureView) {
            this.architectureView = architectureView;
            return this;
        }

        public Builder substitutes(List<SubstituteView> substitutes) {
            this.substitutes = substitutes;
            return this;
        }

        public ArchitectureView collapse() {
            return new ExperimentArchitecture(this.architectureView, this.substitutes);
        }
    }
}
