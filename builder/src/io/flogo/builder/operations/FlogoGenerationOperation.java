package io.flogo.builder.operations;

import io.intino.itrules.Frame;
import io.intino.itrules.FrameBuilder;
import io.intino.magritte.builder.core.CompilationUnit;
import io.intino.magritte.builder.core.errorcollection.CompilationFailedException;
import io.intino.magritte.builder.core.operation.model.ModelOperation;
import io.intino.magritte.builder.model.Model;
import io.intino.magritte.lang.model.Node;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FlogoGenerationOperation extends ModelOperation {


	public FlogoGenerationOperation(CompilationUnit unit) {
		super(unit);
	}

	@Override
	public void call(Model model) throws CompilationFailedException {
		FrameBuilder builder = new FrameBuilder();
		for (Node component : model.components())
			builder.add(component.type())
					.add("name", component.name())
					.add("section", component.components().stream()
							.filter(c -> c.types().contains("Section"))
							.map(this::sectionFrameOf)
							.toArray(Frame[]::new));
		Frame frame = builder.toFrame();
		String render = new ConvolutionalNetworkTemplate().render(frame);
		try {
			Files.writeString(Path.of(""), render);
		} catch (IOException e) {
		}
		System.out.println();
	}

	private Frame sectionFrameOf(Node c) {
		return null;
	}
}
