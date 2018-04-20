package com.example.attila.mobilszoftlab.interactor;

import com.example.attila.mobilszoftlab.BookApplication;
import com.example.attila.mobilszoftlab.interactor.events.DeleteBookEvent;
import com.example.attila.mobilszoftlab.interactor.events.GetBooksEvent;
import com.example.attila.mobilszoftlab.interactor.events.InsertBookEvent;
import com.example.attila.mobilszoftlab.model.Book;
import com.example.attila.mobilszoftlab.repository.Repository;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

public class BookInteractor {
    EventBus bus;
    @Inject
    Repository repository;


    public BookInteractor() {
        BookApplication.injector.inject(this);
    }

    public void getBooks() {
        GetBooksEvent event = new GetBooksEvent();
        try {
            List<Book> books = repository.getBooks();
            event.setBooks(books);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void insertBook(Book book) {
        InsertBookEvent event = new InsertBookEvent();
        event.setBook(book);
        try {
            repository.saveBook(book);
            //Currently don't care about network sync problems
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void deleteBook(Book book) {
        DeleteBookEvent event = new DeleteBookEvent();
        event.setBook(book);
        try {
            repository.removeBook(book);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}

