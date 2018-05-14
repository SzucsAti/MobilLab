package com.example.attila.mobilszoftlab.ui.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.attila.mobilszoftlab.BookApplication;
import com.example.attila.mobilszoftlab.R;
import com.example.attila.mobilszoftlab.di.Network;
import com.example.attila.mobilszoftlab.interactor.BookInteractor;
import com.example.attila.mobilszoftlab.interactor.events.GetBooksEvent;
import com.example.attila.mobilszoftlab.model.Book;
import com.example.attila.mobilszoftlab.repository.Repository;
import com.example.attila.mobilszoftlab.repository.SugarOrmRepository;
import com.example.attila.mobilszoftlab.ui.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;

public class BookListPresenter extends Presenter<BookListScreen> {

    @Inject
    @Network
    Executor networkExecutor;

    @Inject
    EventBus bus;

    @Inject
    BookInteractor bookInteractor;

    @Override
    public void attachScreen(BookListScreen screen)
    {
        super.attachScreen(screen);

        BookApplication.injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void addBook(Book book){

        bookInteractor.addBook(book);
        screen.createBook(book);
    }

    public void getBooks() {

        if(bookInteractor.isRepositoryEmpty()){
            networkExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    bookInteractor.getBooksFromWeb();
                }
            });
        }

        List<Book> books = bookInteractor.getBooksFromRepo();
        screen.showBooks(books);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetBooksEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                //handleDetails(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {
                System.out.println(event.getBooks().size());
                screen.showBooks(event.getBooks());
            }
        }
    }

    public void getPopupMenu(View v, final int position, final Book book){
        PopupMenu popup = new PopupMenu(v.getContext(), v);
        popup.inflate(R.menu.long_click_menu);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (R.id.delete == item.getItemId()) {
                    deleteBook(book, position);
                }
                return false;
            }
        });
        popup.show();
    }

    public void createBook(Book book){
        screen.createBook(book);
    }

    public void deleteBook(Book book, int position){

        bookInteractor.removeBook(book);
        screen.deleteBook(position);
    }

    public void toDetails(Book book){
        screen.toDetails(book);
    }
}
