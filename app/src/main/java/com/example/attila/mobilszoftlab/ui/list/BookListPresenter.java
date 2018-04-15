package com.example.attila.mobilszoftlab.ui.list;

import com.example.attila.mobilszoftlab.model.Book;
import com.example.attila.mobilszoftlab.ui.Presenter;

public class BookListPresenter extends Presenter<BookListScreen> {

    @Override
    public void attachScreen(BookListScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void createBook(Book book){
        screen.createBook(book);
    }

    public void deleteBook(Book book){
        screen.deleteBook(book);
    }

    public void toDetails(Book book){
        screen.toDetails(book);
    }
}
