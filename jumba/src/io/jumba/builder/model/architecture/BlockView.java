package io.jumba.builder.model.architecture;

import java.util.List;

public interface BlockView {

    public OutputView output();
    List<LayerView> layerViews();
}