package io.jumba.model.rules;

import io.intino.tara.language.model.Mogram;
import io.intino.tara.language.model.rules.MogramRule;

public class CheckCustomDownSampling implements MogramRule {


    public boolean accept(Mogram node) {
        return false;
    }
}
