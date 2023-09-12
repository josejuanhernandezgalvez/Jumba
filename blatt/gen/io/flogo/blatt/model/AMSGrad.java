package io.flogo.blatt.model;

import io.flogo.blatt.model.*;

public class AMSGrad extends io.flogo.blatt.model.Optimizer implements io.intino.magritte.framework.tags.Component, io.intino.magritte.framework.tags.Terminal {
	protected double lr;
	protected double beta0;
	protected double beta1;
	protected double weightDecay;

	public AMSGrad(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public double lr() {
		return lr;
	}

	public double beta0() {
		return beta0;
	}

	public double beta1() {
		return beta1;
	}

	public double weightDecay() {
		return weightDecay;
	}

	public AMSGrad lr(double value) {
		this.lr = value;
		return (AMSGrad) this;
	}

	public AMSGrad beta0(double value) {
		this.beta0 = value;
		return (AMSGrad) this;
	}

	public AMSGrad beta1(double value) {
		this.beta1 = value;
		return (AMSGrad) this;
	}

	public AMSGrad weightDecay(double value) {
		this.weightDecay = value;
		return (AMSGrad) this;
	}

	@Override
	protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
		java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
		map.put("lr", new java.util.ArrayList(java.util.Collections.singletonList(this.lr)));
		map.put("beta0", new java.util.ArrayList(java.util.Collections.singletonList(this.beta0)));
		map.put("beta1", new java.util.ArrayList(java.util.Collections.singletonList(this.beta1)));
		map.put("weightDecay", new java.util.ArrayList(java.util.Collections.singletonList(this.weightDecay)));
		return map;
	}

	@Override
	protected void load$(java.lang.String name, java.util.List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("lr")) this.lr = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("beta0")) this.beta0 = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("beta1")) this.beta1 = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("weightDecay")) this.weightDecay = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
	}

	@Override
	protected void set$(java.lang.String name, java.util.List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("lr")) this.lr = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("beta0")) this.beta0 = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("beta1")) this.beta1 = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("weightDecay")) this.weightDecay = (java.lang.Double) values.get(0);
	}

	public io.flogo.blatt.model.BlattGraph graph() {
		return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
	}
}