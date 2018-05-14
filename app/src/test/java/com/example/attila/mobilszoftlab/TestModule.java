package com.example.attila.mobilszoftlab;

import android.content.Context;

import com.example.attila.mobilszoftlab.di.Network;
import com.example.attila.mobilszoftlab.ui.list.BookListPresenter;
import com.example.attila.mobilszoftlab.utils.UiExecutor;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestModule {

    private Context context;

    public TestModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public BookListPresenter provideBookListPresenter() {
        return new BookListPresenter();
    }



    @Provides
    @Singleton
    @Network
    public Executor provideNetworkExecutor() {
        return new UiExecutor();
    }


}
