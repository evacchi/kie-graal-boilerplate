package org.kie.api.rules;

import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.model.Model;
import org.drools.modelcompiler.builder.KieBaseBuilder;
import org.kie.api.runtime.KieSession;

public class RuleRuntime {

//    public <T> RuleUnitInstance<T> instance(RuleUnit<T> unit) {
//        return new RuleUnitInstance<T>(null, unit.memory());
//    }

    public static KieSession fromModel(Model m) {
        InternalKnowledgeBase kbase = KieBaseBuilder.createKieBaseFromModel(m);
        return kbase.newKieSession();
    }

}
