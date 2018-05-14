package com.example.attila.mobilszoftlab.ui.details;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.attila.mobilszoftlab.R;

public class BookDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ActionBar actionBar = getSupportActionBar();

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String author = intent.getStringExtra("AUTHOR");
        String isbn = intent.getStringExtra("ISBN");
        String title = intent.getStringExtra("TITLE");
        String publishDate = intent.getStringExtra("PUBLISHDATE");
        String numberofpages = intent.getStringExtra("NUMBEROFPAGES");

        actionBar.setTitle(author + ": " + title);
        actionBar.setDisplayHomeAsUpEnabled(true);

        TextView authorTextView = findViewById(R.id.textViewAuthor);
        authorTextView.setText(author);

        TextView titleTextView = findViewById(R.id.textViewTitle);
        titleTextView.setText(title);

        TextView publishDateTextView = findViewById(R.id.textViewPublishDate);
        publishDateTextView.setText(publishDate);

        TextView isbnTextView = findViewById(R.id.textViewIsbn);
        isbnTextView.setText(isbn);

        TextView numberOfPagesTextView = findViewById(R.id.textViewNumberOfPages);
        numberOfPagesTextView.setText(numberofpages);
    }
}
