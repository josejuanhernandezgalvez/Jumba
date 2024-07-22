package io.jumba.builder.model.renderers.architecture.sectionrenderers;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.model.architecture.BlockView;
import io.jumba.builder.model.architecture.LayerView;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.blocks.SimpleBlockView;
import io.jumba.builder.model.architecture.sections.processing.LinearSectionView;
import io.jumba.builder.model.renderers.architecture.SectionRenderer;
import io.jumba.builder.model.renderers.architecture.blockrenderers.ResidualBlockRenderer;
import io.jumba.model.LinearSection;
import io.jumba.model.LinearSection.Block;
import io.jumba.model.Section;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinearSectionRenderer extends SectionRenderer<LinearSectionView> {

    @Override
    public LinearSectionView render(Section section, OutputView input, CompilationContext context) {
        return renderSection(cast(section), input, context);
    }

    public LinearSectionView renderSection(LinearSection section, OutputView input, CompilationContext context) {
        return new LinearSectionView(blockViews(section.sectionBlockList().iterator(), input, new ArrayList<>(), context), input);
    }

    private List<BlockView> blockViews(Iterator<LinearSection.SectionBlock> blockIterator, OutputView input, ArrayList<BlockView> blockViews, CompilationContext context) {
        if (!blockIterator.hasNext()) return blockViews;
        blockViews.add(new BlockRenderer().render(blockIterator.next(), input, context));
        return blockViews(blockIterator, blockViews.getLast().output(), blockViews, context);
    }

    private class BlockRenderer {
        public BlockView render(LinearSection.SectionBlock block, OutputView input, CompilationContext context) {
            if (block instanceof Block customBlock) return blockViewFor(blockLayerList(customBlock.layerList().iterator(), input, new ArrayList<>(), context), customBlock, input, context);
            return null;
        }

        private BlockView blockViewFor(List<LayerView> layerViewList, Block block, OutputView input, CompilationContext context) {
            try {
                if (block.isResidual()) return new ResidualBlockRenderer().render(layerViewList, block, input, context);
                return SimpleBlockView.from(layerViewList);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private List<LayerView> blockLayerList(Iterator<Block.Layer> layersIterator, OutputView input, List<LayerView> layerViews, CompilationContext context) {
            if (!layersIterator.hasNext()) return layerViews;
            layerViews.add(LinearSectionRenderer.this.render(layersIterator.next(), input, context));
            return blockLayerList(layersIterator, layerViews.getLast().getOutputView(), layerViews, context);
        }

    }

    private LinearSection cast(Section section) {
        return (LinearSection) section;
    }
}
