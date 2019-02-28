package org.kie.api.rules;

import java.util.Collections;

import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.model.Model;

import static org.drools.modelcompiler.builder.KieBaseBuilder.createKieBaseFromModel;

public class RuleUnit<T> {

    private final T workingMemory;
    InternalKnowledgeBase kbase;

    public RuleUnit(Model m, T workingMemory) {
        this.kbase = createKieBaseFromModel(Collections.singletonList(m));
        this.workingMemory = workingMemory;
    }

    public T memory() {
        return workingMemory;
    }

    public RuleUnitInstance<T> createInstance(T workingMemory) {
        return  new RuleUnitInstance<>(this, workingMemory, kbase.newKieSession());
    }
}
