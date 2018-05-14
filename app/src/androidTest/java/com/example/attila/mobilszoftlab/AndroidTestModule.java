package com.example.attila.mobilszoftlab;

import android.content.Context;

import com.example.attila.mobilszoftlab.di.Network;
import com.example.attila.mobilszoftlab.ui.list.BookListPresenter;
import com.example.attila.mobilszoftlab.ui.UIModule;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidTestModule {

    private final UIModule UIModule;

    public AndroidTestModule(Context context) {

        this.UIModule = new UIModule(context);
    }

    @Provides
    public Context provideContext() {
        return UIModule.provideContext();
    }

    @Provides
    @Singleton
    public BookListPresenter provideBookListPresenter() {
        return UIModule.provideBookListPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return UIModule.provideEventBus();
    }

    @Provides
    @Singleton
    @Network
    public Executor provideNetworkExecutor() {
        return UIModule.provideNetworkExecutor();
    }

}
