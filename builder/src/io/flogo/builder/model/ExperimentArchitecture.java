package io.flogo.builder.model;

import io.flogo.builder.model.architecture.*;
import io.flogo.builder.model.laboratory.SubstituteView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExperimentArchitecture extends ArchitectureView {
    private OutputView previousLayerOutputView = null;

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
        result.add(collapsedBlockView(iterator.next().layerViews().iterator(), substitutes, new ArrayList<>()));
        return collapsedBlockViewList(iterator, substitutes, result);
    }

    private static BlockView collapsedBlockView(Iterator<LayerView> iterator, Map<String, List<SubstituteView>> substitutes, ArrayList<LayerView> result) {
        if (!iterator.hasNext()) return new BlockView(result);
        result.add(collapsedLayerView(iterator.next(), substitutes, result.isEmpty() ? null : result.getLast()));
        return collapsedBlockView(iterator, substitutes, result);
    }

    private static LayerView collapsedLayerView(LayerView layerView, Map<String, List<SubstituteView>> substitutes, LayerView previous) {
        return null; //TODO
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
