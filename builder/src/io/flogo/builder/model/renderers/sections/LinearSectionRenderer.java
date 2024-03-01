package io.flogo.builder.model.renderers.sections;

import io.flogo.model.LinearSection;
import io.flogo.model.Section;
import io.flogo.builder.model.architecture.SectionView;
import io.flogo.builder.model.architecture.blocks.processing.LinearBlockView;
import io.flogo.builder.model.architecture.sections.processing.LinearSectionView;

public class LinearSectionRenderer extends ProcessingSectionRenderer {
    @Override
    public SectionView render(Section section) {
        return new LinearSectionView(((LinearSection) section)
                .blockList()
                .stream()
                .map(this::processEach)
                .toList());
    }

    private LinearBlockView processEach(LinearSection.Block block) {
        return new LinearBlockView(block.layerList().stream().map(layerRenderer::process).toList());
    }

}
