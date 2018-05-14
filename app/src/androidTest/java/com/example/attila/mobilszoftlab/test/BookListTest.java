package com.example.attila.mobilszoftlab.test;

import android.content.Intent;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.example.attila.mobilszoftlab.ui.list.BookListActivity;
import com.example.attila.mobilszoftlab.utils.EspressoTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.example.attila.mobilszoftlab.utils.AndroidTestUtils.setProdutionInjector;
//import static com.example.attila.mobilszoftlab.utils.AndroidTestUtils.setTestInjector;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class BookListTest extends EspressoTest<BookListActivity> {

    public BookListTest() {
        super(BookListActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        //setTestInjector();

        setProdutionInjector();
        Intent intentBooks = new Intent();
        activityRule.launchActivity(intentBooks);
    }

    @Test
    public void testList() {

    }
}
