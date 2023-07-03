package io.flogo.blatt.model;

import io.intino.magritte.framework.Graph;

public class AbstractGraph extends io.intino.magritte.framework.GraphWrapper {

	protected io.intino.magritte.framework.Graph graph;
	private java.util.List<io.flogo.blatt.model.Training> trainingList = new java.util.ArrayList<>();
	private java.util.List<io.flogo.blatt.model.NeuralNetwork> neuralNetworkList = new java.util.ArrayList<>();
	private java.util.List<io.flogo.blatt.model.Save> saveList = new java.util.ArrayList<>();

	private java.util.Map<String, Indexer> _index = _fillIndex();

	public AbstractGraph(io.intino.magritte.framework.Graph graph) {
		this.graph = graph;
		this.graph.i18n().register("blatt");
	}

	public AbstractGraph(io.intino.magritte.framework.Graph graph, AbstractGraph wrapper) {
		this.graph = graph;
		this.graph.i18n().register("blatt");
		this.trainingList = new java.util.ArrayList<>(wrapper.trainingList);
		this.neuralNetworkList = new java.util.ArrayList<>(wrapper.neuralNetworkList);
		this.saveList = new java.util.ArrayList<>(wrapper.saveList);
	}

	public <T extends io.intino.magritte.framework.GraphWrapper> T a$(Class<T> t) {
		return this.core$().as(t);
	}

    @Override
	public void update() {
		this._index.values().forEach(v -> v.clear());
		graph.rootList().forEach(r -> addNode$(r));
	}

	@Override
	protected void addNode$(io.intino.magritte.framework.Node node) {
		for (io.intino.magritte.framework.Concept c : node.conceptList()) if (this._index.containsKey(c.id())) this._index.get(c.id()).add(node);
		if (this._index.containsKey(node.id())) this._index.get(node.id()).add(node);
	}

	@Override
	protected void removeNode$(io.intino.magritte.framework.Node node) {
		for (io.intino.magritte.framework.Concept c : node.conceptList()) if (this._index.containsKey(c.id())) this._index.get(c.id()).remove(node);
		if (this._index.containsKey(node.id())) this._index.get(node.id()).remove(node);
	}

	public java.net.URL resourceAsMessage$(String language, String key) {
		return graph.loadResource(graph.i18n().message(language, key));
	}

	public java.util.List<io.flogo.blatt.model.Training> trainingList() {
		return trainingList;
	}

	public java.util.List<io.flogo.blatt.model.NeuralNetwork> neuralNetworkList() {
		return neuralNetworkList;
	}

	public java.util.List<io.flogo.blatt.model.Save> saveList() {
		return saveList;
	}

	public java.util.stream.Stream<io.flogo.blatt.model.Training> trainingList(java.util.function.Predicate<io.flogo.blatt.model.Training> filter) {
		return trainingList.stream().filter(filter);
	}

	public io.flogo.blatt.model.Training training(int index) {
		return trainingList.get(index);
	}

	public java.util.stream.Stream<io.flogo.blatt.model.NeuralNetwork> neuralNetworkList(java.util.function.Predicate<io.flogo.blatt.model.NeuralNetwork> filter) {
		return neuralNetworkList.stream().filter(filter);
	}

	public io.flogo.blatt.model.NeuralNetwork neuralNetwork(int index) {
		return neuralNetworkList.get(index);
	}

	public java.util.stream.Stream<io.flogo.blatt.model.Save> saveList(java.util.function.Predicate<io.flogo.blatt.model.Save> filter) {
		return saveList.stream().filter(filter);
	}

	public io.flogo.blatt.model.Save save(int index) {
		return saveList.get(index);
	}

	public io.intino.magritte.framework.Graph core$() {
		return graph;
	}

	public io.intino.magritte.framework.utils.I18n i18n$() {
		return graph.i18n();
	}

	public Create create() {
		return new Create("Misc", null);
	}

	public Create create(String stash) {
		return new Create(stash, null);
	}

	public Create create(String stash, String name) {
		return new Create(stash, name);
	}

	public Clear clear() {
		return new Clear();
	}

	public class Create {
		private final String stash;
		private final String name;

		public Create(String stash, String name) {
			this.stash = stash;
			this.name = name;
		}

		public io.flogo.blatt.model.Training training() {
			io.flogo.blatt.model.Training newElement = AbstractGraph.this.graph.createRoot(io.flogo.blatt.model.Training.class, stash, this.name).a$(io.flogo.blatt.model.Training.class);
			return newElement;
		}

		public io.flogo.blatt.model.NeuralNetwork neuralNetwork() {
			io.flogo.blatt.model.NeuralNetwork newElement = AbstractGraph.this.graph.createRoot(io.flogo.blatt.model.NeuralNetwork.class, stash, this.name).a$(io.flogo.blatt.model.NeuralNetwork.class);
			return newElement;
		}

		public io.flogo.blatt.model.Save save(java.lang.String path) {
			io.flogo.blatt.model.Save newElement = AbstractGraph.this.graph.createRoot(io.flogo.blatt.model.Save.class, stash, this.name).a$(io.flogo.blatt.model.Save.class);
			newElement.core$().set(newElement, "path", java.util.Collections.singletonList(path));
			return newElement;
		}
	}

	public class Clear {
	    public void training(java.util.function.Predicate<io.flogo.blatt.model.Training> filter) {
	    	new java.util.ArrayList<>(AbstractGraph.this.trainingList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
	    }

	    public void neuralNetwork(java.util.function.Predicate<io.flogo.blatt.model.NeuralNetwork> filter) {
	    	new java.util.ArrayList<>(AbstractGraph.this.neuralNetworkList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
	    }

	    public void save(java.util.function.Predicate<io.flogo.blatt.model.Save> filter) {
	    	new java.util.ArrayList<>(AbstractGraph.this.saveList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
	    }
	}


	private java.util.HashMap<String, Indexer> _fillIndex() {
		java.util.HashMap<String, Indexer> map = new java.util.HashMap<>();
		map.put("Training", new Indexer(node -> trainingList.add(node.as(io.flogo.blatt.model.Training.class)), node -> trainingList.remove(node.as(io.flogo.blatt.model.Training.class)), () -> trainingList.clear()));
		map.put("NeuralNetwork", new Indexer(node -> neuralNetworkList.add(node.as(io.flogo.blatt.model.NeuralNetwork.class)), node -> neuralNetworkList.remove(node.as(io.flogo.blatt.model.NeuralNetwork.class)), () -> neuralNetworkList.clear()));
		map.put("Save", new Indexer(node -> saveList.add(node.as(io.flogo.blatt.model.Save.class)), node -> saveList.remove(node.as(io.flogo.blatt.model.Save.class)), () -> saveList.clear()));
		return map;
	}

	public static class Indexer {
		Add add;
		Remove remove;
		IndexClear clear;

		public Indexer(Add add, Remove remove, IndexClear clear) {
			this.add = add;
			this.remove = remove;
			this.clear = clear;
		}

		void add(io.intino.magritte.framework.Node node) {
			this.add.add(node);
		}

		void remove(io.intino.magritte.framework.Node node) {
			this.remove.remove(node);
		}

		void clear() {
			this.clear.clear();
		}
	}

	interface Add {
		void add(io.intino.magritte.framework.Node node);
	}

	interface Remove {
		void remove(io.intino.magritte.framework.Node node);
	}

	interface IndexClear {
		void clear();
	}
}