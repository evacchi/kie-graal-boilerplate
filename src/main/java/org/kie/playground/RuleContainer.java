package org.kie.playground;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

public class RuleContainer {
    static final KieSession f =
            KieServices.Factory.get().getKieClasspathContainer().newKieSession();

    public static void main(String[] args) {
        f.insert("hello");
        f.fireAllRules();
    }
}
