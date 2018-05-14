package com.example.attila.mobilszoftlab.interactor;

import android.content.Context;
import android.util.Log;

import com.example.attila.mobilszoftlab.BookApplication;
import com.example.attila.mobilszoftlab.interactor.events.DeleteBookEvent;
import com.example.attila.mobilszoftlab.interactor.events.GetBooksEvent;
import com.example.attila.mobilszoftlab.interactor.events.InsertBookEvent;
import com.example.attila.mobilszoftlab.model.Book;
import com.example.attila.mobilszoftlab.model.BooksResult;
import com.example.attila.mobilszoftlab.network.book.BookApi;
import com.example.attila.mobilszoftlab.repository.Repository;
import com.orm.SugarContext;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class BookInteractor {
    @Inject
    EventBus bus;
    @Inject
    Repository repository;
    @Inject
    BookApi booksApi;



    public BookInteractor() {
        BookApplication.injector.inject(this);
    }

    public boolean isRepositoryEmpty(){
        if (repository.getBooks().isEmpty()){
            return true;
        }
        return false;
    }

    public List<Book> getBooksFromRepo(){
        return repository.getBooks();
    }

    public void addBook(Book book){
        repository.saveBook(book);
    }

    public void removeBook(Book book){
        repository.removeBook(book);
    }

    public void getBooksFromWeb() {
        GetBooksEvent event = new GetBooksEvent();
        try {
            Call<BooksResult> booksCall = booksApi.getBooks();
            Response<BooksResult> response = booksCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setBooks(response.body().getBooks());
            for (Book book:response.body().getBooks()) {
                repository.saveBook(book);
            }

            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }


    }
/*
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
    */
}

