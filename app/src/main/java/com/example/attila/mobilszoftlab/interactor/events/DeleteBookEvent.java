package com.example.attila.mobilszoftlab.interactor.events;

import com.example.attila.mobilszoftlab.model.Book;

public class DeleteBookEvent {
    private int code;
    private Book book;
    private Throwable throwable;

    public DeleteBookEvent() {
    }

    public DeleteBookEvent(int code, Book book, Throwable throwable) {
        this.code = code;
        this.book = book;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
