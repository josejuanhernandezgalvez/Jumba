package io.flogo.builder.operations;

import io.flogo.builder.model.architecture.ArchitectureView;
import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.SectionView;
import io.intino.itrules.FrameBuilder;

import java.util.List;

public class ArchitectureRenderer {
    public String render(ArchitectureView architecture, String library) {
        FrameBuilder builder = new FrameBuilder("architecture").add("library", library);
        builder.add("section", sectionsOf(architecture, library));
        builder.add("block", blocksOf(architecture, library));
        builder.add("layer", layersOf(architecture, library));
        return new ArchitectureTemplate().render(builder);
    }

    private FrameBuilder[] layersOf(ArchitectureView architecture, String library) {
        return architecture.sections().stream()
                .map(SectionView::blocks)
                .flatMap(List::stream)
                .map(BlockView::layerViews)
                .flatMap(List::stream)
                .map(layer -> buildLayerFrame(library, layer))
                .toArray(FrameBuilder[]::new);
    }

    private FrameBuilder buildLayerFrame(String library, LayerView layer) {
        return new FrameBuilder("layer").add("library", library).add("type", typeOf(layer.getClass().getSimpleName()));
    }

    private FrameBuilder[] sectionsOf(ArchitectureView architecture, String library) {
        return architecture.sections().stream()
                .map(section -> buildSectionFrame(library, section))
                .toArray(FrameBuilder[]::new);
    }

    private FrameBuilder[] blocksOf(ArchitectureView architecture, String library) {
        return architecture.sections().stream()
                .map(SectionView::blocks)
                .flatMap(List::stream)
                .map(block -> buildBlockFrame(library, block))
                .toArray(FrameBuilder[]::new);
    }

    private FrameBuilder buildBlockFrame(String library, BlockView block) {
        FrameBuilder fb = new FrameBuilder("block").add("library", library).add("type", "Linear");
        FrameBuilder[] layers = block.layerViews().stream()
                .map(layer -> buildLayerFrame(library, layer))
                .toArray(FrameBuilder[]::new);
        fb.add("layer", layers);
        return fb;
    }

    private FrameBuilder buildSectionFrame(String library, SectionView section) {
        FrameBuilder fb = new FrameBuilder("section").add("library", library).add("type", typeOf(section.getClass().getSimpleName()));
        FrameBuilder[] blocks = section.blocks().stream()
                .map(block -> buildBlockFrame(library, block))
                .toArray(FrameBuilder[]::new);
        fb.add("block", blocks);
        return fb;
    }

    private String typeOf(String view) {
        String component = view.substring(0, view.indexOf("View"));
        for (int i = component.length() - 1; i > 0; i--) {
            if (Character.isUpperCase(component.charAt(i))) return component.substring(0, i);
        }
        return component;
    }
}
