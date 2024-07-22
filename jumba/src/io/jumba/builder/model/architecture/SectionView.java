package io.jumba.builder.model.architecture;

import java.util.List;

public interface SectionView {
    List<BlockView> blocks();

    OutputView output();

    OutputView input();

}
