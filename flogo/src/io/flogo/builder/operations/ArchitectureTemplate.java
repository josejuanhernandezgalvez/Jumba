package io.flogo.builder.operations;

import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;

import java.util.ArrayList;
import java.util.List;

import static io.intino.itrules.template.condition.predicates.Predicates.*;
import static io.intino.itrules.template.outputs.Outputs.*;

public class ArchitectureTemplate extends Template {

	public List<Rule> ruleSet() {
		List<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(allTypes("architecture")).output(literal("from implementations.")).output(placeholder("library")).output(literal(".architecture.architecture import ")).output(placeholder("library", "FirstUppercase")).output(literal("Architecture as Architecture\n")).output(placeholder("import")).output(literal("\n\narchitecture = (Architecture(\"")).output(placeholder("name")).output(literal("\")\n                    ")).output(placeholder("component").multiple("\n")).output(literal(")")));
		rules.add(rule().condition(allTypes("import")).output(placeholder("section", "import").multiple("\n")).output(literal("\n")).output(placeholder("block", "import").multiple("\n")).output(literal("\n")).output(placeholder("layer", "import").multiple("\n")));
		rules.add(rule().condition(all(allTypes("component"), attribute("section"))).output(literal(".attach(")).output(placeholder("section")).output(literal(")")));
		rules.add(rule().condition(all(allTypes("component"), attribute("layer"))).output(literal(".attach(")).output(placeholder("layer")).output(literal(")")));
		rules.add(rule().condition(all(allTypes("section"), trigger("import"))).output(literal("from implementations.")).output(placeholder("library")).output(literal(".architecture.sections.")).output(placeholder("type", "Lowercase")).output(literal(" import ")).output(placeholder("library", "FirstUppercase")).output(placeholder("type")).output(literal("Section as ")).output(placeholder("type", "CamelCase")).output(literal("Section")));
		rules.add(rule().condition(all(all(allTypes("block"), trigger("import")), attribute("type"))).output(literal("from implementations.")).output(placeholder("library")).output(literal(".architecture.blocks.")).output(placeholder("type", "Lowercase")).output(literal(" import ")).output(placeholder("library", "FirstUppercase")).output(placeholder("type")).output(literal("Block as ")).output(placeholder("type", "CamelCase")).output(literal("Block")));
		rules.add(rule().condition(all(allTypes("block"), trigger("import"))).output(literal("from implementations.")).output(placeholder("library")).output(literal(".architecture.block import ")).output(placeholder("library", "FirstUppercase")).output(literal("Block as Block")));
		rules.add(rule().condition(all(all(all(allTypes("layer"), trigger("import")), attribute("package")), attribute("dimensionality"))).output(literal("from implementations.")).output(placeholder("library")).output(literal(".architecture.layers.")).output(placeholder("package")).output(literal(".")).output(placeholder("type", "Lowercase")).output(literal(" import ")).output(placeholder("library", "FirstUppercase")).output(placeholder("dimensionality")).output(literal("Dimensional")).output(placeholder("type")).output(literal("Layer as ")).output(placeholder("type")).output(literal("Layer")));
		rules.add(rule().condition(all(all(all(allTypes("layer"), trigger("import")), attribute("package")), attribute("reduce"))).output(literal("from implementations.")).output(placeholder("library")).output(literal(".architecture.layers.")).output(placeholder("package")).output(literal(".")).output(placeholder("type", "Lowercase")).output(literal(" import ")).output(placeholder("library", "FirstUppercase")).output(placeholder("type")).output(literal("Layer as ")).output(placeholder("type")).output(literal("Layer\n")).output(placeholder("reduce", "import").multiple("")));
		rules.add(rule().condition(all(all(allTypes("layer"), trigger("import")), attribute("package"))).output(literal("from implementations.")).output(placeholder("library")).output(literal(".architecture.layers.")).output(placeholder("package")).output(literal(".")).output(placeholder("type", "Lowercase")).output(literal(" import ")).output(placeholder("library", "FirstUppercase")).output(placeholder("type")).output(literal("Layer as ")).output(placeholder("type")).output(literal("Layer")));
		rules.add(rule().condition(all(all(allTypes("layer"), trigger("import")), attribute("dimensionality"))).output(literal("from implementations.")).output(placeholder("library")).output(literal(".architecture.layers.")).output(placeholder("type", "Lowercase")).output(literal(" import ")).output(placeholder("library", "FirstUppercase")).output(placeholder("dimensionality")).output(literal("Dimensional")).output(placeholder("type")).output(literal("Layer as ")).output(placeholder("type")).output(literal("Layer")));
		rules.add(rule().condition(all(allTypes("layer"), trigger("import"))).output(literal("from implementations.")).output(placeholder("library")).output(literal(".architecture.layers.")).output(placeholder("type", "Lowercase")).output(literal(" import ")).output(placeholder("library", "FirstUppercase")).output(placeholder("type")).output(literal("Layer as ")).output(placeholder("type")).output(literal("Layer")));
		rules.add(rule().condition(all(all(allTypes("reduce"), trigger("import")), attribute("linear"))));
		rules.add(rule().condition(all(all(allTypes("reduce"), trigger("import")), attribute("flatten"))));
		rules.add(rule().condition(allTypes("section")).output(placeholder("type", "CamelCase")).output(literal("Section([\n            ")).output(placeholder("block").multiple(", \n")).output(literal("\n])")));
		rules.add(rule().condition(all(allTypes("block"), attribute("type"))).output(placeholder("type", "CamelCase")).output(literal("Block([\n    ")).output(placeholder("layer").multiple(", \n")).output(literal("\n])")));
		rules.add(rule().condition(allTypes("block")).output(literal("Block([\n    ")).output(placeholder("layer").multiple(", \n")).output(literal("\n])")));
		rules.add(rule().condition(allTypes("kernel|stride|padding")).output(literal("(")).output(placeholder("dimension").multiple(", ")).output(literal(")")));
		rules.add(rule().condition(allTypes("Linear", "layer")).output(placeholder("type")).output(literal("Layer(in_features=")).output(placeholder("in_features")).output(literal(", out_features=")).output(placeholder("out_features")).output(literal(", dimension=")).output(placeholder("dimension")).output(literal(", bias=")).output(placeholder("bias")).output(literal(")")));
		rules.add(rule().condition(allTypes("Convolutional", "layer")).output(placeholder("type")).output(literal("Layer(in_channels=")).output(placeholder("in_channels")).output(literal(", out_channels=")).output(placeholder("out_channels")).output(literal(", kernel=")).output(placeholder("kernel")).output(literal(", stride=")).output(placeholder("stride")).output(literal(", padding=")).output(placeholder("padding")).output(literal(")")));
		rules.add(rule().condition(all(any(allTypes("MaxPool"), allTypes("AvgPool")), allTypes("layer"))).output(placeholder("type")).output(literal("Layer(kernel=")).output(placeholder("kernel")).output(literal(", stride=")).output(placeholder("stride")).output(literal(", padding=")).output(placeholder("padding")).output(literal(")")));
		rules.add(rule().condition(all(allTypes("LSTM|RNN|GRU"), allTypes("layer"))).output(placeholder("type")).output(literal("Layer(input_size=")).output(placeholder("input")).output(literal(", hidden_size=")).output(placeholder("hidden")).output(literal(", output_type=")).output(placeholder("type")).output(literal("Layer.OutputType.")).output(placeholder("output")).output(literal(", num_layer=")).output(placeholder("num_layers")).output(literal(", bidirectional=")).output(placeholder("bidirectional", "FirstUpperCase")).output(literal(", dropout=")).output(placeholder("dropout")).output(literal("),\n")).output(placeholder("reduce").multiple(", \n")));
		rules.add(rule().condition(all(allTypes("reduce"), attribute("slicing"))).output(literal("SlicingLayer(start=")).output(placeholder("from")).output(literal(", end=")).output(placeholder("to")).output(literal(")")));
		rules.add(rule().condition(all(allTypes("reduce"), attribute("linear"))).output(literal("LinearLayer(in_features=")).output(placeholder("in_features")).output(literal(", out_features=")).output(placeholder("out_features")).output(literal(", dimension=")).output(placeholder("dimension")).output(literal(", bias=")).output(placeholder("bias")).output(literal(")")));
		rules.add(rule().condition(all(allTypes("reduce"), attribute("flatten"))).output(literal("FlattenLayer(from_dim=")).output(placeholder("from")).output(literal(", to_dim=")).output(placeholder("to")).output(literal(")")));
		rules.add(rule().condition(allTypes("ELU", "layer")).output(placeholder("type")).output(literal("Layer(alpha=")).output(placeholder("alpha")).output(literal(")")));
		rules.add(rule().condition(allTypes("LeakyReLU", "layer")).output(placeholder("type")).output(literal("Layer(negative_slope=")).output(placeholder("slope")).output(literal(")")));
		rules.add(rule().condition(allTypes("Softmax", "layer")).output(placeholder("type")).output(literal("Layer(dimension=")).output(placeholder("dimension")).output(literal(")")));
		rules.add(rule().condition(allTypes("BatchNormalization", "layer")).output(placeholder("type")).output(literal("Layer(num_features=")).output(placeholder("num_features")).output(literal(", eps=")).output(placeholder("eps")).output(literal(", momentum=")).output(placeholder("momentum")).output(literal(")")));
		rules.add(rule().condition(allTypes("LayerNormalization", "layer")).output(placeholder("type")).output(literal("Layer(normalized_shape=")).output(placeholder("shape")).output(literal(", eps=")).output(placeholder("eps")).output(literal(")")));
		rules.add(rule().condition(allTypes("Dropout", "layer")).output(placeholder("type")).output(literal("Layer(probability=")).output(placeholder("probability")).output(literal(")")));
		rules.add(rule().condition(allTypes("Flatten", "layer")).output(placeholder("type")).output(literal("Layer(from_dim=")).output(placeholder("from_dim")).output(literal(", to_dim=")).output(placeholder("to_dim")).output(literal(")")));
		rules.add(rule().condition(allTypes("layer")).output(placeholder("type")).output(literal("Layer()")));
		return rules;
	}

	public String render(Object object) {
		return new io.intino.itrules.Engine(this).render(object);
	}

	public String render(Object object, java.util.Map<String, io.intino.itrules.Formatter> formatters) {
		return new io.intino.itrules.Engine(this).addAll(formatters).render(object);
	}
}