package io.flogo.blatt.model;

import io.flogo.blatt.model.*;

public class ResidualSection extends io.flogo.blatt.model.ProcessingSection implements io.intino.magritte.framework.tags.Component, io.intino.magritte.framework.tags.Terminal {
	protected io.flogo.blatt.model.ResidualSection.Input input;
	protected io.flogo.blatt.model.ResidualSection.FirstStage firstStage;
	protected io.flogo.blatt.model.ResidualSection.DefaultFirstStage defaultFirstStage;
	protected io.flogo.blatt.model.ResidualSection.CustomFirstStage customFirstStage;
	protected java.util.List<io.flogo.blatt.model.ResidualSection.ResidualLayer> residualLayerList = new java.util.ArrayList<>();
	protected io.flogo.blatt.model.ResidualSection.LastStage lastStage;
	protected io.flogo.blatt.model.ResidualSection.DefaultLastStage defaultLastStage;
	protected io.flogo.blatt.model.ResidualSection.CustomLastStage customLastStage;

	public ResidualSection(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public io.flogo.blatt.model.ResidualSection.Input input() {
		return input;
	}

	public io.flogo.blatt.model.ResidualSection.FirstStage firstStage() {
		return firstStage;
	}

	public io.flogo.blatt.model.ResidualSection.DefaultFirstStage defaultFirstStage() {
		return defaultFirstStage;
	}

	public io.flogo.blatt.model.ResidualSection.CustomFirstStage customFirstStage() {
		return customFirstStage;
	}

	public java.util.List<io.flogo.blatt.model.ResidualSection.ResidualLayer> residualLayerList() {
		return java.util.Collections.unmodifiableList(residualLayerList);
	}

	public io.flogo.blatt.model.ResidualSection.ResidualLayer residualLayer(int index) {
		return residualLayerList.get(index);
	}

	public java.util.List<io.flogo.blatt.model.ResidualSection.ResidualLayer> residualLayerList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.ResidualLayer> predicate) {
		return residualLayerList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
	}

	public io.flogo.blatt.model.ResidualSection.ResidualLayer residualLayer(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.ResidualLayer> predicate) {
		return residualLayerList().stream().filter(predicate).findFirst().orElse(null);
	}

	public io.flogo.blatt.model.ResidualSection.LastStage lastStage() {
		return lastStage;
	}

	public io.flogo.blatt.model.ResidualSection.DefaultLastStage defaultLastStage() {
		return defaultLastStage;
	}

	public io.flogo.blatt.model.ResidualSection.CustomLastStage customLastStage() {
		return customLastStage;
	}

	protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
		java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
		if (input != null) components.add(this.input.core$());
		if (firstStage != null) components.add(this.firstStage.core$());
		if (defaultFirstStage != null) components.add(this.defaultFirstStage.core$());
		if (customFirstStage != null) components.add(this.customFirstStage.core$());
		new java.util.ArrayList<>(residualLayerList).forEach(c -> components.add(c.core$()));
		if (lastStage != null) components.add(this.lastStage.core$());
		if (defaultLastStage != null) components.add(this.defaultLastStage.core$());
		if (customLastStage != null) components.add(this.customLastStage.core$());
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
		if (node.is("ResidualSection$FirstStage")) this.firstStage = node.as(io.flogo.blatt.model.ResidualSection.FirstStage.class);
		if (node.is("ResidualSection$DefaultFirstStage")) this.defaultFirstStage = node.as(io.flogo.blatt.model.ResidualSection.DefaultFirstStage.class);
		if (node.is("ResidualSection$CustomFirstStage")) this.customFirstStage = node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.class);
		if (node.is("ResidualSection$ResidualLayer")) this.residualLayerList.add(node.as(io.flogo.blatt.model.ResidualSection.ResidualLayer.class));
		if (node.is("ResidualSection$LastStage")) this.lastStage = node.as(io.flogo.blatt.model.ResidualSection.LastStage.class);
		if (node.is("ResidualSection$DefaultLastStage")) this.defaultLastStage = node.as(io.flogo.blatt.model.ResidualSection.DefaultLastStage.class);
		if (node.is("ResidualSection$CustomLastStage")) this.customLastStage = node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.class);
	}

	@Override
	protected void removeNode$(io.intino.magritte.framework.Node node) {
		super.removeNode$(node);
		if (node.is("ResidualSection$Input")) this.input = null;
		if (node.is("ResidualSection$FirstStage")) this.firstStage = null;
		if (node.is("ResidualSection$DefaultFirstStage")) this.defaultFirstStage = null;
		if (node.is("ResidualSection$CustomFirstStage")) this.customFirstStage = null;
		if (node.is("ResidualSection$ResidualLayer")) this.residualLayerList.remove(node.as(io.flogo.blatt.model.ResidualSection.ResidualLayer.class));
		if (node.is("ResidualSection$LastStage")) this.lastStage = null;
		if (node.is("ResidualSection$DefaultLastStage")) this.defaultLastStage = null;
		if (node.is("ResidualSection$CustomLastStage")) this.customLastStage = null;
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

		public io.flogo.blatt.model.ResidualSection.DefaultFirstStage defaultFirstStage() {
			io.flogo.blatt.model.ResidualSection.DefaultFirstStage newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.DefaultFirstStage.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.DefaultFirstStage.class);

			return newElement;
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage customFirstStage() {
			io.flogo.blatt.model.ResidualSection.CustomFirstStage newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.class);

			return newElement;
		}

		public io.flogo.blatt.model.ResidualSection.ResidualLayer residualLayer() {
			io.flogo.blatt.model.ResidualSection.ResidualLayer newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.ResidualLayer.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.ResidualLayer.class);

			return newElement;
		}

		public io.flogo.blatt.model.ResidualSection.DefaultLastStage defaultLastStage() {
			io.flogo.blatt.model.ResidualSection.DefaultLastStage newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.DefaultLastStage.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.DefaultLastStage.class);

			return newElement;
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage customLastStage() {
			io.flogo.blatt.model.ResidualSection.CustomLastStage newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.class);

			return newElement;
		}

	}

	public Clear clear() {
		return new Clear();
	}

	public class Clear  {
		public void residualLayer(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.ResidualLayer> filter) {
			new java.util.ArrayList<>(residualLayerList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
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

	public static abstract class FirstStage  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {

		public FirstStage(io.intino.magritte.framework.Node node) {
			super(node);
		}

		@Override
		protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
			java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
			return map;
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

	public static class DefaultFirstStage extends io.flogo.blatt.model.ResidualSection.FirstStage implements io.intino.magritte.framework.tags.Terminal {

		public DefaultFirstStage(io.intino.magritte.framework.Node node) {
			super(node);
		}

		@Override
		protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
			java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
			return map;
		}

		@Override
		protected void load$(java.lang.String name, java.util.List<?> values) {
			super.load$(name, values);
		}

		@Override
		protected void set$(java.lang.String name, java.util.List<?> values) {
			super.set$(name, values);
		}

		public io.flogo.blatt.model.BlattGraph graph() {
			return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
		}
	}

	public static class CustomFirstStage extends io.flogo.blatt.model.ResidualSection.FirstStage implements io.intino.magritte.framework.tags.Terminal {
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block> blockList = new java.util.ArrayList<>();

		public CustomFirstStage(io.intino.magritte.framework.Node node) {
			super(node);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block> blockList() {
			return java.util.Collections.unmodifiableList(blockList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block block(int index) {
			return blockList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block> blockList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block> predicate) {
			return blockList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block block(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block> predicate) {
			return blockList().stream().filter(predicate).findFirst().orElse(null);
		}

		protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
			java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
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
			if (node.is("ResidualSection$CustomFirstStage$Block")) this.blockList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.class));
		}

		@Override
		protected void removeNode$(io.intino.magritte.framework.Node node) {
			super.removeNode$(node);
			if (node.is("ResidualSection$CustomFirstStage$Block")) this.blockList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.class));
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

		public class Create extends io.flogo.blatt.model.ResidualSection.FirstStage.Create {


			public Create(java.lang.String name) {
				super(name);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block block() {
				io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.class);

				return newElement;
			}

		}

		public Clear clear() {
			return new Clear();
		}

		public class Clear  {
			public void block(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block> filter) {
				new java.util.ArrayList<>(blockList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}
		}

		public static class Block  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Layer> layerList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ActivationLayer> activationLayerList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ReLU> reLUList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ELU> eLUList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SELU> sELUList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GELU> gELUList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SiLU> siLUList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GLU> gLUList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LeakyReLU> leakyReLUList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LogSigmoid> logSigmoidList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Sigmoid> sigmoidList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Tanh> tanhList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Mish> mishList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ProcessingLayer> processingLayerList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Dropout> dropoutList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Convolutional> convolutionalList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Pool> poolList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.MaxPool> maxPoolList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.AvgPool> avgPoolList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization> normalizationList = new java.util.ArrayList<>();

			public Block(io.intino.magritte.framework.Node node) {
				super(node);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Layer> layerList() {
				return java.util.Collections.unmodifiableList(layerList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Layer layer(int index) {
				return layerList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Layer> layerList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Layer> predicate) {
				return layerList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Layer layer(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Layer> predicate) {
				return layerList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ActivationLayer> activationLayerList() {
				return java.util.Collections.unmodifiableList(activationLayerList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ActivationLayer activationLayer(int index) {
				return activationLayerList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ActivationLayer> activationLayerList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ActivationLayer> predicate) {
				return activationLayerList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ActivationLayer activationLayer(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ActivationLayer> predicate) {
				return activationLayerList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ReLU> reLUList() {
				return java.util.Collections.unmodifiableList(reLUList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ReLU reLU(int index) {
				return reLUList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ReLU> reLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ReLU> predicate) {
				return reLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ReLU reLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ReLU> predicate) {
				return reLUList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ELU> eLUList() {
				return java.util.Collections.unmodifiableList(eLUList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ELU eLU(int index) {
				return eLUList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ELU> eLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ELU> predicate) {
				return eLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ELU eLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ELU> predicate) {
				return eLUList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SELU> sELUList() {
				return java.util.Collections.unmodifiableList(sELUList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SELU sELU(int index) {
				return sELUList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SELU> sELUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SELU> predicate) {
				return sELUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SELU sELU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SELU> predicate) {
				return sELUList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GELU> gELUList() {
				return java.util.Collections.unmodifiableList(gELUList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GELU gELU(int index) {
				return gELUList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GELU> gELUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GELU> predicate) {
				return gELUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GELU gELU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GELU> predicate) {
				return gELUList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SiLU> siLUList() {
				return java.util.Collections.unmodifiableList(siLUList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SiLU siLU(int index) {
				return siLUList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SiLU> siLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SiLU> predicate) {
				return siLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SiLU siLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SiLU> predicate) {
				return siLUList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GLU> gLUList() {
				return java.util.Collections.unmodifiableList(gLUList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GLU gLU(int index) {
				return gLUList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GLU> gLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GLU> predicate) {
				return gLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GLU gLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GLU> predicate) {
				return gLUList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LeakyReLU> leakyReLUList() {
				return java.util.Collections.unmodifiableList(leakyReLUList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LeakyReLU leakyReLU(int index) {
				return leakyReLUList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LeakyReLU> leakyReLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LeakyReLU> predicate) {
				return leakyReLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LeakyReLU leakyReLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LeakyReLU> predicate) {
				return leakyReLUList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LogSigmoid> logSigmoidList() {
				return java.util.Collections.unmodifiableList(logSigmoidList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LogSigmoid logSigmoid(int index) {
				return logSigmoidList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LogSigmoid> logSigmoidList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LogSigmoid> predicate) {
				return logSigmoidList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LogSigmoid logSigmoid(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LogSigmoid> predicate) {
				return logSigmoidList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Sigmoid> sigmoidList() {
				return java.util.Collections.unmodifiableList(sigmoidList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Sigmoid sigmoid(int index) {
				return sigmoidList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Sigmoid> sigmoidList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Sigmoid> predicate) {
				return sigmoidList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Sigmoid sigmoid(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Sigmoid> predicate) {
				return sigmoidList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Tanh> tanhList() {
				return java.util.Collections.unmodifiableList(tanhList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Tanh tanh(int index) {
				return tanhList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Tanh> tanhList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Tanh> predicate) {
				return tanhList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Tanh tanh(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Tanh> predicate) {
				return tanhList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Mish> mishList() {
				return java.util.Collections.unmodifiableList(mishList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Mish mish(int index) {
				return mishList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Mish> mishList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Mish> predicate) {
				return mishList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Mish mish(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Mish> predicate) {
				return mishList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ProcessingLayer> processingLayerList() {
				return java.util.Collections.unmodifiableList(processingLayerList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ProcessingLayer processingLayer(int index) {
				return processingLayerList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ProcessingLayer> processingLayerList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ProcessingLayer> predicate) {
				return processingLayerList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ProcessingLayer processingLayer(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ProcessingLayer> predicate) {
				return processingLayerList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Dropout> dropoutList() {
				return java.util.Collections.unmodifiableList(dropoutList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Dropout dropout(int index) {
				return dropoutList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Dropout> dropoutList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Dropout> predicate) {
				return dropoutList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Dropout dropout(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Dropout> predicate) {
				return dropoutList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Convolutional> convolutionalList() {
				return java.util.Collections.unmodifiableList(convolutionalList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Convolutional convolutional(int index) {
				return convolutionalList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Convolutional> convolutionalList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Convolutional> predicate) {
				return convolutionalList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Convolutional convolutional(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Convolutional> predicate) {
				return convolutionalList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Pool> poolList() {
				return java.util.Collections.unmodifiableList(poolList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Pool pool(int index) {
				return poolList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Pool> poolList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Pool> predicate) {
				return poolList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Pool pool(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Pool> predicate) {
				return poolList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.MaxPool> maxPoolList() {
				return java.util.Collections.unmodifiableList(maxPoolList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.MaxPool maxPool(int index) {
				return maxPoolList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.MaxPool> maxPoolList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.MaxPool> predicate) {
				return maxPoolList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.MaxPool maxPool(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.MaxPool> predicate) {
				return maxPoolList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.AvgPool> avgPoolList() {
				return java.util.Collections.unmodifiableList(avgPoolList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.AvgPool avgPool(int index) {
				return avgPoolList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.AvgPool> avgPoolList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.AvgPool> predicate) {
				return avgPoolList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.AvgPool avgPool(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.AvgPool> predicate) {
				return avgPoolList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization> normalizationList() {
				return java.util.Collections.unmodifiableList(normalizationList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization normalization(int index) {
				return normalizationList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization> normalizationList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization> predicate) {
				return normalizationList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization normalization(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization> predicate) {
				return normalizationList().stream().filter(predicate).findFirst().orElse(null);
			}

			protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
				java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
				new java.util.ArrayList<>(layerList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(activationLayerList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(reLUList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(eLUList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(sELUList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(gELUList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(siLUList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(gLUList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(leakyReLUList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(logSigmoidList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(sigmoidList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(tanhList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(mishList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(processingLayerList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(dropoutList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(convolutionalList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(poolList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(maxPoolList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(avgPoolList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(normalizationList).forEach(c -> components.add(c.core$()));
				return new java.util.ArrayList<>(components);
			}

			@Override
			protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
				java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
				return map;
			}

			@Override
			protected void addNode$(io.intino.magritte.framework.Node node) {
				super.addNode$(node);
				if (node.is("ResidualSection$CustomFirstStage$Block$Layer")) this.layerList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Layer.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$ActivationLayer")) this.activationLayerList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ActivationLayer.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$ReLU")) this.reLUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ReLU.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$ELU")) this.eLUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ELU.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$SELU")) this.sELUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SELU.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$GELU")) this.gELUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GELU.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$SiLU")) this.siLUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SiLU.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$GLU")) this.gLUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GLU.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$LeakyReLU")) this.leakyReLUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LeakyReLU.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$LogSigmoid")) this.logSigmoidList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LogSigmoid.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$Sigmoid")) this.sigmoidList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Sigmoid.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$Tanh")) this.tanhList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Tanh.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$Mish")) this.mishList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Mish.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$ProcessingLayer")) this.processingLayerList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ProcessingLayer.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$Dropout")) this.dropoutList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Dropout.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$Convolutional")) this.convolutionalList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Convolutional.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$Pool")) this.poolList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Pool.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$MaxPool")) this.maxPoolList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.MaxPool.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$AvgPool")) this.avgPoolList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.AvgPool.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$Normalization")) this.normalizationList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization.class));
			}

			@Override
			protected void removeNode$(io.intino.magritte.framework.Node node) {
				super.removeNode$(node);
				if (node.is("ResidualSection$CustomFirstStage$Block$Layer")) this.layerList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Layer.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$ActivationLayer")) this.activationLayerList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ActivationLayer.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$ReLU")) this.reLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ReLU.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$ELU")) this.eLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ELU.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$SELU")) this.sELUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SELU.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$GELU")) this.gELUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GELU.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$SiLU")) this.siLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SiLU.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$GLU")) this.gLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GLU.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$LeakyReLU")) this.leakyReLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LeakyReLU.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$LogSigmoid")) this.logSigmoidList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LogSigmoid.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$Sigmoid")) this.sigmoidList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Sigmoid.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$Tanh")) this.tanhList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Tanh.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$Mish")) this.mishList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Mish.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$ProcessingLayer")) this.processingLayerList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ProcessingLayer.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$Dropout")) this.dropoutList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Dropout.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$Convolutional")) this.convolutionalList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Convolutional.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$Pool")) this.poolList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Pool.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$MaxPool")) this.maxPoolList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.MaxPool.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$AvgPool")) this.avgPoolList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.AvgPool.class));
				if (node.is("ResidualSection$CustomFirstStage$Block$Normalization")) this.normalizationList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization.class));
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

			public class Create  {
				protected final java.lang.String name;

				public Create(java.lang.String name) {
					this.name = name;
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ReLU reLU() {
					io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ReLU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ReLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ReLU.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ELU eLU() {
					io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ELU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ELU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ELU.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SELU sELU() {
					io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SELU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SELU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SELU.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GELU gELU() {
					io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GELU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GELU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GELU.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SiLU siLU() {
					io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SiLU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SiLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SiLU.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GLU gLU() {
					io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GLU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GLU.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LeakyReLU leakyReLU() {
					io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LeakyReLU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LeakyReLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LeakyReLU.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LogSigmoid logSigmoid() {
					io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LogSigmoid newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LogSigmoid.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LogSigmoid.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Sigmoid sigmoid() {
					io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Sigmoid newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Sigmoid.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Sigmoid.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Tanh tanh() {
					io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Tanh newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Tanh.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Tanh.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Mish mish() {
					io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Mish newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Mish.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Mish.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Dropout dropout(double probability) {
					io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Dropout newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Dropout.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Dropout.class);
					newElement.core$().set(newElement, "probability", java.util.Collections.singletonList(probability));
					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Convolutional convolutional() {
					io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Convolutional newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Convolutional.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Convolutional.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.MaxPool maxPool() {
					io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.MaxPool newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.MaxPool.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.MaxPool.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.AvgPool avgPool() {
					io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.AvgPool newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.AvgPool.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.AvgPool.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization normalization() {
					io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization.class);

					return newElement;
				}

			}

			public Clear clear() {
				return new Clear();
			}

			public class Clear  {
				public void reLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ReLU> filter) {
					new java.util.ArrayList<>(reLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void eLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ELU> filter) {
					new java.util.ArrayList<>(eLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void sELU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SELU> filter) {
					new java.util.ArrayList<>(sELUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void gELU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GELU> filter) {
					new java.util.ArrayList<>(gELUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void siLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.SiLU> filter) {
					new java.util.ArrayList<>(siLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void gLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.GLU> filter) {
					new java.util.ArrayList<>(gLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void leakyReLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LeakyReLU> filter) {
					new java.util.ArrayList<>(leakyReLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void logSigmoid(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.LogSigmoid> filter) {
					new java.util.ArrayList<>(logSigmoidList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void sigmoid(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Sigmoid> filter) {
					new java.util.ArrayList<>(sigmoidList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void tanh(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Tanh> filter) {
					new java.util.ArrayList<>(tanhList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void mish(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Mish> filter) {
					new java.util.ArrayList<>(mishList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void dropout(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Dropout> filter) {
					new java.util.ArrayList<>(dropoutList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void convolutional(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Convolutional> filter) {
					new java.util.ArrayList<>(convolutionalList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void maxPool(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.MaxPool> filter) {
					new java.util.ArrayList<>(maxPoolList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void avgPool(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.AvgPool> filter) {
					new java.util.ArrayList<>(avgPoolList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void normalization(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization> filter) {
					new java.util.ArrayList<>(normalizationList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}
			}

			public static abstract class Layer  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {

				public Layer(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
					return map;
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

			public static abstract class ActivationLayer extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Layer implements io.intino.magritte.framework.tags.Terminal {

				public ActivationLayer(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class ReLU extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

				public ReLU(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class ELU extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {
				protected int alpha;

				public ELU(io.intino.magritte.framework.Node node) {
					super(node);
				}

				public int alpha() {
					return alpha;
				}

				public ELU alpha(int value) {
					this.alpha = value;
					return (ELU) this;
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					map.put("alpha", new java.util.ArrayList(java.util.Collections.singletonList(this.alpha)));
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
					if (name.equalsIgnoreCase("alpha")) this.alpha = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
					if (name.equalsIgnoreCase("alpha")) this.alpha = (java.lang.Integer) values.get(0);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class SELU extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

				public SELU(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class GELU extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

				public GELU(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class SiLU extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

				public SiLU(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class GLU extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

				public GLU(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class LeakyReLU extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {
				protected int alpha;

				public LeakyReLU(io.intino.magritte.framework.Node node) {
					super(node);
				}

				public int alpha() {
					return alpha;
				}

				public LeakyReLU alpha(int value) {
					this.alpha = value;
					return (LeakyReLU) this;
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					map.put("alpha", new java.util.ArrayList(java.util.Collections.singletonList(this.alpha)));
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
					if (name.equalsIgnoreCase("alpha")) this.alpha = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
					if (name.equalsIgnoreCase("alpha")) this.alpha = (java.lang.Integer) values.get(0);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class LogSigmoid extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

				public LogSigmoid(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class Sigmoid extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

				public Sigmoid(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class Tanh extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

				public Tanh(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class Mish extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

				public Mish(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static abstract class ProcessingLayer extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Layer implements io.intino.magritte.framework.tags.Terminal {

				public ProcessingLayer(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class Dropout extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ProcessingLayer implements io.intino.magritte.framework.tags.Terminal {
				protected double probability;

				public Dropout(io.intino.magritte.framework.Node node) {
					super(node);
				}

				public double probability() {
					return probability;
				}

				public Dropout probability(double value) {
					this.probability = value;
					return (Dropout) this;
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					map.put("probability", new java.util.ArrayList(java.util.Collections.singletonList(this.probability)));
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
					if (name.equalsIgnoreCase("probability")) this.probability = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
					if (name.equalsIgnoreCase("probability")) this.probability = (java.lang.Double) values.get(0);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class Convolutional extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ProcessingLayer implements io.intino.magritte.framework.tags.Terminal {
				protected io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Convolutional.Output output;

				public Convolutional(io.intino.magritte.framework.Node node) {
					super(node);
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Convolutional.Output output() {
					return output;
				}

				protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
					java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
					if (output != null) components.add(this.output.core$());
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
					if (node.is("ResidualSection$CustomFirstStage$Block$Convolutional$Output")) this.output = node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Convolutional.Output.class);
				}

				@Override
				protected void removeNode$(io.intino.magritte.framework.Node node) {
					super.removeNode$(node);
					if (node.is("ResidualSection$CustomFirstStage$Block$Convolutional$Output")) this.output = null;
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

				public class Create extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ProcessingLayer.Create {


					public Create(java.lang.String name) {
						super(name);
					}

					public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Convolutional.Output output(int x, int y, int z) {
						io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Convolutional.Output newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Convolutional.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Convolutional.Output.class);
						newElement.core$().set(newElement, "x", java.util.Collections.singletonList(x));
						newElement.core$().set(newElement, "y", java.util.Collections.singletonList(y));
						newElement.core$().set(newElement, "z", java.util.Collections.singletonList(z));
						return newElement;
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

			public static abstract class Pool extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ProcessingLayer implements io.intino.magritte.framework.tags.Terminal {

				public Pool(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class MaxPool extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Pool implements io.intino.magritte.framework.tags.Terminal {
				protected io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.MaxPool.Output output;

				public MaxPool(io.intino.magritte.framework.Node node) {
					super(node);
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.MaxPool.Output output() {
					return output;
				}

				protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
					java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
					if (output != null) components.add(this.output.core$());
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
					if (node.is("ResidualSection$CustomFirstStage$Block$MaxPool$Output")) this.output = node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.MaxPool.Output.class);
				}

				@Override
				protected void removeNode$(io.intino.magritte.framework.Node node) {
					super.removeNode$(node);
					if (node.is("ResidualSection$CustomFirstStage$Block$MaxPool$Output")) this.output = null;
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

				public class Create extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Pool.Create {


					public Create(java.lang.String name) {
						super(name);
					}

					public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.MaxPool.Output output(int x, int y) {
						io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.MaxPool.Output newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.MaxPool.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.MaxPool.Output.class);
						newElement.core$().set(newElement, "x", java.util.Collections.singletonList(x));
						newElement.core$().set(newElement, "y", java.util.Collections.singletonList(y));
						return newElement;
					}

				}

				public static class Output  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
					protected int x;
					protected int y;

					public Output(io.intino.magritte.framework.Node node) {
						super(node);
					}

					public int x() {
						return x;
					}

					public int y() {
						return y;
					}

					public Output x(int value) {
						this.x = value;
						return (Output) this;
					}

					public Output y(int value) {
						this.y = value;
						return (Output) this;
					}

					@Override
					protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
						java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
						map.put("x", new java.util.ArrayList(java.util.Collections.singletonList(this.x)));
						map.put("y", new java.util.ArrayList(java.util.Collections.singletonList(this.y)));
						return map;
					}

					@Override
					protected void load$(java.lang.String name, java.util.List<?> values) {
						super.load$(name, values);
						if (name.equalsIgnoreCase("x")) this.x = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
						else if (name.equalsIgnoreCase("y")) this.y = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
					}

					@Override
					protected void set$(java.lang.String name, java.util.List<?> values) {
						super.set$(name, values);
						if (name.equalsIgnoreCase("x")) this.x = (java.lang.Integer) values.get(0);
						else if (name.equalsIgnoreCase("y")) this.y = (java.lang.Integer) values.get(0);
					}

					public io.flogo.blatt.model.BlattGraph graph() {
						return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
					}
				}


				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class AvgPool extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Pool implements io.intino.magritte.framework.tags.Terminal {
				protected io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.AvgPool.Output output;

				public AvgPool(io.intino.magritte.framework.Node node) {
					super(node);
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.AvgPool.Output output() {
					return output;
				}

				protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
					java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
					if (output != null) components.add(this.output.core$());
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
					if (node.is("ResidualSection$CustomFirstStage$Block$AvgPool$Output")) this.output = node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.AvgPool.Output.class);
				}

				@Override
				protected void removeNode$(io.intino.magritte.framework.Node node) {
					super.removeNode$(node);
					if (node.is("ResidualSection$CustomFirstStage$Block$AvgPool$Output")) this.output = null;
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

				public class Create extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Pool.Create {


					public Create(java.lang.String name) {
						super(name);
					}

					public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.AvgPool.Output output(int x, int y) {
						io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.AvgPool.Output newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.AvgPool.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.AvgPool.Output.class);
						newElement.core$().set(newElement, "x", java.util.Collections.singletonList(x));
						newElement.core$().set(newElement, "y", java.util.Collections.singletonList(y));
						return newElement;
					}

				}

				public static class Output  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
					protected int x;
					protected int y;

					public Output(io.intino.magritte.framework.Node node) {
						super(node);
					}

					public int x() {
						return x;
					}

					public int y() {
						return y;
					}

					public Output x(int value) {
						this.x = value;
						return (Output) this;
					}

					public Output y(int value) {
						this.y = value;
						return (Output) this;
					}

					@Override
					protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
						java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
						map.put("x", new java.util.ArrayList(java.util.Collections.singletonList(this.x)));
						map.put("y", new java.util.ArrayList(java.util.Collections.singletonList(this.y)));
						return map;
					}

					@Override
					protected void load$(java.lang.String name, java.util.List<?> values) {
						super.load$(name, values);
						if (name.equalsIgnoreCase("x")) this.x = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
						else if (name.equalsIgnoreCase("y")) this.y = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
					}

					@Override
					protected void set$(java.lang.String name, java.util.List<?> values) {
						super.set$(name, values);
						if (name.equalsIgnoreCase("x")) this.x = (java.lang.Integer) values.get(0);
						else if (name.equalsIgnoreCase("y")) this.y = (java.lang.Integer) values.get(0);
					}

					public io.flogo.blatt.model.BlattGraph graph() {
						return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
					}
				}


				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class Normalization extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ProcessingLayer implements io.intino.magritte.framework.tags.Terminal {
				protected double eps;
				protected double momentum;
				protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization.Output> outputList = new java.util.ArrayList<>();

				public Normalization(io.intino.magritte.framework.Node node) {
					super(node);
				}

				public double eps() {
					return eps;
				}

				public double momentum() {
					return momentum;
				}

				public Normalization eps(double value) {
					this.eps = value;
					return (Normalization) this;
				}

				public Normalization momentum(double value) {
					this.momentum = value;
					return (Normalization) this;
				}

				public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization.Output> outputList() {
					return java.util.Collections.unmodifiableList(outputList);
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization.Output output(int index) {
					return outputList.get(index);
				}

				public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization.Output> outputList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization.Output> predicate) {
					return outputList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization.Output output(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization.Output> predicate) {
					return outputList().stream().filter(predicate).findFirst().orElse(null);
				}

				protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
					java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
					new java.util.ArrayList<>(outputList).forEach(c -> components.add(c.core$()));
					return new java.util.ArrayList<>(components);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					map.put("eps", new java.util.ArrayList(java.util.Collections.singletonList(this.eps)));
					map.put("momentum", new java.util.ArrayList(java.util.Collections.singletonList(this.momentum)));
					return map;
				}

				@Override
				protected void addNode$(io.intino.magritte.framework.Node node) {
					super.addNode$(node);
					if (node.is("ResidualSection$CustomFirstStage$Block$Normalization$Output")) this.outputList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization.Output.class));
				}

				@Override
				protected void removeNode$(io.intino.magritte.framework.Node node) {
					super.removeNode$(node);
					if (node.is("ResidualSection$CustomFirstStage$Block$Normalization$Output")) this.outputList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization.Output.class));
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
					if (name.equalsIgnoreCase("eps")) this.eps = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
					else if (name.equalsIgnoreCase("momentum")) this.momentum = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
					if (name.equalsIgnoreCase("eps")) this.eps = (java.lang.Double) values.get(0);
					else if (name.equalsIgnoreCase("momentum")) this.momentum = (java.lang.Double) values.get(0);
				}

				public Create create() {
					return new Create(null);
				}

				public Create create(java.lang.String name) {
					return new Create(name);
				}

				public class Create extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.ProcessingLayer.Create {


					public Create(java.lang.String name) {
						super(name);
					}

					public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization.Output output(double z) {
						io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization.Output newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization.Output.class);
						newElement.core$().set(newElement, "z", java.util.Collections.singletonList(z));
						return newElement;
					}

				}

				public Clear clear() {
					return new Clear();
				}

				public class Clear  {
					public void output(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Block.Normalization.Output> filter) {
						new java.util.ArrayList<>(outputList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
					}
				}

				public static class Output  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
					protected double z;

					public Output(io.intino.magritte.framework.Node node) {
						super(node);
					}

					public double z() {
						return z;
					}

					public Output z(double value) {
						this.z = value;
						return (Output) this;
					}

					@Override
					protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
						java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
						map.put("z", new java.util.ArrayList(java.util.Collections.singletonList(this.z)));
						return map;
					}

					@Override
					protected void load$(java.lang.String name, java.util.List<?> values) {
						super.load$(name, values);
						if (name.equalsIgnoreCase("z")) this.z = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
					}

					@Override
					protected void set$(java.lang.String name, java.util.List<?> values) {
						super.set$(name, values);
						if (name.equalsIgnoreCase("z")) this.z = (java.lang.Double) values.get(0);
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


		public io.flogo.blatt.model.BlattGraph graph() {
			return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
		}
	}

	public static class ResidualLayer  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
		protected int repeat;
		protected int expansion;

		public ResidualLayer(io.intino.magritte.framework.Node node) {
			super(node);
		}

		public int repeat() {
			return repeat;
		}

		public int expansion() {
			return expansion;
		}

		public ResidualLayer repeat(int value) {
			this.repeat = value;
			return (ResidualLayer) this;
		}

		public ResidualLayer expansion(int value) {
			this.expansion = value;
			return (ResidualLayer) this;
		}

		@Override
		protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
			java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
			map.put("repeat", new java.util.ArrayList(java.util.Collections.singletonList(this.repeat)));
			map.put("expansion", new java.util.ArrayList(java.util.Collections.singletonList(this.expansion)));
			return map;
		}

		@Override
		protected void load$(java.lang.String name, java.util.List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("repeat")) this.repeat = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
			else if (name.equalsIgnoreCase("expansion")) this.expansion = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
		}

		@Override
		protected void set$(java.lang.String name, java.util.List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("repeat")) this.repeat = (java.lang.Integer) values.get(0);
			else if (name.equalsIgnoreCase("expansion")) this.expansion = (java.lang.Integer) values.get(0);
		}

		public io.flogo.blatt.model.BlattGraph graph() {
			return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
		}
	}

	public static abstract class LastStage  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {

		public LastStage(io.intino.magritte.framework.Node node) {
			super(node);
		}

		@Override
		protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
			java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
			return map;
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

	public static class DefaultLastStage extends io.flogo.blatt.model.ResidualSection.LastStage implements io.intino.magritte.framework.tags.Terminal {

		public DefaultLastStage(io.intino.magritte.framework.Node node) {
			super(node);
		}

		@Override
		protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
			java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
			return map;
		}

		@Override
		protected void load$(java.lang.String name, java.util.List<?> values) {
			super.load$(name, values);
		}

		@Override
		protected void set$(java.lang.String name, java.util.List<?> values) {
			super.set$(name, values);
		}

		public io.flogo.blatt.model.BlattGraph graph() {
			return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
		}
	}

	public static class CustomLastStage extends io.flogo.blatt.model.ResidualSection.LastStage implements io.intino.magritte.framework.tags.Terminal {
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block> blockList = new java.util.ArrayList<>();

		public CustomLastStage(io.intino.magritte.framework.Node node) {
			super(node);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block> blockList() {
			return java.util.Collections.unmodifiableList(blockList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block block(int index) {
			return blockList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block> blockList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block> predicate) {
			return blockList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block block(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block> predicate) {
			return blockList().stream().filter(predicate).findFirst().orElse(null);
		}

		protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
			java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
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
			if (node.is("ResidualSection$CustomLastStage$Block")) this.blockList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.class));
		}

		@Override
		protected void removeNode$(io.intino.magritte.framework.Node node) {
			super.removeNode$(node);
			if (node.is("ResidualSection$CustomLastStage$Block")) this.blockList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.class));
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

		public class Create extends io.flogo.blatt.model.ResidualSection.LastStage.Create {


			public Create(java.lang.String name) {
				super(name);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block block() {
				io.flogo.blatt.model.ResidualSection.CustomLastStage.Block newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.class);

				return newElement;
			}

		}

		public Clear clear() {
			return new Clear();
		}

		public class Clear  {
			public void block(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block> filter) {
				new java.util.ArrayList<>(blockList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}
		}

		public static class Block  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Layer> layerList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ActivationLayer> activationLayerList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ReLU> reLUList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ELU> eLUList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SELU> sELUList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GELU> gELUList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SiLU> siLUList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GLU> gLUList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LeakyReLU> leakyReLUList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LogSigmoid> logSigmoidList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Sigmoid> sigmoidList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Tanh> tanhList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Mish> mishList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ProcessingLayer> processingLayerList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Dropout> dropoutList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Convolutional> convolutionalList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Pool> poolList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.MaxPool> maxPoolList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.AvgPool> avgPoolList = new java.util.ArrayList<>();
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization> normalizationList = new java.util.ArrayList<>();

			public Block(io.intino.magritte.framework.Node node) {
				super(node);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Layer> layerList() {
				return java.util.Collections.unmodifiableList(layerList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Layer layer(int index) {
				return layerList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Layer> layerList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Layer> predicate) {
				return layerList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Layer layer(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Layer> predicate) {
				return layerList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ActivationLayer> activationLayerList() {
				return java.util.Collections.unmodifiableList(activationLayerList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ActivationLayer activationLayer(int index) {
				return activationLayerList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ActivationLayer> activationLayerList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ActivationLayer> predicate) {
				return activationLayerList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ActivationLayer activationLayer(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ActivationLayer> predicate) {
				return activationLayerList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ReLU> reLUList() {
				return java.util.Collections.unmodifiableList(reLUList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ReLU reLU(int index) {
				return reLUList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ReLU> reLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ReLU> predicate) {
				return reLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ReLU reLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ReLU> predicate) {
				return reLUList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ELU> eLUList() {
				return java.util.Collections.unmodifiableList(eLUList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ELU eLU(int index) {
				return eLUList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ELU> eLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ELU> predicate) {
				return eLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ELU eLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ELU> predicate) {
				return eLUList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SELU> sELUList() {
				return java.util.Collections.unmodifiableList(sELUList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SELU sELU(int index) {
				return sELUList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SELU> sELUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SELU> predicate) {
				return sELUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SELU sELU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SELU> predicate) {
				return sELUList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GELU> gELUList() {
				return java.util.Collections.unmodifiableList(gELUList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GELU gELU(int index) {
				return gELUList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GELU> gELUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GELU> predicate) {
				return gELUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GELU gELU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GELU> predicate) {
				return gELUList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SiLU> siLUList() {
				return java.util.Collections.unmodifiableList(siLUList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SiLU siLU(int index) {
				return siLUList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SiLU> siLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SiLU> predicate) {
				return siLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SiLU siLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SiLU> predicate) {
				return siLUList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GLU> gLUList() {
				return java.util.Collections.unmodifiableList(gLUList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GLU gLU(int index) {
				return gLUList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GLU> gLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GLU> predicate) {
				return gLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GLU gLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GLU> predicate) {
				return gLUList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LeakyReLU> leakyReLUList() {
				return java.util.Collections.unmodifiableList(leakyReLUList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LeakyReLU leakyReLU(int index) {
				return leakyReLUList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LeakyReLU> leakyReLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LeakyReLU> predicate) {
				return leakyReLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LeakyReLU leakyReLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LeakyReLU> predicate) {
				return leakyReLUList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LogSigmoid> logSigmoidList() {
				return java.util.Collections.unmodifiableList(logSigmoidList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LogSigmoid logSigmoid(int index) {
				return logSigmoidList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LogSigmoid> logSigmoidList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LogSigmoid> predicate) {
				return logSigmoidList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LogSigmoid logSigmoid(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LogSigmoid> predicate) {
				return logSigmoidList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Sigmoid> sigmoidList() {
				return java.util.Collections.unmodifiableList(sigmoidList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Sigmoid sigmoid(int index) {
				return sigmoidList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Sigmoid> sigmoidList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Sigmoid> predicate) {
				return sigmoidList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Sigmoid sigmoid(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Sigmoid> predicate) {
				return sigmoidList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Tanh> tanhList() {
				return java.util.Collections.unmodifiableList(tanhList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Tanh tanh(int index) {
				return tanhList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Tanh> tanhList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Tanh> predicate) {
				return tanhList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Tanh tanh(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Tanh> predicate) {
				return tanhList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Mish> mishList() {
				return java.util.Collections.unmodifiableList(mishList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Mish mish(int index) {
				return mishList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Mish> mishList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Mish> predicate) {
				return mishList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Mish mish(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Mish> predicate) {
				return mishList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ProcessingLayer> processingLayerList() {
				return java.util.Collections.unmodifiableList(processingLayerList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ProcessingLayer processingLayer(int index) {
				return processingLayerList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ProcessingLayer> processingLayerList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ProcessingLayer> predicate) {
				return processingLayerList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ProcessingLayer processingLayer(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ProcessingLayer> predicate) {
				return processingLayerList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Dropout> dropoutList() {
				return java.util.Collections.unmodifiableList(dropoutList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Dropout dropout(int index) {
				return dropoutList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Dropout> dropoutList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Dropout> predicate) {
				return dropoutList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Dropout dropout(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Dropout> predicate) {
				return dropoutList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Convolutional> convolutionalList() {
				return java.util.Collections.unmodifiableList(convolutionalList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Convolutional convolutional(int index) {
				return convolutionalList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Convolutional> convolutionalList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Convolutional> predicate) {
				return convolutionalList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Convolutional convolutional(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Convolutional> predicate) {
				return convolutionalList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Pool> poolList() {
				return java.util.Collections.unmodifiableList(poolList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Pool pool(int index) {
				return poolList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Pool> poolList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Pool> predicate) {
				return poolList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Pool pool(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Pool> predicate) {
				return poolList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.MaxPool> maxPoolList() {
				return java.util.Collections.unmodifiableList(maxPoolList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.MaxPool maxPool(int index) {
				return maxPoolList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.MaxPool> maxPoolList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.MaxPool> predicate) {
				return maxPoolList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.MaxPool maxPool(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.MaxPool> predicate) {
				return maxPoolList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.AvgPool> avgPoolList() {
				return java.util.Collections.unmodifiableList(avgPoolList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.AvgPool avgPool(int index) {
				return avgPoolList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.AvgPool> avgPoolList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.AvgPool> predicate) {
				return avgPoolList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.AvgPool avgPool(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.AvgPool> predicate) {
				return avgPoolList().stream().filter(predicate).findFirst().orElse(null);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization> normalizationList() {
				return java.util.Collections.unmodifiableList(normalizationList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization normalization(int index) {
				return normalizationList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization> normalizationList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization> predicate) {
				return normalizationList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization normalization(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization> predicate) {
				return normalizationList().stream().filter(predicate).findFirst().orElse(null);
			}

			protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
				java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
				new java.util.ArrayList<>(layerList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(activationLayerList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(reLUList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(eLUList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(sELUList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(gELUList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(siLUList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(gLUList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(leakyReLUList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(logSigmoidList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(sigmoidList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(tanhList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(mishList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(processingLayerList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(dropoutList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(convolutionalList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(poolList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(maxPoolList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(avgPoolList).forEach(c -> components.add(c.core$()));
				new java.util.ArrayList<>(normalizationList).forEach(c -> components.add(c.core$()));
				return new java.util.ArrayList<>(components);
			}

			@Override
			protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
				java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
				return map;
			}

			@Override
			protected void addNode$(io.intino.magritte.framework.Node node) {
				super.addNode$(node);
				if (node.is("ResidualSection$CustomLastStage$Block$Layer")) this.layerList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Layer.class));
				if (node.is("ResidualSection$CustomLastStage$Block$ActivationLayer")) this.activationLayerList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ActivationLayer.class));
				if (node.is("ResidualSection$CustomLastStage$Block$ReLU")) this.reLUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ReLU.class));
				if (node.is("ResidualSection$CustomLastStage$Block$ELU")) this.eLUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ELU.class));
				if (node.is("ResidualSection$CustomLastStage$Block$SELU")) this.sELUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SELU.class));
				if (node.is("ResidualSection$CustomLastStage$Block$GELU")) this.gELUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GELU.class));
				if (node.is("ResidualSection$CustomLastStage$Block$SiLU")) this.siLUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SiLU.class));
				if (node.is("ResidualSection$CustomLastStage$Block$GLU")) this.gLUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GLU.class));
				if (node.is("ResidualSection$CustomLastStage$Block$LeakyReLU")) this.leakyReLUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LeakyReLU.class));
				if (node.is("ResidualSection$CustomLastStage$Block$LogSigmoid")) this.logSigmoidList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LogSigmoid.class));
				if (node.is("ResidualSection$CustomLastStage$Block$Sigmoid")) this.sigmoidList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Sigmoid.class));
				if (node.is("ResidualSection$CustomLastStage$Block$Tanh")) this.tanhList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Tanh.class));
				if (node.is("ResidualSection$CustomLastStage$Block$Mish")) this.mishList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Mish.class));
				if (node.is("ResidualSection$CustomLastStage$Block$ProcessingLayer")) this.processingLayerList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ProcessingLayer.class));
				if (node.is("ResidualSection$CustomLastStage$Block$Dropout")) this.dropoutList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Dropout.class));
				if (node.is("ResidualSection$CustomLastStage$Block$Convolutional")) this.convolutionalList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Convolutional.class));
				if (node.is("ResidualSection$CustomLastStage$Block$Pool")) this.poolList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Pool.class));
				if (node.is("ResidualSection$CustomLastStage$Block$MaxPool")) this.maxPoolList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.MaxPool.class));
				if (node.is("ResidualSection$CustomLastStage$Block$AvgPool")) this.avgPoolList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.AvgPool.class));
				if (node.is("ResidualSection$CustomLastStage$Block$Normalization")) this.normalizationList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization.class));
			}

			@Override
			protected void removeNode$(io.intino.magritte.framework.Node node) {
				super.removeNode$(node);
				if (node.is("ResidualSection$CustomLastStage$Block$Layer")) this.layerList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Layer.class));
				if (node.is("ResidualSection$CustomLastStage$Block$ActivationLayer")) this.activationLayerList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ActivationLayer.class));
				if (node.is("ResidualSection$CustomLastStage$Block$ReLU")) this.reLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ReLU.class));
				if (node.is("ResidualSection$CustomLastStage$Block$ELU")) this.eLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ELU.class));
				if (node.is("ResidualSection$CustomLastStage$Block$SELU")) this.sELUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SELU.class));
				if (node.is("ResidualSection$CustomLastStage$Block$GELU")) this.gELUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GELU.class));
				if (node.is("ResidualSection$CustomLastStage$Block$SiLU")) this.siLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SiLU.class));
				if (node.is("ResidualSection$CustomLastStage$Block$GLU")) this.gLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GLU.class));
				if (node.is("ResidualSection$CustomLastStage$Block$LeakyReLU")) this.leakyReLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LeakyReLU.class));
				if (node.is("ResidualSection$CustomLastStage$Block$LogSigmoid")) this.logSigmoidList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LogSigmoid.class));
				if (node.is("ResidualSection$CustomLastStage$Block$Sigmoid")) this.sigmoidList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Sigmoid.class));
				if (node.is("ResidualSection$CustomLastStage$Block$Tanh")) this.tanhList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Tanh.class));
				if (node.is("ResidualSection$CustomLastStage$Block$Mish")) this.mishList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Mish.class));
				if (node.is("ResidualSection$CustomLastStage$Block$ProcessingLayer")) this.processingLayerList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ProcessingLayer.class));
				if (node.is("ResidualSection$CustomLastStage$Block$Dropout")) this.dropoutList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Dropout.class));
				if (node.is("ResidualSection$CustomLastStage$Block$Convolutional")) this.convolutionalList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Convolutional.class));
				if (node.is("ResidualSection$CustomLastStage$Block$Pool")) this.poolList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Pool.class));
				if (node.is("ResidualSection$CustomLastStage$Block$MaxPool")) this.maxPoolList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.MaxPool.class));
				if (node.is("ResidualSection$CustomLastStage$Block$AvgPool")) this.avgPoolList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.AvgPool.class));
				if (node.is("ResidualSection$CustomLastStage$Block$Normalization")) this.normalizationList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization.class));
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

			public class Create  {
				protected final java.lang.String name;

				public Create(java.lang.String name) {
					this.name = name;
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ReLU reLU() {
					io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ReLU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ReLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ReLU.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ELU eLU() {
					io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ELU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ELU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ELU.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SELU sELU() {
					io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SELU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SELU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SELU.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GELU gELU() {
					io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GELU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GELU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GELU.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SiLU siLU() {
					io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SiLU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SiLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SiLU.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GLU gLU() {
					io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GLU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GLU.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LeakyReLU leakyReLU() {
					io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LeakyReLU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LeakyReLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LeakyReLU.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LogSigmoid logSigmoid() {
					io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LogSigmoid newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LogSigmoid.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LogSigmoid.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Sigmoid sigmoid() {
					io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Sigmoid newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Sigmoid.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Sigmoid.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Tanh tanh() {
					io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Tanh newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Tanh.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Tanh.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Mish mish() {
					io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Mish newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Mish.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Mish.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Dropout dropout(double probability) {
					io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Dropout newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Dropout.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Dropout.class);
					newElement.core$().set(newElement, "probability", java.util.Collections.singletonList(probability));
					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Convolutional convolutional() {
					io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Convolutional newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Convolutional.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Convolutional.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.MaxPool maxPool() {
					io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.MaxPool newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.MaxPool.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.MaxPool.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.AvgPool avgPool() {
					io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.AvgPool newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.AvgPool.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.AvgPool.class);

					return newElement;
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization normalization() {
					io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization.class);

					return newElement;
				}

			}

			public Clear clear() {
				return new Clear();
			}

			public class Clear  {
				public void reLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ReLU> filter) {
					new java.util.ArrayList<>(reLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void eLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ELU> filter) {
					new java.util.ArrayList<>(eLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void sELU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SELU> filter) {
					new java.util.ArrayList<>(sELUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void gELU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GELU> filter) {
					new java.util.ArrayList<>(gELUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void siLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.SiLU> filter) {
					new java.util.ArrayList<>(siLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void gLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.GLU> filter) {
					new java.util.ArrayList<>(gLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void leakyReLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LeakyReLU> filter) {
					new java.util.ArrayList<>(leakyReLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void logSigmoid(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.LogSigmoid> filter) {
					new java.util.ArrayList<>(logSigmoidList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void sigmoid(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Sigmoid> filter) {
					new java.util.ArrayList<>(sigmoidList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void tanh(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Tanh> filter) {
					new java.util.ArrayList<>(tanhList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void mish(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Mish> filter) {
					new java.util.ArrayList<>(mishList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void dropout(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Dropout> filter) {
					new java.util.ArrayList<>(dropoutList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void convolutional(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Convolutional> filter) {
					new java.util.ArrayList<>(convolutionalList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void maxPool(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.MaxPool> filter) {
					new java.util.ArrayList<>(maxPoolList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void avgPool(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.AvgPool> filter) {
					new java.util.ArrayList<>(avgPoolList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}

				public void normalization(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization> filter) {
					new java.util.ArrayList<>(normalizationList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
				}
			}

			public static abstract class Layer  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {

				public Layer(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
					return map;
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

			public static abstract class ActivationLayer extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Layer implements io.intino.magritte.framework.tags.Terminal {

				public ActivationLayer(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class ReLU extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

				public ReLU(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class ELU extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {
				protected int alpha;

				public ELU(io.intino.magritte.framework.Node node) {
					super(node);
				}

				public int alpha() {
					return alpha;
				}

				public ELU alpha(int value) {
					this.alpha = value;
					return (ELU) this;
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					map.put("alpha", new java.util.ArrayList(java.util.Collections.singletonList(this.alpha)));
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
					if (name.equalsIgnoreCase("alpha")) this.alpha = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
					if (name.equalsIgnoreCase("alpha")) this.alpha = (java.lang.Integer) values.get(0);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class SELU extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

				public SELU(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class GELU extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

				public GELU(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class SiLU extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

				public SiLU(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class GLU extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

				public GLU(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class LeakyReLU extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {
				protected int alpha;

				public LeakyReLU(io.intino.magritte.framework.Node node) {
					super(node);
				}

				public int alpha() {
					return alpha;
				}

				public LeakyReLU alpha(int value) {
					this.alpha = value;
					return (LeakyReLU) this;
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					map.put("alpha", new java.util.ArrayList(java.util.Collections.singletonList(this.alpha)));
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
					if (name.equalsIgnoreCase("alpha")) this.alpha = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
					if (name.equalsIgnoreCase("alpha")) this.alpha = (java.lang.Integer) values.get(0);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class LogSigmoid extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

				public LogSigmoid(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class Sigmoid extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

				public Sigmoid(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class Tanh extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

				public Tanh(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class Mish extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

				public Mish(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static abstract class ProcessingLayer extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Layer implements io.intino.magritte.framework.tags.Terminal {

				public ProcessingLayer(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class Dropout extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ProcessingLayer implements io.intino.magritte.framework.tags.Terminal {
				protected double probability;

				public Dropout(io.intino.magritte.framework.Node node) {
					super(node);
				}

				public double probability() {
					return probability;
				}

				public Dropout probability(double value) {
					this.probability = value;
					return (Dropout) this;
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					map.put("probability", new java.util.ArrayList(java.util.Collections.singletonList(this.probability)));
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
					if (name.equalsIgnoreCase("probability")) this.probability = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
					if (name.equalsIgnoreCase("probability")) this.probability = (java.lang.Double) values.get(0);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class Convolutional extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ProcessingLayer implements io.intino.magritte.framework.tags.Terminal {
				protected io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Convolutional.Output output;

				public Convolutional(io.intino.magritte.framework.Node node) {
					super(node);
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Convolutional.Output output() {
					return output;
				}

				protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
					java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
					if (output != null) components.add(this.output.core$());
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
					if (node.is("ResidualSection$CustomLastStage$Block$Convolutional$Output")) this.output = node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Convolutional.Output.class);
				}

				@Override
				protected void removeNode$(io.intino.magritte.framework.Node node) {
					super.removeNode$(node);
					if (node.is("ResidualSection$CustomLastStage$Block$Convolutional$Output")) this.output = null;
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

				public class Create extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ProcessingLayer.Create {


					public Create(java.lang.String name) {
						super(name);
					}

					public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Convolutional.Output output(int x, int y, int z) {
						io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Convolutional.Output newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Convolutional.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Convolutional.Output.class);
						newElement.core$().set(newElement, "x", java.util.Collections.singletonList(x));
						newElement.core$().set(newElement, "y", java.util.Collections.singletonList(y));
						newElement.core$().set(newElement, "z", java.util.Collections.singletonList(z));
						return newElement;
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

			public static abstract class Pool extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ProcessingLayer implements io.intino.magritte.framework.tags.Terminal {

				public Pool(io.intino.magritte.framework.Node node) {
					super(node);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					return map;
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
				}

				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class MaxPool extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Pool implements io.intino.magritte.framework.tags.Terminal {
				protected io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.MaxPool.Output output;

				public MaxPool(io.intino.magritte.framework.Node node) {
					super(node);
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.MaxPool.Output output() {
					return output;
				}

				protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
					java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
					if (output != null) components.add(this.output.core$());
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
					if (node.is("ResidualSection$CustomLastStage$Block$MaxPool$Output")) this.output = node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.MaxPool.Output.class);
				}

				@Override
				protected void removeNode$(io.intino.magritte.framework.Node node) {
					super.removeNode$(node);
					if (node.is("ResidualSection$CustomLastStage$Block$MaxPool$Output")) this.output = null;
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

				public class Create extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Pool.Create {


					public Create(java.lang.String name) {
						super(name);
					}

					public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.MaxPool.Output output(int x, int y) {
						io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.MaxPool.Output newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.MaxPool.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.MaxPool.Output.class);
						newElement.core$().set(newElement, "x", java.util.Collections.singletonList(x));
						newElement.core$().set(newElement, "y", java.util.Collections.singletonList(y));
						return newElement;
					}

				}

				public static class Output  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
					protected int x;
					protected int y;

					public Output(io.intino.magritte.framework.Node node) {
						super(node);
					}

					public int x() {
						return x;
					}

					public int y() {
						return y;
					}

					public Output x(int value) {
						this.x = value;
						return (Output) this;
					}

					public Output y(int value) {
						this.y = value;
						return (Output) this;
					}

					@Override
					protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
						java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
						map.put("x", new java.util.ArrayList(java.util.Collections.singletonList(this.x)));
						map.put("y", new java.util.ArrayList(java.util.Collections.singletonList(this.y)));
						return map;
					}

					@Override
					protected void load$(java.lang.String name, java.util.List<?> values) {
						super.load$(name, values);
						if (name.equalsIgnoreCase("x")) this.x = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
						else if (name.equalsIgnoreCase("y")) this.y = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
					}

					@Override
					protected void set$(java.lang.String name, java.util.List<?> values) {
						super.set$(name, values);
						if (name.equalsIgnoreCase("x")) this.x = (java.lang.Integer) values.get(0);
						else if (name.equalsIgnoreCase("y")) this.y = (java.lang.Integer) values.get(0);
					}

					public io.flogo.blatt.model.BlattGraph graph() {
						return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
					}
				}


				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class AvgPool extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Pool implements io.intino.magritte.framework.tags.Terminal {
				protected io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.AvgPool.Output output;

				public AvgPool(io.intino.magritte.framework.Node node) {
					super(node);
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.AvgPool.Output output() {
					return output;
				}

				protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
					java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
					if (output != null) components.add(this.output.core$());
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
					if (node.is("ResidualSection$CustomLastStage$Block$AvgPool$Output")) this.output = node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.AvgPool.Output.class);
				}

				@Override
				protected void removeNode$(io.intino.magritte.framework.Node node) {
					super.removeNode$(node);
					if (node.is("ResidualSection$CustomLastStage$Block$AvgPool$Output")) this.output = null;
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

				public class Create extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Pool.Create {


					public Create(java.lang.String name) {
						super(name);
					}

					public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.AvgPool.Output output(int x, int y) {
						io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.AvgPool.Output newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.AvgPool.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.AvgPool.Output.class);
						newElement.core$().set(newElement, "x", java.util.Collections.singletonList(x));
						newElement.core$().set(newElement, "y", java.util.Collections.singletonList(y));
						return newElement;
					}

				}

				public static class Output  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
					protected int x;
					protected int y;

					public Output(io.intino.magritte.framework.Node node) {
						super(node);
					}

					public int x() {
						return x;
					}

					public int y() {
						return y;
					}

					public Output x(int value) {
						this.x = value;
						return (Output) this;
					}

					public Output y(int value) {
						this.y = value;
						return (Output) this;
					}

					@Override
					protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
						java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
						map.put("x", new java.util.ArrayList(java.util.Collections.singletonList(this.x)));
						map.put("y", new java.util.ArrayList(java.util.Collections.singletonList(this.y)));
						return map;
					}

					@Override
					protected void load$(java.lang.String name, java.util.List<?> values) {
						super.load$(name, values);
						if (name.equalsIgnoreCase("x")) this.x = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
						else if (name.equalsIgnoreCase("y")) this.y = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
					}

					@Override
					protected void set$(java.lang.String name, java.util.List<?> values) {
						super.set$(name, values);
						if (name.equalsIgnoreCase("x")) this.x = (java.lang.Integer) values.get(0);
						else if (name.equalsIgnoreCase("y")) this.y = (java.lang.Integer) values.get(0);
					}

					public io.flogo.blatt.model.BlattGraph graph() {
						return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
					}
				}


				public io.flogo.blatt.model.BlattGraph graph() {
					return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
				}
			}

			public static class Normalization extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ProcessingLayer implements io.intino.magritte.framework.tags.Terminal {
				protected double eps;
				protected double momentum;
				protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization.Output> outputList = new java.util.ArrayList<>();

				public Normalization(io.intino.magritte.framework.Node node) {
					super(node);
				}

				public double eps() {
					return eps;
				}

				public double momentum() {
					return momentum;
				}

				public Normalization eps(double value) {
					this.eps = value;
					return (Normalization) this;
				}

				public Normalization momentum(double value) {
					this.momentum = value;
					return (Normalization) this;
				}

				public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization.Output> outputList() {
					return java.util.Collections.unmodifiableList(outputList);
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization.Output output(int index) {
					return outputList.get(index);
				}

				public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization.Output> outputList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization.Output> predicate) {
					return outputList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization.Output output(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization.Output> predicate) {
					return outputList().stream().filter(predicate).findFirst().orElse(null);
				}

				protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
					java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
					new java.util.ArrayList<>(outputList).forEach(c -> components.add(c.core$()));
					return new java.util.ArrayList<>(components);
				}

				@Override
				protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
					java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
					map.put("eps", new java.util.ArrayList(java.util.Collections.singletonList(this.eps)));
					map.put("momentum", new java.util.ArrayList(java.util.Collections.singletonList(this.momentum)));
					return map;
				}

				@Override
				protected void addNode$(io.intino.magritte.framework.Node node) {
					super.addNode$(node);
					if (node.is("ResidualSection$CustomLastStage$Block$Normalization$Output")) this.outputList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization.Output.class));
				}

				@Override
				protected void removeNode$(io.intino.magritte.framework.Node node) {
					super.removeNode$(node);
					if (node.is("ResidualSection$CustomLastStage$Block$Normalization$Output")) this.outputList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization.Output.class));
				}

				@Override
				protected void load$(java.lang.String name, java.util.List<?> values) {
					super.load$(name, values);
					if (name.equalsIgnoreCase("eps")) this.eps = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
					else if (name.equalsIgnoreCase("momentum")) this.momentum = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
				}

				@Override
				protected void set$(java.lang.String name, java.util.List<?> values) {
					super.set$(name, values);
					if (name.equalsIgnoreCase("eps")) this.eps = (java.lang.Double) values.get(0);
					else if (name.equalsIgnoreCase("momentum")) this.momentum = (java.lang.Double) values.get(0);
				}

				public Create create() {
					return new Create(null);
				}

				public Create create(java.lang.String name) {
					return new Create(name);
				}

				public class Create extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.ProcessingLayer.Create {


					public Create(java.lang.String name) {
						super(name);
					}

					public io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization.Output output(double z) {
						io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization.Output newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization.Output.class);
						newElement.core$().set(newElement, "z", java.util.Collections.singletonList(z));
						return newElement;
					}

				}

				public Clear clear() {
					return new Clear();
				}

				public class Clear  {
					public void output(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Block.Normalization.Output> filter) {
						new java.util.ArrayList<>(outputList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
					}
				}

				public static class Output  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
					protected double z;

					public Output(io.intino.magritte.framework.Node node) {
						super(node);
					}

					public double z() {
						return z;
					}

					public Output z(double value) {
						this.z = value;
						return (Output) this;
					}

					@Override
					protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
						java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
						map.put("z", new java.util.ArrayList(java.util.Collections.singletonList(this.z)));
						return map;
					}

					@Override
					protected void load$(java.lang.String name, java.util.List<?> values) {
						super.load$(name, values);
						if (name.equalsIgnoreCase("z")) this.z = io.intino.magritte.framework.loaders.DoubleLoader.load(values, this).get(0);
					}

					@Override
					protected void set$(java.lang.String name, java.util.List<?> values) {
						super.set$(name, values);
						if (name.equalsIgnoreCase("z")) this.z = (java.lang.Double) values.get(0);
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


		public io.flogo.blatt.model.BlattGraph graph() {
			return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
		}
	}


	public io.flogo.blatt.model.BlattGraph graph() {
		return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
	}
}