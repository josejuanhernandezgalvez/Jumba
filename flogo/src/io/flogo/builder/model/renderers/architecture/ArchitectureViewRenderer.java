package io.flogo.builder.model.renderers.architecture;

import io.flogo.builder.CompilationContext;
import io.flogo.builder.model.Renderer;
import io.flogo.builder.model.architecture.ArchitectureView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.SectionView;
import io.flogo.model.Architecture;
import io.flogo.model.Section;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class ArchitectureViewRenderer implements Renderer<Architecture, ArchitectureView> {
    private final InputRenderer inputRenderer;
    private final SectionRenderer<SectionView> sectionRenderer;
    private final CompilationContext context;

    public ArchitectureViewRenderer(CompilationContext context) {
        this.inputRenderer = new InputRenderer();
        this.sectionRenderer = new SectionRenderer.SectionOrchestratorRenderer();
        this.context = context;
    }

    public ArchitectureView render(Architecture architecture) {
        OutputView input = inputRenderer.render(architecture.section(0));
        return new ArchitectureView(render(architecture.sectionList().iterator(), input, new ArrayList<>()), architecture.name$());
    }

    private List<SectionView> render(Iterator<Section> iterator, OutputView input, List<SectionView> sectionViews) {
        if (!iterator.hasNext()) return sectionViews;
        sectionViews.add(sectionRenderer.render(iterator.next(), input, context));
        return render(iterator, sectionViews.getLast().output(), sectionViews);
    }

    private static final class InputRenderer implements Renderer<Section, OutputView> {
        private final static String directory = "io/flogo/builder/model/architecture/layers/output/";
        private final static String packageRoute = "io.flogo.builder.model.architecture.layers.output.";


        @Override
        public OutputView render(Section section) {
            try {
                Object input = section.core$().findNode(getInputClassFor(section)).getFirst();
                return determineOutputClass(input).getConstructor(List.class).newInstance(getFieldsOf(input));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private Class<OutputView> determineOutputClass(Object input) {
            for (Class<?> aClass : outputClasses())
                if (aClass.getDeclaredFields().length == getFieldsOf(input).size()) return (Class<OutputView>) aClass;
            throw new RuntimeException("Input size not valid");
        }

        private List<Object> getFieldsOf(Object input) {
            return Arrays.stream(input.getClass().getDeclaredFields())
                    .map(f -> getValue(input, f))
                    .toList();
        }

        private List<Class<?>> outputClasses() {
            return new BufferedReader(inputStreamReader())
                    .lines()
                    .filter(line -> line.endsWith(".class"))
                    .map(this::getOutputClass)
                    .collect(Collectors.toList());
        }

        private InputStreamReader inputStreamReader() {
            return new InputStreamReader(Objects.requireNonNull(ClassLoader.getSystemClassLoader()
                    .getResourceAsStream(directory)));
        }

        private Class<?> getOutputClass(String outputClassName) {
            try {
                return Class.forName(getOutputClassNameFor(outputClassName));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        private String getOutputClassNameFor(String name) {
            return packageRoute + name.substring(0, name.lastIndexOf('.'));
        }

        private Class getInputClassFor(Section section) throws ClassNotFoundException {
            return Class.forName("io.flogo.model." + extractFrom(section) + "$Input");
        }

        private String extractFrom(Section section) {
            return section.core$().conceptList().getFirst().toString().split("\\{")[0];
        }

        private Object getValue(Object input, Field field) {
            try {
                field.setAccessible(true);
                return field.get(input);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

