package io.flogo.blatt.model;

import io.flogo.blatt.model.*;

public class LinearSection extends io.flogo.blatt.model.ProcessingSection implements io.intino.magritte.framework.tags.Component, io.intino.magritte.framework.tags.Terminal {
	protected io.flogo.blatt.model.LinearSection.Input input;
	protected java.util.List<io.flogo.blatt.model.LinearSection.Block> blockList = new java.util.ArrayList<>();

	public LinearSection(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public io.flogo.blatt.model.LinearSection.Input input() {
		return input;
	}

	public java.util.List<io.flogo.blatt.model.LinearSection.Block> blockList() {
		return java.util.Collections.unmodifiableList(blockList);
	}

	public io.flogo.blatt.model.LinearSection.Block block(int index) {
		return blockList.get(index);
	}

	public java.util.List<io.flogo.blatt.model.LinearSection.Block> blockList(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block> predicate) {
		return blockList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
	}

	public io.flogo.blatt.model.LinearSection.Block block(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block> predicate) {
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
		if (node.is("LinearSection$Input")) this.input = node.as(io.flogo.blatt.model.LinearSection.Input.class);
		if (node.is("LinearSection$Block")) this.blockList.add(node.as(io.flogo.blatt.model.LinearSection.Block.class));
	}

	@Override
	protected void removeNode$(io.intino.magritte.framework.Node node) {
		super.removeNode$(node);
		if (node.is("LinearSection$Input")) this.input = null;
		if (node.is("LinearSection$Block")) this.blockList.remove(node.as(io.flogo.blatt.model.LinearSection.Block.class));
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

		public io.flogo.blatt.model.LinearSection.Input input(int x) {
			io.flogo.blatt.model.LinearSection.Input newElement = core$().graph().concept(io.flogo.blatt.model.LinearSection.Input.class).createNode(this.name, core$()).as(io.flogo.blatt.model.LinearSection.Input.class);
			newElement.core$().set(newElement, "x", java.util.Collections.singletonList(x));
			return newElement;
		}

		public io.flogo.blatt.model.LinearSection.Block block() {
			io.flogo.blatt.model.LinearSection.Block newElement = core$().graph().concept(io.flogo.blatt.model.LinearSection.Block.class).createNode(this.name, core$()).as(io.flogo.blatt.model.LinearSection.Block.class);

			return newElement;
		}

	}

	public Clear clear() {
		return new Clear();
	}

	public class Clear  {
		public void block(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block> filter) {
			new java.util.ArrayList<>(blockList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
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

	public static class Block  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
		protected java.util.List<io.flogo.blatt.model.LinearSection.Block.Layer> layerList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.LinearSection.Block.ActivationLayer> activationLayerList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.LinearSection.Block.ReLU> reLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.LinearSection.Block.ELU> eLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.LinearSection.Block.SELU> sELUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.LinearSection.Block.GELU> gELUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.LinearSection.Block.SiLU> siLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.LinearSection.Block.GLU> gLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.LinearSection.Block.LeakyReLU> leakyReLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.LinearSection.Block.LogSigmoid> logSigmoidList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.LinearSection.Block.Sigmoid> sigmoidList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.LinearSection.Block.Tanh> tanhList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.LinearSection.Block.Mish> mishList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.LinearSection.Block.ProcessingLayer> processingLayerList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.LinearSection.Block.Linear> linearList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.LinearSection.Block.Dropout> dropoutList = new java.util.ArrayList<>();

		public Block(io.intino.magritte.framework.Node node) {
			super(node);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.Layer> layerList() {
			return java.util.Collections.unmodifiableList(layerList);
		}

		public io.flogo.blatt.model.LinearSection.Block.Layer layer(int index) {
			return layerList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.Layer> layerList(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.Layer> predicate) {
			return layerList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.LinearSection.Block.Layer layer(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.Layer> predicate) {
			return layerList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.ActivationLayer> activationLayerList() {
			return java.util.Collections.unmodifiableList(activationLayerList);
		}

		public io.flogo.blatt.model.LinearSection.Block.ActivationLayer activationLayer(int index) {
			return activationLayerList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.ActivationLayer> activationLayerList(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.ActivationLayer> predicate) {
			return activationLayerList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.LinearSection.Block.ActivationLayer activationLayer(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.ActivationLayer> predicate) {
			return activationLayerList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.ReLU> reLUList() {
			return java.util.Collections.unmodifiableList(reLUList);
		}

		public io.flogo.blatt.model.LinearSection.Block.ReLU reLU(int index) {
			return reLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.ReLU> reLUList(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.ReLU> predicate) {
			return reLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.LinearSection.Block.ReLU reLU(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.ReLU> predicate) {
			return reLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.ELU> eLUList() {
			return java.util.Collections.unmodifiableList(eLUList);
		}

		public io.flogo.blatt.model.LinearSection.Block.ELU eLU(int index) {
			return eLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.ELU> eLUList(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.ELU> predicate) {
			return eLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.LinearSection.Block.ELU eLU(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.ELU> predicate) {
			return eLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.SELU> sELUList() {
			return java.util.Collections.unmodifiableList(sELUList);
		}

		public io.flogo.blatt.model.LinearSection.Block.SELU sELU(int index) {
			return sELUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.SELU> sELUList(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.SELU> predicate) {
			return sELUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.LinearSection.Block.SELU sELU(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.SELU> predicate) {
			return sELUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.GELU> gELUList() {
			return java.util.Collections.unmodifiableList(gELUList);
		}

		public io.flogo.blatt.model.LinearSection.Block.GELU gELU(int index) {
			return gELUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.GELU> gELUList(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.GELU> predicate) {
			return gELUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.LinearSection.Block.GELU gELU(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.GELU> predicate) {
			return gELUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.SiLU> siLUList() {
			return java.util.Collections.unmodifiableList(siLUList);
		}

		public io.flogo.blatt.model.LinearSection.Block.SiLU siLU(int index) {
			return siLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.SiLU> siLUList(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.SiLU> predicate) {
			return siLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.LinearSection.Block.SiLU siLU(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.SiLU> predicate) {
			return siLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.GLU> gLUList() {
			return java.util.Collections.unmodifiableList(gLUList);
		}

		public io.flogo.blatt.model.LinearSection.Block.GLU gLU(int index) {
			return gLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.GLU> gLUList(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.GLU> predicate) {
			return gLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.LinearSection.Block.GLU gLU(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.GLU> predicate) {
			return gLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.LeakyReLU> leakyReLUList() {
			return java.util.Collections.unmodifiableList(leakyReLUList);
		}

		public io.flogo.blatt.model.LinearSection.Block.LeakyReLU leakyReLU(int index) {
			return leakyReLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.LeakyReLU> leakyReLUList(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.LeakyReLU> predicate) {
			return leakyReLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.LinearSection.Block.LeakyReLU leakyReLU(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.LeakyReLU> predicate) {
			return leakyReLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.LogSigmoid> logSigmoidList() {
			return java.util.Collections.unmodifiableList(logSigmoidList);
		}

		public io.flogo.blatt.model.LinearSection.Block.LogSigmoid logSigmoid(int index) {
			return logSigmoidList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.LogSigmoid> logSigmoidList(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.LogSigmoid> predicate) {
			return logSigmoidList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.LinearSection.Block.LogSigmoid logSigmoid(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.LogSigmoid> predicate) {
			return logSigmoidList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.Sigmoid> sigmoidList() {
			return java.util.Collections.unmodifiableList(sigmoidList);
		}

		public io.flogo.blatt.model.LinearSection.Block.Sigmoid sigmoid(int index) {
			return sigmoidList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.Sigmoid> sigmoidList(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.Sigmoid> predicate) {
			return sigmoidList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.LinearSection.Block.Sigmoid sigmoid(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.Sigmoid> predicate) {
			return sigmoidList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.Tanh> tanhList() {
			return java.util.Collections.unmodifiableList(tanhList);
		}

		public io.flogo.blatt.model.LinearSection.Block.Tanh tanh(int index) {
			return tanhList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.Tanh> tanhList(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.Tanh> predicate) {
			return tanhList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.LinearSection.Block.Tanh tanh(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.Tanh> predicate) {
			return tanhList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.Mish> mishList() {
			return java.util.Collections.unmodifiableList(mishList);
		}

		public io.flogo.blatt.model.LinearSection.Block.Mish mish(int index) {
			return mishList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.Mish> mishList(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.Mish> predicate) {
			return mishList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.LinearSection.Block.Mish mish(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.Mish> predicate) {
			return mishList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.ProcessingLayer> processingLayerList() {
			return java.util.Collections.unmodifiableList(processingLayerList);
		}

		public io.flogo.blatt.model.LinearSection.Block.ProcessingLayer processingLayer(int index) {
			return processingLayerList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.ProcessingLayer> processingLayerList(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.ProcessingLayer> predicate) {
			return processingLayerList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.LinearSection.Block.ProcessingLayer processingLayer(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.ProcessingLayer> predicate) {
			return processingLayerList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.Linear> linearList() {
			return java.util.Collections.unmodifiableList(linearList);
		}

		public io.flogo.blatt.model.LinearSection.Block.Linear linear(int index) {
			return linearList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.Linear> linearList(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.Linear> predicate) {
			return linearList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.LinearSection.Block.Linear linear(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.Linear> predicate) {
			return linearList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.Dropout> dropoutList() {
			return java.util.Collections.unmodifiableList(dropoutList);
		}

		public io.flogo.blatt.model.LinearSection.Block.Dropout dropout(int index) {
			return dropoutList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.LinearSection.Block.Dropout> dropoutList(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.Dropout> predicate) {
			return dropoutList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.LinearSection.Block.Dropout dropout(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.Dropout> predicate) {
			return dropoutList().stream().filter(predicate).findFirst().orElse(null);
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
			new java.util.ArrayList<>(linearList).forEach(c -> components.add(c.core$()));
			new java.util.ArrayList<>(dropoutList).forEach(c -> components.add(c.core$()));
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
			if (node.is("LinearSection$Block$Layer")) this.layerList.add(node.as(io.flogo.blatt.model.LinearSection.Block.Layer.class));
			if (node.is("LinearSection$Block$ActivationLayer")) this.activationLayerList.add(node.as(io.flogo.blatt.model.LinearSection.Block.ActivationLayer.class));
			if (node.is("LinearSection$Block$ReLU")) this.reLUList.add(node.as(io.flogo.blatt.model.LinearSection.Block.ReLU.class));
			if (node.is("LinearSection$Block$ELU")) this.eLUList.add(node.as(io.flogo.blatt.model.LinearSection.Block.ELU.class));
			if (node.is("LinearSection$Block$SELU")) this.sELUList.add(node.as(io.flogo.blatt.model.LinearSection.Block.SELU.class));
			if (node.is("LinearSection$Block$GELU")) this.gELUList.add(node.as(io.flogo.blatt.model.LinearSection.Block.GELU.class));
			if (node.is("LinearSection$Block$SiLU")) this.siLUList.add(node.as(io.flogo.blatt.model.LinearSection.Block.SiLU.class));
			if (node.is("LinearSection$Block$GLU")) this.gLUList.add(node.as(io.flogo.blatt.model.LinearSection.Block.GLU.class));
			if (node.is("LinearSection$Block$LeakyReLU")) this.leakyReLUList.add(node.as(io.flogo.blatt.model.LinearSection.Block.LeakyReLU.class));
			if (node.is("LinearSection$Block$LogSigmoid")) this.logSigmoidList.add(node.as(io.flogo.blatt.model.LinearSection.Block.LogSigmoid.class));
			if (node.is("LinearSection$Block$Sigmoid")) this.sigmoidList.add(node.as(io.flogo.blatt.model.LinearSection.Block.Sigmoid.class));
			if (node.is("LinearSection$Block$Tanh")) this.tanhList.add(node.as(io.flogo.blatt.model.LinearSection.Block.Tanh.class));
			if (node.is("LinearSection$Block$Mish")) this.mishList.add(node.as(io.flogo.blatt.model.LinearSection.Block.Mish.class));
			if (node.is("LinearSection$Block$ProcessingLayer")) this.processingLayerList.add(node.as(io.flogo.blatt.model.LinearSection.Block.ProcessingLayer.class));
			if (node.is("LinearSection$Block$Linear")) this.linearList.add(node.as(io.flogo.blatt.model.LinearSection.Block.Linear.class));
			if (node.is("LinearSection$Block$Dropout")) this.dropoutList.add(node.as(io.flogo.blatt.model.LinearSection.Block.Dropout.class));
		}

		@Override
		protected void removeNode$(io.intino.magritte.framework.Node node) {
			super.removeNode$(node);
			if (node.is("LinearSection$Block$Layer")) this.layerList.remove(node.as(io.flogo.blatt.model.LinearSection.Block.Layer.class));
			if (node.is("LinearSection$Block$ActivationLayer")) this.activationLayerList.remove(node.as(io.flogo.blatt.model.LinearSection.Block.ActivationLayer.class));
			if (node.is("LinearSection$Block$ReLU")) this.reLUList.remove(node.as(io.flogo.blatt.model.LinearSection.Block.ReLU.class));
			if (node.is("LinearSection$Block$ELU")) this.eLUList.remove(node.as(io.flogo.blatt.model.LinearSection.Block.ELU.class));
			if (node.is("LinearSection$Block$SELU")) this.sELUList.remove(node.as(io.flogo.blatt.model.LinearSection.Block.SELU.class));
			if (node.is("LinearSection$Block$GELU")) this.gELUList.remove(node.as(io.flogo.blatt.model.LinearSection.Block.GELU.class));
			if (node.is("LinearSection$Block$SiLU")) this.siLUList.remove(node.as(io.flogo.blatt.model.LinearSection.Block.SiLU.class));
			if (node.is("LinearSection$Block$GLU")) this.gLUList.remove(node.as(io.flogo.blatt.model.LinearSection.Block.GLU.class));
			if (node.is("LinearSection$Block$LeakyReLU")) this.leakyReLUList.remove(node.as(io.flogo.blatt.model.LinearSection.Block.LeakyReLU.class));
			if (node.is("LinearSection$Block$LogSigmoid")) this.logSigmoidList.remove(node.as(io.flogo.blatt.model.LinearSection.Block.LogSigmoid.class));
			if (node.is("LinearSection$Block$Sigmoid")) this.sigmoidList.remove(node.as(io.flogo.blatt.model.LinearSection.Block.Sigmoid.class));
			if (node.is("LinearSection$Block$Tanh")) this.tanhList.remove(node.as(io.flogo.blatt.model.LinearSection.Block.Tanh.class));
			if (node.is("LinearSection$Block$Mish")) this.mishList.remove(node.as(io.flogo.blatt.model.LinearSection.Block.Mish.class));
			if (node.is("LinearSection$Block$ProcessingLayer")) this.processingLayerList.remove(node.as(io.flogo.blatt.model.LinearSection.Block.ProcessingLayer.class));
			if (node.is("LinearSection$Block$Linear")) this.linearList.remove(node.as(io.flogo.blatt.model.LinearSection.Block.Linear.class));
			if (node.is("LinearSection$Block$Dropout")) this.dropoutList.remove(node.as(io.flogo.blatt.model.LinearSection.Block.Dropout.class));
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

			public io.flogo.blatt.model.LinearSection.Block.ReLU reLU() {
				io.flogo.blatt.model.LinearSection.Block.ReLU newElement = core$().graph().concept(io.flogo.blatt.model.LinearSection.Block.ReLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.LinearSection.Block.ReLU.class);

				return newElement;
			}

			public io.flogo.blatt.model.LinearSection.Block.ELU eLU() {
				io.flogo.blatt.model.LinearSection.Block.ELU newElement = core$().graph().concept(io.flogo.blatt.model.LinearSection.Block.ELU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.LinearSection.Block.ELU.class);

				return newElement;
			}

			public io.flogo.blatt.model.LinearSection.Block.SELU sELU() {
				io.flogo.blatt.model.LinearSection.Block.SELU newElement = core$().graph().concept(io.flogo.blatt.model.LinearSection.Block.SELU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.LinearSection.Block.SELU.class);

				return newElement;
			}

			public io.flogo.blatt.model.LinearSection.Block.GELU gELU() {
				io.flogo.blatt.model.LinearSection.Block.GELU newElement = core$().graph().concept(io.flogo.blatt.model.LinearSection.Block.GELU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.LinearSection.Block.GELU.class);

				return newElement;
			}

			public io.flogo.blatt.model.LinearSection.Block.SiLU siLU() {
				io.flogo.blatt.model.LinearSection.Block.SiLU newElement = core$().graph().concept(io.flogo.blatt.model.LinearSection.Block.SiLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.LinearSection.Block.SiLU.class);

				return newElement;
			}

			public io.flogo.blatt.model.LinearSection.Block.GLU gLU() {
				io.flogo.blatt.model.LinearSection.Block.GLU newElement = core$().graph().concept(io.flogo.blatt.model.LinearSection.Block.GLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.LinearSection.Block.GLU.class);

				return newElement;
			}

			public io.flogo.blatt.model.LinearSection.Block.LeakyReLU leakyReLU() {
				io.flogo.blatt.model.LinearSection.Block.LeakyReLU newElement = core$().graph().concept(io.flogo.blatt.model.LinearSection.Block.LeakyReLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.LinearSection.Block.LeakyReLU.class);

				return newElement;
			}

			public io.flogo.blatt.model.LinearSection.Block.LogSigmoid logSigmoid() {
				io.flogo.blatt.model.LinearSection.Block.LogSigmoid newElement = core$().graph().concept(io.flogo.blatt.model.LinearSection.Block.LogSigmoid.class).createNode(this.name, core$()).as(io.flogo.blatt.model.LinearSection.Block.LogSigmoid.class);

				return newElement;
			}

			public io.flogo.blatt.model.LinearSection.Block.Sigmoid sigmoid() {
				io.flogo.blatt.model.LinearSection.Block.Sigmoid newElement = core$().graph().concept(io.flogo.blatt.model.LinearSection.Block.Sigmoid.class).createNode(this.name, core$()).as(io.flogo.blatt.model.LinearSection.Block.Sigmoid.class);

				return newElement;
			}

			public io.flogo.blatt.model.LinearSection.Block.Tanh tanh() {
				io.flogo.blatt.model.LinearSection.Block.Tanh newElement = core$().graph().concept(io.flogo.blatt.model.LinearSection.Block.Tanh.class).createNode(this.name, core$()).as(io.flogo.blatt.model.LinearSection.Block.Tanh.class);

				return newElement;
			}

			public io.flogo.blatt.model.LinearSection.Block.Mish mish() {
				io.flogo.blatt.model.LinearSection.Block.Mish newElement = core$().graph().concept(io.flogo.blatt.model.LinearSection.Block.Mish.class).createNode(this.name, core$()).as(io.flogo.blatt.model.LinearSection.Block.Mish.class);

				return newElement;
			}

			public io.flogo.blatt.model.LinearSection.Block.Linear linear() {
				io.flogo.blatt.model.LinearSection.Block.Linear newElement = core$().graph().concept(io.flogo.blatt.model.LinearSection.Block.Linear.class).createNode(this.name, core$()).as(io.flogo.blatt.model.LinearSection.Block.Linear.class);

				return newElement;
			}

			public io.flogo.blatt.model.LinearSection.Block.Dropout dropout() {
				io.flogo.blatt.model.LinearSection.Block.Dropout newElement = core$().graph().concept(io.flogo.blatt.model.LinearSection.Block.Dropout.class).createNode(this.name, core$()).as(io.flogo.blatt.model.LinearSection.Block.Dropout.class);

				return newElement;
			}

		}

		public Clear clear() {
			return new Clear();
		}

		public class Clear  {
			public void reLU(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.ReLU> filter) {
				new java.util.ArrayList<>(reLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void eLU(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.ELU> filter) {
				new java.util.ArrayList<>(eLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void sELU(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.SELU> filter) {
				new java.util.ArrayList<>(sELUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void gELU(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.GELU> filter) {
				new java.util.ArrayList<>(gELUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void siLU(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.SiLU> filter) {
				new java.util.ArrayList<>(siLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void gLU(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.GLU> filter) {
				new java.util.ArrayList<>(gLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void leakyReLU(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.LeakyReLU> filter) {
				new java.util.ArrayList<>(leakyReLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void logSigmoid(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.LogSigmoid> filter) {
				new java.util.ArrayList<>(logSigmoidList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void sigmoid(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.Sigmoid> filter) {
				new java.util.ArrayList<>(sigmoidList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void tanh(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.Tanh> filter) {
				new java.util.ArrayList<>(tanhList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void mish(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.Mish> filter) {
				new java.util.ArrayList<>(mishList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void linear(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.Linear> filter) {
				new java.util.ArrayList<>(linearList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void dropout(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.Dropout> filter) {
				new java.util.ArrayList<>(dropoutList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
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

		public static abstract class ActivationLayer extends io.flogo.blatt.model.LinearSection.Block.Layer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class ReLU extends io.flogo.blatt.model.LinearSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class ELU extends io.flogo.blatt.model.LinearSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {
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

		public static class SELU extends io.flogo.blatt.model.LinearSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class GELU extends io.flogo.blatt.model.LinearSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class SiLU extends io.flogo.blatt.model.LinearSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class GLU extends io.flogo.blatt.model.LinearSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class LeakyReLU extends io.flogo.blatt.model.LinearSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {
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

		public static class LogSigmoid extends io.flogo.blatt.model.LinearSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class Sigmoid extends io.flogo.blatt.model.LinearSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class Tanh extends io.flogo.blatt.model.LinearSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class Mish extends io.flogo.blatt.model.LinearSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static abstract class ProcessingLayer extends io.flogo.blatt.model.LinearSection.Block.Layer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class Linear extends io.flogo.blatt.model.LinearSection.Block.ProcessingLayer implements io.intino.magritte.framework.tags.Terminal {
			protected java.util.List<io.flogo.blatt.model.LinearSection.Block.Linear.Output> outputList = new java.util.ArrayList<>();

			public Linear(io.intino.magritte.framework.Node node) {
				super(node);
			}

			public java.util.List<io.flogo.blatt.model.LinearSection.Block.Linear.Output> outputList() {
				return java.util.Collections.unmodifiableList(outputList);
			}

			public io.flogo.blatt.model.LinearSection.Block.Linear.Output output(int index) {
				return outputList.get(index);
			}

			public java.util.List<io.flogo.blatt.model.LinearSection.Block.Linear.Output> outputList(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.Linear.Output> predicate) {
				return outputList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
			}

			public io.flogo.blatt.model.LinearSection.Block.Linear.Output output(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.Linear.Output> predicate) {
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
				return map;
			}

			@Override
			protected void addNode$(io.intino.magritte.framework.Node node) {
				super.addNode$(node);
				if (node.is("LinearSection$Block$Linear$Output")) this.outputList.add(node.as(io.flogo.blatt.model.LinearSection.Block.Linear.Output.class));
			}

			@Override
			protected void removeNode$(io.intino.magritte.framework.Node node) {
				super.removeNode$(node);
				if (node.is("LinearSection$Block$Linear$Output")) this.outputList.remove(node.as(io.flogo.blatt.model.LinearSection.Block.Linear.Output.class));
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

			public class Create extends io.flogo.blatt.model.LinearSection.Block.ProcessingLayer.Create {


				public Create(java.lang.String name) {
					super(name);
				}

				public io.flogo.blatt.model.LinearSection.Block.Linear.Output output(int x) {
					io.flogo.blatt.model.LinearSection.Block.Linear.Output newElement = core$().graph().concept(io.flogo.blatt.model.LinearSection.Block.Linear.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.LinearSection.Block.Linear.Output.class);
					newElement.core$().set(newElement, "x", java.util.Collections.singletonList(x));
					return newElement;
				}

			}

			public Clear clear() {
				return new Clear();
			}

			public class Clear  {
				public void output(java.util.function.Predicate<io.flogo.blatt.model.LinearSection.Block.Linear.Output> filter) {
					new java.util.ArrayList<>(outputList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
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


			public io.flogo.blatt.model.BlattGraph graph() {
				return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
			}
		}

		public static class Dropout extends io.flogo.blatt.model.LinearSection.Block.ProcessingLayer implements io.intino.magritte.framework.tags.Terminal {
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


		public io.flogo.blatt.model.BlattGraph graph() {
			return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
		}
	}


	public io.flogo.blatt.model.BlattGraph graph() {
		return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
	}
}