package org.kie.api;

import javax.annotation.Generated;

import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.kie.api.process.Process;
import org.kie.api.process.ProcessRuntime;

@Generated("jbpm-codegen")
public class BookProcess extends Process<Book, BookProcessInstance> {

    public BookProcess(Book variables) {
        super(variables);
    }

    @Override
    public BookProcessInstance createInstance(ProcessRuntime rt) {
        return new BookProcessInstance(rt, this, variables());
    }

    public void description() {
        RuleFlowProcessFactory factory =
                RuleFlowProcessFactory.createProcess("org.kie.api.process.MyProcessUnit");

        factory
                // Header
                .name("HelloWorldProcess")
                .version("1.0")
                .packageName("org.jbpm")
                // Nodes
                .startNode(1).name("Start").done()
                .actionNode(2).name("Action")
                .action(ctx -> System.out.println("Hello World!")).done()
                .endNode(3).name("End").done()
                // Connections
                .connection(1, 2)
                .connection(2, 3);

    }

}
