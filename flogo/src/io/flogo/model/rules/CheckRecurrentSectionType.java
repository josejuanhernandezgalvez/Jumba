package io.flogo.model.rules;

import io.intino.tara.language.model.Mogram;
import io.intino.tara.language.model.rules.NodeRule;

public class CheckRecurrentSectionType implements NodeRule {
    private static final String[] allowedTypes = {"LSTM", "GRU", "RNN"};
    private static String LSTM = "LSTM";

    public boolean accept(Mogram mogram) {
        boolean result = false;
        for (String allowedType : allowedTypes)
            result = result || type(mogram).equals(allowedType);
        return result;
    }

    private static String type(Mogram mogram) {
        Mogram componentType = null;
        for (Mogram component : mogram.container().components())
            if (component.type().endsWith("Type")) componentType = component;
        return componentType != null ? (String) componentType.parameters().getFirst().values().getFirst() : LSTM;
    }
}
