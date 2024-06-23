package io.flogo.builder.model;

import io.flogo.builder.CompilationContext;
import io.flogo.builder.model.architecture.*;
import io.flogo.builder.model.architecture.blocks.ResidualBlockView;
import io.flogo.builder.model.architecture.blocks.SimpleBlockView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.laboratory.MaterializationView;
import io.intino.magritte.framework.Layer;

import java.util.*;
import java.util.stream.Collectors;

import static io.flogo.builder.model.renderers.architecture.LayerRenderer.ActivationLayersViewPackage;
import static io.flogo.builder.model.renderers.architecture.LayerRenderer.ProcessingLayersViewPackage;


public class ExperimentArchitecture extends ArchitectureView {
    static OutputView sectionInput;

    public ExperimentArchitecture(ArchitectureView architectureView, List<MaterializationView> substitutes, String name, CompilationContext context) {
        super(collapesedSectionList(architectureView.sections().iterator(), substitutes, new ArrayList<>(), context), name);
    }

    private static List<SectionView> collapesedSectionList(Iterator<SectionView> iterator, List<MaterializationView> substitutes, ArrayList<SectionView> result, CompilationContext context) {
        if (!iterator.hasNext()) return result;
        result.add(collapseSectionView(iterator.next(), map(substitutes), result.isEmpty() ? null : result.getLast().blocks().getLast().layerViews().getLast(), context));
        return collapesedSectionList(iterator, substitutes, result, context);

    }

    private static Map<String, List<MaterializationView>> map(List<MaterializationView> substitutes) {
        return substitutes.stream().collect(Collectors.groupingBy(substituteView -> substituteView.id));
    }

    private static SectionView collapseSectionView(SectionView sectionView, Map<String, List<MaterializationView>> substitutes, LayerView previous, CompilationContext context) {
        try {
            sectionInput = sectionView.input();
            return (SectionView) sectionView.getClass().getConstructors()[0].newInstance(
                    collapsedBlockViewList(sectionView.blocks().iterator(), substitutes, new ArrayList<>(), previous, context), sectionView.input());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static List<BlockView> collapsedBlockViewList(Iterator<BlockView> iterator, Map<String, List<MaterializationView>> substitutes, ArrayList<BlockView> result, LayerView previous, CompilationContext context) {
        if (!iterator.hasNext()) return result;
        BlockView nextBlock = iterator.next();
        result.add(isSimple(nextBlock) ?
                collapsedSimpleBlockView(nextBlock.layerViews().iterator(), substitutes, new ArrayList<>(), previous, context) :
                collapsedResidualBlockView(nextBlock.layerViews().iterator(), ((ResidualBlockView) nextBlock).shortCut, substitutes, new ArrayList<>(), previous, context));
        return collapsedBlockViewList(iterator, substitutes, result, result.getLast().layerViews().getLast(), context);
    }

    private static boolean isSimple(BlockView nextBlock) {
        return !(nextBlock instanceof ResidualBlockView);
    }

    private static BlockView collapsedSimpleBlockView(Iterator<LayerView> iterator, Map<String, List<MaterializationView>> substitutes, ArrayList<LayerView> result, LayerView previous, CompilationContext context) {
        if (!iterator.hasNext()) return new SimpleBlockView(result);
        result.add(collapsedLayerView(iterator.next(), substitutes, previous, context));
        return collapsedSimpleBlockView(iterator, substitutes, result, result.getLast(), context);
    }

    private static BlockView collapsedResidualBlockView(Iterator<LayerView> iterator, ResidualBlockView.ShortcutView residualConnection, Map<String, List<MaterializationView>> substitutes, ArrayList<LayerView> result, LayerView previous, CompilationContext context) {
        if (!iterator.hasNext()) return new ResidualBlockView(result, residualConnection);
        result.add(collapsedLayerView(iterator.next(), substitutes, previous, context));
        return collapsedResidualBlockView(iterator, residualConnection, substitutes, result, result.getLast(), context);
    }

    private static LayerView collapsedLayerView(LayerView layerView, Map<String, List<MaterializationView>> substitutes, LayerView previous, CompilationContext context) {
        try {
            if (layerView instanceof VLayerView vLayerView) {
                return (LayerView) Class.forName(viewClassName(substitutes.get(vLayerView.id).getFirst()))
                        .getMethod("createFromMaterialization", LayerView.class, MaterializationView.class, CompilationContext.class)
                        .invoke(null, previous == null ? vLayerView : previous, substitutes.get(vLayerView.id).getFirst(), context);
            }
            return layerView.from(previous != null ? previous.getOutputView() : sectionInput, context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String viewClassName(MaterializationView substitute) {
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
        private List<MaterializationView> substitutes;
        private String name;

        public Builder from(ArchitectureView architectureView) {
            this.architectureView = architectureView;
            return this;
        }

        public Builder substitutes(List<MaterializationView> substitutes) {
            this.substitutes = substitutes;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public ArchitectureView collapse(CompilationContext context) {
            return new ExperimentArchitecture(this.architectureView, this.substitutes, this.name, context);
        }
    }
}
