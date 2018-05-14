package com.example.attila.mobilszoftlab.test;

import com.example.attila.mobilszoftlab.BuildConfig;
import com.example.attila.mobilszoftlab.ui.list.BookListPresenter;
import com.example.attila.mobilszoftlab.ui.list.BookListScreen;
import com.example.attila.mobilszoftlab.utils.RobolectricDaggerTestRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;

import static com.example.attila.mobilszoftlab.TestHelper.setTestInjector;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class BooksTest {

    private BookListPresenter bookListPresenter;
    private BookListScreen bookListScreen;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        bookListScreen = mock(BookListScreen.class);
        bookListPresenter = new BookListPresenter();
        bookListPresenter.attachScreen(bookListScreen);
    }

    @Test
    public void testBooks() {

        bookListPresenter.getBooks();

        ArgumentCaptor<List> artistCaptor = ArgumentCaptor.forClass(
                List.class);
        verify(bookListScreen).showBooks(artistCaptor.capture());
        assertTrue(artistCaptor.getValue().size() > 0);
    }



    @After
    public void tearDown() {
        bookListPresenter.detachScreen();
    }

}
