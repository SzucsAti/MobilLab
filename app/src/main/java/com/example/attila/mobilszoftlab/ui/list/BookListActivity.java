package com.example.attila.mobilszoftlab.ui.list;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.attila.mobilszoftlab.BookApplication;
import com.example.attila.mobilszoftlab.R;
import com.example.attila.mobilszoftlab.model.Book;
import com.example.attila.mobilszoftlab.ui.details.BookDetailsActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crash.FirebaseCrash;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class BookListActivity extends AppCompatActivity implements BookListScreen, MyRecyclerViewAdapter.ItemClickListener, CreateBookDialogFragment.IBookCreateFragment{

    public MyRecyclerViewAdapter adapter;

    private FirebaseAnalytics mFirebaseAnalytics;

    @Inject
    BookListPresenter bookListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        BookApplication.injector.inject(this);

        FirebaseCrash.log("Activity created");
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayoutList);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                bookListPresenter.getBooks();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateBookDialogFragment fragment = new CreateBookDialogFragment();
                android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
                fragment.show(fm,CreateBookDialogFragment.TAG);
            }
        });
    }

    //@Override
    public void onItemClick(View view, int position) {
        toDetails(adapter.getItem(position));
    }

    @Override
    public boolean onItemLongClick(View view, int position) {
        bookListPresenter.getPopupMenu(view, position, adapter.getItem(position));
        return true;
    }


    @Override
    protected void onStart() {
        super.onStart();
        bookListPresenter.attachScreen(this);


        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "1");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Started");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        bookListPresenter.getBooks();
    }

    @Override
    protected void onStop() {
        super.onStop();
        bookListPresenter.detachScreen();
    }


    @Override
    public void showBooks(List<Book> books) {

        if (adapter==null) {
            // set up the RecyclerView
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new MyRecyclerViewAdapter(this, books);
            adapter.setClickListener(this);
            recyclerView.setAdapter(adapter);
        }
        if (adapter.getItemCount() == 0){
            for (Book book: books) {
                adapter.addItem(book);
            }
        }

        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayoutList);
        swipeRefreshLayout.setRefreshing(false);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void createBook(Book book) {
        adapter.addItem(book);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void deleteBook(int position) {
        adapter.removeItem(position);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void toDetails(Book book) {
        Intent intent = new Intent(this, BookDetailsActivity.class);
        intent.putExtra("AUTHOR", book.getAuthor());
        intent.putExtra("ISBN", book.getIsbn().toString());
        intent.putExtra("TITLE", book.getTitle());
        intent.putExtra("PUBLISHDATE", book.getPublishDate());
        intent.putExtra("NUMBEROFPAGES", book.getNumberOfPages().toString());
        startActivity(intent);
    }

    @Override
    public void onBookCreated(Book newBook) {
        bookListPresenter.addBook(newBook);
    }
}


