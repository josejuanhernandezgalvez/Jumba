package io.flogo.model.rules;

import io.intino.tara.language.model.Mogram;
import io.intino.tara.language.model.rules.MogramRule;

public class CheckRecurrentSectionOutputType implements MogramRule {
    private final static String[] validSectionOutput = {"lastOutput", "cellStates", "hiddenStates"};

    public boolean accept(Mogram mogram) {
        return isValid(mogram);
    }

    private static boolean isValid(Mogram mogram) {
        for (String sectionOutput : validSectionOutput)
            if (sectionOutput.equals(mogram.parameters().get(0).values().get(0))) return true;
        return false;
    }
}
