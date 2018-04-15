package com.example.attila.mobilszoftlab.ui.list;

import com.example.attila.mobilszoftlab.model.Book;

public interface BookListScreen {

    public void createBook(Book book);
    public void deleteBook(Book book);
    public void toDetails(Book book);
}
