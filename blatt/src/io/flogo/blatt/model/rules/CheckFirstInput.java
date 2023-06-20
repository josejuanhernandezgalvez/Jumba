package io.flogo.blatt.model.rules;

import io.intino.magritte.lang.model.Node;
import io.intino.magritte.lang.model.rules.NodeRule;

public class CheckFirstInput implements NodeRule {


	public boolean accept(Node node) {
		return index(node.container(), node) == 0 ? checkIfHasInput(node) : !checkIfHasInput(node);
	}

	private boolean checkIfHasInput(Node node) {
		return node.components().stream().anyMatch(c -> c.type().equals("Input"));

	}

	private int index(Node container, Node node) {
		return 0;//TODO
	}
}
