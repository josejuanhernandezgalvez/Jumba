package io.flogo.blatt.model;

import io.flogo.blatt.model.*;

public class Training  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
	protected io.flogo.blatt.model.Optimizer optimizer;
	protected io.flogo.blatt.model.EarlyStopping earlyStopping;
	protected io.flogo.blatt.model.LossFunction lossFunction;

	public Training(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public io.flogo.blatt.model.Optimizer optimizer() {
		return optimizer;
	}

	public io.flogo.blatt.model.EarlyStopping earlyStopping() {
		return earlyStopping;
	}

	public io.flogo.blatt.model.LossFunction lossFunction() {
		return lossFunction;
	}

	protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
		java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
		if (optimizer != null) components.add(this.optimizer.core$());
		if (earlyStopping != null) components.add(this.earlyStopping.core$());
		if (lossFunction != null) components.add(this.lossFunction.core$());
		return new java.util.ArrayList<>(components);
	}

	@Override
	protected java.util.Map<java.lang.String, java.util.List<?>> variables$() {
		java.util.Map<java.lang.String, java.util.List<?>> map = new java.util.LinkedHashMap<>();
		return map;
	}

	@Override
	protected void addNode$(io.intino.magritte.framework.Node node) {
		super.addNode$(node);
		if (node.is("Optimizer")) this.optimizer = node.as(io.flogo.blatt.model.Optimizer.class);
		if (node.is("EarlyStopping")) this.earlyStopping = node.as(io.flogo.blatt.model.EarlyStopping.class);
		if (node.is("LossFunction")) this.lossFunction = node.as(io.flogo.blatt.model.LossFunction.class);
	}

	@Override
	protected void removeNode$(io.intino.magritte.framework.Node node) {
		super.removeNode$(node);
		if (node.is("Optimizer")) this.optimizer = null;
		if (node.is("EarlyStopping")) this.earlyStopping = null;
		if (node.is("LossFunction")) this.lossFunction = null;
	}

	@Override
	protected void load$(java.lang.String name, java.util.List<?> values) {
		super.load$(name, values);
	}

	@Override
	protected void set$(java.lang.String name, java.util.List<?> values) {
		super.set$(name, values);
	}

	public Create create() {
		return new Create(null);
	}

	public Create create(java.lang.String name) {
		return new Create(name);
	}

	public class Create  {
		protected final java.lang.String name;

		public Create(java.lang.String name) {
			this.name = name;
		}


		public io.flogo.blatt.model.Adam adam() {
			io.flogo.blatt.model.Adam newElement = core$().graph().concept(io.flogo.blatt.model.Adam.class).createNode(this.name, core$()).as(io.flogo.blatt.model.Adam.class);

			return newElement;
		}

		public io.flogo.blatt.model.SGD sGD() {
			io.flogo.blatt.model.SGD newElement = core$().graph().concept(io.flogo.blatt.model.SGD.class).createNode(this.name, core$()).as(io.flogo.blatt.model.SGD.class);

			return newElement;
		}

		public io.flogo.blatt.model.RMSProp rMSProp() {
			io.flogo.blatt.model.RMSProp newElement = core$().graph().concept(io.flogo.blatt.model.RMSProp.class).createNode(this.name, core$()).as(io.flogo.blatt.model.RMSProp.class);

			return newElement;
		}

		public io.flogo.blatt.model.Adadelta adadelta() {
			io.flogo.blatt.model.Adadelta newElement = core$().graph().concept(io.flogo.blatt.model.Adadelta.class).createNode(this.name, core$()).as(io.flogo.blatt.model.Adadelta.class);

			return newElement;
		}

		public io.flogo.blatt.model.ASGD aSGD() {
			io.flogo.blatt.model.ASGD newElement = core$().graph().concept(io.flogo.blatt.model.ASGD.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ASGD.class);

			return newElement;
		}

		public io.flogo.blatt.model.Adagrad adagrad() {
			io.flogo.blatt.model.Adagrad newElement = core$().graph().concept(io.flogo.blatt.model.Adagrad.class).createNode(this.name, core$()).as(io.flogo.blatt.model.Adagrad.class);

			return newElement;
		}

		public io.flogo.blatt.model.GrowthEarlyStopper growthEarlyStopper(double threshold) {
			io.flogo.blatt.model.GrowthEarlyStopper newElement = core$().graph().concept(io.flogo.blatt.model.GrowthEarlyStopper.class).createNode(this.name, core$()).as(io.flogo.blatt.model.GrowthEarlyStopper.class);
			newElement.core$().set(newElement, "threshold", java.util.Collections.singletonList(threshold));
			return newElement;
		}

		public io.flogo.blatt.model.PrecisionEarlyStopper precisionEarlyStopper(int threshold) {
			io.flogo.blatt.model.PrecisionEarlyStopper newElement = core$().graph().concept(io.flogo.blatt.model.PrecisionEarlyStopper.class).createNode(this.name, core$()).as(io.flogo.blatt.model.PrecisionEarlyStopper.class);
			newElement.core$().set(newElement, "threshold", java.util.Collections.singletonList(threshold));
			return newElement;
		}

		public io.flogo.blatt.model.CrossEntropyLoss crossEntropyLoss() {
			io.flogo.blatt.model.CrossEntropyLoss newElement = core$().graph().concept(io.flogo.blatt.model.CrossEntropyLoss.class).createNode(this.name, core$()).as(io.flogo.blatt.model.CrossEntropyLoss.class);

			return newElement;
		}

		public io.flogo.blatt.model.BinaryCrossEntropyLoss binaryCrossEntropyLoss() {
			io.flogo.blatt.model.BinaryCrossEntropyLoss newElement = core$().graph().concept(io.flogo.blatt.model.BinaryCrossEntropyLoss.class).createNode(this.name, core$()).as(io.flogo.blatt.model.BinaryCrossEntropyLoss.class);

			return newElement;
		}

		public io.flogo.blatt.model.MSELoss mSELoss() {
			io.flogo.blatt.model.MSELoss newElement = core$().graph().concept(io.flogo.blatt.model.MSELoss.class).createNode(this.name, core$()).as(io.flogo.blatt.model.MSELoss.class);

			return newElement;
		}

		public io.flogo.blatt.model.MAELoss mAELoss() {
			io.flogo.blatt.model.MAELoss newElement = core$().graph().concept(io.flogo.blatt.model.MAELoss.class).createNode(this.name, core$()).as(io.flogo.blatt.model.MAELoss.class);

			return newElement;
		}
	}

	public io.flogo.blatt.model.BlattGraph graph() {
		return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
	}
}