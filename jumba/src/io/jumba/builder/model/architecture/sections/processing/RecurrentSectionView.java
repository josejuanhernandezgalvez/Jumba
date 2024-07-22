package io.jumba.builder.model.architecture.sections.processing;

import io.jumba.builder.model.architecture.BlockView;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.SectionView;

import java.util.ArrayList;
import java.util.List;

public class RecurrentSectionView implements SectionView {
    public final List<BlockView> simpleBlockViews;
    private final OutputView input;

    public RecurrentSectionView(List<BlockView> simpleBlockViews, OutputView input) {
        this.simpleBlockViews = simpleBlockViews;
        this.input = input;
    }

    @Override
    public List<BlockView> blocks() {
        return new ArrayList<>(simpleBlockViews);
    }

    @Override
    public OutputView output() {
        return simpleBlockViews.getLast().output();
    }

    @Override
    public OutputView input() {
        return input;
    }
}
