package com.example.attila.mobilszoftlab.test;

import android.content.Intent;
import android.support.test.espresso.action.ViewActions;
//import android.support.test.espresso.contrib.RecyclerViewActions;

import com.example.attila.mobilszoftlab.ui.list.BookListActivity;
import com.example.attila.mobilszoftlab.utils.ElapsedTimeIdlingResource;
import com.example.attila.mobilszoftlab.utils.EspressoTest;

import org.junit.Before;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.example.attila.mobilszoftlab.utils.AndroidTestUtils.setProdutionInjector;

public class BookDetailsTest  extends EspressoTest<BookListActivity> {

    public BookDetailsTest() {
        super(BookListActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        setProdutionInjector();
        Intent intent = new Intent();
        activityRule.launchActivity(intent);
    }

    @Test
    public void testItemClick() {
        /*
        ElapsedTimeIdlingResource.waitFor(2000, new ElapsedTimeIdlingResource.Listener() {
            @Override
            public void inIdle() {
                onView(withId(
                        hu.bme.aut.android.spotifydemo.R.id.recyclerViewArtists))
                        .perform(RecyclerViewActions.actionOnItemAtPosition(
                                0, ViewActions.click()));

                onView(withText("http://www.google.hu")).check(matches(isDisplayed()));
            }
        });
        */

    }
}
