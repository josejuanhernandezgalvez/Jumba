package io.flogo.builder.operations;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class ConvolutionalNetworkTemplate extends Template {

    public RuleSet ruleSet() {
        return new RuleSet().add(
                rule().condition((type("ConvolutionalNetwork"))).output(literal("class ")).output(mark("name")).output(literal("(ConvolutionalSection):")).output(expression().output(literal("\n"))).output(literal("\n    def __init__(self, section):\n        self.section = section\n\n")).output(mark("section").multiple("\n")).output(literal("\n\n")).output(mark("section", "setter").multiple("\n")).output(literal("\n")),
                rule().condition((type("LinearSection")), (trigger("section"))).output(literal("\n")),
                rule().condition((type("LinearSection")), (trigger("setter"))).output(literal("\n"))
        );
    }
}