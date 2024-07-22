package io.jumba.builder.model;

import io.intino.magritte.framework.Layer;

public interface Renderer<T extends Layer, V> {
    public V render(T layer) throws Exception;
}
