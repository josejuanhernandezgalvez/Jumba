package io.flogo.blatt.model;

import io.flogo.blatt.model.*;

public class Tuning  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
	protected java.util.List<io.flogo.blatt.model.Tuning.Optimization> optimizationList = new java.util.ArrayList<>();

	public Tuning(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public java.util.List<io.flogo.blatt.model.Tuning.Optimization> optimizationList() {
		return java.util.Collections.unmodifiableList(optimizationList);
	}

	public io.flogo.blatt.model.Tuning.Optimization optimization(int index) {
		return optimizationList.get(index);
	}

	public java.util.List<io.flogo.blatt.model.Tuning.Optimization> optimizationList(java.util.function.Predicate<io.flogo.blatt.model.Tuning.Optimization> predicate) {
		return optimizationList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
	}

	public io.flogo.blatt.model.Tuning.Optimization optimization(java.util.function.Predicate<io.flogo.blatt.model.Tuning.Optimization> predicate) {
		return optimizationList().stream().filter(predicate).findFirst().orElse(null);
	}

	protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
		java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
		new java.util.ArrayList<>(optimizationList).forEach(c -> components.add(c.core$()));
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
		if (node.is("Tuning$Optimization")) this.optimizationList.add(node.as(io.flogo.blatt.model.Tuning.Optimization.class));
	}

	@Override
	protected void removeNode$(io.intino.magritte.framework.Node node) {
		super.removeNode$(node);
		if (node.is("Tuning$Optimization")) this.optimizationList.remove(node.as(io.flogo.blatt.model.Tuning.Optimization.class));
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

		public io.flogo.blatt.model.Tuning.Optimization optimization(java.util.List<io.flogo.blatt.model.NeuralNetwork> neuralNetworks) {
			io.flogo.blatt.model.Tuning.Optimization newElement = core$().graph().concept(io.flogo.blatt.model.Tuning.Optimization.class).createNode(this.name, core$()).as(io.flogo.blatt.model.Tuning.Optimization.class);
			newElement.core$().set(newElement, "neuralNetworks", neuralNetworks);
			return newElement;
		}

	}

	public Clear clear() {
		return new Clear();
	}

	public class Clear  {
		public void optimization(java.util.function.Predicate<io.flogo.blatt.model.Tuning.Optimization> filter) {
			new java.util.ArrayList<>(optimizationList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
		}
	}

	public static class Optimization  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
		protected java.util.List<io.flogo.blatt.model.NeuralNetwork> neuralNetworks = new java.util.ArrayList<>();

		public Optimization(io.intino.magritte.framework.Node node) {
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


	public io.flogo.blatt.model.BlattGraph graph() {
		return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
	}
}