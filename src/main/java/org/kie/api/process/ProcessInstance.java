package org.kie.api.process;

import java.util.Collections;
import java.util.HashMap;

import org.jbpm.process.instance.LightProcessRuntime;
import org.jbpm.process.instance.LightProcessRuntimeContext;
import org.jbpm.process.instance.LightProcessRuntimeServiceProvider;
import org.jbpm.ruleflow.core.RuleFlowProcess;

public class ProcessInstance<T> {
    private final LightProcessRuntime rt;
    private final Process<T> process;
    private final T variables;
    private final org.jbpm.process.instance.ProcessInstance legacyProcessInstance;

    public ProcessInstance(Process<T> process, T variables) {
        this.process = process;
        this.variables = variables;
        this.rt = initLegacyRuntime(process.getRuleFlowProcess());
        this.legacyProcessInstance = initLegacyProcessInstance(process, variables);
    }

    public Process<T> process() {
        return process;
    }

    public T variables() {
        return variables;
    }

    public void start() {
        rt.startProcessInstance(legacyProcessInstance.getId());
    }

    public void signal(Signal s) {

    }

    private org.jbpm.process.instance.ProcessInstance initLegacyProcessInstance(Process<T> process, T variables) {
        HashMap<String, Object> vs = new HashMap<>();
        vs.put("$v", variables);
         return (org.jbpm.process.instance.ProcessInstance)
                 rt.createProcessInstance(
                         process.getRuleFlowProcess().getId(), vs);
    }

    private LightProcessRuntime initLegacyRuntime(RuleFlowProcess process) {
        LightProcessRuntimeServiceProvider services =
                new LightProcessRuntimeServiceProvider();

        LightProcessRuntimeContext rtc = new LightProcessRuntimeContext(
                Collections.singletonList(process));

        return new LightProcessRuntime(rtc, services);
    }
}
