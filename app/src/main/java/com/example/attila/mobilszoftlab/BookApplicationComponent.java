package com.example.attila.mobilszoftlab;


import com.example.attila.mobilszoftlab.interactor.BookInteractor;
import com.example.attila.mobilszoftlab.interactor.InteractorModule;
import com.example.attila.mobilszoftlab.network.NetworkModule;
import com.example.attila.mobilszoftlab.repository.RepositoryModule;
import com.example.attila.mobilszoftlab.ui.UIModule;
import com.example.attila.mobilszoftlab.ui.list.BookListActivity;
import com.example.attila.mobilszoftlab.ui.list.BookListPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, NetworkModule.class, InteractorModule.class})
public interface BookApplicationComponent {
    void inject(BookListActivity bookListActivity);

    void inject(BookInteractor bookInteractor);

    void inject(BookListPresenter bookListPresenter);
}