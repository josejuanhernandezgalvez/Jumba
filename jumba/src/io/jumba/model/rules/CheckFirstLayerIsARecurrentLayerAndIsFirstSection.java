package io.jumba.model.rules;

import io.intino.tara.language.model.Mogram;
import io.intino.tara.language.model.rules.MogramRule;

public class CheckFirstLayerIsARecurrentLayerAndIsFirstSection implements MogramRule {


    public boolean accept(Mogram node) {
        try {
            return node.container().components().get(0).components().get(0).type().contains("Input") &&
                    (isARecurrentLayer(node.container().components().get(0).components().get(1).components().get(0).type(), "RNN") ||
                            isARecurrentLayer(node.container().components().get(0).components().get(1).components().get(0).type(), "LSTM") ||
                            isARecurrentLayer(node.container().components().get(0).components().get(1).components().get(0).type(), "GRU"));
        }
        catch (Exception e) {
            return false;
        }
    }

    private static boolean isARecurrentLayer(String recurrentLayer, String name) {
        return recurrentLayer.endsWith(name);
    }
}
