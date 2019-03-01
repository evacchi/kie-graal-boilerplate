package org.kie.playground.generated;

import org.jbpm.ruleflow.core.RuleFlowProcess;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.kie.api.process.Process;
import org.kie.api.rules.RuleUnitInstance;
import org.kie.api.runtime.process.ProcessContext;
import org.kie.playground.People;

public class PeopleProcess extends Process<People> {

    public PeopleProcess(PeopleModule m) {
        super(initProcess(m));
    }

    private static RuleFlowProcess initProcess(PeopleModule m) {
        RuleFlowProcess p;
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
                    System.out.println("begin rule action");
                    People people = getProcessData(ctx);
                    RuleUnitInstance<People> rui =
                            m.peopleRuleUnit().createInstance(people);
                    rui.fire();
                    System.out.println("end rule action");
                }).done()
                .endNode(3).name("End").done()
                // Connections
                .connection(1, 2)
                .connection(2, 3);
        p = factory.validate().getProcess();
        return p;
    }

    private static <T> T getProcessData(ProcessContext ctx) {
        return (T) ctx.getVariable("$v");
    }
}