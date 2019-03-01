const ProcessRuntime = Java.type("org.kie.api.process.ProcessRuntime")
const RuleFlowProcessFactory = Java.type('org.jbpm.ruleflow.core.RuleFlowProcessFactory');
const factory = RuleFlowProcessFactory.createProcess("org.kie.api2.MyProcessUnit");
factory
    // Header
    .name("HelloWorldProcess")
    .version("1.0")
    .packageName("org.jbpm")
    // Nodes
    .startNode(1).name("Start").done()
    .actionNode(2).name("Action")
    .action(ctx => {
        console.log("begin rule action");
        console.log("end rule action");
    }).done()
    .endNode(3).name("End").done()
    // Connections
    .connection(1, 2)
    .connection(2, 3);
p = factory.validate().getProcess();

const rt = ProcessRuntime.of(p)
rt.startProcess(p.getId())
