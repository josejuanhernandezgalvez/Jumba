package io.flogo.builder.model.renderers.architecture.sectionrenderers;

import io.flogo.builder.CompilationContext;
import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.blocks.ResidualBlockView;
import io.flogo.builder.model.architecture.blocks.ResidualBlockView.ShortcutView;
import io.flogo.builder.model.architecture.blocks.SimpleBlockView;
import io.flogo.builder.model.architecture.sections.processing.ConvolutionalSectionView;
import io.flogo.builder.model.renderers.architecture.SectionRenderer;
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
        return new ConvolutionalSectionView(blockViews(section.blockList().iterator(), input, new ArrayList<>(), context), input);
    }

    private List<BlockView> blockViews(Iterator<ConvolutionalSection.Block> blockIterator, OutputView input, ArrayList<BlockView> blockViews, CompilationContext context) {
        if (!blockIterator.hasNext()) return blockViews;
        ConvolutionalSection.Block nextBlock = blockIterator.next();
        blockViews.add(blockViewFor(blockLayerList(nextBlock.layerList().iterator(), input, new ArrayList<>(), context), nextBlock, input, context));
        return blockViews(blockIterator, blockViews.getLast().output(), blockViews, context);
    }

    private BlockView blockViewFor(List<LayerView> layerViewList, ConvolutionalSection.Block block, OutputView input, CompilationContext context) {
        try {
            if (block.isResidual()) return new ResidualBlockRenderer().render(layerViewList, block, input, context);
            return SimpleBlockView.from(layerViewList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<LayerView> blockLayerList(Iterator<ConvolutionalSection.Block.Layer> layersIterator, OutputView input, List<LayerView> layerViews, CompilationContext context) {
        if (!layersIterator.hasNext()) return layerViews;
        layerViews.add(render(layersIterator.next(), input, context));
        return blockLayerList(layersIterator, layerViews.getLast().getOutputView(), layerViews, context);
    }

    private ConvolutionalSection cast(Section section) {
        return (ConvolutionalSection) section;
    }

    private class ResidualBlockRenderer {
        public ResidualBlockView render(List<LayerView> layerViewList, ConvolutionalSection.Block block, OutputView input, CompilationContext context) {
            return ResidualBlockView.from(layerViewList, residualConnectionView(layerViewList, block, input, context));
        }

        private ShortcutView residualConnectionView(List<LayerView> layerViewList, ConvolutionalSection.Block block, OutputView inputView, CompilationContext context) {
            if (!block.asResidual().shortcut().toString().equals("Custom")) return ShortcutView.from(block.asResidual().shortcut().toString(), inputView, layerViewList.getLast().getOutputView());
            return ShortcutView.from(customDownSamplingLayerList((block.asResidual().customShortcut().layerList()).iterator(), inputView, new ArrayList<>(), context), layerViewList.getLast().getOutputView());
        }

        private List<LayerView> customDownSamplingLayerList(Iterator<ConvolutionalSection.Block.Residual.CustomShortcut.Layer> layersIterator, OutputView input, List<LayerView> layerViews, CompilationContext context) {
            if (!layersIterator.hasNext()) return layerViews;
            layerViews.add(ConvolutionalSectionRenderer.this.render(layersIterator.next(), input, context));
            return customDownSamplingLayerList(layersIterator, layerViews.getLast().getOutputView(), layerViews, context);
        }
    }
}
