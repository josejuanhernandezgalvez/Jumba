package io.flogo.model;

import io.intino.magritte.framework.Graph;

public class FlogoGraph extends io.flogo.model.AbstractGraph {

	public FlogoGraph(Graph graph) {
		super(graph);
	}

	public FlogoGraph(io.intino.magritte.framework.Graph graph, FlogoGraph wrapper) {
	    super(graph, wrapper);
	}


	public static FlogoGraph load(io.intino.magritte.io.model.Stash... startingModel) {
		return new Graph().loadLanguage("Flogo", _language()).loadStashes(startingModel).as(FlogoGraph.class);
	}

	public static FlogoGraph load(io.intino.magritte.framework.Store store, io.intino.magritte.io.model.Stash... startingModel) {
		return new Graph(store).loadLanguage("Flogo", _language()).loadStashes(startingModel).as(FlogoGraph.class);
	}

	public static FlogoGraph load(String... startingModel) {
		return new Graph().loadLanguage("Flogo", _language()).loadStashes(startingModel).as(FlogoGraph.class);
	}

	public static FlogoGraph load(io.intino.magritte.framework.Store store, String... startingModel) {
		return new Graph(store).loadLanguage("Flogo", _language()).loadStashes(startingModel).as(FlogoGraph.class);
	}
}