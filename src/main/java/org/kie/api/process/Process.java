package org.kie.api.process;

import org.jbpm.ruleflow.core.RuleFlowProcess;

public abstract class Process<T> {

    private final RuleFlowProcess process;

    public Process(RuleFlowProcess process) {
        this.process = process;
    }

    public ProcessInstance<T> createInstance(T variables) {
        return new ProcessInstance<>(this, variables);
    }

    RuleFlowProcess getRuleFlowProcess() {
        return process;
    }
}
