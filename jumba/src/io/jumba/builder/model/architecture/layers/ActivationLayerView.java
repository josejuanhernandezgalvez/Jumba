package io.jumba.builder.model.architecture.layers;

import io.jumba.builder.model.architecture.LayerView;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.layers.activation.*;

public interface ActivationLayerView extends LayerView {
    static ActivationLayerView from(String name, OutputView outputView) {
        return switch (name) {
            case "ELU" -> new ELULayerView(1, outputView);
            case "GELU" -> new GELULayerView(outputView);
            case "GLU" -> new GLULayerView(outputView);
            case "LeakyReLU" -> new LeakyReLULayerView(1, outputView);
            case "LogSigmoid" -> new LogSigmoidLayerView(outputView);
            case "Mish" -> new MishLayerView(outputView);
            case "ReLU" -> new ReLULayerView(outputView);
            case "SELU" -> new SELULayerView(outputView);
            case "Sigmoid" -> new SigmoidLayerView(outputView);
            case "SiLU" -> new SiLULayerView(outputView);
            case "Softmax" -> new SoftmaxLayerView(outputView);
            case "Tanh" -> new TanhLayerView(outputView);
            case null, default -> throw new RuntimeException();
        };
    }

}
