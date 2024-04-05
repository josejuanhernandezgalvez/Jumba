package io.flogo.builder.model;

import io.flogo.builder.model.architecture.ArchitectureView;
import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.SectionView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.laboratory.SubstituteView;
import io.intino.magritte.framework.Layer;

import java.util.*;
import java.util.stream.Collectors;

import static io.flogo.builder.model.renderers.architecture.SectionRenderer.LayerRenderer.ActivationLayersViewPackage;
import static io.flogo.builder.model.renderers.architecture.SectionRenderer.LayerRenderer.ProcessingLayersViewPackage;

public class ExperimentArchitecture extends ArchitectureView {

    public ExperimentArchitecture(ArchitectureView architectureView, List<SubstituteView> substitutes) {
        super(collapesedSectionList(architectureView.sections().iterator(), substitutes, new ArrayList<>()));
    }

    private static List<SectionView> collapesedSectionList(Iterator<SectionView> iterator, List<SubstituteView> substitutes, ArrayList<SectionView> result) {
        if (!iterator.hasNext()) return result;
        result.add(collapseSectionView(iterator.next(), map(substitutes), result.isEmpty() ? null : result.getLast().blocks().getLast().layerViews().getLast()));
        return collapesedSectionList(iterator, substitutes, result);

    }

    private static Map<String, List<SubstituteView>> map(List<SubstituteView> substitutes) {
        return substitutes.stream().collect(Collectors.groupingBy(substituteView -> substituteView.id));
    }

    private static SectionView collapseSectionView(SectionView sectionView, Map<String, List<SubstituteView>> substitutes, LayerView previous) {
        try {
            return (SectionView) sectionView.getClass().getConstructors()[0].newInstance(
                    collapsedBlockViewList(sectionView.blocks().iterator(), substitutes, new ArrayList<>(), previous));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static List<BlockView> collapsedBlockViewList(Iterator<BlockView> iterator, Map<String, List<SubstituteView>> substitutes, ArrayList<BlockView> result, LayerView previous) {
        if (!iterator.hasNext()) return result;
        result.add(collapsedBlockView(iterator.next().layerViews().iterator(), substitutes, new ArrayList<>(), previous));
        return collapsedBlockViewList(iterator, substitutes, result, result.getLast().layerViews().getLast());
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
                        .invoke(null, previous == null ? vLayerView : previous, substitutes.get(vLayerView.id).getFirst());
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
