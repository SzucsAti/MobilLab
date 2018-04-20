package com.example.attila.mobilszoftlab.interactor;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {
    @Provides
    public BookInteractor provideBookInteractor() {
        return new BookInteractor();
    }
}