package io.flogo.blatt.model;

import io.flogo.blatt.model.*;

public class RecurrentSection extends io.flogo.blatt.model.ProcessingSection implements io.intino.magritte.framework.tags.Component, io.intino.magritte.framework.tags.Terminal {
	protected io.flogo.blatt.model.RecurrentSection.Input input;
	protected java.util.List<io.flogo.blatt.model.RecurrentSection.Output> outputList = new java.util.ArrayList<>();
	protected java.util.List<io.flogo.blatt.model.RecurrentSection.Type> typeList = new java.util.ArrayList<>();

	public RecurrentSection(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public io.flogo.blatt.model.RecurrentSection.Input input() {
		return input;
	}

	public java.util.List<io.flogo.blatt.model.RecurrentSection.Output> outputList() {
		return java.util.Collections.unmodifiableList(outputList);
	}

	public io.flogo.blatt.model.RecurrentSection.Output output(int index) {
		return outputList.get(index);
	}

	public java.util.List<io.flogo.blatt.model.RecurrentSection.Output> outputList(java.util.function.Predicate<io.flogo.blatt.model.RecurrentSection.Output> predicate) {
		return outputList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
	}

	public io.flogo.blatt.model.RecurrentSection.Output output(java.util.function.Predicate<io.flogo.blatt.model.RecurrentSection.Output> predicate) {
		return outputList().stream().filter(predicate).findFirst().orElse(null);
	}

	public java.util.List<io.flogo.blatt.model.RecurrentSection.Type> typeList() {
		return java.util.Collections.unmodifiableList(typeList);
	}

	public io.flogo.blatt.model.RecurrentSection.Type type(int index) {
		return typeList.get(index);
	}

	public java.util.List<io.flogo.blatt.model.RecurrentSection.Type> typeList(java.util.function.Predicate<io.flogo.blatt.model.RecurrentSection.Type> predicate) {
		return typeList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
	}

	public io.flogo.blatt.model.RecurrentSection.Type type(java.util.function.Predicate<io.flogo.blatt.model.RecurrentSection.Type> predicate) {
		return typeList().stream().filter(predicate).findFirst().orElse(null);
	}

	protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
		java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
		if (input != null) components.add(this.input.core$());
		new java.util.ArrayList<>(outputList).forEach(c -> components.add(c.core$()));
		new java.util.ArrayList<>(typeList).forEach(c -> components.add(c.core$()));
		return new java.util.ArrayList<>(components);
	}

