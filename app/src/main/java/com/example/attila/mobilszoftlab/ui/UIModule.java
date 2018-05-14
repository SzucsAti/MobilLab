package com.example.attila.mobilszoftlab.ui;

import android.content.Context;

import com.example.attila.mobilszoftlab.di.Network;
import com.example.attila.mobilszoftlab.repository.Repository;
import com.example.attila.mobilszoftlab.repository.SugarOrmRepository;
import com.example.attila.mobilszoftlab.ui.list.BookListActivity;
import com.example.attila.mobilszoftlab.ui.list.BookListPresenter;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public BookListActivity provideBookListActivity() {
        return new BookListActivity();
    }

    @Provides
    @Singleton
    public BookListPresenter provideBookListPresenter() {
        return new BookListPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    @Network
    public Executor provideNetworkExecutor() {
        return Executors.newFixedThreadPool(1);
    }
}
