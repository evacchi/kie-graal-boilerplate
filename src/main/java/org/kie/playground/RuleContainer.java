package org.kie.playground;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

public class RuleContainer {
    static final KieSession k =
            KieServices.Factory.get()
                    .getKieClasspathContainer()
                    .newKieSession();

    public static void main(String[] args) {
        k.insert("hello");
        k.fireAllRules();
    }
}
