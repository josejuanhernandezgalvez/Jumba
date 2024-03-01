package io.flogo.builder.model.renderers;

import io.flogo.builder.model.Renderer;
import io.flogo.builder.model.architecture.ArchitectureView;
import io.flogo.builder.model.architecture.Output;
import io.flogo.builder.model.architecture.SectionView;
import io.flogo.model.Architecture;
import io.flogo.model.Section;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class ArchitectureRenderer implements Renderer {

    public ArchitectureView render(Architecture architecture) {
        AtomicReference<Output> input = new AtomicReference<>(getInputFrom(architecture.section(0)));
        return new ArchitectureView(architecture.sectionList().stream().map(s -> getSectionView(input, s)).toList());
    }

    private SectionView getSectionView(AtomicReference<Output> input, Section section) {
        SectionRenderer sectionRenderer = getRendererFor(section);
        SectionView sectionView = sectionRenderer.init(input.get()).render(section);
        input.set(sectionRenderer.sectionOutput());
        return sectionView;
    }

    private SectionRenderer getRendererFor(Section section) {
        try {
            return (SectionRenderer) Class.forName(getOutputClassNameFor(section)).getConstructors()[0].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Output getInputFrom(Section section) {
        try {
            Object input = section.core$().findNode(getInputClassFor(section)).getFirst();
            return determineOutputClass(input).getConstructor(List.class).newInstance(getFieldsOf(input));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Class<Output> determineOutputClass(Object input) {
        for (Class<?> aClass : outputClasses())
            if (aClass.getDeclaredFields().length == getFieldsOf(input).size()) return (Class<Output>) aClass;
        throw new RuntimeException("Input size not valid");
    }

    private static List<Object> getFieldsOf(Object input) {
        return Arrays.stream(input.getClass().getDeclaredFields())
                .map(f -> getValue(input, f))
                .toList();
    }

    private static Object getValue(Object input, Field field) {
        try {
            field.setAccessible(true);
            return field.get(input);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Class> outputClasses() {
        return new BufferedReader(new InputStreamReader(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResourceAsStream(Output.directory))))
                .lines()
                .filter(line -> line.endsWith(".class"))
                .map(ArchitectureRenderer::getOutputClass)
                .collect(Collectors.toList());
    }

    private static Class getOutputClass(String outputClassName) {
        try {
            return Class.forName(getOutputClassNameFor(outputClassName));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getOutputClassNameFor(String name) {
        return Output.packageRoute + name.substring(0, name.lastIndexOf('.'));
    }

    private String getOutputClassNameFor(Section section) {
        return SectionRenderer.packageRoute + extractFrom(section) + "Renderer";
    }

    private static Class getInputClassFor(Section section) throws ClassNotFoundException {
        return Class.forName("io.flogo.model." + extractFrom(section) + "$Input");
    }

    private static String extractFrom(Section section) {
        return section.core$().conceptList().getFirst().toString().split("\\{")[0];
    }

}
