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
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Layer> layerList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.ActivationLayer> activationLayerList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.ReLU> reLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.ELU> eLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.SELU> sELUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.GELU> gELUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.SiLU> siLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.GLU> gLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.LeakyReLU> leakyReLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.LogSigmoid> logSigmoidList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Sigmoid> sigmoidList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Tanh> tanhList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Mish> mishList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.ProcessingLayer> processingLayerList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Dropout> dropoutList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Convolutional> convolutionalList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Pool> poolList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.MaxPool> maxPoolList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.AvgPool> avgPoolList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization> normalizationList = new java.util.ArrayList<>();

		public CustomFirstStage(io.intino.magritte.framework.Node node) {
			super(node);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Layer> layerList() {
			return java.util.Collections.unmodifiableList(layerList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Layer layer(int index) {
			return layerList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Layer> layerList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Layer> predicate) {
			return layerList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Layer layer(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Layer> predicate) {
			return layerList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.ActivationLayer> activationLayerList() {
			return java.util.Collections.unmodifiableList(activationLayerList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.ActivationLayer activationLayer(int index) {
			return activationLayerList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.ActivationLayer> activationLayerList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.ActivationLayer> predicate) {
			return activationLayerList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.ActivationLayer activationLayer(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.ActivationLayer> predicate) {
			return activationLayerList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.ReLU> reLUList() {
			return java.util.Collections.unmodifiableList(reLUList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.ReLU reLU(int index) {
			return reLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.ReLU> reLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.ReLU> predicate) {
			return reLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.ReLU reLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.ReLU> predicate) {
			return reLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.ELU> eLUList() {
			return java.util.Collections.unmodifiableList(eLUList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.ELU eLU(int index) {
			return eLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.ELU> eLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.ELU> predicate) {
			return eLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.ELU eLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.ELU> predicate) {
			return eLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.SELU> sELUList() {
			return java.util.Collections.unmodifiableList(sELUList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.SELU sELU(int index) {
			return sELUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.SELU> sELUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.SELU> predicate) {
			return sELUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.SELU sELU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.SELU> predicate) {
			return sELUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.GELU> gELUList() {
			return java.util.Collections.unmodifiableList(gELUList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.GELU gELU(int index) {
			return gELUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.GELU> gELUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.GELU> predicate) {
			return gELUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.GELU gELU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.GELU> predicate) {
			return gELUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.SiLU> siLUList() {
			return java.util.Collections.unmodifiableList(siLUList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.SiLU siLU(int index) {
			return siLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.SiLU> siLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.SiLU> predicate) {
			return siLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.SiLU siLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.SiLU> predicate) {
			return siLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.GLU> gLUList() {
			return java.util.Collections.unmodifiableList(gLUList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.GLU gLU(int index) {
			return gLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.GLU> gLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.GLU> predicate) {
			return gLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.GLU gLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.GLU> predicate) {
			return gLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.LeakyReLU> leakyReLUList() {
			return java.util.Collections.unmodifiableList(leakyReLUList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.LeakyReLU leakyReLU(int index) {
			return leakyReLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.LeakyReLU> leakyReLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.LeakyReLU> predicate) {
			return leakyReLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.LeakyReLU leakyReLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.LeakyReLU> predicate) {
			return leakyReLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.LogSigmoid> logSigmoidList() {
			return java.util.Collections.unmodifiableList(logSigmoidList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.LogSigmoid logSigmoid(int index) {
			return logSigmoidList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.LogSigmoid> logSigmoidList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.LogSigmoid> predicate) {
			return logSigmoidList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.LogSigmoid logSigmoid(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.LogSigmoid> predicate) {
			return logSigmoidList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Sigmoid> sigmoidList() {
			return java.util.Collections.unmodifiableList(sigmoidList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Sigmoid sigmoid(int index) {
			return sigmoidList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Sigmoid> sigmoidList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Sigmoid> predicate) {
			return sigmoidList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Sigmoid sigmoid(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Sigmoid> predicate) {
			return sigmoidList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Tanh> tanhList() {
			return java.util.Collections.unmodifiableList(tanhList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Tanh tanh(int index) {
			return tanhList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Tanh> tanhList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Tanh> predicate) {
			return tanhList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Tanh tanh(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Tanh> predicate) {
			return tanhList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Mish> mishList() {
			return java.util.Collections.unmodifiableList(mishList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Mish mish(int index) {
			return mishList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Mish> mishList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Mish> predicate) {
			return mishList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Mish mish(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Mish> predicate) {
			return mishList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.ProcessingLayer> processingLayerList() {
			return java.util.Collections.unmodifiableList(processingLayerList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.ProcessingLayer processingLayer(int index) {
			return processingLayerList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.ProcessingLayer> processingLayerList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.ProcessingLayer> predicate) {
			return processingLayerList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.ProcessingLayer processingLayer(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.ProcessingLayer> predicate) {
			return processingLayerList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Dropout> dropoutList() {
			return java.util.Collections.unmodifiableList(dropoutList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Dropout dropout(int index) {
			return dropoutList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Dropout> dropoutList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Dropout> predicate) {
			return dropoutList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Dropout dropout(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Dropout> predicate) {
			return dropoutList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Convolutional> convolutionalList() {
			return java.util.Collections.unmodifiableList(convolutionalList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Convolutional convolutional(int index) {
			return convolutionalList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Convolutional> convolutionalList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Convolutional> predicate) {
			return convolutionalList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Convolutional convolutional(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Convolutional> predicate) {
			return convolutionalList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Pool> poolList() {
			return java.util.Collections.unmodifiableList(poolList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Pool pool(int index) {
			return poolList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Pool> poolList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Pool> predicate) {
			return poolList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Pool pool(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Pool> predicate) {
			return poolList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.MaxPool> maxPoolList() {
			return java.util.Collections.unmodifiableList(maxPoolList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.MaxPool maxPool(int index) {
			return maxPoolList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.MaxPool> maxPoolList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.MaxPool> predicate) {
			return maxPoolList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.MaxPool maxPool(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.MaxPool> predicate) {
			return maxPoolList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.AvgPool> avgPoolList() {
			return java.util.Collections.unmodifiableList(avgPoolList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.AvgPool avgPool(int index) {
			return avgPoolList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.AvgPool> avgPoolList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.AvgPool> predicate) {
			return avgPoolList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.AvgPool avgPool(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.AvgPool> predicate) {
			return avgPoolList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization> normalizationList() {
			return java.util.Collections.unmodifiableList(normalizationList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization normalization(int index) {
			return normalizationList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization> normalizationList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization> predicate) {
			return normalizationList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization normalization(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization> predicate) {
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
			java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
			return map;
		}

		@Override
		protected void addNode$(io.intino.magritte.framework.Node node) {
			super.addNode$(node);
			if (node.is("ResidualSection$CustomFirstStage$Layer")) this.layerList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Layer.class));
			if (node.is("ResidualSection$CustomFirstStage$ActivationLayer")) this.activationLayerList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.ActivationLayer.class));
			if (node.is("ResidualSection$CustomFirstStage$ReLU")) this.reLUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.ReLU.class));
			if (node.is("ResidualSection$CustomFirstStage$ELU")) this.eLUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.ELU.class));
			if (node.is("ResidualSection$CustomFirstStage$SELU")) this.sELUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.SELU.class));
			if (node.is("ResidualSection$CustomFirstStage$GELU")) this.gELUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.GELU.class));
			if (node.is("ResidualSection$CustomFirstStage$SiLU")) this.siLUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.SiLU.class));
			if (node.is("ResidualSection$CustomFirstStage$GLU")) this.gLUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.GLU.class));
			if (node.is("ResidualSection$CustomFirstStage$LeakyReLU")) this.leakyReLUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.LeakyReLU.class));
			if (node.is("ResidualSection$CustomFirstStage$LogSigmoid")) this.logSigmoidList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.LogSigmoid.class));
			if (node.is("ResidualSection$CustomFirstStage$Sigmoid")) this.sigmoidList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Sigmoid.class));
			if (node.is("ResidualSection$CustomFirstStage$Tanh")) this.tanhList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Tanh.class));
			if (node.is("ResidualSection$CustomFirstStage$Mish")) this.mishList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Mish.class));
			if (node.is("ResidualSection$CustomFirstStage$ProcessingLayer")) this.processingLayerList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.ProcessingLayer.class));
			if (node.is("ResidualSection$CustomFirstStage$Dropout")) this.dropoutList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Dropout.class));
			if (node.is("ResidualSection$CustomFirstStage$Convolutional")) this.convolutionalList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Convolutional.class));
			if (node.is("ResidualSection$CustomFirstStage$Pool")) this.poolList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Pool.class));
			if (node.is("ResidualSection$CustomFirstStage$MaxPool")) this.maxPoolList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.MaxPool.class));
			if (node.is("ResidualSection$CustomFirstStage$AvgPool")) this.avgPoolList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.AvgPool.class));
			if (node.is("ResidualSection$CustomFirstStage$Normalization")) this.normalizationList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization.class));
		}

		@Override
		protected void removeNode$(io.intino.magritte.framework.Node node) {
			super.removeNode$(node);
			if (node.is("ResidualSection$CustomFirstStage$Layer")) this.layerList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Layer.class));
			if (node.is("ResidualSection$CustomFirstStage$ActivationLayer")) this.activationLayerList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.ActivationLayer.class));
			if (node.is("ResidualSection$CustomFirstStage$ReLU")) this.reLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.ReLU.class));
			if (node.is("ResidualSection$CustomFirstStage$ELU")) this.eLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.ELU.class));
			if (node.is("ResidualSection$CustomFirstStage$SELU")) this.sELUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.SELU.class));
			if (node.is("ResidualSection$CustomFirstStage$GELU")) this.gELUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.GELU.class));
			if (node.is("ResidualSection$CustomFirstStage$SiLU")) this.siLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.SiLU.class));
			if (node.is("ResidualSection$CustomFirstStage$GLU")) this.gLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.GLU.class));
			if (node.is("ResidualSection$CustomFirstStage$LeakyReLU")) this.leakyReLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.LeakyReLU.class));
			if (node.is("ResidualSection$CustomFirstStage$LogSigmoid")) this.logSigmoidList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.LogSigmoid.class));
			if (node.is("ResidualSection$CustomFirstStage$Sigmoid")) this.sigmoidList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Sigmoid.class));
			if (node.is("ResidualSection$CustomFirstStage$Tanh")) this.tanhList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Tanh.class));
			if (node.is("ResidualSection$CustomFirstStage$Mish")) this.mishList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Mish.class));
			if (node.is("ResidualSection$CustomFirstStage$ProcessingLayer")) this.processingLayerList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.ProcessingLayer.class));
			if (node.is("ResidualSection$CustomFirstStage$Dropout")) this.dropoutList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Dropout.class));
			if (node.is("ResidualSection$CustomFirstStage$Convolutional")) this.convolutionalList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Convolutional.class));
			if (node.is("ResidualSection$CustomFirstStage$Pool")) this.poolList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Pool.class));
			if (node.is("ResidualSection$CustomFirstStage$MaxPool")) this.maxPoolList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.MaxPool.class));
			if (node.is("ResidualSection$CustomFirstStage$AvgPool")) this.avgPoolList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.AvgPool.class));
			if (node.is("ResidualSection$CustomFirstStage$Normalization")) this.normalizationList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization.class));
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

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.ReLU reLU() {
				io.flogo.blatt.model.ResidualSection.CustomFirstStage.ReLU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.ReLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.ReLU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.ELU eLU() {
				io.flogo.blatt.model.ResidualSection.CustomFirstStage.ELU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.ELU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.ELU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.SELU sELU() {
				io.flogo.blatt.model.ResidualSection.CustomFirstStage.SELU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.SELU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.SELU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.GELU gELU() {
				io.flogo.blatt.model.ResidualSection.CustomFirstStage.GELU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.GELU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.GELU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.SiLU siLU() {
				io.flogo.blatt.model.ResidualSection.CustomFirstStage.SiLU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.SiLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.SiLU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.GLU gLU() {
				io.flogo.blatt.model.ResidualSection.CustomFirstStage.GLU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.GLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.GLU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.LeakyReLU leakyReLU() {
				io.flogo.blatt.model.ResidualSection.CustomFirstStage.LeakyReLU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.LeakyReLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.LeakyReLU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.LogSigmoid logSigmoid() {
				io.flogo.blatt.model.ResidualSection.CustomFirstStage.LogSigmoid newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.LogSigmoid.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.LogSigmoid.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Sigmoid sigmoid() {
				io.flogo.blatt.model.ResidualSection.CustomFirstStage.Sigmoid newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Sigmoid.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Sigmoid.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Tanh tanh() {
				io.flogo.blatt.model.ResidualSection.CustomFirstStage.Tanh newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Tanh.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Tanh.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Mish mish() {
				io.flogo.blatt.model.ResidualSection.CustomFirstStage.Mish newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Mish.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Mish.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Dropout dropout(double probability) {
				io.flogo.blatt.model.ResidualSection.CustomFirstStage.Dropout newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Dropout.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Dropout.class);
				newElement.core$().set(newElement, "probability", java.util.Collections.singletonList(probability));
				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Convolutional convolutional() {
				io.flogo.blatt.model.ResidualSection.CustomFirstStage.Convolutional newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Convolutional.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Convolutional.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.MaxPool maxPool() {
				io.flogo.blatt.model.ResidualSection.CustomFirstStage.MaxPool newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.MaxPool.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.MaxPool.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.AvgPool avgPool() {
				io.flogo.blatt.model.ResidualSection.CustomFirstStage.AvgPool newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.AvgPool.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.AvgPool.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization normalization() {
				io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization.class);

				return newElement;
			}

		}

		public Clear clear() {
			return new Clear();
		}

		public class Clear  {
			public void reLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.ReLU> filter) {
				new java.util.ArrayList<>(reLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void eLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.ELU> filter) {
				new java.util.ArrayList<>(eLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void sELU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.SELU> filter) {
				new java.util.ArrayList<>(sELUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void gELU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.GELU> filter) {
				new java.util.ArrayList<>(gELUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void siLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.SiLU> filter) {
				new java.util.ArrayList<>(siLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void gLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.GLU> filter) {
				new java.util.ArrayList<>(gLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void leakyReLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.LeakyReLU> filter) {
				new java.util.ArrayList<>(leakyReLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void logSigmoid(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.LogSigmoid> filter) {
				new java.util.ArrayList<>(logSigmoidList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void sigmoid(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Sigmoid> filter) {
				new java.util.ArrayList<>(sigmoidList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void tanh(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Tanh> filter) {
				new java.util.ArrayList<>(tanhList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void mish(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Mish> filter) {
				new java.util.ArrayList<>(mishList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void dropout(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Dropout> filter) {
				new java.util.ArrayList<>(dropoutList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void convolutional(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Convolutional> filter) {
				new java.util.ArrayList<>(convolutionalList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void maxPool(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.MaxPool> filter) {
				new java.util.ArrayList<>(maxPoolList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void avgPool(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.AvgPool> filter) {
				new java.util.ArrayList<>(avgPoolList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void normalization(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization> filter) {
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

		public static abstract class ActivationLayer extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Layer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class ReLU extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class ELU extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {
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

		public static class SELU extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class GELU extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class SiLU extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class GLU extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class LeakyReLU extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {
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

		public static class LogSigmoid extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class Sigmoid extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class Tanh extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class Mish extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static abstract class ProcessingLayer extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Layer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class Dropout extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.ProcessingLayer implements io.intino.magritte.framework.tags.Terminal {
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

		public static class Convolutional extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.ProcessingLayer implements io.intino.magritte.framework.tags.Terminal {
			protected io.flogo.blatt.model.ResidualSection.CustomFirstStage.Convolutional.Output output;

			public Convolutional(io.intino.magritte.framework.Node node) {
				super(node);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Convolutional.Output output() {
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
				if (node.is("ResidualSection$CustomFirstStage$Convolutional$Output")) this.output = node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Convolutional.Output.class);
			}

			@Override
			protected void removeNode$(io.intino.magritte.framework.Node node) {
				super.removeNode$(node);
				if (node.is("ResidualSection$CustomFirstStage$Convolutional$Output")) this.output = null;
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

			public class Create extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.ProcessingLayer.Create {


				public Create(java.lang.String name) {
					super(name);
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Convolutional.Output output(int x, int y, int z) {
					io.flogo.blatt.model.ResidualSection.CustomFirstStage.Convolutional.Output newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Convolutional.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Convolutional.Output.class);
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

		public static abstract class Pool extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.ProcessingLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class MaxPool extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Pool implements io.intino.magritte.framework.tags.Terminal {
			protected io.flogo.blatt.model.ResidualSection.CustomFirstStage.MaxPool.Output output;

			public MaxPool(io.intino.magritte.framework.Node node) {
				super(node);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.MaxPool.Output output() {
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
				if (node.is("ResidualSection$CustomFirstStage$MaxPool$Output")) this.output = node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.MaxPool.Output.class);
			}

			@Override
			protected void removeNode$(io.intino.magritte.framework.Node node) {
				super.removeNode$(node);
				if (node.is("ResidualSection$CustomFirstStage$MaxPool$Output")) this.output = null;
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

			public class Create extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Pool.Create {


				public Create(java.lang.String name) {
					super(name);
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.MaxPool.Output output(int x, int y) {
					io.flogo.blatt.model.ResidualSection.CustomFirstStage.MaxPool.Output newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.MaxPool.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.MaxPool.Output.class);
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

		public static class AvgPool extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Pool implements io.intino.magritte.framework.tags.Terminal {
			protected io.flogo.blatt.model.ResidualSection.CustomFirstStage.AvgPool.Output output;

			public AvgPool(io.intino.magritte.framework.Node node) {
				super(node);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.AvgPool.Output output() {
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
				if (node.is("ResidualSection$CustomFirstStage$AvgPool$Output")) this.output = node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.AvgPool.Output.class);
			}

			@Override
			protected void removeNode$(io.intino.magritte.framework.Node node) {
				super.removeNode$(node);
				if (node.is("ResidualSection$CustomFirstStage$AvgPool$Output")) this.output = null;
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

			public class Create extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.Pool.Create {


				public Create(java.lang.String name) {
					super(name);
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.AvgPool.Output output(int x, int y) {
					io.flogo.blatt.model.ResidualSection.CustomFirstStage.AvgPool.Output newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.AvgPool.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.AvgPool.Output.class);
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

		public static class Normalization extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.ProcessingLayer implements io.intino.magritte.framework.tags.Terminal {
			protected double eps;
			protected double momentum;
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization.Output> outputList = new java.util.ArrayList<>();

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

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization.Output> outputList() {
				return java.util.Collections.unmodifiableList(outputList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization.Output output(int index) {
				return outputList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization.Output> outputList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization.Output> predicate) {
				return outputList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization.Output output(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization.Output> predicate) {
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
				if (node.is("ResidualSection$CustomFirstStage$Normalization$Output")) this.outputList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization.Output.class));
			}

			@Override
			protected void removeNode$(io.intino.magritte.framework.Node node) {
				super.removeNode$(node);
				if (node.is("ResidualSection$CustomFirstStage$Normalization$Output")) this.outputList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization.Output.class));
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

			public class Create extends io.flogo.blatt.model.ResidualSection.CustomFirstStage.ProcessingLayer.Create {


				public Create(java.lang.String name) {
					super(name);
				}

				public io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization.Output output(double z) {
					io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization.Output newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization.Output.class);
					newElement.core$().set(newElement, "z", java.util.Collections.singletonList(z));
					return newElement;
				}

			}

			public Clear clear() {
				return new Clear();
			}

			public class Clear  {
				public void output(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomFirstStage.Normalization.Output> filter) {
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
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Layer> layerList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.ActivationLayer> activationLayerList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.ReLU> reLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.ELU> eLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.SELU> sELUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.GELU> gELUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.SiLU> siLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.GLU> gLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.LeakyReLU> leakyReLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.LogSigmoid> logSigmoidList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Sigmoid> sigmoidList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Tanh> tanhList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Mish> mishList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.ProcessingLayer> processingLayerList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Dropout> dropoutList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Convolutional> convolutionalList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Pool> poolList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.MaxPool> maxPoolList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.AvgPool> avgPoolList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization> normalizationList = new java.util.ArrayList<>();

		public CustomLastStage(io.intino.magritte.framework.Node node) {
			super(node);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Layer> layerList() {
			return java.util.Collections.unmodifiableList(layerList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.Layer layer(int index) {
			return layerList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Layer> layerList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Layer> predicate) {
			return layerList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.Layer layer(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Layer> predicate) {
			return layerList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.ActivationLayer> activationLayerList() {
			return java.util.Collections.unmodifiableList(activationLayerList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.ActivationLayer activationLayer(int index) {
			return activationLayerList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.ActivationLayer> activationLayerList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.ActivationLayer> predicate) {
			return activationLayerList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.ActivationLayer activationLayer(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.ActivationLayer> predicate) {
			return activationLayerList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.ReLU> reLUList() {
			return java.util.Collections.unmodifiableList(reLUList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.ReLU reLU(int index) {
			return reLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.ReLU> reLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.ReLU> predicate) {
			return reLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.ReLU reLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.ReLU> predicate) {
			return reLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.ELU> eLUList() {
			return java.util.Collections.unmodifiableList(eLUList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.ELU eLU(int index) {
			return eLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.ELU> eLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.ELU> predicate) {
			return eLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.ELU eLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.ELU> predicate) {
			return eLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.SELU> sELUList() {
			return java.util.Collections.unmodifiableList(sELUList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.SELU sELU(int index) {
			return sELUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.SELU> sELUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.SELU> predicate) {
			return sELUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.SELU sELU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.SELU> predicate) {
			return sELUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.GELU> gELUList() {
			return java.util.Collections.unmodifiableList(gELUList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.GELU gELU(int index) {
			return gELUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.GELU> gELUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.GELU> predicate) {
			return gELUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.GELU gELU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.GELU> predicate) {
			return gELUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.SiLU> siLUList() {
			return java.util.Collections.unmodifiableList(siLUList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.SiLU siLU(int index) {
			return siLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.SiLU> siLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.SiLU> predicate) {
			return siLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.SiLU siLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.SiLU> predicate) {
			return siLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.GLU> gLUList() {
			return java.util.Collections.unmodifiableList(gLUList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.GLU gLU(int index) {
			return gLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.GLU> gLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.GLU> predicate) {
			return gLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.GLU gLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.GLU> predicate) {
			return gLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.LeakyReLU> leakyReLUList() {
			return java.util.Collections.unmodifiableList(leakyReLUList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.LeakyReLU leakyReLU(int index) {
			return leakyReLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.LeakyReLU> leakyReLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.LeakyReLU> predicate) {
			return leakyReLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.LeakyReLU leakyReLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.LeakyReLU> predicate) {
			return leakyReLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.LogSigmoid> logSigmoidList() {
			return java.util.Collections.unmodifiableList(logSigmoidList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.LogSigmoid logSigmoid(int index) {
			return logSigmoidList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.LogSigmoid> logSigmoidList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.LogSigmoid> predicate) {
			return logSigmoidList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.LogSigmoid logSigmoid(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.LogSigmoid> predicate) {
			return logSigmoidList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Sigmoid> sigmoidList() {
			return java.util.Collections.unmodifiableList(sigmoidList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.Sigmoid sigmoid(int index) {
			return sigmoidList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Sigmoid> sigmoidList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Sigmoid> predicate) {
			return sigmoidList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.Sigmoid sigmoid(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Sigmoid> predicate) {
			return sigmoidList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Tanh> tanhList() {
			return java.util.Collections.unmodifiableList(tanhList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.Tanh tanh(int index) {
			return tanhList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Tanh> tanhList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Tanh> predicate) {
			return tanhList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.Tanh tanh(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Tanh> predicate) {
			return tanhList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Mish> mishList() {
			return java.util.Collections.unmodifiableList(mishList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.Mish mish(int index) {
			return mishList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Mish> mishList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Mish> predicate) {
			return mishList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.Mish mish(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Mish> predicate) {
			return mishList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.ProcessingLayer> processingLayerList() {
			return java.util.Collections.unmodifiableList(processingLayerList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.ProcessingLayer processingLayer(int index) {
			return processingLayerList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.ProcessingLayer> processingLayerList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.ProcessingLayer> predicate) {
			return processingLayerList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.ProcessingLayer processingLayer(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.ProcessingLayer> predicate) {
			return processingLayerList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Dropout> dropoutList() {
			return java.util.Collections.unmodifiableList(dropoutList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.Dropout dropout(int index) {
			return dropoutList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Dropout> dropoutList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Dropout> predicate) {
			return dropoutList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.Dropout dropout(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Dropout> predicate) {
			return dropoutList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Convolutional> convolutionalList() {
			return java.util.Collections.unmodifiableList(convolutionalList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.Convolutional convolutional(int index) {
			return convolutionalList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Convolutional> convolutionalList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Convolutional> predicate) {
			return convolutionalList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.Convolutional convolutional(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Convolutional> predicate) {
			return convolutionalList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Pool> poolList() {
			return java.util.Collections.unmodifiableList(poolList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.Pool pool(int index) {
			return poolList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Pool> poolList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Pool> predicate) {
			return poolList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.Pool pool(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Pool> predicate) {
			return poolList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.MaxPool> maxPoolList() {
			return java.util.Collections.unmodifiableList(maxPoolList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.MaxPool maxPool(int index) {
			return maxPoolList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.MaxPool> maxPoolList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.MaxPool> predicate) {
			return maxPoolList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.MaxPool maxPool(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.MaxPool> predicate) {
			return maxPoolList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.AvgPool> avgPoolList() {
			return java.util.Collections.unmodifiableList(avgPoolList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.AvgPool avgPool(int index) {
			return avgPoolList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.AvgPool> avgPoolList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.AvgPool> predicate) {
			return avgPoolList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.AvgPool avgPool(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.AvgPool> predicate) {
			return avgPoolList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization> normalizationList() {
			return java.util.Collections.unmodifiableList(normalizationList);
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization normalization(int index) {
			return normalizationList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization> normalizationList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization> predicate) {
			return normalizationList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization normalization(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization> predicate) {
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
			java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
			return map;
		}

		@Override
		protected void addNode$(io.intino.magritte.framework.Node node) {
			super.addNode$(node);
			if (node.is("ResidualSection$CustomLastStage$Layer")) this.layerList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Layer.class));
			if (node.is("ResidualSection$CustomLastStage$ActivationLayer")) this.activationLayerList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.ActivationLayer.class));
			if (node.is("ResidualSection$CustomLastStage$ReLU")) this.reLUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.ReLU.class));
			if (node.is("ResidualSection$CustomLastStage$ELU")) this.eLUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.ELU.class));
			if (node.is("ResidualSection$CustomLastStage$SELU")) this.sELUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.SELU.class));
			if (node.is("ResidualSection$CustomLastStage$GELU")) this.gELUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.GELU.class));
			if (node.is("ResidualSection$CustomLastStage$SiLU")) this.siLUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.SiLU.class));
			if (node.is("ResidualSection$CustomLastStage$GLU")) this.gLUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.GLU.class));
			if (node.is("ResidualSection$CustomLastStage$LeakyReLU")) this.leakyReLUList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.LeakyReLU.class));
			if (node.is("ResidualSection$CustomLastStage$LogSigmoid")) this.logSigmoidList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.LogSigmoid.class));
			if (node.is("ResidualSection$CustomLastStage$Sigmoid")) this.sigmoidList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Sigmoid.class));
			if (node.is("ResidualSection$CustomLastStage$Tanh")) this.tanhList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Tanh.class));
			if (node.is("ResidualSection$CustomLastStage$Mish")) this.mishList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Mish.class));
			if (node.is("ResidualSection$CustomLastStage$ProcessingLayer")) this.processingLayerList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.ProcessingLayer.class));
			if (node.is("ResidualSection$CustomLastStage$Dropout")) this.dropoutList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Dropout.class));
			if (node.is("ResidualSection$CustomLastStage$Convolutional")) this.convolutionalList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Convolutional.class));
			if (node.is("ResidualSection$CustomLastStage$Pool")) this.poolList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Pool.class));
			if (node.is("ResidualSection$CustomLastStage$MaxPool")) this.maxPoolList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.MaxPool.class));
			if (node.is("ResidualSection$CustomLastStage$AvgPool")) this.avgPoolList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.AvgPool.class));
			if (node.is("ResidualSection$CustomLastStage$Normalization")) this.normalizationList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization.class));
		}

		@Override
		protected void removeNode$(io.intino.magritte.framework.Node node) {
			super.removeNode$(node);
			if (node.is("ResidualSection$CustomLastStage$Layer")) this.layerList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Layer.class));
			if (node.is("ResidualSection$CustomLastStage$ActivationLayer")) this.activationLayerList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.ActivationLayer.class));
			if (node.is("ResidualSection$CustomLastStage$ReLU")) this.reLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.ReLU.class));
			if (node.is("ResidualSection$CustomLastStage$ELU")) this.eLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.ELU.class));
			if (node.is("ResidualSection$CustomLastStage$SELU")) this.sELUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.SELU.class));
			if (node.is("ResidualSection$CustomLastStage$GELU")) this.gELUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.GELU.class));
			if (node.is("ResidualSection$CustomLastStage$SiLU")) this.siLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.SiLU.class));
			if (node.is("ResidualSection$CustomLastStage$GLU")) this.gLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.GLU.class));
			if (node.is("ResidualSection$CustomLastStage$LeakyReLU")) this.leakyReLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.LeakyReLU.class));
			if (node.is("ResidualSection$CustomLastStage$LogSigmoid")) this.logSigmoidList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.LogSigmoid.class));
			if (node.is("ResidualSection$CustomLastStage$Sigmoid")) this.sigmoidList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Sigmoid.class));
			if (node.is("ResidualSection$CustomLastStage$Tanh")) this.tanhList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Tanh.class));
			if (node.is("ResidualSection$CustomLastStage$Mish")) this.mishList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Mish.class));
			if (node.is("ResidualSection$CustomLastStage$ProcessingLayer")) this.processingLayerList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.ProcessingLayer.class));
			if (node.is("ResidualSection$CustomLastStage$Dropout")) this.dropoutList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Dropout.class));
			if (node.is("ResidualSection$CustomLastStage$Convolutional")) this.convolutionalList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Convolutional.class));
			if (node.is("ResidualSection$CustomLastStage$Pool")) this.poolList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Pool.class));
			if (node.is("ResidualSection$CustomLastStage$MaxPool")) this.maxPoolList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.MaxPool.class));
			if (node.is("ResidualSection$CustomLastStage$AvgPool")) this.avgPoolList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.AvgPool.class));
			if (node.is("ResidualSection$CustomLastStage$Normalization")) this.normalizationList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization.class));
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

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.ReLU reLU() {
				io.flogo.blatt.model.ResidualSection.CustomLastStage.ReLU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.ReLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.ReLU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.ELU eLU() {
				io.flogo.blatt.model.ResidualSection.CustomLastStage.ELU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.ELU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.ELU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.SELU sELU() {
				io.flogo.blatt.model.ResidualSection.CustomLastStage.SELU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.SELU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.SELU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.GELU gELU() {
				io.flogo.blatt.model.ResidualSection.CustomLastStage.GELU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.GELU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.GELU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.SiLU siLU() {
				io.flogo.blatt.model.ResidualSection.CustomLastStage.SiLU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.SiLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.SiLU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.GLU gLU() {
				io.flogo.blatt.model.ResidualSection.CustomLastStage.GLU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.GLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.GLU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.LeakyReLU leakyReLU() {
				io.flogo.blatt.model.ResidualSection.CustomLastStage.LeakyReLU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.LeakyReLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.LeakyReLU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.LogSigmoid logSigmoid() {
				io.flogo.blatt.model.ResidualSection.CustomLastStage.LogSigmoid newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.LogSigmoid.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.LogSigmoid.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Sigmoid sigmoid() {
				io.flogo.blatt.model.ResidualSection.CustomLastStage.Sigmoid newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Sigmoid.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Sigmoid.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Tanh tanh() {
				io.flogo.blatt.model.ResidualSection.CustomLastStage.Tanh newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Tanh.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Tanh.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Mish mish() {
				io.flogo.blatt.model.ResidualSection.CustomLastStage.Mish newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Mish.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Mish.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Dropout dropout(double probability) {
				io.flogo.blatt.model.ResidualSection.CustomLastStage.Dropout newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Dropout.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Dropout.class);
				newElement.core$().set(newElement, "probability", java.util.Collections.singletonList(probability));
				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Convolutional convolutional() {
				io.flogo.blatt.model.ResidualSection.CustomLastStage.Convolutional newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Convolutional.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Convolutional.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.MaxPool maxPool() {
				io.flogo.blatt.model.ResidualSection.CustomLastStage.MaxPool newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.MaxPool.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.MaxPool.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.AvgPool avgPool() {
				io.flogo.blatt.model.ResidualSection.CustomLastStage.AvgPool newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.AvgPool.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.AvgPool.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization normalization() {
				io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization.class);

				return newElement;
			}

		}

		public Clear clear() {
			return new Clear();
		}

		public class Clear  {
			public void reLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.ReLU> filter) {
				new java.util.ArrayList<>(reLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void eLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.ELU> filter) {
				new java.util.ArrayList<>(eLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void sELU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.SELU> filter) {
				new java.util.ArrayList<>(sELUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void gELU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.GELU> filter) {
				new java.util.ArrayList<>(gELUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void siLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.SiLU> filter) {
				new java.util.ArrayList<>(siLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void gLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.GLU> filter) {
				new java.util.ArrayList<>(gLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void leakyReLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.LeakyReLU> filter) {
				new java.util.ArrayList<>(leakyReLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void logSigmoid(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.LogSigmoid> filter) {
				new java.util.ArrayList<>(logSigmoidList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void sigmoid(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Sigmoid> filter) {
				new java.util.ArrayList<>(sigmoidList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void tanh(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Tanh> filter) {
				new java.util.ArrayList<>(tanhList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void mish(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Mish> filter) {
				new java.util.ArrayList<>(mishList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void dropout(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Dropout> filter) {
				new java.util.ArrayList<>(dropoutList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void convolutional(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Convolutional> filter) {
				new java.util.ArrayList<>(convolutionalList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void maxPool(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.MaxPool> filter) {
				new java.util.ArrayList<>(maxPoolList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void avgPool(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.AvgPool> filter) {
				new java.util.ArrayList<>(avgPoolList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void normalization(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization> filter) {
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

		public static abstract class ActivationLayer extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Layer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class ReLU extends io.flogo.blatt.model.ResidualSection.CustomLastStage.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class ELU extends io.flogo.blatt.model.ResidualSection.CustomLastStage.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {
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

		public static class SELU extends io.flogo.blatt.model.ResidualSection.CustomLastStage.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class GELU extends io.flogo.blatt.model.ResidualSection.CustomLastStage.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class SiLU extends io.flogo.blatt.model.ResidualSection.CustomLastStage.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class GLU extends io.flogo.blatt.model.ResidualSection.CustomLastStage.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class LeakyReLU extends io.flogo.blatt.model.ResidualSection.CustomLastStage.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {
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

		public static class LogSigmoid extends io.flogo.blatt.model.ResidualSection.CustomLastStage.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class Sigmoid extends io.flogo.blatt.model.ResidualSection.CustomLastStage.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class Tanh extends io.flogo.blatt.model.ResidualSection.CustomLastStage.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class Mish extends io.flogo.blatt.model.ResidualSection.CustomLastStage.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static abstract class ProcessingLayer extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Layer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class Dropout extends io.flogo.blatt.model.ResidualSection.CustomLastStage.ProcessingLayer implements io.intino.magritte.framework.tags.Terminal {
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

		public static class Convolutional extends io.flogo.blatt.model.ResidualSection.CustomLastStage.ProcessingLayer implements io.intino.magritte.framework.tags.Terminal {
			protected io.flogo.blatt.model.ResidualSection.CustomLastStage.Convolutional.Output output;

			public Convolutional(io.intino.magritte.framework.Node node) {
				super(node);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Convolutional.Output output() {
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
				if (node.is("ResidualSection$CustomLastStage$Convolutional$Output")) this.output = node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Convolutional.Output.class);
			}

			@Override
			protected void removeNode$(io.intino.magritte.framework.Node node) {
				super.removeNode$(node);
				if (node.is("ResidualSection$CustomLastStage$Convolutional$Output")) this.output = null;
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

			public class Create extends io.flogo.blatt.model.ResidualSection.CustomLastStage.ProcessingLayer.Create {


				public Create(java.lang.String name) {
					super(name);
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Convolutional.Output output(int x, int y, int z) {
					io.flogo.blatt.model.ResidualSection.CustomLastStage.Convolutional.Output newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Convolutional.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Convolutional.Output.class);
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

		public static abstract class Pool extends io.flogo.blatt.model.ResidualSection.CustomLastStage.ProcessingLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class MaxPool extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Pool implements io.intino.magritte.framework.tags.Terminal {
			protected io.flogo.blatt.model.ResidualSection.CustomLastStage.MaxPool.Output output;

			public MaxPool(io.intino.magritte.framework.Node node) {
				super(node);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.MaxPool.Output output() {
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
				if (node.is("ResidualSection$CustomLastStage$MaxPool$Output")) this.output = node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.MaxPool.Output.class);
			}

			@Override
			protected void removeNode$(io.intino.magritte.framework.Node node) {
				super.removeNode$(node);
				if (node.is("ResidualSection$CustomLastStage$MaxPool$Output")) this.output = null;
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

			public class Create extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Pool.Create {


				public Create(java.lang.String name) {
					super(name);
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.MaxPool.Output output(int x, int y) {
					io.flogo.blatt.model.ResidualSection.CustomLastStage.MaxPool.Output newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.MaxPool.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.MaxPool.Output.class);
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

		public static class AvgPool extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Pool implements io.intino.magritte.framework.tags.Terminal {
			protected io.flogo.blatt.model.ResidualSection.CustomLastStage.AvgPool.Output output;

			public AvgPool(io.intino.magritte.framework.Node node) {
				super(node);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.AvgPool.Output output() {
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
				if (node.is("ResidualSection$CustomLastStage$AvgPool$Output")) this.output = node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.AvgPool.Output.class);
			}

			@Override
			protected void removeNode$(io.intino.magritte.framework.Node node) {
				super.removeNode$(node);
				if (node.is("ResidualSection$CustomLastStage$AvgPool$Output")) this.output = null;
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

			public class Create extends io.flogo.blatt.model.ResidualSection.CustomLastStage.Pool.Create {


				public Create(java.lang.String name) {
					super(name);
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.AvgPool.Output output(int x, int y) {
					io.flogo.blatt.model.ResidualSection.CustomLastStage.AvgPool.Output newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.AvgPool.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.AvgPool.Output.class);
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

		public static class Normalization extends io.flogo.blatt.model.ResidualSection.CustomLastStage.ProcessingLayer implements io.intino.magritte.framework.tags.Terminal {
			protected double eps;
			protected double momentum;
			protected java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization.Output> outputList = new java.util.ArrayList<>();

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

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization.Output> outputList() {
				return java.util.Collections.unmodifiableList(outputList);
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization.Output output(int index) {
				return outputList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization.Output> outputList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization.Output> predicate) {
				return outputList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization.Output output(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization.Output> predicate) {
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
				if (node.is("ResidualSection$CustomLastStage$Normalization$Output")) this.outputList.add(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization.Output.class));
			}

			@Override
			protected void removeNode$(io.intino.magritte.framework.Node node) {
				super.removeNode$(node);
				if (node.is("ResidualSection$CustomLastStage$Normalization$Output")) this.outputList.remove(node.as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization.Output.class));
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

			public class Create extends io.flogo.blatt.model.ResidualSection.CustomLastStage.ProcessingLayer.Create {


				public Create(java.lang.String name) {
					super(name);
				}

				public io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization.Output output(double z) {
					io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization.Output newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization.Output.class);
					newElement.core$().set(newElement, "z", java.util.Collections.singletonList(z));
					return newElement;
				}

			}

			public Clear clear() {
				return new Clear();
			}

			public class Clear  {
				public void output(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.CustomLastStage.Normalization.Output> filter) {
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