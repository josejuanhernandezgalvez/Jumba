package io.flogo.builder.operations;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class ArchitectureTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
				rule().condition((type("architecture"))).output(literal("from implementations.")).output(mark("library")).output(literal(".architecture.architecture import ")).output(mark("library", "FirstUppercase")).output(literal("Architecture as Architecture\n")).output(mark("section", "import").multiple("\n")).output(literal("\n")).output(mark("block", "import").multiple("\n")).output(literal("\n")).output(mark("layer", "import").multiple("\n")).output(literal("\n\narchitecture = (Architecture(\"")).output(mark("name")).output(literal("\")\n                    .attach(")).output(mark("section").multiple(",\n")).output(literal(")")),
				rule().condition((type("section")), (trigger("import"))).output(literal("from implementations.")).output(mark("library")).output(literal(".architecture.sections.")).output(mark("type", "Lowercase")).output(literal(" import ")).output(mark("library", "FirstUppercase")).output(mark("type", "CamelCase")).output(literal("Section as ")).output(mark("type", "CamelCase")).output(literal("Section")),
				rule().condition((type("section"))).output(mark("type", "CamelCase")).output(literal("Section([\n    ")).output(mark("block").multiple(", \n")).output(literal("\n])")),
				rule().condition((type("block")), (trigger("import"))).output(literal("from implementations.")).output(mark("library")).output(literal(".architecture.blocks.")).output(mark("type", "Lowercase")).output(literal(" import ")).output(mark("library", "FirstUppercase")).output(mark("type", "CamelCase")).output(literal("Block as ")).output(mark("type", "CamelCase")).output(literal("Block")),
				rule().condition((type("block"))).output(mark("type", "CamelCase")).output(literal("Block([\n    ")).output(mark("layer").multiple(", \n")).output(literal("\n])")),
				rule().condition((type("layer")), (trigger("import"))).output(literal("from implementations.")).output(mark("library")).output(literal(".architecture.layers.")).output(mark("type", "Lowercase")).output(literal(" import ")).output(mark("library", "FirstUppercase")).output(mark("type")).output(literal("Layer as ")).output(mark("type")).output(literal("Layer")),
				rule().condition((type("layer"))).output(mark("type")).output(literal("Layer()"))
		);
	}
}