	@Override
	protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
		java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
		return map;
	}

	@Override
	protected void addNode$(io.intino.magritte.framework.Node node) {
		super.addNode$(node);
		if (node.is("RecurrentSection$Input")) this.input = node.as(io.flogo.blatt.model.RecurrentSection.Input.class);
		if (node.is("RecurrentSection$Output")) this.outputList.add(node.as(io.flogo.blatt.model.RecurrentSection.Output.class));
		if (node.is("RecurrentSection$Type")) this.typeList.add(node.as(io.flogo.blatt.model.RecurrentSection.Type.class));
	}

	@Override
	protected void removeNode$(io.intino.magritte.framework.Node node) {
		super.removeNode$(node);
		if (node.is("RecurrentSection$Input")) this.input = null;
		if (node.is("RecurrentSection$Output")) this.outputList.remove(node.as(io.flogo.blatt.model.RecurrentSection.Output.class));
		if (node.is("RecurrentSection$Type")) this.typeList.remove(node.as(io.flogo.blatt.model.RecurrentSection.Type.class));
	}

	@Override
	protected void load$(java.lang.String name, java.util.List<?> values) {
		super.load$(name, values);
	}

	@Override
	protected void set$(java.lang.String name, java.util.List<?> values) {
		super.set$(name, values);
	}

	public Create create() {
		return new Create(null);
	}

	public Create create(java.lang.String name) {
		return new Create(name);
	}

	public class Create extends io.flogo.blatt.model.ProcessingSection.Create {


		public Create(java.lang.String name) {
			super(name);
		}

		public io.flogo.blatt.model.RecurrentSection.Input input(int x) {
			io.flogo.blatt.model.RecurrentSection.Input newElement = core$().graph().concept(io.flogo.blatt.model.RecurrentSection.Input.class).createNode(this.name, core$()).as(io.flogo.blatt.model.RecurrentSection.Input.class);
			newElement.core$().set(newElement, "x", java.util.Collections.singletonList(x));
			return newElement;
		}

		public io.flogo.blatt.model.RecurrentSection.Output output(int x) {
			io.flogo.blatt.model.RecurrentSection.Output newElement = core$().graph().concept(io.flogo.blatt.model.RecurrentSection.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.RecurrentSection.Output.class);
			newElement.core$().set(newElement, "x", java.util.Collections.singletonList(x));
			return newElement;
		}

		public io.flogo.blatt.model.RecurrentSection.Type type() {
			io.flogo.blatt.model.RecurrentSection.Type newElement = core$().graph().concept(io.flogo.blatt.model.RecurrentSection.Type.class).createNode(this.name, core$()).as(io.flogo.blatt.model.RecurrentSection.Type.class);

			return newElement;
		}

	}

	public Clear clear() {
		return new Clear();
	}

	public class Clear  {
		public void output(java.util.function.Predicate<io.flogo.blatt.model.RecurrentSection.Output> filter) {
			new java.util.ArrayList<>(outputList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
		}

		public void type(java.util.function.Predicate<io.flogo.blatt.model.RecurrentSection.Type> filter) {
			new java.util.ArrayList<>(typeList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
		}
	}

	public static class Input  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
		protected int x;

		public Input(io.intino.magritte.framework.Node node) {
			super(node);
		}

		public int x() {
			return x;
		}

		public Input x(int value) {
			this.x = value;
			return (Input) this;
		}

		@Override
		protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
			java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
			map.put("x", new java.util.ArrayList(java.util.Collections.singletonList(this.x)));
			return map;
		}

		@Override
		protected void load$(java.lang.String name, java.util.List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("x")) this.x = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
		}

		@Override
		protected void set$(java.lang.String name, java.util.List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("x")) this.x = (java.lang.Integer) values.get(0);
		}

		public io.flogo.blatt.model.BlattGraph graph() {
			return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
		}
	}

	public static class Output  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
		protected int x;

		public Output(io.intino.magritte.framework.Node node) {
			super(node);
		}

		public int x() {
			return x;
		}

		public Output x(int value) {
			this.x = value;
			return (Output) this;
		}

		@Override
		protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
			java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
			map.put("x", new java.util.ArrayList(java.util.Collections.singletonList(this.x)));
			return map;
		}

		@Override
		protected void load$(java.lang.String name, java.util.List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("x")) this.x = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
		}

		@Override
		protected void set$(java.lang.String name, java.util.List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("x")) this.x = (java.lang.Integer) values.get(0);
		}

		public io.flogo.blatt.model.BlattGraph graph() {
			return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
		}
	}

	public static class Type  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
		protected java.lang.String type;

		public Type(io.intino.magritte.framework.Node node) {
			super(node);
		}

		public java.lang.String type() {
			return type;
		}

		public Type type(java.lang.String value) {
			this.type = value;
			return (Type) this;
		}

		@Override
		protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
			java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
			map.put("type", new java.util.ArrayList(java.util.Collections.singletonList(this.type)));
			return map;
		}

		@Override
		protected void load$(java.lang.String name, java.util.List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("type")) this.type = io.intino.magritte.framework.loaders.StringLoader.load(values, this).get(0);
		}

		@Override
		protected void set$(java.lang.String name, java.util.List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("type")) this.type = (java.lang.String) values.get(0);
		}

		public io.flogo.blatt.model.BlattGraph graph() {
			return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
		}
	}


	public io.flogo.blatt.model.BlattGraph graph() {
		return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
	}
}