package io.flogo.builder.model.renderers.architecture.sectionrenderers;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.blocks.ResidualBlockView;
import io.flogo.builder.model.architecture.blocks.SimpleBlockView;
import io.flogo.builder.model.architecture.layers.VLayerView;
import io.flogo.builder.model.architecture.layers.output.UndeterminedOutputView;
import io.flogo.builder.model.architecture.layers.processing.LinearLayerView;
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

    private BlockView blockViewFor(List<LayerView> layerViewList, Block block, OutputView input) {
        try {
            return (BlockView) (block.isResidual() ? ResidualBlockView.class : SimpleBlockView.class).getMethod("from", List.class, List.class)
                    .invoke(null, layerViewList, facetLayerViews(input, block, layerViewList.getLast()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<LayerView> facetLayerViews(OutputView input, Block block, LayerView layerView) {
        if (block.isResidual()) return residualConnection(input, block, layerView);
        return null;
    }

    private ArrayList<LayerView> residualConnection(OutputView previousOutput, Block block, LayerView layerView) {
        ArrayList<LayerView> result = new ArrayList<>();
        if (isDefaultResidualConnection(block)) {
            result.add((layerView instanceof VLayerView vLayerView) ? new VLayerView(vLayerView.id, previousOutput, vLayerView.getOutputView()) : new LinearLayerView(previousOutput, layerView.getOutputView()));
            return result;
        }
        for (Block.Residual.CustomDownSampling.Layer layer : block.asResidual().customDownSampling().layerList()) {
            LayerView renderedLayerView = render(layer, previousOutput);
            result.add(renderedLayerView);
            previousOutput = renderedLayerView.getOutputView();
        }
        if (result.getLast().getOutputView().equals(layerView.getOutputView()) || result.getLast().getOutputView() instanceof UndeterminedOutputView || layerView instanceof VLayerView)
            return result;
        result.add(new LinearLayerView(result.getLast().getOutputView(), layerView.getOutputView()));
        return result;
    }

    private static boolean isDefaultResidualConnection(Block block) {
        return block.asResidual().downSampling().name().equals("Default");
    }


    private List<LayerView> blockLayerList(Iterator<Block.Layer> layersIterator, OutputView input, List<LayerView> layerViews) {
        if (!layersIterator.hasNext()) return layerViews;
        layerViews.add(render(layersIterator.next(), input));
        return blockLayerList(layersIterator, layerViews.getLast().getOutputView(), layerViews);
    }

    private LinearSection cast(Section section) {
        return (LinearSection) section;
    }
}
