package io.flogo.builder.model.renderers.architecture.sectionrenderers;

import io.flogo.builder.CompilationContext;
import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.blocks.SimpleBlockView;
import io.flogo.builder.model.architecture.sections.processing.ConvolutionalSectionView;
import io.flogo.builder.model.renderers.architecture.SectionRenderer;
import io.flogo.builder.model.renderers.architecture.blockrenderers.ResidualBlockRenderer;
import io.flogo.model.ConvolutionalSection;
import io.flogo.model.Section;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConvolutionalSectionRenderer extends SectionRenderer<ConvolutionalSectionView> {

    @Override
    public ConvolutionalSectionView render(Section section, OutputView input, CompilationContext context) {
        return renderSection(cast(section), input, context);
    }

    public ConvolutionalSectionView renderSection(ConvolutionalSection section, OutputView input, CompilationContext context) {
        return new ConvolutionalSectionView(blockViews(section.sectionBlockList().iterator(), input, new ArrayList<>(), context), input);
    }

    private List<BlockView> blockViews(Iterator<ConvolutionalSection.SectionBlock> blockIterator, OutputView input, ArrayList<BlockView> blockViews, CompilationContext context) {
        if (!blockIterator.hasNext()) return blockViews;
        blockViews.add(new BlockRenderer().render(blockIterator.next(), input, context));
        return blockViews(blockIterator, blockViews.getLast().output(), blockViews, context);
    }

    private class BlockRenderer {
        public BlockView render(ConvolutionalSection.SectionBlock block, OutputView input, CompilationContext context) {
            if (block instanceof ConvolutionalSection.Block customBlock) return blockViewFor(blockLayerList(customBlock.layerList().iterator(), input, new ArrayList<>(), context), customBlock, input, context);
            return null;
        }

        private List<LayerView> blockLayerList(Iterator<ConvolutionalSection.Block.Layer> layersIterator, OutputView input, List<LayerView> layerViews, CompilationContext context) {
            if (!layersIterator.hasNext()) return layerViews;
            layerViews.add(ConvolutionalSectionRenderer.this.render(layersIterator.next(), input, context));
            return blockLayerList(layersIterator, layerViews.getLast().getOutputView(), layerViews, context);
        }

        private BlockView blockViewFor(List<LayerView> layerViewList, ConvolutionalSection.Block block, OutputView input, CompilationContext context) {
            try {
                if (block.isResidual()) return new ResidualBlockRenderer().render(layerViewList, block, input, context);
                return SimpleBlockView.from(layerViewList);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private ConvolutionalSection cast(Section section) {
        return (ConvolutionalSection) section;
    }
}
