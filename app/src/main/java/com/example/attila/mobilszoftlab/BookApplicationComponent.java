package com.example.attila.mobilszoftlab;


import com.example.attila.mobilszoftlab.ui.UIModule;
import com.example.attila.mobilszoftlab.ui.list.BookListActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class})
public interface BookApplicationComponent {
    void inject(BookListActivity bookListActivity);
}
