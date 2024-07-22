package io.jumba.builder.model.architecture.sections.link;

import io.jumba.builder.model.architecture.BlockView;
import io.jumba.builder.model.architecture.LayerView;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.SectionView;

import java.util.ArrayList;
import java.util.List;

public class FlattenSectionView implements SectionView {
    public final List<BlockView> blocks;
    public final List<LayerView> layerViews;
    public final OutputView input;

    public FlattenSectionView(List<BlockView> block, OutputView input) {
        this.blocks = block;
        this.layerViews = layers();
        this.input = input;
    }

    private List<LayerView> layers() {
        return blocks.getFirst().layerViews();
    }

    @Override
    public List<BlockView> blocks() {
        return new ArrayList<>(blocks);
    }

    @Override
    public OutputView output() {
        return blocks.getLast().output();
    }

    @Override
    public OutputView input() {
        return input;
    }
}
