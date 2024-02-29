package io.flogo.model.rules;

import io.intino.tara.language.model.Mogram;
import io.intino.tara.language.model.rules.NodeRule;

public class CheckFirstSectionWithInput implements NodeRule {

    public boolean accept(Mogram mogram) {
        return theFirstSectionMustHaveAnInputComponent(mogram);
    }

    private static boolean theFirstSectionMustHaveAnInputComponent(Mogram mogram) {
        return mogram.container().components()
                .get(0).components()
                .get(0).type()
                .endsWith("Input");
    }
}
