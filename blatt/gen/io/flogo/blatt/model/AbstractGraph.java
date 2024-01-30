package io.flogo.blatt.model;

import io.intino.magritte.framework.Graph;

public class AbstractGraph extends io.intino.magritte.framework.GraphWrapper {
	protected io.intino.magritte.framework.Graph graph;
	private java.util.List<io.flogo.blatt.model.NeuralNetwork> neuralNetworkList = new java.util.ArrayList<>();
	private java.util.List<io.flogo.blatt.model.Tuning> tuningList = new java.util.ArrayList<>();
	private java.util.List<io.flogo.blatt.model.ModulesManagement> modulesManagementList = new java.util.ArrayList<>();
	private java.util.List<io.flogo.blatt.model.Load> loadList = new java.util.ArrayList<>();
	private java.util.List<io.flogo.blatt.model.Save> saveList = new java.util.ArrayList<>();
	private java.util.List<io.flogo.blatt.model.Freeze> freezeList = new java.util.ArrayList<>();

	private java.util.Map<String, Indexer> _index = _fillIndex();

	public AbstractGraph(io.intino.magritte.framework.Graph graph) {
		this.graph = graph;
		this.graph.i18n().register("blatt");
	}

	public AbstractGraph(io.intino.magritte.framework.Graph graph, AbstractGraph wrapper) {
		this.graph = graph;
		this.graph.i18n().register("blatt");
		this.neuralNetworkList = new java.util.ArrayList<>(wrapper.neuralNetworkList);
		this.tuningList = new java.util.ArrayList<>(wrapper.tuningList);
		this.modulesManagementList = new java.util.ArrayList<>(wrapper.modulesManagementList);
		this.loadList = new java.util.ArrayList<>(wrapper.loadList);
		this.saveList = new java.util.ArrayList<>(wrapper.saveList);
		this.freezeList = new java.util.ArrayList<>(wrapper.freezeList);
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

	public java.util.stream.Stream<io.flogo.blatt.model.NeuralNetwork> neuralNetworkList(java.util.function.Predicate<io.flogo.blatt.model.NeuralNetwork> filter) {
		return neuralNetworkList.stream().filter(filter);
	}

	public io.flogo.blatt.model.NeuralNetwork neuralNetwork(int index) {
		return neuralNetworkList.get(index);
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
	}

	public class Clear {
	    public void neuralNetwork(java.util.function.Predicate<io.flogo.blatt.model.NeuralNetwork> filter) {
	    	new java.util.ArrayList<>(AbstractGraph.this.neuralNetworkList()).stream().filter(filter).forEach(io.intino.magritte.framework.Layer::delete$);
	    }

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
	}


	private java.util.HashMap<String, Indexer> _fillIndex() {
		java.util.HashMap<String, Indexer> map = new java.util.HashMap<>();
		map.put("NeuralNetwork", new Indexer(node -> neuralNetworkList.add(node.as(io.flogo.blatt.model.NeuralNetwork.class)), node -> neuralNetworkList.remove(node.as(io.flogo.blatt.model.NeuralNetwork.class)), () -> neuralNetworkList.clear()));
		map.put("Tuning", new Indexer(node -> tuningList.add(node.as(io.flogo.blatt.model.Tuning.class)), node -> tuningList.remove(node.as(io.flogo.blatt.model.Tuning.class)), () -> tuningList.clear()));
		map.put("ModulesManagement", new Indexer(node -> modulesManagementList.add(node.as(io.flogo.blatt.model.ModulesManagement.class)), node -> modulesManagementList.remove(node.as(io.flogo.blatt.model.ModulesManagement.class)), () -> modulesManagementList.clear()));
		map.put("Load", new Indexer(node -> loadList.add(node.as(io.flogo.blatt.model.Load.class)), node -> loadList.remove(node.as(io.flogo.blatt.model.Load.class)), () -> loadList.clear()));
		map.put("Save", new Indexer(node -> saveList.add(node.as(io.flogo.blatt.model.Save.class)), node -> saveList.remove(node.as(io.flogo.blatt.model.Save.class)), () -> saveList.clear()));
		map.put("Freeze", new Indexer(node -> freezeList.add(node.as(io.flogo.blatt.model.Freeze.class)), node -> freezeList.remove(node.as(io.flogo.blatt.model.Freeze.class)), () -> freezeList.clear()));
		return map;
	}

	public static io.intino.magritte.io.Stash[] _language() {
		return new io.intino.magritte.io.Stash[]{stash()};
	}

	private static io.intino.magritte.io.Stash stash() {
		String content = "gAK9Ws1v3EQUH284IVn8E3vePwFEKVkhbdKqG7hPNtONtV7PyjsOpKdoiwRXuNFrv1TCR4EWUUAIIXHkyB+ASNRKLSDCHnoieGa8tmfm2TN2aXqpd97z7/3mvfl478UH/k+ehwLaCyIWRLQ3xeM4YIz00qHXaDQisyW6nj5fDumY9rZDzFhvSndI2NskSYzDTcLepvHEX3heHQjrpv8zEi3Rv6enpy91hmTEAvonQh4q4zz2Pd878DuZZZ9jmpazl/2UOEL5D4cXB0E0UV5WBnxv9VjA3ABxhvQym+J3pHrkcySkjAm0MrgNcZ0/k0hBVMZqEG+DiBdjOiLzeRCNc1COgAKqD1fM+2MQMxXv0TDhaDhcwV5NcTsIEnXfiGbJUgYclJ8L6egxnyogFcRMtgXFu84UBQ8mnVopX+orqAE+n8fE/zB1hGWyk+4A75MTqXVYo/Zq+mMP8wH+QmyF3cLRI6l0vUZrGIynNNiRirdqFAd0rOjWqF4ig1+tSsPXHZT6LkrDwEGp76CTG7tZozQgeLKfzvBNK9xGMM8CUBfWYj2Xwnqn5gVFZCVxkdIndsxNGk9xGFwRy6tyT3Bd4zj+uuGeEMs9liePRetEt/UjfIbXwGibRpqtC4fxgu/VaEuWBcH7Tfmlm3S35hTKlR5xIk14F5y+acop2+aSlsPZ0Z7agAJ3TakVh5Bk53ZgtSfYOJ78YLDGk5+PZ8gpPWntnPhxfIac+i6c+Ol/hpzSe8TOiV827Tnda8qp70Cpf6aMXAL3LHFbeJ0ArBrewnGAt0OSpmaMjMkJwuFs9zd/0UGdb5tOIr/E5VSc7vtnmVGJa+NlmaYR9iuC5xqtCba4V7WsxX6vGi80uld/aMpPEfFKFHU6d131uxcSllYH3OV1SZNqw+J8ff7F3H5u7HyIrFwhTaeoJ1iNF2eaXq7ce9uiVvJqveaT1r5ceGuWs2PI4iB6iNj+7NhfrKEN/PT7NlNWnO44cd3Xjde0kqQ7rGlF33FNqzbaxuGq94IlDudpsh0egAIjMvvHX7yI/t79/f37T49entIpiVjyBx+79hH/9+CV5tsDmrd9e8BvqSGDu16DICI4ztCy3ocyVm56qAJuWnQ7ysPWNscdO41yf8MULPWJuSAKN/kf5B0NQFpuZdyA5GAPA1IsWgiQNC/UIWHRWICkRUcBkhatBEia9xAg4SpPqFNZVSRH1TpWhaKtA0mLngPof7DZACmKsSySkPx8TGc0WZrLi4uNHsHnrsur3ByoEhtdgQfO6HoGJOyAjjI0RafVUNPzlM+cqRTJZ4VUZNBO3Arznzqbz7N4WNjCuJrlujuiqE4rpC24NIhDUYhWSJ+v+aLmrJC2Me++DPLyEha2gAIx/pWzca0Iq1NpQURdj/fcWWktplqdo+a8vC+cqVh5tCfhvkKLDmWFVNSdz818Uf1WSNuYd78x9BSXZ93iVkSHDupZGll5y+jojrdMRbkOvQoTkg5tMAP9yoX/EAbhybF2fquKuhgTaYCTV9tsPZnfsP+Xd5Y0tSB+EyR+icyDnSQvZLLSQxstFx+6iJsV5YcqsBYghy50yiUIJBJ+KC8qN1ThqlJcQLkMhEhPIbmeoPK7IiYzgpfisvjSnYiyoWo0jMneqrAxSuI4rYFXIX03C6k6XIqpKZP2KoRb+7NjSVURWCP+iRNdNeSAzHADnKoY76pehoQGctVqMh1CKnC5xQGvjIWylveOBsOtX0AbW0kURA9l6Drix7h7YcaCaXDlWO7DbPAcmbNMsKqaS5IBnc/Xk0hEgn8Uk8Fq04RPBtVqNkGNio4Ef98BUI0VOGUSOiYcXniS2ScusND4mAf+wmWD7iQhmW/gCI8J7yXxEs9D+rCxWECwAcVHnJOH5JPvmTgWiCHeO5YQ8qkFxHpMCA8WB1k918P47+WHo/IhlRySy0g+GyhymE9XPnHW8kmaTo8IRv7yvSGLkxFLYtKbM8xTsIP/AAA=";
		return io.intino.magritte.io.StashDeserializer.stashFrom(java.util.Base64.getDecoder().decode(content));
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