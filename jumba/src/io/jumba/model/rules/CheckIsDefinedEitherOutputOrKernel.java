package io.jumba.model.rules;

import io.intino.tara.language.model.Mogram;
import io.intino.tara.language.model.rules.MogramRule;

public class CheckIsDefinedEitherOutputOrKernel implements MogramRule {


    public boolean accept(Mogram mogram) {
        if (mogram.components().size() == 2) return parameters(mogram, 0) && parameters(mogram, 1);
        if (mogram.components().size() == 1) return mogram.components().get(0).type().endsWith("Output") || (mogram.type().contains("Pool") && mogram.components().getFirst().type().contains("Kernel"));
        return false;
    }

    private static boolean parameters(Mogram mogram, int index) {
        return mogram.components().get(index).type().endsWith("Kernel") || mogram.components().get(index).type().endsWith("OutChannels");
    }
}
