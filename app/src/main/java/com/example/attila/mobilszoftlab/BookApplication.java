package com.example.attila.mobilszoftlab;

import android.app.Application;

import com.example.attila.mobilszoftlab.ui.UIModule;

public class BookApplication extends Application {

    public static BookApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerBookApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}
