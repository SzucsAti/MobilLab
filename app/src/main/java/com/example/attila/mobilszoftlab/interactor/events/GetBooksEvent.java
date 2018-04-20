package com.example.attila.mobilszoftlab.interactor.events;

import com.example.attila.mobilszoftlab.model.Book;

import java.util.List;

public class GetBooksEvent {
    private int code;
    private List<Book> books;
    private Throwable throwable;

    public GetBooksEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
