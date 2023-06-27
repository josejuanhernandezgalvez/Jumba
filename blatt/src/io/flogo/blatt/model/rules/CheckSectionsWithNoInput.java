package io.flogo.blatt.model.rules;

import io.intino.magritte.lang.model.Node;
import io.intino.magritte.lang.model.rules.NodeRule;

public class CheckSectionsWithNoInput implements NodeRule {

    @Override
    public boolean accept(Node node) {
        return true;
    }
}
