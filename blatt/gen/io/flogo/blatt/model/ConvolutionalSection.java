package io.flogo.blatt.model;

import io.flogo.blatt.model.*;

public class ConvolutionalSection extends io.flogo.blatt.model.ProcessingSection implements io.intino.magritte.framework.tags.Component, io.intino.magritte.framework.tags.Terminal {
	protected io.flogo.blatt.model.ConvolutionalSection.Input input;
	protected java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block> blockList = new java.util.ArrayList<>();

	public ConvolutionalSection(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public io.flogo.blatt.model.ConvolutionalSection.Input input() {
		return input;
	}

	public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block> blockList() {
		return java.util.Collections.unmodifiableList(blockList);
	}

	public io.flogo.blatt.model.ConvolutionalSection.Block block(int index) {
		return blockList.get(index);
	}

	public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block> blockList(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block> predicate) {
		return blockList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
	}

	public io.flogo.blatt.model.ConvolutionalSection.Block block(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block> predicate) {
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
		if (node.is("ConvolutionalSection$Input")) this.input = node.as(io.flogo.blatt.model.ConvolutionalSection.Input.class);
		if (node.is("ConvolutionalSection$Block")) this.blockList.add(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.class));
	}

	@Override
	protected void removeNode$(io.intino.magritte.framework.Node node) {
		super.removeNode$(node);
		if (node.is("ConvolutionalSection$Input")) this.input = null;
		if (node.is("ConvolutionalSection$Block")) this.blockList.remove(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.class));
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

		public io.flogo.blatt.model.ConvolutionalSection.Input input(int x, int y, int z) {
			io.flogo.blatt.model.ConvolutionalSection.Input newElement = core$().graph().concept(io.flogo.blatt.model.ConvolutionalSection.Input.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ConvolutionalSection.Input.class);
			newElement.core$().set(newElement, "x", java.util.Collections.singletonList(x));
			newElement.core$().set(newElement, "y", java.util.Collections.singletonList(y));
			newElement.core$().set(newElement, "z", java.util.Collections.singletonList(z));
			return newElement;
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block block() {
			io.flogo.blatt.model.ConvolutionalSection.Block newElement = core$().graph().concept(io.flogo.blatt.model.ConvolutionalSection.Block.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ConvolutionalSection.Block.class);

			return newElement;
		}

	}

	public Clear clear() {
		return new Clear();
	}

