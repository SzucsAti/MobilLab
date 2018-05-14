package com.example.attila.mobilszoftlab.utils;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;

import com.example.attila.mobilszoftlab.AndroidTestComponent;
import com.example.attila.mobilszoftlab.AndroidTestModule;
import com.example.attila.mobilszoftlab.BookApplication;
import com.example.attila.mobilszoftlab.BookApplicationComponent;
//import com.example.attila.mobilszoftlab.DaggerAndroidTestComponent;
import com.example.attila.mobilszoftlab.DaggerBookApplicationComponent;
import com.example.attila.mobilszoftlab.ui.UIModule;

public class AndroidTestUtils {

    /*
    public static void setTestInjector() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        BookApplication app = (BookApplication) instrumentation.getTargetContext()
                .getApplicationContext();

        AndroidTestComponent androidTestComponent = DaggerAndroidTestComponent.builder().androidTestModule(new AndroidTestModule(app)).build();
        app.injector = androidTestComponent;
    }
    */

    public static void setProdutionInjector() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        BookApplication app = (BookApplication) instrumentation.getTargetContext()
                .getApplicationContext();

        BookApplicationComponent androidTestComponent = DaggerBookApplicationComponent.builder().uIModule(new UIModule(app)).build();
        app.injector = androidTestComponent;
    }
}
