package io.flogo.blatt.model;

import io.flogo.blatt.model.*;

public class SaveModule  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
	protected java.lang.String path;
	protected int section;
	protected int from;
	protected int to;
	protected java.lang.String name;

	public SaveModule(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public java.lang.String path() {
		return path;
	}

	public int section() {
		return section;
	}

	public int from() {
		return from;
	}

	public int to() {
		return to;
	}

	public java.lang.String name() {
		return name;
	}

	public SaveModule path(java.lang.String value) {
		this.path = value;
		return (SaveModule) this;
	}

	public SaveModule section(int value) {
		this.section = value;
		return (SaveModule) this;
	}

	public SaveModule from(int value) {
		this.from = value;
		return (SaveModule) this;
	}

	public SaveModule to(int value) {
		this.to = value;
		return (SaveModule) this;
	}

	public SaveModule name(java.lang.String value) {
		this.name = value;
		return (SaveModule) this;
	}

	@Override
	protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
		java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
		map.put("path", new java.util.ArrayList(java.util.Collections.singletonList(this.path)));
		map.put("section", new java.util.ArrayList(java.util.Collections.singletonList(this.section)));
		map.put("from", new java.util.ArrayList(java.util.Collections.singletonList(this.from)));
		map.put("to", new java.util.ArrayList(java.util.Collections.singletonList(this.to)));
		map.put("name", new java.util.ArrayList(java.util.Collections.singletonList(this.name)));
		return map;
	}

	@Override
	protected void load$(java.lang.String name, java.util.List<?> values) {
		super.load$(name, values);
		if (name.equalsIgnoreCase("path")) this.path = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("section")) this.section = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("from")) this.from = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("to")) this.to = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
		else if (name.equalsIgnoreCase("name")) this.name = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
	}

	@Override
	protected void set$(java.lang.String name, java.util.List<?> values) {
		super.set$(name, values);
		if (name.equalsIgnoreCase("path")) this.path = (java.lang.String) values.get(0);
		else if (name.equalsIgnoreCase("section")) this.section = (java.lang.Integer) values.get(0);
		else if (name.equalsIgnoreCase("from")) this.from = (java.lang.Integer) values.get(0);
		else if (name.equalsIgnoreCase("to")) this.to = (java.lang.Integer) values.get(0);
		else if (name.equalsIgnoreCase("name")) this.name = (java.lang.String) values.get(0);
	}

	public io.flogo.blatt.model.BlattGraph graph() {
		return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
	}
}