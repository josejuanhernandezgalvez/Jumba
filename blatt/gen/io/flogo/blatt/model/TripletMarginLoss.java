package io.flogo.blatt.model;

import io.flogo.blatt.model.*;

public class TripletMarginLoss extends io.flogo.blatt.model.LossFunction implements io.intino.magritte.framework.tags.Component, io.intino.magritte.framework.tags.Terminal {
	protected double margin;
	protected double normDegree;
	protected double eps;

	public TripletMarginLoss(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public double margin() {
		return margin;
	}

	public double normDegree() {
		return normDegree;
	}

	public double eps() {
		return eps;
	}

	public TripletMarginLoss margin(double value) {
		this.margin = value;
		return (TripletMarginLoss) this;
	}

	public TripletMarginLoss normDegree(double value) {
		this.normDegree = value;
		return (TripletMarginLoss) this;
	}

	public TripletMarginLoss eps(double value) {
		this.eps = value;
		return (TripletMarginLoss) this;
	}

	@Override
	protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
		java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
		map.put("margin", new java.util.ArrayList(java.util.Collections.singletonList(this.margin)));
		map.put("normDegree", new java.util.ArrayList(java.util.Collections.singletonList(this.normDegree)));
		map.put("eps", new java.util.ArrayList(java.util.Collections.singletonList(this.eps)));
		return map;
	}

	@Override
	protected void load$(java.lang.String name, java.util.List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("margin")) this.margin = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("normDegree")) this.normDegree = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("eps")) this.eps = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
	}

	@Override
	protected void set$(java.lang.String name, java.util.List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("margin")) this.margin = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("normDegree")) this.normDegree = (java.lang.Double) values.get(0);
		else if (name.equalsIgnoreCase("eps")) this.eps = (java.lang.Double) values.get(0);
	}

	public io.flogo.blatt.model.BlattGraph graph() {
		return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
	}
}