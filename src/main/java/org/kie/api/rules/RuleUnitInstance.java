package org.kie.api.rules;

import org.kie.api.runtime.KieSession;
import org.kie.playground.People;

public class RuleUnitInstance<T> {

    private final T workingMemory;
    private final KieSession rt;

    public RuleUnitInstance(KieSession rt, T workingMemory) {
        this.rt = rt;
        this.workingMemory = workingMemory;
    }

    public void fire() {
        magicReflectionThingie(rt, workingMemory);
        rt.fireAllRules();
    }

    public T workingMemory() {
        return workingMemory;
    }

    private void magicReflectionThingie(KieSession rt, T workingMemory) {
        // come on, it's a demo
        People w = (People) workingMemory;
        w.persons().drainInto(rt::insert);
    }
}
