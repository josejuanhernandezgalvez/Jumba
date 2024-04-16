package io.flogo.builder.model.renderers.architecture.sectionrenderers;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.blocks.ResidualBlockView;
import io.flogo.builder.model.architecture.blocks.SimpleBlockView;
import io.flogo.builder.model.architecture.sections.processing.ConvolutionalSectionView;
import io.flogo.builder.model.renderers.architecture.SectionRenderer;
import io.flogo.model.ConvolutionalSection;
import io.flogo.model.ConvolutionalSection.Block;
import io.flogo.model.Section;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConvolutionalSectionRenderer extends SectionRenderer<ConvolutionalSectionView> {

    @Override
    public ConvolutionalSectionView render(Section section, OutputView input) {
        return renderSection(cast(section), input);
    }

    public ConvolutionalSectionView renderSection(ConvolutionalSection section, OutputView input) {
        return new ConvolutionalSectionView(blockViews(section.blockList().iterator(), input, new ArrayList<>()), input);
    }

    private List<BlockView> blockViews(Iterator<Block> blockIterator, OutputView input, ArrayList<BlockView> blockViews) {
        if (!blockIterator.hasNext()) return blockViews;
        blockViews.add(block(blockIterator.next().layerList().iterator(), input, new ArrayList<>()));
        return blockViews(blockIterator, blockViews.getLast().output(), blockViews);
    }

    private BlockView block(Iterator<Block.Layer> layersIterator, OutputView input, List<LayerView> layerViews) {
        if (!layersIterator.hasNext()) return new SimpleBlockView(layerViews);
        layerViews.add(render(layersIterator.next(), input));
        return block(layersIterator, layerViews.getLast().getOutputView(), layerViews);
    }

    private BlockView blockView(List<LayerView> layerViewList, ConvolutionalSection.Block block, OutputView input) {
        try {
            return (BlockView) (block.isResidual() ? ResidualBlockView.class : SimpleBlockView.class).getMethod("from", List.class, List.class)
                    .invoke(null, layerViewList, facetLayerViews(input, block, layerViewList.getLast().getOutputView()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<LayerView> facetLayerViews(OutputView input, ConvolutionalSection.Block block, OutputView outputView) {
        return null;
    }


    private ConvolutionalSection cast(Section section) {
        return (ConvolutionalSection) section;
    }
}
