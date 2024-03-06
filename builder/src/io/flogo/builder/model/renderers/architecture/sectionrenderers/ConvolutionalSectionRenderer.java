package io.flogo.builder.model.renderers.architecture.sectionrenderers;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
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
        return new ConvolutionalSectionView(blockViews(section.blockList().iterator(), input, new ArrayList<>()));
    }

    private List<BlockView> blockViews(Iterator<Block> blockIterator, OutputView input, ArrayList<BlockView> blockViews) {
        if (!blockIterator.hasNext()) return blockViews;
        blockViews.add(block(blockIterator.next().layerList().iterator(), input, new ArrayList<>()));
        return blockViews(blockIterator, blockViews.getLast().output(), blockViews);
    }

    private BlockView block(Iterator<Block.Layer> layersIterator, OutputView input, List<LayerView> layerViews) {
        if (!layersIterator.hasNext()) return new BlockView(layerViews);
        layerViews.add(render(layersIterator.next(), input));
        return block(layersIterator, layerViews.getLast().getOutputView(), layerViews);
    }

    private ConvolutionalSection cast(Section section) {
        return (ConvolutionalSection) section;
    }
}
