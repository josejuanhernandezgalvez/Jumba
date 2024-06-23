package io.flogo.builder.model.architecture;

import io.flogo.builder.CompilationContext;

public interface LayerView {
    OutputView getOutputView();

    LayerView from(OutputView previous, CompilationContext context);

}
