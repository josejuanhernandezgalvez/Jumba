package io.flogo.builder.model.architecture.layers.processing;

import io.flogo.model.ConvolutionalSection;
import io.flogo.builder.model.architecture.Output;
import io.flogo.builder.model.architecture.layers.ProcessingLayerView;
import io.intino.magritte.framework.Layer;

public record DropoutLayerView(double probability, Output output) implements ProcessingLayerView{
    public static ProcessingLayerView from(Layer layer, Output previousOutput) {
        return new DropoutLayerView(((ConvolutionalSection.Block.Dropout) layer).probability(), previousOutput);
    }

    @Override
    public Output getLayerOutput() {
        return output;
    }
}
