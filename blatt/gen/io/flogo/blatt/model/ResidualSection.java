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

		public io.flogo.blatt.model.ResidualSection.Input input(int z) {
			io.flogo.blatt.model.ResidualSection.Input newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.Input.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.Input.class);
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
		protected int z;

		public Input(io.intino.magritte.framework.Node node) {
			super(node);
		}

		public int z() {
			return z;
		}

		public Input z(int value) {
			this.z = value;
			return (Input) this;
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
			if (name.equalsIgnoreCase("z")) this.z = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
		}

		@Override
		protected void set$(java.lang.String name, java.util.List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("z")) this.z = (java.lang.Integer) values.get(0);
		}

		public io.flogo.blatt.model.BlattGraph graph() {
			return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
		}
	}

	public static class Block  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
		protected int repeat;
		protected java.util.List<io.flogo.blatt.model.ResidualSection.Block.Output> outputList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.Block.ActivationLayer> activationLayerList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.Block.ReLU> reLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.Block.ELU> eLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.Block.SELU> sELUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.Block.GELU> gELUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.Block.SiLU> siLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.Block.GLU> gLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.Block.LeakyReLU> leakyReLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.Block.LogSigmoid> logSigmoidList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.Block.Sigmoid> sigmoidList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.Block.Tanh> tanhList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ResidualSection.Block.Mish> mishList = new java.util.ArrayList<>();

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

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.ActivationLayer> activationLayerList() {
			return java.util.Collections.unmodifiableList(activationLayerList);
		}

		public io.flogo.blatt.model.ResidualSection.Block.ActivationLayer activationLayer(int index) {
			return activationLayerList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.ActivationLayer> activationLayerList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.ActivationLayer> predicate) {
			return activationLayerList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.Block.ActivationLayer activationLayer(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.ActivationLayer> predicate) {
			return activationLayerList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.ReLU> reLUList() {
			return java.util.Collections.unmodifiableList(reLUList);
		}

		public io.flogo.blatt.model.ResidualSection.Block.ReLU reLU(int index) {
			return reLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.ReLU> reLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.ReLU> predicate) {
			return reLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.Block.ReLU reLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.ReLU> predicate) {
			return reLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.ELU> eLUList() {
			return java.util.Collections.unmodifiableList(eLUList);
		}

		public io.flogo.blatt.model.ResidualSection.Block.ELU eLU(int index) {
			return eLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.ELU> eLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.ELU> predicate) {
			return eLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.Block.ELU eLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.ELU> predicate) {
			return eLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.SELU> sELUList() {
			return java.util.Collections.unmodifiableList(sELUList);
		}

		public io.flogo.blatt.model.ResidualSection.Block.SELU sELU(int index) {
			return sELUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.SELU> sELUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.SELU> predicate) {
			return sELUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.Block.SELU sELU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.SELU> predicate) {
			return sELUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.GELU> gELUList() {
			return java.util.Collections.unmodifiableList(gELUList);
		}

		public io.flogo.blatt.model.ResidualSection.Block.GELU gELU(int index) {
			return gELUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.GELU> gELUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.GELU> predicate) {
			return gELUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.Block.GELU gELU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.GELU> predicate) {
			return gELUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.SiLU> siLUList() {
			return java.util.Collections.unmodifiableList(siLUList);
		}

		public io.flogo.blatt.model.ResidualSection.Block.SiLU siLU(int index) {
			return siLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.SiLU> siLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.SiLU> predicate) {
			return siLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.Block.SiLU siLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.SiLU> predicate) {
			return siLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.GLU> gLUList() {
			return java.util.Collections.unmodifiableList(gLUList);
		}

		public io.flogo.blatt.model.ResidualSection.Block.GLU gLU(int index) {
			return gLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.GLU> gLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.GLU> predicate) {
			return gLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.Block.GLU gLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.GLU> predicate) {
			return gLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.LeakyReLU> leakyReLUList() {
			return java.util.Collections.unmodifiableList(leakyReLUList);
		}

		public io.flogo.blatt.model.ResidualSection.Block.LeakyReLU leakyReLU(int index) {
			return leakyReLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.LeakyReLU> leakyReLUList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.LeakyReLU> predicate) {
			return leakyReLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.Block.LeakyReLU leakyReLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.LeakyReLU> predicate) {
			return leakyReLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.LogSigmoid> logSigmoidList() {
			return java.util.Collections.unmodifiableList(logSigmoidList);
		}

		public io.flogo.blatt.model.ResidualSection.Block.LogSigmoid logSigmoid(int index) {
			return logSigmoidList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.LogSigmoid> logSigmoidList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.LogSigmoid> predicate) {
			return logSigmoidList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.Block.LogSigmoid logSigmoid(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.LogSigmoid> predicate) {
			return logSigmoidList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.Sigmoid> sigmoidList() {
			return java.util.Collections.unmodifiableList(sigmoidList);
		}

		public io.flogo.blatt.model.ResidualSection.Block.Sigmoid sigmoid(int index) {
			return sigmoidList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.Sigmoid> sigmoidList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.Sigmoid> predicate) {
			return sigmoidList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.Block.Sigmoid sigmoid(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.Sigmoid> predicate) {
			return sigmoidList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.Tanh> tanhList() {
			return java.util.Collections.unmodifiableList(tanhList);
		}

		public io.flogo.blatt.model.ResidualSection.Block.Tanh tanh(int index) {
			return tanhList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.Tanh> tanhList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.Tanh> predicate) {
			return tanhList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.Block.Tanh tanh(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.Tanh> predicate) {
			return tanhList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.Mish> mishList() {
			return java.util.Collections.unmodifiableList(mishList);
		}

		public io.flogo.blatt.model.ResidualSection.Block.Mish mish(int index) {
			return mishList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ResidualSection.Block.Mish> mishList(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.Mish> predicate) {
			return mishList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ResidualSection.Block.Mish mish(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.Mish> predicate) {
			return mishList().stream().filter(predicate).findFirst().orElse(null);
		}

		protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
			java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
			new java.util.ArrayList<>(outputList).forEach(c -> components.add(c.core$()));
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
			if (node.is("ResidualSection$Block$ActivationLayer")) this.activationLayerList.add(node.as(io.flogo.blatt.model.ResidualSection.Block.ActivationLayer.class));
			if (node.is("ResidualSection$Block$ReLU")) this.reLUList.add(node.as(io.flogo.blatt.model.ResidualSection.Block.ReLU.class));
			if (node.is("ResidualSection$Block$ELU")) this.eLUList.add(node.as(io.flogo.blatt.model.ResidualSection.Block.ELU.class));
			if (node.is("ResidualSection$Block$SELU")) this.sELUList.add(node.as(io.flogo.blatt.model.ResidualSection.Block.SELU.class));
			if (node.is("ResidualSection$Block$GELU")) this.gELUList.add(node.as(io.flogo.blatt.model.ResidualSection.Block.GELU.class));
			if (node.is("ResidualSection$Block$SiLU")) this.siLUList.add(node.as(io.flogo.blatt.model.ResidualSection.Block.SiLU.class));
			if (node.is("ResidualSection$Block$GLU")) this.gLUList.add(node.as(io.flogo.blatt.model.ResidualSection.Block.GLU.class));
			if (node.is("ResidualSection$Block$LeakyReLU")) this.leakyReLUList.add(node.as(io.flogo.blatt.model.ResidualSection.Block.LeakyReLU.class));
			if (node.is("ResidualSection$Block$LogSigmoid")) this.logSigmoidList.add(node.as(io.flogo.blatt.model.ResidualSection.Block.LogSigmoid.class));
			if (node.is("ResidualSection$Block$Sigmoid")) this.sigmoidList.add(node.as(io.flogo.blatt.model.ResidualSection.Block.Sigmoid.class));
			if (node.is("ResidualSection$Block$Tanh")) this.tanhList.add(node.as(io.flogo.blatt.model.ResidualSection.Block.Tanh.class));
			if (node.is("ResidualSection$Block$Mish")) this.mishList.add(node.as(io.flogo.blatt.model.ResidualSection.Block.Mish.class));
		}

		@Override
		protected void removeNode$(io.intino.magritte.framework.Node node) {
			super.removeNode$(node);
			if (node.is("ResidualSection$Block$Output")) this.outputList.remove(node.as(io.flogo.blatt.model.ResidualSection.Block.Output.class));
			if (node.is("ResidualSection$Block$ActivationLayer")) this.activationLayerList.remove(node.as(io.flogo.blatt.model.ResidualSection.Block.ActivationLayer.class));
			if (node.is("ResidualSection$Block$ReLU")) this.reLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.Block.ReLU.class));
			if (node.is("ResidualSection$Block$ELU")) this.eLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.Block.ELU.class));
			if (node.is("ResidualSection$Block$SELU")) this.sELUList.remove(node.as(io.flogo.blatt.model.ResidualSection.Block.SELU.class));
			if (node.is("ResidualSection$Block$GELU")) this.gELUList.remove(node.as(io.flogo.blatt.model.ResidualSection.Block.GELU.class));
			if (node.is("ResidualSection$Block$SiLU")) this.siLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.Block.SiLU.class));
			if (node.is("ResidualSection$Block$GLU")) this.gLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.Block.GLU.class));
			if (node.is("ResidualSection$Block$LeakyReLU")) this.leakyReLUList.remove(node.as(io.flogo.blatt.model.ResidualSection.Block.LeakyReLU.class));
			if (node.is("ResidualSection$Block$LogSigmoid")) this.logSigmoidList.remove(node.as(io.flogo.blatt.model.ResidualSection.Block.LogSigmoid.class));
			if (node.is("ResidualSection$Block$Sigmoid")) this.sigmoidList.remove(node.as(io.flogo.blatt.model.ResidualSection.Block.Sigmoid.class));
			if (node.is("ResidualSection$Block$Tanh")) this.tanhList.remove(node.as(io.flogo.blatt.model.ResidualSection.Block.Tanh.class));
			if (node.is("ResidualSection$Block$Mish")) this.mishList.remove(node.as(io.flogo.blatt.model.ResidualSection.Block.Mish.class));
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

			public io.flogo.blatt.model.ResidualSection.Block.Output output(int z) {
				io.flogo.blatt.model.ResidualSection.Block.Output newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.Block.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.Block.Output.class);
				newElement.core$().set(newElement, "z", java.util.Collections.singletonList(z));
				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.Block.ReLU reLU() {
				io.flogo.blatt.model.ResidualSection.Block.ReLU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.Block.ReLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.Block.ReLU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.Block.ELU eLU() {
				io.flogo.blatt.model.ResidualSection.Block.ELU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.Block.ELU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.Block.ELU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.Block.SELU sELU() {
				io.flogo.blatt.model.ResidualSection.Block.SELU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.Block.SELU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.Block.SELU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.Block.GELU gELU() {
				io.flogo.blatt.model.ResidualSection.Block.GELU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.Block.GELU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.Block.GELU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.Block.SiLU siLU() {
				io.flogo.blatt.model.ResidualSection.Block.SiLU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.Block.SiLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.Block.SiLU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.Block.GLU gLU() {
				io.flogo.blatt.model.ResidualSection.Block.GLU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.Block.GLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.Block.GLU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.Block.LeakyReLU leakyReLU() {
				io.flogo.blatt.model.ResidualSection.Block.LeakyReLU newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.Block.LeakyReLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.Block.LeakyReLU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.Block.LogSigmoid logSigmoid() {
				io.flogo.blatt.model.ResidualSection.Block.LogSigmoid newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.Block.LogSigmoid.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.Block.LogSigmoid.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.Block.Sigmoid sigmoid() {
				io.flogo.blatt.model.ResidualSection.Block.Sigmoid newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.Block.Sigmoid.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.Block.Sigmoid.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.Block.Tanh tanh() {
				io.flogo.blatt.model.ResidualSection.Block.Tanh newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.Block.Tanh.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.Block.Tanh.class);

				return newElement;
			}

			public io.flogo.blatt.model.ResidualSection.Block.Mish mish() {
				io.flogo.blatt.model.ResidualSection.Block.Mish newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.Block.Mish.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.Block.Mish.class);

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

			public void reLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.ReLU> filter) {
				new java.util.ArrayList<>(reLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void eLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.ELU> filter) {
				new java.util.ArrayList<>(eLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void sELU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.SELU> filter) {
				new java.util.ArrayList<>(sELUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void gELU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.GELU> filter) {
				new java.util.ArrayList<>(gELUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void siLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.SiLU> filter) {
				new java.util.ArrayList<>(siLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void gLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.GLU> filter) {
				new java.util.ArrayList<>(gLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void leakyReLU(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.LeakyReLU> filter) {
				new java.util.ArrayList<>(leakyReLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void logSigmoid(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.LogSigmoid> filter) {
				new java.util.ArrayList<>(logSigmoidList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void sigmoid(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.Sigmoid> filter) {
				new java.util.ArrayList<>(sigmoidList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void tanh(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.Tanh> filter) {
				new java.util.ArrayList<>(tanhList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void mish(java.util.function.Predicate<io.flogo.blatt.model.ResidualSection.Block.Mish> filter) {
				new java.util.ArrayList<>(mishList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}
		}

		public static class Output  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
			protected int z;

			public Output(io.intino.magritte.framework.Node node) {
				super(node);
			}

			public int z() {
				return z;
			}

			public Output z(int value) {
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
				if (name.equalsIgnoreCase("z")) this.z = io.intino.magritte.framework.loaders.IntegerLoader.load(values, this).get(0);
			}

			@Override
			protected void set$(java.lang.String name, java.util.List<?> values) {
				super.set$(name, values);
				if (name.equalsIgnoreCase("z")) this.z = (java.lang.Integer) values.get(0);
			}

			public io.flogo.blatt.model.BlattGraph graph() {
				return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
			}
		}

		public static abstract class ActivationLayer  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {

			public ActivationLayer(io.intino.magritte.framework.Node node) {
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

		public static class ReLU extends io.flogo.blatt.model.ResidualSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class ELU extends io.flogo.blatt.model.ResidualSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {
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

		public static class SELU extends io.flogo.blatt.model.ResidualSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class GELU extends io.flogo.blatt.model.ResidualSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class SiLU extends io.flogo.blatt.model.ResidualSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class GLU extends io.flogo.blatt.model.ResidualSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class LeakyReLU extends io.flogo.blatt.model.ResidualSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {
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

		public static class LogSigmoid extends io.flogo.blatt.model.ResidualSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class Sigmoid extends io.flogo.blatt.model.ResidualSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class Tanh extends io.flogo.blatt.model.ResidualSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class Mish extends io.flogo.blatt.model.ResidualSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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


		public io.flogo.blatt.model.BlattGraph graph() {
			return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
		}
	}


	public io.flogo.blatt.model.BlattGraph graph() {
		return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
	}
}