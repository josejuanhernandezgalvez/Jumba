package io.flogo.builder.model.renderers.sections;

import io.flogo.model.ConvolutionalSection;
import io.flogo.model.Section;
import io.flogo.builder.model.architecture.SectionView;
import io.flogo.builder.model.architecture.blocks.processing.ConvolutionalBlockView;
import io.flogo.builder.model.architecture.sections.processing.ConvolutionalSectionView;

public class ConvolutionalSectionRenderer extends ProcessingSectionRenderer {
    @Override
    public SectionView render(Section section) {
        return new ConvolutionalSectionView(((ConvolutionalSection) section)
                .blockList()
                .stream()
                .map(this::processEach)
                .toList());
    }

    private ConvolutionalBlockView processEach(ConvolutionalSection.Block block) {
        return new ConvolutionalBlockView(block.layerList().stream().map(layerRenderer::process).toList());
    }

}
