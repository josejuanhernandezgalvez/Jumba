package io.flogo.blatt.model;

import io.flogo.blatt.model.*;

public class PrecisionEarlyStopper extends io.flogo.blatt.model.EarlyStopping implements io.intino.magritte.framework.tags.Component, io.intino.magritte.framework.tags.Terminal {
	protected int patience;
	protected int threshold;

	public PrecisionEarlyStopper(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public int patience() {
		return patience;
	}

	public int threshold() {
		return threshold;
	}

	public PrecisionEarlyStopper patience(int value) {
		this.patience = value;
		return (PrecisionEarlyStopper) this;
	}

	public PrecisionEarlyStopper threshold(int value) {
		this.threshold = value;
		return (PrecisionEarlyStopper) this;
	}

	@Override
	protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
		java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
		map.put("patience", new java.util.ArrayList(java.util.Collections.singletonList(this.patience)));
		map.put("threshold", new java.util.ArrayList(java.util.Collections.singletonList(this.threshold)));
		return map;
	}

	@Override
	protected void load$(java.lang.String name, java.util.List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("patience")) this.patience = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("threshold")) this.threshold = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
	}

	@Override
	protected void set$(java.lang.String name, java.util.List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("patience")) this.patience = (java.lang.Integer) values.get(0);
		else if (name.equalsIgnoreCase("threshold")) this.threshold = (java.lang.Integer) values.get(0);
	}

	public io.flogo.blatt.model.BlattGraph graph() {
		return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
	}
}