package com.example.attila.mobilszoftlab.repository;

import android.content.Context;

import com.example.attila.mobilszoftlab.model.Book;

import java.util.List;

public interface Repository {

    void open(Context context);

    void close();

    List<Book> getBooks();

    void saveBook(Book book);

    //void updateSessions(List<Session> sessions);

    void removeBook(Book book);

    boolean isInDB(Book book);
}
