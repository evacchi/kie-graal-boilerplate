package org.kie.api;

public class Book {

    @Variable String title;
    @Variable String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
