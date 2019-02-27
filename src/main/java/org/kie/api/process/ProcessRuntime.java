package org.kie.api.process;

public class ProcessRuntime {

    public <T, U extends ProcessInstance<T>> U createInstance(Process<T, U> p) {
        return p.createInstance(this);
    }
}
