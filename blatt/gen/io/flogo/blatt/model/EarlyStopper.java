package io.flogo.blatt.model;

import io.flogo.blatt.model.*;

public abstract class EarlyStopper  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Component, io.intino.magritte.framework.tags.Terminal {
	protected int patience;
	protected double threshold;

	public EarlyStopper(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public int patience() {
		return patience;
	}

	public double threshold() {
		return threshold;
	}

	public EarlyStopper patience(int value) {
		this.patience = value;
		return (EarlyStopper) this;
	}

	public EarlyStopper threshold(double value) {
		this.threshold = value;
		return (EarlyStopper) this;
	}

	@Override
	protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
		java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
		map.put("patience", new java.util.ArrayList(java.util.Collections.singletonList(this.patience)));
		map.put("threshold", new java.util.ArrayList(java.util.Collections.singletonList(this.threshold)));
		return map;
	}

	@Override
	protected void load$(java.lang.String name, java.util.List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("patience")) this.patience = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("threshold")) this.threshold = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
	}

	@Override
	protected void set$(java.lang.String name, java.util.List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("patience")) this.patience = (java.lang.Integer) values.get(0);
		else if (name.equalsIgnoreCase("threshold")) this.threshold = (java.lang.Double) values.get(0);
	}

	public Create create() {
		return new Create(null);
	}

	public Create create(java.lang.String name) {
		return new Create(name);
	}

	public class Create  {
		protected final java.lang.String name;

		public Create(java.lang.String name) {
			this.name = name;
		}



	}

	public io.flogo.blatt.model.BlattGraph graph() {
		return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
	}
}