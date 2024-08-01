package io.jumba.builder.model.architecture;

import io.jumba.model.Section;

import java.util.List;

public interface SectionView {
    List<BlockView> blocks();
    OutputView output();
    OutputView input();

    static Boolean getMutable(Section section) {
        return false;
    }

}
