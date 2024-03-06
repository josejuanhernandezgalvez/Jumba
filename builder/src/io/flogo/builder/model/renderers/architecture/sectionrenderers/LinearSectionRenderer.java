package io.flogo.builder.model.renderers.architecture.sectionrenderers;

import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
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
        return new LinearSectionView(blockViews(section.blockList().iterator(), input, new ArrayList<>()));
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

    private LinearSection cast(Section section) {
        return (LinearSection) section;
    }
}
