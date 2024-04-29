package io.flogo.builder.model.renderers.architecture.sectionrenderers;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.blocks.ResidualBlockView;
import io.flogo.builder.model.architecture.blocks.ResidualBlockView.ShorcutView;
import io.flogo.builder.model.architecture.blocks.SimpleBlockView;
import io.flogo.builder.model.architecture.sections.processing.LinearSectionView;
import io.flogo.builder.model.renderers.architecture.SectionRenderer;
import io.flogo.model.LinearSection;
import io.flogo.model.LinearSection.Block;
import io.flogo.model.Section;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinearSectionRenderer extends SectionRenderer<LinearSectionView> {

    @Override
    public LinearSectionView render(Section section, OutputView input) {
        return renderSection(cast(section), input);
    }

    public LinearSectionView renderSection(LinearSection section, OutputView input) {
        return new LinearSectionView(blockViews(section.blockList().iterator(), input, new ArrayList<>()), input);
    }

    private List<BlockView> blockViews(Iterator<Block> blockIterator, OutputView input, ArrayList<BlockView> blockViews) {
        if (!blockIterator.hasNext()) return blockViews;
        Block nextBlock = blockIterator.next();
        blockViews.add(blockViewFor(blockLayerList(nextBlock.layerList().iterator(), input, new ArrayList<>()), nextBlock, input));
        return blockViews(blockIterator, blockViews.getLast().output(), blockViews);
    }

    private List<LayerView> blockLayerList(Iterator<Block.Layer> layersIterator, OutputView input, List<LayerView> layerViews) {
        if (!layersIterator.hasNext()) return layerViews;
        layerViews.add(render(layersIterator.next(), input));
        return blockLayerList(layersIterator, layerViews.getLast().getOutputView(), layerViews);
    }

    private BlockView blockViewFor(List<LayerView> layerViewList, Block block, OutputView input) {
        try {
            if (block.isResidual()) return ResidualBlockView.from(layerViewList, residualConnectionView(layerViewList, block, input));
            return SimpleBlockView.from(layerViewList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private ShorcutView residualConnectionView(List<LayerView> layerViewList, LinearSection.Block block, OutputView inputView) {
        if (!block.asResidual().shortcut().toString().equals("Custom")) return ShorcutView.from(block.asResidual().shortcut().toString(), inputView, layerViewList.getLast().getOutputView());
        return ShorcutView.from(customDownSamplingLayerList((block.asResidual().customShortcut().layerList()).iterator(), inputView, new ArrayList<>()), layerViewList.getLast().getOutputView());
    }

    private List<LayerView> customDownSamplingLayerList(Iterator<Block.Residual.CustomShortcut.Layer> layersIterator, OutputView input, List<LayerView> layerViews) {
        if (!layersIterator.hasNext()) return layerViews;
        layerViews.add(render(layersIterator.next(), input));
        return customDownSamplingLayerList(layersIterator, layerViews.getLast().getOutputView(), layerViews);
    }


    private LinearSection cast(Section section) {
        return (LinearSection) section;
    }
}
