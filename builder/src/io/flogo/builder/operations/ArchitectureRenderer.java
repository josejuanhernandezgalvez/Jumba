package io.flogo.builder.operations;

import io.flogo.builder.model.architecture.ArchitectureView;
import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.SectionView;
import io.flogo.builder.model.architecture.layers.activation.ReLULayerView;
import io.flogo.builder.model.architecture.layers.link.SoftmaxLayerView;
import io.flogo.builder.model.architecture.layers.processing.*;
import io.flogo.builder.model.architecture.sections.link.FlattenSectionView;
import io.intino.itrules.FrameBuilder;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class ArchitectureRenderer {
    public String render(ArchitectureView architecture, String name, String library) {
        FrameBuilder builder = new FrameBuilder("architecture").add("library", library);
        builder.add("name", name);
        builder.add("import", importsOf(architecture, library));
        builder.add("component", componentsOf(architecture, library));
        return new ArchitectureTemplate().render(builder);
    }

    private FrameBuilder importsOf(ArchitectureView architecture, String library) {
        FrameBuilder builder = new FrameBuilder("import");
        builder.add("section", sectionsOf(architecture, library));
        builder.add("block", blocksOf(architecture, library));
        builder.add("layer", layersOf(architecture, library));
        return builder;
    }

    private FrameBuilder[] componentsOf(ArchitectureView architecture, String library) {
        return architecture.sections().stream()
                .map(section -> buildSectionFrame(library, section))
                .toArray(FrameBuilder[]::new);
    }

    private FrameBuilder[] sectionsOf(ArchitectureView architecture, String library) {
        return architecture.sections().stream()
                .filter(distinctBy(SectionView::getClass))
                .filter(sectionView -> !(sectionView instanceof FlattenSectionView))
                .map(sectionView -> buildSectionFrame(library, sectionView))
                .toArray(FrameBuilder[]::new);
    }

    private FrameBuilder[] blocksOf(ArchitectureView architecture, String library) {
        return architecture.sections().stream()
                .map(SectionView::blocks)
                .flatMap(List::stream)
                .filter(distinctBy(BlockView::getClass))
                .map(blockView ->  buildBlockFrame(library, blockView))
                .toArray(FrameBuilder[]::new);
    }

    private FrameBuilder[] layersOf(ArchitectureView architecture, String library) {
        return architecture.sections().stream()
                .map(SectionView::blocks)
                .flatMap(List::stream)
                .map(BlockView::layerViews)
                .flatMap(List::stream)
                .filter(distinctBy(LayerView::getClass))
                .map(layer -> buildLayerFrame(library, layer))
                .toArray(FrameBuilder[]::new);
    }

    private FrameBuilder buildSectionFrame(String library, SectionView section) {
        FrameBuilder fb = new FrameBuilder("section")
                .add("library", library)
                .add("type", typeOf(section.getClass().getSimpleName()));
        FrameBuilder[] blocks = section.blocks().stream()
                .map(block -> buildBlockFrame(library, block))
                .toArray(FrameBuilder[]::new);
        fb.add("block", blocks);
        return fb;
    }

    private FrameBuilder buildBlockFrame(String library, BlockView block) {
        FrameBuilder fb = new FrameBuilder("block").add("library", library).add("type", "Linear");
        FrameBuilder[] layers = block.layerViews().stream()
                .map(layer -> buildLayerFrame(library, layer))
                .toArray(FrameBuilder[]::new);
        fb.add("layer", layers);
        return fb;
    }

    private FrameBuilder buildLayerFrame(String library, LayerView layer) {
        FrameBuilder builder = new FrameBuilder("layer", typeOf(layer.getClass().getSimpleName()))
                .add("library", library)
                .add("type", typeOf(layer.getClass().getSimpleName()));
        switch (layer) {
            case LinearLayerView linear ->
                    builder.add("in_features", linear.previousLayerOutput.dimensions())
                            .add("out_features", linear.getOutputView().dimensions())
                            .add("bias", "True");
            case ConvolutionalLayerView convolutional ->
                builder.add("in_channels", convolutional.previousLayerOutput.dimensions())
                        .add("out_channels", convolutional.thisLayerOutput.dimensions())
                        .add("kernel", convolutional.kernel.size())
                        .add("stride", convolutional.kernel.stride())
                        .add("padding", convolutional.kernel.padding());
            case MaxPoolLayerView maxPool ->
                    builder.add("package", "poolings")
                            .add("kernel", maxPool.kernel.size())
                            .add("stride", maxPool.kernel.stride())
                            .add("padding", maxPool.kernel.padding());
            case AvgPoolLayerView avgPool ->
                    builder.add("package", "poolings")
                            .add("kernel", avgPool.kernel.size())
                            .add("stride", avgPool.kernel.stride())
                            .add("padding", avgPool.kernel.padding());
            case ReLULayerView ignored ->
                    builder.add("package", "activations");
            case DropoutLayerView dropout ->
                    builder.add("probability", dropout.probability)
                            .add("package", "regularizations");
            case NormalizationLayerView batchNormalization ->
                    builder.add("package", "regularizations")
                            .add("num_features", batchNormalization.output.dimensions())
                            .add("eps", batchNormalization.eps)
                            .add("momentum", batchNormalization.momentum);
            case SoftmaxLayerView softmax ->
                    builder.add("package", "activations")
                            .add("n_dimensions", softmax.getOutputView().dimensions());
            default -> {}
        }
        return builder;
    }

    private String typeOf(String view) {
        String component = view.substring(0, view.indexOf("View"));
        for (int i = component.length() - 1; i > 0; i--) {
            if (Character.isUpperCase(component.charAt(i))) return component.substring(0, i);
        }
        return component;
    }

    public static <T> Predicate<T> distinctBy(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
