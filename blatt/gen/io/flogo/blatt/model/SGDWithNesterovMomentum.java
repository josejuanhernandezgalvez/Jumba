package io.flogo.blatt.model;

import io.flogo.blatt.model.*;

public class SGDWithNesterovMomentum extends io.flogo.blatt.model.Optimizer implements io.intino.magritte.framework.tags.Component, io.intino.magritte.framework.tags.Terminal {
	protected double lr;
	protected double momentum;
	protected double momentumDecay;
	protected double weightDecay;

	public SGDWithNesterovMomentum(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public double lr() {
		return lr;
	}

	public double momentum() {
		return momentum;
	}

	public double momentumDecay() {
		return momentumDecay;
	}

	public double weightDecay() {
		return weightDecay;
	}

	public SGDWithNesterovMomentum lr(double value) {
		this.lr = value;
		return (SGDWithNesterovMomentum) this;
	}

	public SGDWithNesterovMomentum momentum(double value) {
		this.momentum = value;
		return (SGDWithNesterovMomentum) this;
	}

	public SGDWithNesterovMomentum momentumDecay(double value) {
		this.momentumDecay = value;
		return (SGDWithNesterovMomentum) this;
	}

	public SGDWithNesterovMomentum weightDecay(double value) {
		this.weightDecay = value;
		return (SGDWithNesterovMomentum) this;
	}

	@Override
	protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
		java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
		map.put("lr", new java.util.ArrayList(java.util.Collections.singletonList(this.lr)));
		map.put("momentum", new java.util.ArrayList(java.util.Collections.singletonList(this.momentum)));
		map.put("momentumDecay", new java.util.ArrayList(java.util.Collections.singletonList(this.momentumDecay)));
		map.put("weightDecay", new java.util.ArrayList(java.util.Collections.singletonList(this.weightDecay)));
		return map;
	}

	@Override
	protected void load$(java.lang.String name, java.util.List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("lr")) this.lr = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("momentum")) this.momentum = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("momentumDecay")) this.momentumDecay = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("weightDecay")) this.weightDecay = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
	}

	@Override
	protected void set$(java.lang.String name, java.util.List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("lr")) this.lr = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("momentum")) this.momentum = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("momentumDecay")) this.momentumDecay = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("weightDecay")) this.weightDecay = (java.lang.Double) values.get(0);
	}

	public io.flogo.blatt.model.BlattGraph graph() {
		return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
	}
}