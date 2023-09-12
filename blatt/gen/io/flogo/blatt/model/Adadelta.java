package io.flogo.blatt.model;

import io.flogo.blatt.model.*;

public class Adadelta extends io.flogo.blatt.model.Optimizer implements io.intino.magritte.framework.tags.Component, io.intino.magritte.framework.tags.Terminal {
	protected double lr;
	protected double rho;
	protected double eps;
	protected double weightDecay;

	public Adadelta(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public double lr() {
		return lr;
	}

	public double rho() {
		return rho;
	}

	public double eps() {
		return eps;
	}

	public double weightDecay() {
		return weightDecay;
	}

	public Adadelta lr(double value) {
		this.lr = value;
		return (Adadelta) this;
	}

	public Adadelta rho(double value) {
		this.rho = value;
		return (Adadelta) this;
	}

	public Adadelta eps(double value) {
		this.eps = value;
		return (Adadelta) this;
	}

	public Adadelta weightDecay(double value) {
		this.weightDecay = value;
		return (Adadelta) this;
	}

	@Override
	protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
		java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
		map.put("lr", new java.util.ArrayList(java.util.Collections.singletonList(this.lr)));
		map.put("rho", new java.util.ArrayList(java.util.Collections.singletonList(this.rho)));
		map.put("eps", new java.util.ArrayList(java.util.Collections.singletonList(this.eps)));
		map.put("weightDecay", new java.util.ArrayList(java.util.Collections.singletonList(this.weightDecay)));
		return map;
	}

	@Override
	protected void load$(java.lang.String name, java.util.List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("lr")) this.lr = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("rho")) this.rho = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("eps")) this.eps = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("weightDecay")) this.weightDecay = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
	}

	@Override
	protected void set$(java.lang.String name, java.util.List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("lr")) this.lr = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("rho")) this.rho = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("eps")) this.eps = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("weightDecay")) this.weightDecay = (java.lang.Double) values.get(0);
	}

	public io.flogo.blatt.model.BlattGraph graph() {
		return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
	}
}