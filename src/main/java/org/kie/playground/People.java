package org.kie.playground;

import org.kie.api.DataSource;

public class People {
    DataSource<Person> persons = new DataSource<>();

    public DataSource<Person> persons() {
        return persons;
    }
}
