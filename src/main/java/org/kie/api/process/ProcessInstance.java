package org.kie.api.process;

public class ProcessInstance<T> {
    private final ProcessRuntime rt;
    private final Process process;
    private final T variables;

    public ProcessInstance(ProcessRuntime rt, Process process, T variables) {
        this.rt = rt;
        this.process = process;
        this.variables = variables;
    }

    public Process process() {
        return process;
    }

    public T variables() {
        return variables;
    }

    public void start() {
    }

    public void signal(Signal s) {

    }
}
