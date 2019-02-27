package org.kie.api;

import org.kie.api.process.Process;
import org.kie.api.process.ProcessInstance;
import org.kie.api.process.ProcessRuntime;

public class BookProcessInstance extends ProcessInstance<Book> {

    public BookProcessInstance(ProcessRuntime rt, Process<Book, BookProcessInstance> p, Book variables) {
        super(rt,
              p,
              variables);
    }
}
