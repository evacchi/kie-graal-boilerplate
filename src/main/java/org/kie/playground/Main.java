package org.kie.playground;

import org.kie.api.DataSource;
import org.kie.api.process.ProcessInstance;
import org.kie.playground.generated.PeopleModule;

import static java.util.Arrays.asList;

public class Main {

    final static Main main = new Main();

    final PeopleModule module;
    final ProcessInstance<People> instance;

    Main() {
        this.module = new PeopleModule();
        this.instance = module
                .peopleProcess()
                .createInstance(new People());
    }

    void run() {
        People people = instance.variables();
        DataSource<Person> persons = people.persons();
        persons.addAll(asList(
                new Person("Mark", 37),
                new Person("Edson", 35),
                new Person("Mario", 40)
        ));

        instance.start();
    }

    public static void main(String[] args) {
        main.run();
    }
}
