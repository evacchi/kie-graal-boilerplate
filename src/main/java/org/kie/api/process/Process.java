package org.kie.api.process;

public abstract class Process<T, U extends ProcessInstance<T>> {

    private final T variables;

    public Process(T variables) {
        this.variables = variables;
    }

    public abstract U createInstance(ProcessRuntime processRuntime);


    public T variables() {
        return variables;
    }
}
