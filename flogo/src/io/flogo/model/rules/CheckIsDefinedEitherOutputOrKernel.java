package io.flogo.model.rules;

import io.intino.tara.language.model.Mogram;
import io.intino.tara.language.model.rules.MogramRule;

public class CheckIsDefinedEitherOutputOrKernel implements MogramRule {


    public boolean accept(Mogram node) {
        return false;
    }
}
