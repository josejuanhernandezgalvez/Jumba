package io.jumba.model.rules;

import io.intino.tara.language.model.Mogram;
import io.intino.tara.language.model.Parameter;
import io.intino.tara.language.model.rules.MogramRule;

public class CheckSumIsEqualToOne implements MogramRule {

    public boolean accept(Mogram mogram) {
        double sum = 0;
        for (Parameter parameter : mogram.parameters())
            sum += (double) parameter.values().getFirst() * 10;
        return sum == 10;
    }
}
