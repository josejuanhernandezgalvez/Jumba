package io.flogo.blatt.model.rules;

import io.intino.tara.language.model.Mogram;
import io.intino.tara.language.model.rules.NodeRule;

public class CheckFirstInput implements NodeRule {


	public boolean accept(Mogram mogram) {
		return index(mogram.container(), mogram) == 0 ? checkIfHasInput(mogram) : !checkIfHasInput(mogram);
	}

	private boolean checkIfHasInput(Mogram mogram) {
		return mogram.components().stream().anyMatch(c -> c.type().equals("Input"));

	}

	private int index(Mogram container, Mogram mogram) {
		return 0;//TODO
	}
}
