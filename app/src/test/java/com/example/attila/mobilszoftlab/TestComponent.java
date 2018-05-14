package com.example.attila.mobilszoftlab;

import com.example.attila.mobilszoftlab.interactor.InteractorModule;
import com.example.attila.mobilszoftlab.mock.MockNetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class})
public interface TestComponent extends BookApplicationComponent {
}
