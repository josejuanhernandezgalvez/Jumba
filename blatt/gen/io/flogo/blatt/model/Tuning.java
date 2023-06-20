package io.flogo.blatt.model;

import io.flogo.blatt.model.*;

public class Tuning  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
	protected io.flogo.blatt.model.Tuning.Optimize optimize;
	protected java.util.List<io.flogo.blatt.model.Tuning.BestOptimizer> bestOptimizerList = new java.util.ArrayList<>();
	protected java.util.List<io.flogo.blatt.model.Tuning.BestLossFunction> bestLossFunctionList = new java.util.ArrayList<>();

	public Tuning(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public io.flogo.blatt.model.Tuning.Optimize optimize() {
		return optimize;
	}

	public java.util.List<io.flogo.blatt.model.Tuning.BestOptimizer> bestOptimizerList() {
		return java.util.Collections.unmodifiableList(bestOptimizerList);
	}

	public io.flogo.blatt.model.Tuning.BestOptimizer bestOptimizer(int index) {
		return bestOptimizerList.get(index);
	}

	public java.util.List<io.flogo.blatt.model.Tuning.BestOptimizer> bestOptimizerList(java.util.function.Predicate<io.flogo.blatt.model.Tuning.BestOptimizer> predicate) {
		return bestOptimizerList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
	}

	public io.flogo.blatt.model.Tuning.BestOptimizer bestOptimizer(java.util.function.Predicate<io.flogo.blatt.model.Tuning.BestOptimizer> predicate) {
		return bestOptimizerList().stream().filter(predicate).findFirst().orElse(null);
	}

	public java.util.List<io.flogo.blatt.model.Tuning.BestLossFunction> bestLossFunctionList() {
		return java.util.Collections.unmodifiableList(bestLossFunctionList);
	}

	public io.flogo.blatt.model.Tuning.BestLossFunction bestLossFunction(int index) {
		return bestLossFunctionList.get(index);
	}

	public java.util.List<io.flogo.blatt.model.Tuning.BestLossFunction> bestLossFunctionList(java.util.function.Predicate<io.flogo.blatt.model.Tuning.BestLossFunction> predicate) {
		return bestLossFunctionList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
	}

	public io.flogo.blatt.model.Tuning.BestLossFunction bestLossFunction(java.util.function.Predicate<io.flogo.blatt.model.Tuning.BestLossFunction> predicate) {
		return bestLossFunctionList().stream().filter(predicate).findFirst().orElse(null);
	}

	protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
		java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
		if (optimize != null) components.add(this.optimize.core$());
		new java.util.ArrayList<>(bestOptimizerList).forEach(c -> components.add(c.core$()));
		new java.util.ArrayList<>(bestLossFunctionList).forEach(c -> components.add(c.core$()));
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
		if (node.is("Tuning$Optimize")) this.optimize = node.as(io.flogo.blatt.model.Tuning.Optimize.class);
		if (node.is("Tuning$BestOptimizer")) this.bestOptimizerList.add(node.as(io.flogo.blatt.model.Tuning.BestOptimizer.class));
		if (node.is("Tuning$BestLossFunction")) this.bestLossFunctionList.add(node.as(io.flogo.blatt.model.Tuning.BestLossFunction.class));
	}

	@Override
	protected void removeNode$(io.intino.magritte.framework.Node node) {
		super.removeNode$(node);
		if (node.is("Tuning$Optimize")) this.optimize = null;
		if (node.is("Tuning$BestOptimizer")) this.bestOptimizerList.remove(node.as(io.flogo.blatt.model.Tuning.BestOptimizer.class));
		if (node.is("Tuning$BestLossFunction")) this.bestLossFunctionList.remove(node.as(io.flogo.blatt.model.Tuning.BestLossFunction.class));
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

		public io.flogo.blatt.model.Tuning.Optimize optimize(java.util.List<io.flogo.blatt.model.NeuralNetwork> neuralNetworks) {
			io.flogo.blatt.model.Tuning.Optimize newElement = core$().graph().concept(io.flogo.blatt.model.Tuning.Optimize.class).createNode(this.name, core$()).as(io.flogo.blatt.model.Tuning.Optimize.class);
			newElement.core$().set(newElement, "neuralNetworks", neuralNetworks);
			return newElement;
		}

		public io.flogo.blatt.model.Tuning.BestOptimizer bestOptimizer(io.flogo.blatt.model.NeuralNetwork neuralNetwork) {
			io.flogo.blatt.model.Tuning.BestOptimizer newElement = core$().graph().concept(io.flogo.blatt.model.Tuning.BestOptimizer.class).createNode(this.name, core$()).as(io.flogo.blatt.model.Tuning.BestOptimizer.class);
			newElement.core$().set(newElement, "neuralNetwork", java.util.Collections.singletonList(neuralNetwork));
			return newElement;
		}

		public io.flogo.blatt.model.Tuning.BestLossFunction bestLossFunction(io.flogo.blatt.model.NeuralNetwork neuralNetwork) {
			io.flogo.blatt.model.Tuning.BestLossFunction newElement = core$().graph().concept(io.flogo.blatt.model.Tuning.BestLossFunction.class).createNode(this.name, core$()).as(io.flogo.blatt.model.Tuning.BestLossFunction.class);
			newElement.core$().set(newElement, "neuralNetwork", java.util.Collections.singletonList(neuralNetwork));
			return newElement;
		}

	}

	public Clear clear() {
		return new Clear();
	}

	public class Clear  {
		public void bestOptimizer(java.util.function.Predicate<io.flogo.blatt.model.Tuning.BestOptimizer> filter) {
			new java.util.ArrayList<>(bestOptimizerList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
		}

		public void bestLossFunction(java.util.function.Predicate<io.flogo.blatt.model.Tuning.BestLossFunction> filter) {
			new java.util.ArrayList<>(bestLossFunctionList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
		}
	}

	public static class Optimize  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
		protected java.util.List<io.flogo.blatt.model.NeuralNetwork> neuralNetworks = new java.util.ArrayList<>();

		public Optimize(io.intino.magritte.framework.Node node) {
			super(node);
		}

		public java.util.List<io.flogo.blatt.model.NeuralNetwork> neuralNetworks() {
			return neuralNetworks;
		}

		public io.flogo.blatt.model.NeuralNetwork neuralNetworks(int index) {
			return neuralNetworks.get(index);
		}

		public java.util.List<io.flogo.blatt.model.NeuralNetwork> neuralNetworks(java.util.function.Predicate<io.flogo.blatt.model.NeuralNetwork> predicate) {
			return neuralNetworks().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
		}

		@Override
		protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
			java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
			map.put("neuralNetworks", this.neuralNetworks);
			return map;
		}

		@Override
		protected void load$(java.lang.String name, java.util.List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("neuralNetworks")) this.neuralNetworks = io.intino.magritte.framework.loaders.NodeLoader.load(values,  io.flogo.blatt.model.NeuralNetwork.class, this);
		}

		@Override
		protected void set$(java.lang.String name, java.util.List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("neuralNetworks")) this.neuralNetworks = ((java.util.List<java.lang.Object>) values).stream().
				map(s -> graph().core$().load(((io.intino.magritte.framework.Layer) s).core$().id()).as(io.flogo.blatt.model.NeuralNetwork.class)).collect(java.util.stream.Collectors.toList());
		}

		public io.flogo.blatt.model.BlattGraph graph() {
			return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
		}
	}

	public static class BestOptimizer  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
		protected io.flogo.blatt.model.NeuralNetwork neuralNetwork;

		public BestOptimizer(io.intino.magritte.framework.Node node) {
			super(node);
		}

		public io.flogo.blatt.model.NeuralNetwork neuralNetwork() {
			return neuralNetwork;
		}

		public BestOptimizer neuralNetwork(io.flogo.blatt.model.NeuralNetwork value) {
			this.neuralNetwork = value;
			return (BestOptimizer) this;
		}

		@Override
		protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
			java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
			map.put("neuralNetwork", this.neuralNetwork != null ? new java.util.ArrayList(java.util.Collections.singletonList(this.neuralNetwork)) : java.util.Collections.emptyList());
			return map;
		}

		@Override
		protected void load$(java.lang.String name, java.util.List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("neuralNetwork")) this.neuralNetwork = io.intino.magritte.framework.loaders.NodeLoader.load(values, io.flogo.blatt.model.NeuralNetwork.class, this).get(0);
		}

		@Override
		protected void set$(java.lang.String name, java.util.List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("neuralNetwork")) this.neuralNetwork = values.get(0)!= null ? core$().graph().load(((io.intino.magritte.framework.Layer) values.get(0)).core$().id()).as(io.flogo.blatt.model.NeuralNetwork.class) : null;
		}

		public io.flogo.blatt.model.BlattGraph graph() {
			return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
		}
	}

	public static class BestLossFunction  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
		protected io.flogo.blatt.model.NeuralNetwork neuralNetwork;

		public BestLossFunction(io.intino.magritte.framework.Node node) {
			super(node);
		}

		public io.flogo.blatt.model.NeuralNetwork neuralNetwork() {
			return neuralNetwork;
		}

		public BestLossFunction neuralNetwork(io.flogo.blatt.model.NeuralNetwork value) {
			this.neuralNetwork = value;
			return (BestLossFunction) this;
		}

		@Override
		protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
			java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
			map.put("neuralNetwork", this.neuralNetwork != null ? new java.util.ArrayList(java.util.Collections.singletonList(this.neuralNetwork)) : java.util.Collections.emptyList());
			return map;
		}

		@Override
		protected void load$(java.lang.String name, java.util.List<?> values) {
			super.load$(name, values);
			if (name.equalsIgnoreCase("neuralNetwork")) this.neuralNetwork = io.intino.magritte.framework.loaders.NodeLoader.load(values, io.flogo.blatt.model.NeuralNetwork.class, this).get(0);
		}

		@Override
		protected void set$(java.lang.String name, java.util.List<?> values) {
			super.set$(name, values);
			if (name.equalsIgnoreCase("neuralNetwork")) this.neuralNetwork = values.get(0)!= null ? core$().graph().load(((io.intino.magritte.framework.Layer) values.get(0)).core$().id()).as(io.flogo.blatt.model.NeuralNetwork.class) : null;
		}

		public io.flogo.blatt.model.BlattGraph graph() {
			return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
		}
	}


	public io.flogo.blatt.model.BlattGraph graph() {
		return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
	}
}