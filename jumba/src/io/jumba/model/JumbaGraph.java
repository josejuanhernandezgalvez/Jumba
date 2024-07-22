package io.jumba.model;

import io.intino.magritte.framework.Graph;

public class JumbaGraph extends io.jumba.model.AbstractGraph {

	public JumbaGraph(Graph graph) {
		super(graph);
	}

	public JumbaGraph(io.intino.magritte.framework.Graph graph, JumbaGraph wrapper) {
	    super(graph, wrapper);
	}


	public static JumbaGraph load(io.intino.magritte.io.model.Stash... startingModel) {
		return new Graph().loadLanguage("Jumba", _language()).loadStashes(startingModel).as(JumbaGraph.class);
	}

	public static JumbaGraph load(io.intino.magritte.framework.Store store, io.intino.magritte.io.model.Stash... startingModel) {
		return new Graph(store).loadLanguage("Jumba", _language()).loadStashes(startingModel).as(JumbaGraph.class);
	}

	public static JumbaGraph load(String... startingModel) {
		return new Graph().loadLanguage("Jumba", _language()).loadStashes(startingModel).as(JumbaGraph.class);
	}

	public static JumbaGraph load(io.intino.magritte.framework.Store store, String... startingModel) {
		return new Graph(store).loadLanguage("Jumba", _language()).loadStashes(startingModel).as(JumbaGraph.class);
	}
}