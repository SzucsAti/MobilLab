package com.example.attila.mobilszoftlab.ui.list;

import com.example.attila.mobilszoftlab.model.Book;

import java.util.List;

public interface BookListScreen {

    public void createBook(Book book);
    public void deleteBook(int pos);
    public void toDetails(Book book);
    void showBooks(List<Book> books);
}
