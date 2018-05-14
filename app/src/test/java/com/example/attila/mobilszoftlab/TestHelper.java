package com.example.attila.mobilszoftlab;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class TestHelper {

    public static void setTestInjector() {
        ShadowLog.stream = System.out;
        BookApplication application = (BookApplication) RuntimeEnvironment.application;
        //BookApplicationApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        //application.injector = injector;
    }
}
