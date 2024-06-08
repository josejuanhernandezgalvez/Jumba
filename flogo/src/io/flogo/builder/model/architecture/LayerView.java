package io.flogo.builder.model.architecture;

public interface LayerView {
    OutputView getOutputView();

    LayerView from(OutputView previous);

}
