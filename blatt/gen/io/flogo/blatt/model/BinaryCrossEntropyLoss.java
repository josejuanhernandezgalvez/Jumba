package io.flogo.blatt.model;

import io.flogo.blatt.model.*;

public class BinaryCrossEntropyLoss extends io.flogo.blatt.model.LossFunction implements io.intino.magritte.framework.tags.Component, io.intino.magritte.framework.tags.Terminal {

	public BinaryCrossEntropyLoss(io.intino.magritte.framework.Node node) {
		super(node);
	}

	@Override
	protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
		java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
		return map;
	}

	@Override
	protected void load$(java.lang.String name, java.util.List<?> values) {
		super.load$(name, values);
	}

	@Override
	protected void set$(java.lang.String name, java.util.List<?> values) {
		super.set$(name, values);
	}

	public io.flogo.blatt.model.BlattGraph graph() {
		return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
	}
}