package org.kie.api.rules;

import org.drools.model.Model;

public class RuleUnit<T> {

    private final Model model;
    private final T workingMemory;

    public RuleUnit(Model m, T workingMemory) {
        model = m;
        this.workingMemory = workingMemory;
    }

    public T memory() {
        return workingMemory;
    }

    public Model model() {
        return model;
    }
}
