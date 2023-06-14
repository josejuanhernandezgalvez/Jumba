package io.flogo.builder.operations;

import io.intino.magritte.builder.core.CompilationUnit;
import io.intino.magritte.builder.core.errorcollection.CompilationFailedException;
import io.intino.magritte.builder.core.operation.model.ModelOperation;
import io.intino.magritte.builder.model.Model;

public class FlogoGenerationOperation extends ModelOperation {


	public FlogoGenerationOperation(CompilationUnit unit) {
		super(unit);
	}

	@Override
	public void call(Model model) throws CompilationFailedException {

	}
}
