package io.flogo.builder.operations;

import io.flogo.builder.model.architecture.ArchitectureView;
import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.SectionView;
import io.flogo.builder.model.architecture.layers.ActivationLayerView;
import io.flogo.builder.model.architecture.layers.activation.ELULayerView;
import io.flogo.builder.model.architecture.layers.activation.LeakyReLULayerView;
import io.flogo.builder.model.architecture.layers.activation.SoftmaxLayerView;
import io.flogo.builder.model.architecture.layers.link.FlattenLayerView;
import io.flogo.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.flogo.builder.model.architecture.layers.processing.*;
import io.flogo.builder.model.architecture.layers.processing.RecurrentLayerView.Reduce.SliceReduce;
import io.flogo.builder.model.architecture.sections.link.FlattenSectionView;
import io.intino.itrules.FrameBuilder;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class ArchitectureRenderer {
    public String render(ArchitectureView architecture, String library) {
        FrameBuilder builder = new FrameBuilder("architecture").add("library", library);
        builder.add("name", architecture.name);
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
                .map(section -> isFlattenSection(section) ? buildFlattenFrame(section, library) : sectionOf(section, library))
                .toArray(FrameBuilder[]::new);
    }

    private static boolean isFlattenSection(SectionView section) {
        return section instanceof FlattenSectionView;
    }

    private FrameBuilder buildFlattenFrame(SectionView section, String library) {
        return new FrameBuilder("component").add("layer", buildLayerFrame(library, section.blocks().stream().map(BlockView::layerViews).flatMap(List::stream).toList().getFirst()));
    }

    private FrameBuilder sectionOf(SectionView section, String library) {
        return new FrameBuilder("component").add("section", buildSectionFrame(library, section));
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
                .map(layerView -> layerView instanceof RecurrentLayerView ? layersOf((RecurrentLayerView) layerView) : List.of(layerView))
                .flatMap(List::stream)
                .filter(distinctBy(LayerView::getClass))
                .map(layer -> buildLayerFrame(library, layer))
                .toArray(FrameBuilder[]::new);
    }

    private List<LayerView> layersOf(RecurrentLayerView recurrent) {
        ArrayList<LayerView> layers = new ArrayList<>();
        for (RecurrentLayerView.Reduce reduce : recurrent.reduce) {
            if (reduce instanceof RecurrentLayerView.Reduce.LinearReduce) layers.add(new LinearLayerView(new OneDimensionOutputView(1), new OneDimensionOutputView(1)));
            if (reduce instanceof RecurrentLayerView.Reduce.FlattenReduce) layers.add(new FlattenLayerView(new OneDimensionOutputView(1), new OneDimensionOutputView(1)));
            if (reduce instanceof SliceReduce) layers.add(new SlicingLayerView());
        }
        layers.add(recurrent);
        return layers;
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
        FrameBuilder fb = new FrameBuilder("block").add("library", library);
        if (!isSimpleBlock(block)) fb.add("type", typeOf(block.getClass().getSimpleName()));
        FrameBuilder[] layers = block.layerViews().stream()
                .map(layer -> buildLayerFrame(library, layer))
                .toArray(FrameBuilder[]::new);
        fb.add("layer", layers);
        return fb;
    }

    private static boolean isSimpleBlock(BlockView block) {
        return block.getClass().getSimpleName().substring(0, block.getClass().getSimpleName().indexOf("View")).startsWith("Simple");
    }

    private FrameBuilder buildLayerFrame(String library, LayerView layer) {
        FrameBuilder builder = new FrameBuilder("layer", typeOf(layer.getClass().getSimpleName()))
                .add("library", library)
                .add("type", typeOf(layer.getClass().getSimpleName()));
        switch (layer) {
            case LinearLayerView linear ->
                    builder.add("in_features", linear.previousLayerOutput.asArray()[0])
                            .add("out_features", linear.thisLayerOutput.asArray()[0])
                            .add("dimension", -1)
                            .add("bias", "True");
            case ConvolutionalLayerView convolutional ->
                    builder.add("dimensionality", convolutional.previousLayerOutput.dimensions() - 1)
                            .add("in_channels", convolutional.previousLayerOutput.asArray()[2])
                            .add("out_channels", convolutional.thisLayerOutput.asArray()[2])
                            .add("kernel", new FrameBuilder("kernel").add("dimension", convolutional.kernel.size().asArray()))
                            .add("stride", new FrameBuilder("stride").add("dimension", convolutional.kernel.stride().asArray()))
                            .add("padding", new FrameBuilder("padding").add("dimension", convolutional.kernel.padding().asArray()));
            case RecurrentLayerView recurrent ->
                    builder.add("package", "recurrents")
                            .add("input", recurrent.previousLayerOutput.asArray()[1])
                            .add("hidden", recurrent.hiddenSize)
                            .add("output", outputsNames.get(recurrent.outputType.name()))
                            .add("num_layers", recurrent.numLayers)
                            .add("bidirectional", recurrent.bidirectional)
                            .add("dropout", recurrent.dropout)
                            .add("reduce", reductionsOf(recurrent, library));
            case PoolLayerView pool ->
                    builder.add("package", "poolings")
                            .add("dimensionality", pool.getOutputView().dimensions() - 1)
                            .add("kernel", new FrameBuilder("kernel").add("dimension", pool.kernel.size().asArray()))
                            .add("stride", new FrameBuilder("stride").add("dimension", pool.kernel.stride().asArray()))
                            .add("padding", new FrameBuilder("padding").add("dimension", pool.kernel.padding().asArray()));
            case ELULayerView elu ->
                    builder.add("package", "activations")
                            .add("alpha", elu.alpha);
            case LeakyReLULayerView leaky ->
                    builder.add("package", "activations")
                            .add("slope", leaky.alpha);
            case SoftmaxLayerView softmax ->
                    builder.add("package", "activations")
                            .add("dimension", -1);
            case ActivationLayerView activation ->
                    builder.add("package", "activations");
            case DropoutLayerView dropout ->
                    builder.add("package", "regularizations")
                            .add("probability", dropout.probability);
            case LayerNormalizationLayerView layerNormalization ->
                    builder.add("package", "regularizations")
                            .add("shape", layerNormalization.output.asArray()[layerNormalization.output.asArray().length - 1])
                            .add("eps", layerNormalization.eps);
            case BatchNormalizationLayerView batchNormalization ->
                    builder.add("package", "regularizations")
                            .add("dimensionality", batchNormalization.getOutputView().dimensions() - 1)
                            .add("num_features", batchNormalization.output.asArray()[batchNormalization.output.asArray().length - 1] == 0 ? 1: batchNormalization.output.asArray()[batchNormalization.output.asArray().length - 1])
                            .add("eps", batchNormalization.eps)
                            .add("momentum", batchNormalization.momentum);
            case FlattenLayerView flatten ->
                    builder.add("from_dim", flatten.toDimension)
                            .add("to_dim", flatten.fromDimension);
            default -> {}
        }
        return builder;
    }

    private FrameBuilder[] reductionsOf(RecurrentLayerView recurrent, String library) {
        return recurrent.reduce.stream()
                .map(reduce -> buildReduceFrame(reduce, recurrent.outputType, library))
                .toArray(FrameBuilder[]::new);
    }

    private static Map<String, String> outputsNames = Map.of("EndSequence", "EndSequence",
            "LastHiddenState", "HiddenStates",
            "LastCellState", "CellStates",
            "HiddenStates", "HiddenStates",
            "CellStates", "CellStates");
    private FrameBuilder buildReduceFrame(RecurrentLayerView.Reduce reduce, RecurrentLayerView.OutputType output, String library) {
        FrameBuilder fb = new FrameBuilder("reduce").add("library", library);
        switch (reduce) {
            case SliceReduce slicing ->
                    fb.add("slicing", true)
                            .add("from", slicing.from)
                            .add("to", slicing.to + 1);
            case RecurrentLayerView.Reduce.LinearReduce linear ->
                    fb.add("linear", true)
                            .add("in_features", linear.previousOutputView.asArray()[linear.dimensionToActOn - 1])
                            .add("out_features", linear.outputView.asArray()[linear.dimensionToActOn - 1])
                            .add("dimension", linear.dimensionToActOn)
                            .add("bias", "True");
            case RecurrentLayerView.Reduce.FlattenReduce flatten ->
                    fb.add("flatten", true)
                            .add("from", flatten.startDimension)
                            .add("to", flatten.endDimension);
            default -> {}
        }
        return fb;
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
