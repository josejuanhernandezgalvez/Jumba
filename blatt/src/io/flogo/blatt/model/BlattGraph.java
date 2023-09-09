package io.flogo.blatt.model;

import io.intino.magritte.framework.Graph;

public class BlattGraph extends io.flogo.blatt.model.AbstractGraph {

	public BlattGraph(Graph graph) {
		super(graph);
	}

	public BlattGraph(io.intino.magritte.framework.Graph graph, BlattGraph wrapper) {
	    super(graph, wrapper);
	}
}