package io.flogo.blatt.model.rules;

import io.intino.magritte.lang.model.Node;
import io.intino.magritte.lang.model.rules.NodeRule;

import java.util.List;

public class CheckSGDWithNesterovMomentumParameters implements NodeRule {

    @Override
    public boolean accept(Node node) {
        return true;
    }
}
