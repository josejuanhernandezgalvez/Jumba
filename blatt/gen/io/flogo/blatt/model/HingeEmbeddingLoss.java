package io.flogo.blatt.model;

import io.flogo.blatt.model.*;

public class HingeEmbeddingLoss extends io.flogo.blatt.model.LossFunction implements io.intino.magritte.framework.tags.Component, io.intino.magritte.framework.tags.Terminal {
	protected double margin;

	public HingeEmbeddingLoss(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public double margin() {
		return margin;
	}

	public HingeEmbeddingLoss margin(double value) {
		this.margin = value;
		return (HingeEmbeddingLoss) this;
	}

	@Override
	protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
		java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
		map.put("margin", new java.util.ArrayList(java.util.Collections.singletonList(this.margin)));
		return map;
	}

	@Override
	protected void load$(java.lang.String name, java.util.List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("margin")) this.margin = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
	}

	@Override
	protected void set$(java.lang.String name, java.util.List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("margin")) this.margin = (java.lang.Double) values.get(0);
	}

	public io.flogo.blatt.model.BlattGraph graph() {
		return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
	}
}