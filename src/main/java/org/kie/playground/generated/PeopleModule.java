package org.kie.playground.generated;

import java.util.Collections;
import java.util.List;

import org.drools.model.Model;
import org.drools.modelcompiler.CanonicalKieModuleModel;
import org.kie.api.process.Process;
import org.kie.api.rules.RuleUnit;
import org.kie.playground.People;

import static org.drools.modelcompiler.builder.KieBaseBuilder.createKieBaseFromModel;

public class PeopleModule implements CanonicalKieModuleModel {

    private final RuleUnit<People> peopleRuleUnit;
    private final Process<People> peopleProcess;

    public PeopleModule() {
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
