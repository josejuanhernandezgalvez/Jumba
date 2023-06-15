package io.flogo.blatt.model;

import io.flogo.blatt.model.*;

public class ResidualSection extends io.flogo.blatt.model.ProcessingSection implements io.intino.magritte.framework.tags.Component, io.intino.magritte.framework.tags.Terminal {
	protected io.flogo.blatt.model.ResidualSection.Input input;
	protected java.util.List<io.flogo.blatt.model.ResidualSection.Block> blockList = new java.util.ArrayList<>();

	public ResidualSection(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public io.flogo.blatt.model.ResidualSection.Input input() {
		return input;
	}

	public java.util.List<io.flogo.blatt.model.ResidualSection.Block> blockList() {
		return java.util.Collections.unmodifiableList(blockList);
	}

	public io.flogo.blatt.model.ResidualSection.Block block(int index) {
		return blockList.get(index);
	}

	public java.util.List<io.flogo.blatt.model.ResidualSection.Block> blockList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block> predicate) {
		return blockList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
	}

	public io.flogo.blatt.model.ResidualSection.Block block(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block> predicate) {
		return blockList().stream().filter(predicate).findFirst().orElse(null);
	}

	protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
		java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
		if (input != null) components.add(this.input.core$());
		new java.util.ArrayList<>(blockList).forEach(c -> components.add(c.core$()));
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
		if (node.is("ResidualSection$Input")) this.input = node.as(io.flogo.blatt.model.ResidualSection.Input.class);
		if (node.is("ResidualSection$Block")) this.blockList.add(node.as(io.flogo.blatt.model.ResidualSection.Block.class));
	}

	@Override
	protected void removeNode$(io.intino.magritte.framework.Node node) {
		super.removeNode$(node);
		if (node.is("ResidualSection$Input")) this.input = null;
		if (node.is("ResidualSection$Block")) this.blockList.remove(node.as(io.flogo.blatt.model.ResidualSection.Block.class));
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

		public io.flogo.blatt.model.ResidualSection.Input input(int x, int y, int z) {
			io.flogo.blatt.model.ResidualSection.Input newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.Input.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.Input.class);
			newElement.core$().set(newElement, "x", java.util.Collections.singletonList(x));
			newElement.core$().set(newElement, "y", java.util.Collections.singletonList(y));
			newElement.core$().set(newElement, "z", java.util.Collections.singletonList(z));
			return newElement;
		}

		public io.flogo.blatt.model.ResidualSection.Block block() {
			io.flogo.blatt.model.ResidualSection.Block newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.Block.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.Block.class);

			return newElement;
		}

	}

	public Clear clear() {
		return new Clear();
	}

	public class Clear  {
		public void block(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block> filter) {
			new java.util.ArrayList<>(blockList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
		}
	}

	public static class Input  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
		protected int x;
		protected int y;
		protected int z;

		public Input(io.intino.magritte.framework.Node node) {
			super(node);
		}

		public int x() {
			return x;
		}

		public int y() {
			return y;
		}

		public int z() {
			return z;
		}

		public Input x(int value) {
			this.x = value;
			return (Input) this;
		}

		public Input y(int value) {
			this.y = value;
			return (Input) this;
		}

		public Input z(int value) {
			this.z = value;
			return (Input) this;
		}

		@Override
		protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
			java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
			map.put("x", new java.util.ArrayList(java.util.Collections.singletonList(this.x)));
			map.put("y", new java.util.ArrayList(java.util.Collections.singletonList(this.y)));
			map.put("z", new java.util.ArrayList(java.util.Collections.singletonList(this.z)));
			return map;
		}

		@Override
		protected void load$(java.lang.String name, java.util.List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("x")) this.x = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
			else if (name.equalsIgnoreCase("y")) this.y = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
			else if (name.equalsIgnoreCase("z")) this.z = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
		}

		@Override
		protected void set$(java.lang.String name, java.util.List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("x")) this.x = (java.lang.Integer) values.get(0);
			else if (name.equalsIgnoreCase("y")) this.y = (java.lang.Integer) values.get(0);
			else if (name.equalsIgnoreCase("z")) this.z = (java.lang.Integer) values.get(0);
		}

		public io.flogo.blatt.model.BlattGraph graph() {
			return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
		}
	}

	public static class Block  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
		protected int repeat;
		protected java.util.List<io.flogo.blatt.model.ResidualSection.Block.Output> outputList = new java.util.ArrayList<>();

		public Block(io.intino.magritte.framework.Node node) {
			super(node);
		}

		public int repeat() {
			return repeat;
		}

		public Block repeat(int value) {
			this.repeat = value;
			return (Block) this;
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.Output> outputList() {
			return java.util.Collections.unmodifiableList(outputList);
		}

		public io.flogo.blatt.model.ResidualSection.Block.Output output(int index) {
			return outputList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.Output> outputList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.Output> predicate) {
			return outputList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.Block.Output output(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.Output> predicate) {
			return outputList().stream().filter(predicate).findFirst().orElse(null);
		}

		protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
			java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
			new java.util.ArrayList<>(outputList).forEach(c -> components.add(c.core$()));
			return new java.util.ArrayList<>(components);
		}

		@Override
		protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
			java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
			map.put("repeat", new java.util.ArrayList(java.util.Collections.singletonList(this.repeat)));
			return map;
		}

		@Override
		protected void addNode$(io.intino.magritte.framework.Node node) {
			super.addNode$(node);
			if (node.is("ResidualSection$Block$Output")) this.outputList.add(node.as(io.flogo.blatt.model.ResidualSection.Block.Output.class));
		}

		@Override
		protected void removeNode$(io.intino.magritte.framework.Node node) {
			super.removeNode$(node);
			if (node.is("ResidualSection$Block$Output")) this.outputList.remove(node.as(io.flogo.blatt.model.ResidualSection.Block.Output.class));
		}

		@Override
		protected void load$(java.lang.String name, java.util.List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("repeat")) this.repeat = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
		}

		@Override
		protected void set$(java.lang.String name, java.util.List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("repeat")) this.repeat = (java.lang.Integer) values.get(0);
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

			public io.flogo.blatt.model.ResidualSection.Block.Output output(int x, int y, int z) {
				io.flogo.blatt.model.ResidualSection.Block.Output newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.Block.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.Block.Output.class);
				newElement.core$().set(newElement, "x", java.util.Collections.singletonList(x));
				newElement.core$().set(newElement, "y", java.util.Collections.singletonList(y));
				newElement.core$().set(newElement, "z", java.util.Collections.singletonList(z));
				return newElement;
			}

		}

		public Clear clear() {
			return new Clear();
		}

		public class Clear  {
			public void output(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.Output> filter) {
				new java.util.ArrayList<>(outputList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}
		}

		public static class Output  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
			protected int x;
			protected int y;
			protected int z;

			public Output(io.intino.magritte.framework.Node node) {
				super(node);
			}

			public int x() {
				return x;
			}

			public int y() {
				return y;
			}

			public int z() {
				return z;
			}

			public Output x(int value) {
				this.x = value;
				return (Output) this;
			}

			public Output y(int value) {
				this.y = value;
				return (Output) this;
			}

			public Output z(int value) {
				this.z = value;
				return (Output) this;
			}

			@Override
			protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
				java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
				map.put("x", new java.util.ArrayList(java.util.Collections.singletonList(this.x)));
				map.put("y", new java.util.ArrayList(java.util.Collections.singletonList(this.y)));
				map.put("z", new java.util.ArrayList(java.util.Collections.singletonList(this.z)));
				return map;
			}

			@Override
			protected void load$(java.lang.String name, java.util.List<?> values) {
				super.load$(name, values);
				if (name.equalsIgnoreCase("x")) this.x = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
				else if (name.equalsIgnoreCase("y")) this.y = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
				else if (name.equalsIgnoreCase("z")) this.z = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
			}

			@Override
			protected void set$(java.lang.String name, java.util.List<?> values) {
				super.set$(name, values);
				if (name.equalsIgnoreCase("x")) this.x = (java.lang.Integer) values.get(0);
				else if (name.equalsIgnoreCase("y")) this.y = (java.lang.Integer) values.get(0);
				else if (name.equalsIgnoreCase("z")) this.z = (java.lang.Integer) values.get(0);
			}

			public io.flogo.blatt.model.BlattGraph graph() {
				return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
			}
		}


		public io.flogo.blatt.model.BlattGraph graph() {
			return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
		}
	}


	public io.flogo.blatt.model.BlattGraph graph() {
		return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
	}
}