package io.flogo.model.rules;

import io.intino.tara.language.model.Mogram;
import io.intino.tara.language.model.rules.NodeRule;

public class CheckIsDefinedEitherOutputOrKernel implements NodeRule {


    public boolean accept(Mogram node) {
        return false;
    }
}
