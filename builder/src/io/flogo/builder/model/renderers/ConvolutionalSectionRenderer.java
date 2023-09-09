package io.flogo.builder.model.renderers;

import io.flogo.blatt.model.ConvolutionalSection;
import io.flogo.blatt.model.Section;
import io.flogo.builder.model.views.SectionView;
import io.flogo.builder.model.views.blocks.processing.ConvolutionalBlockView;
import io.flogo.builder.model.views.sections.processing.ConvolutionalSectionView;

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
        return new ConvolutionalBlockView(block.layerList().stream().map(this::processEach).toList());
    }

}
