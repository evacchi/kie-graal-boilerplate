package org.kie.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class DataSource<T> {
    ArrayList<T> values = new ArrayList<>();

    public void add(T t) {
        values.add(t);
    }

    public void addAll(Collection<? extends T> ts) {
        values.addAll(ts);
    }

    public void drainInto(Consumer<Object> sink) {
        Iterator<T> iter = values.iterator();
        while(iter.hasNext()) {
            T t = iter.next();
            sink.accept(t);
            iter.remove();
        }
    }
}