	public class Clear  {
		public void block(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block> filter) {
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
		protected java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.Layer> layerList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.ActivationLayer> activationLayerList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.Tanh> tanhList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.Sigmoid> sigmoidList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.LogSigmoid> logSigmoidList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.ReLU> reLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.SELU> sELUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.GELU> gELUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.SiLU> siLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.GLU> gLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.ELU> eLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.LeakyReLU> leakyReLUList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.Mish> mishList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.ProcessingLayer> processingLayerList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.Convolutional> convolutionalList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.Pool> poolList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.MaxPool> maxPoolList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool> avgPoolList = new java.util.ArrayList<>();
		protected java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.Normalization> normalizationList = new java.util.ArrayList<>();

		public Block(io.intino.magritte.framework.Node node) {
			super(node);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.Layer> layerList() {
			return java.util.Collections.unmodifiableList(layerList);
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.Layer layer(int index) {
			return layerList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.Layer> layerList(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.Layer> predicate) {
			return layerList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.Layer layer(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.Layer> predicate) {
			return layerList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.ActivationLayer> activationLayerList() {
			return java.util.Collections.unmodifiableList(activationLayerList);
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.ActivationLayer activationLayer(int index) {
			return activationLayerList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.ActivationLayer> activationLayerList(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.ActivationLayer> predicate) {
			return activationLayerList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.ActivationLayer activationLayer(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.ActivationLayer> predicate) {
			return activationLayerList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.Tanh> tanhList() {
			return java.util.Collections.unmodifiableList(tanhList);
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.Tanh tanh(int index) {
			return tanhList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.Tanh> tanhList(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.Tanh> predicate) {
			return tanhList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.Tanh tanh(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.Tanh> predicate) {
			return tanhList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.Sigmoid> sigmoidList() {
			return java.util.Collections.unmodifiableList(sigmoidList);
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.Sigmoid sigmoid(int index) {
			return sigmoidList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.Sigmoid> sigmoidList(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.Sigmoid> predicate) {
			return sigmoidList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.Sigmoid sigmoid(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.Sigmoid> predicate) {
			return sigmoidList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.LogSigmoid> logSigmoidList() {
			return java.util.Collections.unmodifiableList(logSigmoidList);
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.LogSigmoid logSigmoid(int index) {
			return logSigmoidList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.LogSigmoid> logSigmoidList(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.LogSigmoid> predicate) {
			return logSigmoidList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.LogSigmoid logSigmoid(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.LogSigmoid> predicate) {
			return logSigmoidList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.ReLU> reLUList() {
			return java.util.Collections.unmodifiableList(reLUList);
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.ReLU reLU(int index) {
			return reLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.ReLU> reLUList(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.ReLU> predicate) {
			return reLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.ReLU reLU(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.ReLU> predicate) {
			return reLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.SELU> sELUList() {
			return java.util.Collections.unmodifiableList(sELUList);
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.SELU sELU(int index) {
			return sELUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.SELU> sELUList(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.SELU> predicate) {
			return sELUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.SELU sELU(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.SELU> predicate) {
			return sELUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.GELU> gELUList() {
			return java.util.Collections.unmodifiableList(gELUList);
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.GELU gELU(int index) {
			return gELUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.GELU> gELUList(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.GELU> predicate) {
			return gELUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.GELU gELU(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.GELU> predicate) {
			return gELUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.SiLU> siLUList() {
			return java.util.Collections.unmodifiableList(siLUList);
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.SiLU siLU(int index) {
			return siLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.SiLU> siLUList(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.SiLU> predicate) {
			return siLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.SiLU siLU(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.SiLU> predicate) {
			return siLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.GLU> gLUList() {
			return java.util.Collections.unmodifiableList(gLUList);
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.GLU gLU(int index) {
			return gLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.GLU> gLUList(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.GLU> predicate) {
			return gLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.GLU gLU(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.GLU> predicate) {
			return gLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.ELU> eLUList() {
			return java.util.Collections.unmodifiableList(eLUList);
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.ELU eLU(int index) {
			return eLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.ELU> eLUList(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.ELU> predicate) {
			return eLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.ELU eLU(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.ELU> predicate) {
			return eLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.LeakyReLU> leakyReLUList() {
			return java.util.Collections.unmodifiableList(leakyReLUList);
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.LeakyReLU leakyReLU(int index) {
			return leakyReLUList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.LeakyReLU> leakyReLUList(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.LeakyReLU> predicate) {
			return leakyReLUList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.LeakyReLU leakyReLU(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.LeakyReLU> predicate) {
			return leakyReLUList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.Mish> mishList() {
			return java.util.Collections.unmodifiableList(mishList);
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.Mish mish(int index) {
			return mishList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.Mish> mishList(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.Mish> predicate) {
			return mishList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.Mish mish(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.Mish> predicate) {
			return mishList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.ProcessingLayer> processingLayerList() {
			return java.util.Collections.unmodifiableList(processingLayerList);
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.ProcessingLayer processingLayer(int index) {
			return processingLayerList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.ProcessingLayer> processingLayerList(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.ProcessingLayer> predicate) {
			return processingLayerList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.ProcessingLayer processingLayer(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.ProcessingLayer> predicate) {
			return processingLayerList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.Convolutional> convolutionalList() {
			return java.util.Collections.unmodifiableList(convolutionalList);
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.Convolutional convolutional(int index) {
			return convolutionalList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.Convolutional> convolutionalList(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.Convolutional> predicate) {
			return convolutionalList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.Convolutional convolutional(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.Convolutional> predicate) {
			return convolutionalList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.Pool> poolList() {
			return java.util.Collections.unmodifiableList(poolList);
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.Pool pool(int index) {
			return poolList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.Pool> poolList(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.Pool> predicate) {
			return poolList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.Pool pool(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.Pool> predicate) {
			return poolList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.MaxPool> maxPoolList() {
			return java.util.Collections.unmodifiableList(maxPoolList);
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.MaxPool maxPool(int index) {
			return maxPoolList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.MaxPool> maxPoolList(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.MaxPool> predicate) {
			return maxPoolList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.MaxPool maxPool(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.MaxPool> predicate) {
			return maxPoolList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool> avgPoolList() {
			return java.util.Collections.unmodifiableList(avgPoolList);
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool avgPool(int index) {
			return avgPoolList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool> avgPoolList(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool> predicate) {
			return avgPoolList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool avgPool(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool> predicate) {
			return avgPoolList().stream().filter(predicate).findFirst().orElse(null);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.Normalization> normalizationList() {
			return java.util.Collections.unmodifiableList(normalizationList);
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.Normalization normalization(int index) {
			return normalizationList.get(index);
		}

		public java.util.List<io.flogo.blatt.model.ConvolutionalSection.Block.Normalization> normalizationList(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.Normalization> predicate) {
			return normalizationList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.ConvolutionalSection.Block.Normalization normalization(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.Normalization> predicate) {
			return normalizationList().stream().filter(predicate).findFirst().orElse(null);
		}

		protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
			java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
			new java.util.ArrayList<>(layerList).forEach(c -> components.add(c.core$()));
			new java.util.ArrayList<>(activationLayerList).forEach(c -> components.add(c.core$()));
			new java.util.ArrayList<>(tanhList).forEach(c -> components.add(c.core$()));
			new java.util.ArrayList<>(sigmoidList).forEach(c -> components.add(c.core$()));
			new java.util.ArrayList<>(logSigmoidList).forEach(c -> components.add(c.core$()));
			new java.util.ArrayList<>(reLUList).forEach(c -> components.add(c.core$()));
			new java.util.ArrayList<>(sELUList).forEach(c -> components.add(c.core$()));
			new java.util.ArrayList<>(gELUList).forEach(c -> components.add(c.core$()));
			new java.util.ArrayList<>(siLUList).forEach(c -> components.add(c.core$()));
			new java.util.ArrayList<>(gLUList).forEach(c -> components.add(c.core$()));
			new java.util.ArrayList<>(eLUList).forEach(c -> components.add(c.core$()));
			new java.util.ArrayList<>(leakyReLUList).forEach(c -> components.add(c.core$()));
			new java.util.ArrayList<>(mishList).forEach(c -> components.add(c.core$()));
			new java.util.ArrayList<>(processingLayerList).forEach(c -> components.add(c.core$()));
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
			if (node.is("ConvolutionalSection$Block$Layer")) this.layerList.add(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.Layer.class));
			if (node.is("ConvolutionalSection$Block$ActivationLayer")) this.activationLayerList.add(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.ActivationLayer.class));
			if (node.is("ConvolutionalSection$Block$Tanh")) this.tanhList.add(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.Tanh.class));
			if (node.is("ConvolutionalSection$Block$Sigmoid")) this.sigmoidList.add(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.Sigmoid.class));
			if (node.is("ConvolutionalSection$Block$LogSigmoid")) this.logSigmoidList.add(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.LogSigmoid.class));
			if (node.is("ConvolutionalSection$Block$ReLU")) this.reLUList.add(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.ReLU.class));
			if (node.is("ConvolutionalSection$Block$SELU")) this.sELUList.add(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.SELU.class));
			if (node.is("ConvolutionalSection$Block$GELU")) this.gELUList.add(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.GELU.class));
			if (node.is("ConvolutionalSection$Block$SiLU")) this.siLUList.add(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.SiLU.class));
			if (node.is("ConvolutionalSection$Block$GLU")) this.gLUList.add(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.GLU.class));
			if (node.is("ConvolutionalSection$Block$ELU")) this.eLUList.add(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.ELU.class));
			if (node.is("ConvolutionalSection$Block$LeakyReLU")) this.leakyReLUList.add(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.LeakyReLU.class));
			if (node.is("ConvolutionalSection$Block$Mish")) this.mishList.add(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.Mish.class));
			if (node.is("ConvolutionalSection$Block$ProcessingLayer")) this.processingLayerList.add(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.ProcessingLayer.class));
			if (node.is("ConvolutionalSection$Block$Convolutional")) this.convolutionalList.add(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.Convolutional.class));
			if (node.is("ConvolutionalSection$Block$Pool")) this.poolList.add(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.Pool.class));
			if (node.is("ConvolutionalSection$Block$MaxPool")) this.maxPoolList.add(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.MaxPool.class));
			if (node.is("ConvolutionalSection$Block$AvgPool")) this.avgPoolList.add(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool.class));
			if (node.is("ConvolutionalSection$Block$Normalization")) this.normalizationList.add(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.Normalization.class));
		}

		@Override
		protected void removeNode$(io.intino.magritte.framework.Node node) {
			super.removeNode$(node);
			if (node.is("ConvolutionalSection$Block$Layer")) this.layerList.remove(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.Layer.class));
			if (node.is("ConvolutionalSection$Block$ActivationLayer")) this.activationLayerList.remove(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.ActivationLayer.class));
			if (node.is("ConvolutionalSection$Block$Tanh")) this.tanhList.remove(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.Tanh.class));
			if (node.is("ConvolutionalSection$Block$Sigmoid")) this.sigmoidList.remove(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.Sigmoid.class));
			if (node.is("ConvolutionalSection$Block$LogSigmoid")) this.logSigmoidList.remove(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.LogSigmoid.class));
			if (node.is("ConvolutionalSection$Block$ReLU")) this.reLUList.remove(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.ReLU.class));
			if (node.is("ConvolutionalSection$Block$SELU")) this.sELUList.remove(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.SELU.class));
			if (node.is("ConvolutionalSection$Block$GELU")) this.gELUList.remove(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.GELU.class));
			if (node.is("ConvolutionalSection$Block$SiLU")) this.siLUList.remove(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.SiLU.class));
			if (node.is("ConvolutionalSection$Block$GLU")) this.gLUList.remove(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.GLU.class));
			if (node.is("ConvolutionalSection$Block$ELU")) this.eLUList.remove(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.ELU.class));
			if (node.is("ConvolutionalSection$Block$LeakyReLU")) this.leakyReLUList.remove(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.LeakyReLU.class));
			if (node.is("ConvolutionalSection$Block$Mish")) this.mishList.remove(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.Mish.class));
			if (node.is("ConvolutionalSection$Block$ProcessingLayer")) this.processingLayerList.remove(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.ProcessingLayer.class));
			if (node.is("ConvolutionalSection$Block$Convolutional")) this.convolutionalList.remove(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.Convolutional.class));
			if (node.is("ConvolutionalSection$Block$Pool")) this.poolList.remove(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.Pool.class));
			if (node.is("ConvolutionalSection$Block$MaxPool")) this.maxPoolList.remove(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.MaxPool.class));
			if (node.is("ConvolutionalSection$Block$AvgPool")) this.avgPoolList.remove(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool.class));
			if (node.is("ConvolutionalSection$Block$Normalization")) this.normalizationList.remove(node.as(io.flogo.blatt.model.ConvolutionalSection.Block.Normalization.class));
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

			public io.flogo.blatt.model.ConvolutionalSection.Block.Tanh tanh() {
				io.flogo.blatt.model.ConvolutionalSection.Block.Tanh newElement = core$().graph().concept(io.flogo.blatt.model.ConvolutionalSection.Block.Tanh.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ConvolutionalSection.Block.Tanh.class);

				return newElement;
			}

			public io.flogo.blatt.model.ConvolutionalSection.Block.Sigmoid sigmoid() {
				io.flogo.blatt.model.ConvolutionalSection.Block.Sigmoid newElement = core$().graph().concept(io.flogo.blatt.model.ConvolutionalSection.Block.Sigmoid.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ConvolutionalSection.Block.Sigmoid.class);

				return newElement;
			}

			public io.flogo.blatt.model.ConvolutionalSection.Block.LogSigmoid logSigmoid() {
				io.flogo.blatt.model.ConvolutionalSection.Block.LogSigmoid newElement = core$().graph().concept(io.flogo.blatt.model.ConvolutionalSection.Block.LogSigmoid.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ConvolutionalSection.Block.LogSigmoid.class);

				return newElement;
			}

			public io.flogo.blatt.model.ConvolutionalSection.Block.ReLU reLU() {
				io.flogo.blatt.model.ConvolutionalSection.Block.ReLU newElement = core$().graph().concept(io.flogo.blatt.model.ConvolutionalSection.Block.ReLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ConvolutionalSection.Block.ReLU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ConvolutionalSection.Block.SELU sELU() {
				io.flogo.blatt.model.ConvolutionalSection.Block.SELU newElement = core$().graph().concept(io.flogo.blatt.model.ConvolutionalSection.Block.SELU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ConvolutionalSection.Block.SELU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ConvolutionalSection.Block.GELU gELU() {
				io.flogo.blatt.model.ConvolutionalSection.Block.GELU newElement = core$().graph().concept(io.flogo.blatt.model.ConvolutionalSection.Block.GELU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ConvolutionalSection.Block.GELU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ConvolutionalSection.Block.SiLU siLU() {
				io.flogo.blatt.model.ConvolutionalSection.Block.SiLU newElement = core$().graph().concept(io.flogo.blatt.model.ConvolutionalSection.Block.SiLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ConvolutionalSection.Block.SiLU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ConvolutionalSection.Block.GLU gLU() {
				io.flogo.blatt.model.ConvolutionalSection.Block.GLU newElement = core$().graph().concept(io.flogo.blatt.model.ConvolutionalSection.Block.GLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ConvolutionalSection.Block.GLU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ConvolutionalSection.Block.ELU eLU() {
				io.flogo.blatt.model.ConvolutionalSection.Block.ELU newElement = core$().graph().concept(io.flogo.blatt.model.ConvolutionalSection.Block.ELU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ConvolutionalSection.Block.ELU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ConvolutionalSection.Block.LeakyReLU leakyReLU() {
				io.flogo.blatt.model.ConvolutionalSection.Block.LeakyReLU newElement = core$().graph().concept(io.flogo.blatt.model.ConvolutionalSection.Block.LeakyReLU.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ConvolutionalSection.Block.LeakyReLU.class);

				return newElement;
			}

			public io.flogo.blatt.model.ConvolutionalSection.Block.Mish mish() {
				io.flogo.blatt.model.ConvolutionalSection.Block.Mish newElement = core$().graph().concept(io.flogo.blatt.model.ConvolutionalSection.Block.Mish.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ConvolutionalSection.Block.Mish.class);

				return newElement;
			}

			public io.flogo.blatt.model.ConvolutionalSection.Block.Convolutional convolutional() {
				io.flogo.blatt.model.ConvolutionalSection.Block.Convolutional newElement = core$().graph().concept(io.flogo.blatt.model.ConvolutionalSection.Block.Convolutional.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ConvolutionalSection.Block.Convolutional.class);

				return newElement;
			}

			public io.flogo.blatt.model.ConvolutionalSection.Block.MaxPool maxPool() {
				io.flogo.blatt.model.ConvolutionalSection.Block.MaxPool newElement = core$().graph().concept(io.flogo.blatt.model.ConvolutionalSection.Block.MaxPool.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ConvolutionalSection.Block.MaxPool.class);

				return newElement;
			}

			public io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool avgPool() {
				io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool newElement = core$().graph().concept(io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool.class);

				return newElement;
			}

			public io.flogo.blatt.model.ConvolutionalSection.Block.Normalization normalization() {
				io.flogo.blatt.model.ConvolutionalSection.Block.Normalization newElement = core$().graph().concept(io.flogo.blatt.model.ConvolutionalSection.Block.Normalization.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ConvolutionalSection.Block.Normalization.class);

				return newElement;
			}

		}

		public Clear clear() {
			return new Clear();
		}

		public class Clear  {
			public void tanh(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.Tanh> filter) {
				new java.util.ArrayList<>(tanhList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void sigmoid(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.Sigmoid> filter) {
				new java.util.ArrayList<>(sigmoidList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void logSigmoid(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.LogSigmoid> filter) {
				new java.util.ArrayList<>(logSigmoidList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void reLU(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.ReLU> filter) {
				new java.util.ArrayList<>(reLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void sELU(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.SELU> filter) {
				new java.util.ArrayList<>(sELUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void gELU(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.GELU> filter) {
				new java.util.ArrayList<>(gELUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void siLU(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.SiLU> filter) {
				new java.util.ArrayList<>(siLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void gLU(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.GLU> filter) {
				new java.util.ArrayList<>(gLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void eLU(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.ELU> filter) {
				new java.util.ArrayList<>(eLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void leakyReLU(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.LeakyReLU> filter) {
				new java.util.ArrayList<>(leakyReLUList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void mish(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.Mish> filter) {
				new java.util.ArrayList<>(mishList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void convolutional(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.Convolutional> filter) {
				new java.util.ArrayList<>(convolutionalList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void maxPool(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.MaxPool> filter) {
				new java.util.ArrayList<>(maxPoolList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void avgPool(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool> filter) {
				new java.util.ArrayList<>(avgPoolList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
			}

			public void normalization(java.util.function.Predicate<io.flogo.blatt.model.ConvolutionalSection.Block.Normalization> filter) {
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

		public static abstract class ActivationLayer extends io.flogo.blatt.model.ConvolutionalSection.Block.Layer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class Tanh extends io.flogo.blatt.model.ConvolutionalSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class Sigmoid extends io.flogo.blatt.model.ConvolutionalSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class LogSigmoid extends io.flogo.blatt.model.ConvolutionalSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class ReLU extends io.flogo.blatt.model.ConvolutionalSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class SELU extends io.flogo.blatt.model.ConvolutionalSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class GELU extends io.flogo.blatt.model.ConvolutionalSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class SiLU extends io.flogo.blatt.model.ConvolutionalSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class GLU extends io.flogo.blatt.model.ConvolutionalSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class ELU extends io.flogo.blatt.model.ConvolutionalSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {
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

		public static class LeakyReLU extends io.flogo.blatt.model.ConvolutionalSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {
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

		public static class Mish extends io.flogo.blatt.model.ConvolutionalSection.Block.ActivationLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static abstract class ProcessingLayer extends io.flogo.blatt.model.ConvolutionalSection.Block.Layer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class Convolutional extends io.flogo.blatt.model.ConvolutionalSection.Block.ProcessingLayer implements io.intino.magritte.framework.tags.Terminal {
			protected io.flogo.blatt.model.ConvolutionalSection.Block.Convolutional.Output output;

			public Convolutional(io.intino.magritte.framework.Node node) {
				super(node);
			}

			public io.flogo.blatt.model.ConvolutionalSection.Block.Convolutional.Output output() {
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
				if (node.is("ConvolutionalSection$Block$Convolutional$Output")) this.output = node.as(io.flogo.blatt.model.ConvolutionalSection.Block.Convolutional.Output.class);
			}

			@Override
			protected void removeNode$(io.intino.magritte.framework.Node node) {
				super.removeNode$(node);
				if (node.is("ConvolutionalSection$Block$Convolutional$Output")) this.output = null;
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

			public class Create extends io.flogo.blatt.model.ConvolutionalSection.Block.ProcessingLayer.Create {


				public Create(java.lang.String name) {
					super(name);
				}

				public io.flogo.blatt.model.ConvolutionalSection.Block.Convolutional.Output output(int x, int y, int z) {
					io.flogo.blatt.model.ConvolutionalSection.Block.Convolutional.Output newElement = core$().graph().concept(io.flogo.blatt.model.ConvolutionalSection.Block.Convolutional.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ConvolutionalSection.Block.Convolutional.Output.class);
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

		public static abstract class Pool extends io.flogo.blatt.model.ConvolutionalSection.Block.ProcessingLayer implements io.intino.magritte.framework.tags.Terminal {

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

		public static class MaxPool extends io.flogo.blatt.model.ConvolutionalSection.Block.Pool implements io.intino.magritte.framework.tags.Terminal {
			protected io.flogo.blatt.model.ConvolutionalSection.Block.MaxPool.Output output;

			public MaxPool(io.intino.magritte.framework.Node node) {
				super(node);
			}

			public io.flogo.blatt.model.ConvolutionalSection.Block.MaxPool.Output output() {
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
				if (node.is("ConvolutionalSection$Block$MaxPool$Output")) this.output = node.as(io.flogo.blatt.model.ConvolutionalSection.Block.MaxPool.Output.class);
			}

			@Override
			protected void removeNode$(io.intino.magritte.framework.Node node) {
				super.removeNode$(node);
				if (node.is("ConvolutionalSection$Block$MaxPool$Output")) this.output = null;
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

			public class Create extends io.flogo.blatt.model.ConvolutionalSection.Block.Pool.Create {


				public Create(java.lang.String name) {
					super(name);
				}

				public io.flogo.blatt.model.ConvolutionalSection.Block.MaxPool.Output output(int x, int y) {
					io.flogo.blatt.model.ConvolutionalSection.Block.MaxPool.Output newElement = core$().graph().concept(io.flogo.blatt.model.ConvolutionalSection.Block.MaxPool.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ConvolutionalSection.Block.MaxPool.Output.class);
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

		public static class AvgPool extends io.flogo.blatt.model.ConvolutionalSection.Block.Pool implements io.intino.magritte.framework.tags.Terminal {
			protected io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool.Output output;

			public AvgPool(io.intino.magritte.framework.Node node) {
				super(node);
			}

			public io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool.Output output() {
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
				if (node.is("ConvolutionalSection$Block$AvgPool$Output")) this.output = node.as(io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool.Output.class);
			}

			@Override
			protected void removeNode$(io.intino.magritte.framework.Node node) {
				super.removeNode$(node);
				if (node.is("ConvolutionalSection$Block$AvgPool$Output")) this.output = null;
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

			public class Create extends io.flogo.blatt.model.ConvolutionalSection.Block.Pool.Create {


				public Create(java.lang.String name) {
					super(name);
				}

				public io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool.Output output(int x, int y) {
					io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool.Output newElement = core$().graph().concept(io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool.Output.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ConvolutionalSection.Block.AvgPool.Output.class);
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

		public static class Normalization extends io.flogo.blatt.model.ConvolutionalSection.Block.ProcessingLayer implements io.intino.magritte.framework.tags.Terminal {
			protected double eps;
			protected double momentum;

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

			@Override
			protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
				java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>(super.variables$());
				map.put("eps", new java.util.ArrayList(java.util.Collections.singletonList(this.eps)));
				map.put("momentum", new java.util.ArrayList(java.util.Collections.singletonList(this.momentum)));
				return map;
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