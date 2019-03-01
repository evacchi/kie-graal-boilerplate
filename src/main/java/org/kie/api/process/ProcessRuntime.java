package org.kie.api.process;

import java.util.Collections;

import org.jbpm.process.instance.LightProcessRuntime;
import org.jbpm.process.instance.LightProcessRuntimeContext;
import org.jbpm.process.instance.LightProcessRuntimeServiceProvider;
import org.jbpm.ruleflow.core.RuleFlowProcess;

public class ProcessRuntime {

//    public <T, U extends ProcessInstance<T>> U createInstance(Process<T, U> p) {
//        return p.createInstance(this);
//    }

    public static LightProcessRuntime of(RuleFlowProcess process) {
        LightProcessRuntimeServiceProvider services =
                new LightProcessRuntimeServiceProvider();

        LightProcessRuntimeContext rtc = new LightProcessRuntimeContext(
                Collections.singletonList(process));

        return new LightProcessRuntime(rtc, services);

    }
}
