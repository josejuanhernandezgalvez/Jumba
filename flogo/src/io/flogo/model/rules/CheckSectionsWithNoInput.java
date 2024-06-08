package io.flogo.model.rules;

import io.intino.tara.language.model.Mogram;
import io.intino.tara.language.model.rules.MogramRule;

import java.util.Collection;
import java.util.List;

public class CheckSectionsWithNoInput implements MogramRule {

    public boolean accept(Mogram mogram) {
		boolean result = true;
		for (String componentName : component(mogram))
			result = result && !componentName.endsWith("Input");
		return result;
    }

	private static List<String> component(Mogram mogram) {
		return mogram.container().components().stream()
								 	 		  .skip(1)
								 	 		  .map(Mogram::components)
								 	 		  .flatMap(Collection::stream)
								 	 		  .map(Mogram::type)
								 	 		  .toList();
	}
}
