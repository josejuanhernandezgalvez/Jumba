package io.flogo.blatt.model;

import io.flogo.blatt.model.*;

public class ASGD extends io.flogo.blatt.model.Optimizer implements io.intino.magritte.framework.tags.Component, io.intino.magritte.framework.tags.Terminal {
	protected double lr;
	protected double alpha;

	public ASGD(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public double lr() {
		return lr;
	}

	public double alpha() {
		return alpha;
	}

	public ASGD lr(double value) {
		this.lr = value;
		return (ASGD) this;
	}

	public ASGD alpha(double value) {
		this.alpha = value;
		return (ASGD) this;
	}

	@Override
	protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
		java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
		map.put("lr", new java.util.ArrayList(java.util.Collections.singletonList(this.lr)));
		map.put("alpha", new java.util.ArrayList(java.util.Collections.singletonList(this.alpha)));
		return map;
	}

	@Override
	protected void load$(java.lang.String name, java.util.List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("lr")) this.lr = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("alpha")) this.alpha = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
	}

	@Override
	protected void set$(java.lang.String name, java.util.List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("lr")) this.lr = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("alpha")) this.alpha = (java.lang.Double) values.get(0);
	}

	public io.flogo.blatt.model.BlattGraph graph() {
		return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
	}
}