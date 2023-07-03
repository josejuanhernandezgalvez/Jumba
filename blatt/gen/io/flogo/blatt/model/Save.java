package io.flogo.blatt.model;

import io.flogo.blatt.model.*;

public class Save  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
	protected java.lang.String path;
	protected int section;

	public Save(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public java.lang.String path() {
		return path;
	}

	public int section() {
		return section;
	}

	public Save path(java.lang.String value) {
		this.path = value;
		return (Save) this;
	}

	public Save section(int value) {
		this.section = value;
		return (Save) this;
	}

	@Override
	protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
		java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
		map.put("path", new java.util.ArrayList(java.util.Collections.singletonList(this.path)));
		map.put("section", new java.util.ArrayList(java.util.Collections.singletonList(this.section)));
		return map;
	}

	@Override
	protected void load$(java.lang.String name, java.util.List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("path")) this.path = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("section")) this.section = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
	}

	@Override
	protected void set$(java.lang.String name, java.util.List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("path")) this.path = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("section")) this.section = (java.lang.Integer) values.get(0);
	}

	public io.flogo.blatt.model.BlattGraph graph() {
		return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
	}
}