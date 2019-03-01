package org.kie.api.rules;

import java.util.Collections;

import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.model.Model;

import static org.drools.modelcompiler.builder.KieBaseBuilder.createKieBaseFromModel;

public class RuleUnit<T> {

    InternalKnowledgeBase kbase;

    public RuleUnit(Model m) {
        this.kbase = createKieBaseFromModel(Collections.singletonList(m));
    }

    public RuleUnitInstance<T> createInstance(T workingMemory) {
        return  new RuleUnitInstance<>(this, workingMemory, kbase.newKieSession());
    }
}
