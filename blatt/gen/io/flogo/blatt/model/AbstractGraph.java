package io.flogo.blatt.model;

import io.intino.magritte.framework.Graph;

public class AbstractGraph extends io.intino.magritte.framework.GraphWrapper {

	protected io.intino.magritte.framework.Graph graph;
	private java.util.List<io.flogo.blatt.model.NeuralNetwork> neuralNetworkList = new java.util.ArrayList<>();

	private java.util.Map<String, Indexer> _index = _fillIndex();

	public AbstractGraph(io.intino.magritte.framework.Graph graph) {
		this.graph = graph;
		this.graph.i18n().register("blatt");
	}

	public AbstractGraph(io.intino.magritte.framework.Graph graph, AbstractGraph wrapper) {
		this.graph = graph;
		this.graph.i18n().register("blatt");
		this.neuralNetworkList = new java.util.ArrayList<>(wrapper.neuralNetworkList);
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

	public java.util.List<io.flogo.blatt.model.NeuralNetwork> neuralNetworkList() {
		return neuralNetworkList;
	}

	public java.util.stream.Stream<io.flogo.blatt.model.NeuralNetwork> neuralNetworkList(java.util.function.Predicate<io.flogo.blatt.model.NeuralNetwork> filter) {
		return neuralNetworkList.stream().filter(filter);
	}

	public io.flogo.blatt.model.NeuralNetwork neuralNetwork(int index) {
		return neuralNetworkList.get(index);
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

		public io.flogo.blatt.model.NeuralNetwork neuralNetwork() {
			io.flogo.blatt.model.NeuralNetwork newElement = AbstractGraph.this.graph.createRoot(io.flogo.blatt.model.NeuralNetwork.class, stash, this.name).a$(io.flogo.blatt.model.NeuralNetwork.class);
			return newElement;
		}
	}

	public class Clear {
	    public void neuralNetwork(java.util.function.Predicate<io.flogo.blatt.model.NeuralNetwork> filter) {
	    	new java.util.ArrayList<>(AbstractGraph.this.neuralNetworkList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
	    }
	}


	private java.util.HashMap<String, Indexer> _fillIndex() {
		java.util.HashMap<String, Indexer> map = new java.util.HashMap<>();
		map.put("NeuralNetwork", new Indexer(node -> neuralNetworkList.add(node.as(io.flogo.blatt.model.NeuralNetwork.class)), node -> neuralNetworkList.remove(node.as(io.flogo.blatt.model.NeuralNetwork.class)), () -> neuralNetworkList.clear()));
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