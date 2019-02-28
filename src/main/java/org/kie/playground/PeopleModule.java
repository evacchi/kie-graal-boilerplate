package org.kie.playground;

import java.util.Collections;
import java.util.List;

import org.drools.core.WorkingMemory;
import org.drools.core.rule.Collect;
import org.drools.model.Index;
import org.drools.model.Model;
import org.drools.model.Rule;
import org.drools.model.Variable;
import org.drools.model.impl.ModelImpl;
import org.drools.modelcompiler.CanonicalKieModuleModel;
import org.jbpm.ruleflow.core.RuleFlowProcess;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.kie.api.process.Process;
import org.kie.api.process.ProcessInstance;
import org.kie.api.rules.RuleUnit;
import org.kie.api.rules.RuleUnitInstance;

import static org.drools.model.DSL.*;
import static org.drools.model.PatternDSL.*;
import static org.drools.modelcompiler.builder.KieBaseBuilder.createKieBaseFromModel;

public class PeopleModule implements CanonicalKieModuleModel {

    private final RuleUnit<People> peopleRuleUnit;
    private final Process<People> peopleProcess;

    PeopleModule() {
        this.peopleRuleUnit = new PeopleRuleUnit(this);
        this.peopleProcess = new PeopleProcess(this);
    }

    public RuleUnit<People> peopleRuleUnit() {
        return peopleRuleUnit;
    }

    public Process<People> peopleProcess() {
        return peopleProcess;
    }

    @Override
    public String getVersion() {
        return "1";
    }

    @Override
    public List<Model> getModels() {
        return Collections.emptyList();
    }

}
