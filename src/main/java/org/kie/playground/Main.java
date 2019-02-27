package org.kie.playground;

import org.kie.api.DataSource;
import org.kie.api.rules.RuleUnitInstance;

import static java.util.Arrays.asList;

//import org.jbpm.process.instance.LightProcessRuntime;
//import org.jbpm.process.instance.LightProcessRuntimeContext;
//import org.jbpm.process.instance.LightProcessRuntimeServiceProvider;

public class Main {

    final static Main main = new Main();

    final MyModule module;
    final RuleUnitInstance<People> instance;

    Main() {
        module = new MyModule();
        instance = module.peopleRuleUnit(new People());
    }

    public void run() {
        People people = instance.workingMemory();
        DataSource<Person> persons = people.persons();
        persons.addAll(asList(
                new Person("Mark", 37),
                new Person("Edson", 35),
                new Person("Mario", 40)
        ));

        instance.fire();
    }

    public static void main(String[] args) {
        main.run();
    }
}
