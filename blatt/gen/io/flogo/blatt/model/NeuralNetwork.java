package io.flogo.blatt.model;

import io.flogo.blatt.model.*;

public class NeuralNetwork  extends io.intino.magritte.framework.Layer implements io.intino.magritte.framework.tags.Terminal {
	protected java.util.List<io.flogo.blatt.model.Section> sectionList = new java.util.ArrayList<>();

	public NeuralNetwork(io.intino.magritte.framework.Node node) {
		super(node);
	}

	public java.util.List<io.flogo.blatt.model.Section> sectionList() {
		return java.util.Collections.unmodifiableList(sectionList);
	}

	public io.flogo.blatt.model.Section section(int index) {
		return sectionList.get(index);
	}

	public java.util.List<io.flogo.blatt.model.Section> sectionList(java.util.function.Predicate<io.flogo.blatt.model.Section> predicate) {
		return sectionList().stream().filter(predicate).collect(java.util.stream.Collectors.toList());
	}

	public io.flogo.blatt.model.Section section(java.util.function.Predicate<io.flogo.blatt.model.Section> predicate) {
		return sectionList().stream().filter(predicate).findFirst().orElse(null);
	}

	protected java.util.List<io.intino.magritte.framework.Node> componentList$() {
		java.util.Set<io.intino.magritte.framework.Node> components = new java.util.LinkedHashSet<>(super.componentList$());
		new java.util.ArrayList<>(sectionList).forEach(c -> components.add(c.core$()));
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
		if (node.is("Section")) this.sectionList.add(node.as(io.flogo.blatt.model.Section.class));
	}

	@Override
	protected void removeNode$(io.intino.magritte.framework.Node node) {
		super.removeNode$(node);
		if (node.is("Section")) this.sectionList.remove(node.as(io.flogo.blatt.model.Section.class));
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


		public io.flogo.blatt.model.SoftmaxSection softmaxSection() {
			io.flogo.blatt.model.SoftmaxSection newElement = core$().graph().concept(io.flogo.blatt.model.SoftmaxSection.class).createNode(this.name, core$()).as(io.flogo.blatt.model.SoftmaxSection.class);

			return newElement;
		}

		public io.flogo.blatt.model.FlattenSection flattenSection() {
			io.flogo.blatt.model.FlattenSection newElement = core$().graph().concept(io.flogo.blatt.model.FlattenSection.class).createNode(this.name, core$()).as(io.flogo.blatt.model.FlattenSection.class);

			return newElement;
		}

		public io.flogo.blatt.model.ConvolutionalSection convolutionalSection() {
			io.flogo.blatt.model.ConvolutionalSection newElement = core$().graph().concept(io.flogo.blatt.model.ConvolutionalSection.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ConvolutionalSection.class);

			return newElement;
		}

		public io.flogo.blatt.model.ResidualSection residualSection() {
			io.flogo.blatt.model.ResidualSection newElement = core$().graph().concept(io.flogo.blatt.model.ResidualSection.class).createNode(this.name, core$()).as(io.flogo.blatt.model.ResidualSection.class);

			return newElement;
		}

		public io.flogo.blatt.model.LinearSection linearSection() {
			io.flogo.blatt.model.LinearSection newElement = core$().graph().concept(io.flogo.blatt.model.LinearSection.class).createNode(this.name, core$()).as(io.flogo.blatt.model.LinearSection.class);

			return newElement;
		}

		public io.flogo.blatt.model.RecurrentSection recurrentSection() {
			io.flogo.blatt.model.RecurrentSection newElement = core$().graph().concept(io.flogo.blatt.model.RecurrentSection.class).createNode(this.name, core$()).as(io.flogo.blatt.model.RecurrentSection.class);

			return newElement;
		}
	}

	public io.flogo.blatt.model.BlattGraph graph() {
		return (io.flogo.blatt.model.BlattGraph) core$().graph().as(io.flogo.blatt.model.BlattGraph.class);
	}
}