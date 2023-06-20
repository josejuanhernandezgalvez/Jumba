package io.flogo.blatt.model;

import io.intino.magritte.framework.Graph;

public class AbstractGraph extends io.intino.magritte.framework.GraphWrapper {

	protected io.intino.magritte.framework.Graph graph;
	private java.util.List<io.flogo.blatt.model.Tuning> tuningList = new java.util.ArrayList<>();
	private java.util.List<io.flogo.blatt.model.ModulesManagement> modulesManagementList = new java.util.ArrayList<>();
	private java.util.List<io.flogo.blatt.model.Load> loadList = new java.util.ArrayList<>();
	private java.util.List<io.flogo.blatt.model.Save> saveList = new java.util.ArrayList<>();
	private java.util.List<io.flogo.blatt.model.Freeze> freezeList = new java.util.ArrayList<>();
	private java.util.List<io.flogo.blatt.model.NeuralNetwork> neuralNetworkList = new java.util.ArrayList<>();

	private java.util.Map<String, Indexer> _index = _fillIndex();

	public AbstractGraph(io.intino.magritte.framework.Graph graph) {
		this.graph = graph;
		this.graph.i18n().register("blatt");
	}

	public AbstractGraph(io.intino.magritte.framework.Graph graph, AbstractGraph wrapper) {
		this.graph = graph;
		this.graph.i18n().register("blatt");
		this.tuningList = new java.util.ArrayList<>(wrapper.tuningList);
		this.modulesManagementList = new java.util.ArrayList<>(wrapper.modulesManagementList);
		this.loadList = new java.util.ArrayList<>(wrapper.loadList);
		this.saveList = new java.util.ArrayList<>(wrapper.saveList);
		this.freezeList = new java.util.ArrayList<>(wrapper.freezeList);
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

	public java.util.List<io.flogo.blatt.model.Tuning> tuningList() {
		return tuningList;
	}

	public java.util.List<io.flogo.blatt.model.ModulesManagement> modulesManagementList() {
		return modulesManagementList;
	}

	public java.util.List<io.flogo.blatt.model.Load> loadList() {
		return loadList;
	}

	public java.util.List<io.flogo.blatt.model.Save> saveList() {
		return saveList;
	}

	public java.util.List<io.flogo.blatt.model.Freeze> freezeList() {
		return freezeList;
	}

	public java.util.List<io.flogo.blatt.model.NeuralNetwork> neuralNetworkList() {
		return neuralNetworkList;
	}

	public java.util.stream.Stream<io.flogo.blatt.model.Tuning> tuningList(java.util.function.Predicate<io.flogo.blatt.model.Tuning> filter) {
		return tuningList.stream().filter(filter);
	}

	public io.flogo.blatt.model.Tuning tuning(int index) {
		return tuningList.get(index);
	}

	public java.util.stream.Stream<io.flogo.blatt.model.ModulesManagement> modulesManagementList(java.util.function.Predicate<io.flogo.blatt.model.ModulesManagement> filter) {
		return modulesManagementList.stream().filter(filter);
	}

	public io.flogo.blatt.model.ModulesManagement modulesManagement(int index) {
		return modulesManagementList.get(index);
	}

	public java.util.stream.Stream<io.flogo.blatt.model.Load> loadList(java.util.function.Predicate<io.flogo.blatt.model.Load> filter) {
		return loadList.stream().filter(filter);
	}

	public io.flogo.blatt.model.Load load(int index) {
		return loadList.get(index);
	}

	public java.util.stream.Stream<io.flogo.blatt.model.Save> saveList(java.util.function.Predicate<io.flogo.blatt.model.Save> filter) {
		return saveList.stream().filter(filter);
	}

	public io.flogo.blatt.model.Save save(int index) {
		return saveList.get(index);
	}

	public java.util.stream.Stream<io.flogo.blatt.model.Freeze> freezeList(java.util.function.Predicate<io.flogo.blatt.model.Freeze> filter) {
		return freezeList.stream().filter(filter);
	}

	public io.flogo.blatt.model.Freeze freeze(int index) {
		return freezeList.get(index);
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

		public io.flogo.blatt.model.Tuning tuning() {
			io.flogo.blatt.model.Tuning newElement = AbstractGraph.this.graph.createRoot(io.flogo.blatt.model.Tuning.class, stash, this.name).a$(io.flogo.blatt.model.Tuning.class);
			return newElement;
		}

		public io.flogo.blatt.model.Load load(java.lang.String path) {
			io.flogo.blatt.model.Load newElement = AbstractGraph.this.graph.createRoot(io.flogo.blatt.model.Load.class, stash, this.name).a$(io.flogo.blatt.model.Load.class);
			newElement.core$().set(newElement, "path", java.util.Collections.singletonList(path));
			return newElement;
		}

		public io.flogo.blatt.model.Save save(java.lang.String path, io.flogo.blatt.model.Section section) {
			io.flogo.blatt.model.Save newElement = AbstractGraph.this.graph.createRoot(io.flogo.blatt.model.Save.class, stash, this.name).a$(io.flogo.blatt.model.Save.class);
			newElement.core$().set(newElement, "path", java.util.Collections.singletonList(path));
			newElement.core$().set(newElement, "section", java.util.Collections.singletonList(section));
			return newElement;
		}

		public io.flogo.blatt.model.Freeze freeze(io.flogo.blatt.model.Section section) {
			io.flogo.blatt.model.Freeze newElement = AbstractGraph.this.graph.createRoot(io.flogo.blatt.model.Freeze.class, stash, this.name).a$(io.flogo.blatt.model.Freeze.class);
			newElement.core$().set(newElement, "section", java.util.Collections.singletonList(section));
			return newElement;
		}

		public io.flogo.blatt.model.NeuralNetwork neuralNetwork() {
			io.flogo.blatt.model.NeuralNetwork newElement = AbstractGraph.this.graph.createRoot(io.flogo.blatt.model.NeuralNetwork.class, stash, this.name).a$(io.flogo.blatt.model.NeuralNetwork.class);
			return newElement;
		}
	}

	public class Clear {
	    public void tuning(java.util.function.Predicate<io.flogo.blatt.model.Tuning> filter) {
	    	new java.util.ArrayList<>(AbstractGraph.this.tuningList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
	    }

	    public void load(java.util.function.Predicate<io.flogo.blatt.model.Load> filter) {
	    	new java.util.ArrayList<>(AbstractGraph.this.loadList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
	    }

	    public void save(java.util.function.Predicate<io.flogo.blatt.model.Save> filter) {
	    	new java.util.ArrayList<>(AbstractGraph.this.saveList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
	    }

	    public void freeze(java.util.function.Predicate<io.flogo.blatt.model.Freeze> filter) {
	    	new java.util.ArrayList<>(AbstractGraph.this.freezeList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
	    }

	    public void neuralNetwork(java.util.function.Predicate<io.flogo.blatt.model.NeuralNetwork> filter) {
	    	new java.util.ArrayList<>(AbstractGraph.this.neuralNetworkList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
	    }
	}


	private java.util.HashMap<String, Indexer> _fillIndex() {
		java.util.HashMap<String, Indexer> map = new java.util.HashMap<>();
		map.put("Tuning", new Indexer(node -> tuningList.add(node.as(io.flogo.blatt.model.Tuning.class)), node -> tuningList.remove(node.as(io.flogo.blatt.model.Tuning.class)), () -> tuningList.clear()));
		map.put("ModulesManagement", new Indexer(node -> modulesManagementList.add(node.as(io.flogo.blatt.model.ModulesManagement.class)), node -> modulesManagementList.remove(node.as(io.flogo.blatt.model.ModulesManagement.class)), () -> modulesManagementList.clear()));
		map.put("Load", new Indexer(node -> loadList.add(node.as(io.flogo.blatt.model.Load.class)), node -> loadList.remove(node.as(io.flogo.blatt.model.Load.class)), () -> loadList.clear()));
		map.put("Save", new Indexer(node -> saveList.add(node.as(io.flogo.blatt.model.Save.class)), node -> saveList.remove(node.as(io.flogo.blatt.model.Save.class)), () -> saveList.clear()));
		map.put("Freeze", new Indexer(node -> freezeList.add(node.as(io.flogo.blatt.model.Freeze.class)), node -> freezeList.remove(node.as(io.flogo.blatt.model.Freeze.class)), () -> freezeList.clear()));
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