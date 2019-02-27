package org.kie.api;

import org.kie.api.process.ProcessInstance;
import org.kie.api.process.ProcessRuntime;
import org.kie.api.rules.RuleRuntime;
import org.kie.api.rules.RuleUnit;
import org.kie.api.rules.RuleUnitInstance;

public class ProcessApiTest {

    Book book = new Book("The Jungle Book", "Rudyard Kipling");


    public void createProcess() {
        ProcessRuntime prt = new ProcessRuntime();
        BookProcess p = new BookProcess(book);
        BookProcessInstance pi = prt.createInstance(p);
        pi.start();
    }

    public void createRules() {
//        RuleUnit<Book> ru = RuleUnit.of(book);
//        RuleRuntime rrt = new RuleRuntime();
//        RuleUnitInstance<Book> rui = rrt.instance(ru);
//        rui.fire();
    }

    public void chain() {
    }
}

