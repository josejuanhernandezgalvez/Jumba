package io.flogo.blatt.model;

import io.flogo.blatt.model.*;

public class ASGD extends io.flogo.blatt.model.Optimizer implements io.intino.magritte.framework.tags.Component, io.intino.magritte.framework.tags.Terminal {
	protected double lr;
	protected double lrDecay;
	protected double alpha;
	protected double pointToStartAverage;
	protected double weightDecay;

	public ASGD(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public double lr() {
		return lr;
	}

	public double lrDecay() {
		return lrDecay;
	}

	public double alpha() {
		return alpha;
	}

	public double pointToStartAverage() {
		return pointToStartAverage;
	}

	public double weightDecay() {
		return weightDecay;
	}

	public ASGD lr(double value) {
		this.lr = value;
		return (ASGD) this;
	}

	public ASGD lrDecay(double value) {
		this.lrDecay = value;
		return (ASGD) this;
	}

	public ASGD alpha(double value) {
		this.alpha = value;
		return (ASGD) this;
	}

	public ASGD pointToStartAverage(double value) {
		this.pointToStartAverage = value;
		return (ASGD) this;
	}

	public ASGD weightDecay(double value) {
		this.weightDecay = value;
		return (ASGD) this;
	}

	@Override
	protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
		java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
		map.put("lr", new java.util.ArrayList(java.util.Collections.singletonList(this.lr)));
		map.put("lrDecay", new java.util.ArrayList(java.util.Collections.singletonList(this.lrDecay)));
		map.put("alpha", new java.util.ArrayList(java.util.Collections.singletonList(this.alpha)));
		map.put("pointToStartAverage", new java.util.ArrayList(java.util.Collections.singletonList(this.pointToStartAverage)));
		map.put("weightDecay", new java.util.ArrayList(java.util.Collections.singletonList(this.weightDecay)));
		return map;
	}

	@Override
	protected void load$(java.lang.String name, java.util.List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("lr")) this.lr = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("lrDecay")) this.lrDecay = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("alpha")) this.alpha = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("pointToStartAverage")) this.pointToStartAverage = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("weightDecay")) this.weightDecay = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
	}

	@Override
	protected void set$(java.lang.String name, java.util.List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("lr")) this.lr = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("lrDecay")) this.lrDecay = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("alpha")) this.alpha = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("pointToStartAverage")) this.pointToStartAverage = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("weightDecay")) this.weightDecay = (java.lang.Double) values.get(0);
	}

	public io.flogo.blatt.model.BlattGraph graph() {
		return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
	}
}