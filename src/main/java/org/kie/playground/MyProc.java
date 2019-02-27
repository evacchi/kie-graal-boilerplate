package org.kie.playground;

import java.util.Objects;

import org.jbpm.process.instance.InternalProcessRuntime;
import org.jbpm.ruleflow.core.RuleFlowProcess;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.kie.api.runtime.process.ProcessInstance;

//import org.jbpm.process.instance.LightProcessRuntime;
//import org.jbpm.process.instance.LightProcessRuntimeContext;
//import org.jbpm.process.instance.LightProcessRuntimeServiceProvider;

public class MyProc {

    final static MyProc m = new MyProc();

    final InternalProcessRuntime rt;
    String result;

    MyProc() {
        RuleFlowProcessFactory factory =
                RuleFlowProcessFactory.createProcess("org.kie.api2.MyProcessUnit");
        factory
                // Header
                .name("HelloWorldProcess")
                .version("1.0")
                .packageName("org.jbpm")
                // Nodes
                .startNode(1).name("Start").done()
                .actionNode(2).name("Action")
                .action(ctx -> {
                    System.out.println("Hello, World!");
                    result = "hello!";
                }).done()
                .endNode(3).name("End").done()
                // Connections
                .connection(1, 2)
                .connection(2, 3);
        RuleFlowProcess process = factory.validate().getProcess();

//        LightProcessRuntimeServiceProvider services =
//                new LightProcessRuntimeServiceProvider();
//
//        LightProcessRuntimeContext rtc = new LightProcessRuntimeContext(
//                Collections.singletonList(process));
//
//        rt = new LightProcessRuntime(rtc, services);
        rt=null;

        System.out.println("DONE INIT");
    }

    void run() {
        ProcessInstance pi = rt.startProcess("org.kie.api2.MyProcessUnit");
        Objects.requireNonNull(result);
    }

    public static void main(String[] args) {
        m.run();
    }
}
