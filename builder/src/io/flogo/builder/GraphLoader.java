package io.flogo.builder;

import io.flogo.model.FlogoGraph;
import io.intino.magritte.builder.StashBuilder;
import io.intino.magritte.framework.loaders.ClassFinder;
import io.intino.magritte.framework.stores.ResourcesStore;
import io.intino.magritte.io.model.Stash;
import tara.dsl.Flogo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class GraphLoader {
    private Stash[] stashes;

    public FlogoGraph loadGraph(CompilerConfiguration configuration, List<File> srcFiles) {
        ClassFinder.clear();
        Charset charset = Charset.forName(configuration.sourceEncoding());
        if (!srcFiles.isEmpty()) {
            final ByteArrayOutputStream out = new ByteArrayOutputStream();
            final StashBuilder stashBuilder = new StashBuilder(srcFiles.stream().collect(Collectors.toMap(f -> f, f -> charset)), new Flogo(), configuration.module(), new PrintStream(out));
            stashes = stashBuilder.build();
            configuration.project();
            configuration.out().print(out.toString(StandardCharsets.UTF_8).replaceAll("\ntarac", "\nkonosc").replaceAll("%%rc.*/%rc\n", ""));
            if (stashes == null) return null;
            else return loadGraph(configuration, stashes);
        } else return loadGraph(configuration);
    }

    public Stash[] stashes() {
        return stashes;
    }

    private FlogoGraph loadGraph(CompilerConfiguration configuration, Stash... stashes) {
        final ClassLoader currentLoader = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(GraphLoader.class.getClassLoader());
        FlogoGraph graph = FlogoGraph.load(store(configuration), stashes);
        if (graph == null) return null;
        Thread.currentThread().setContextClassLoader(currentLoader);
        return graph;
    }

    private ResourcesStore store(CompilerConfiguration configuration) {
        return new ResourcesStore() {
            @Override
            public URL resourceFrom(String path) {
                try {
                    return new File(configuration.resDirectory().getPath() + File.separator + path).toURI().toURL();
                } catch (MalformedURLException e) {
                    return null;
                }
            }
        };
    }
}
