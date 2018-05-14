package com.example.attila.mobilszoftlab.ui.list;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.attila.mobilszoftlab.R;
import com.example.attila.mobilszoftlab.model.Book;

public class CreateBookDialogFragment extends DialogFragment {

    // Log tag
    public static final String TAG = "BookCreateFragment";

    // UI
    private EditText bookTitle;
    private EditText bookAuthor;
    private EditText bookIsbn;
    private EditText bookNumberOfPages;
    private EditText bookPublishDate;

    // Listener
    private IBookCreateFragment listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (getTargetFragment() != null) {
            try {
                listener = (IBookCreateFragment) getTargetFragment();
            } catch (ClassCastException ce) {
                Log.e(TAG,
                        "Target Fragment does not implement fragment interface!");
            } catch (Exception e) {
                Log.e(TAG, "Unhandled exception!");
                e.printStackTrace();
            }
        } else {
            try {
                listener = (IBookCreateFragment) activity;
            } catch (ClassCastException ce) {
                Log.e(TAG,
                        "Parent Activity does not implement fragment interface!");
            } catch (Exception e) {
                Log.e(TAG, "Unhandled exception!");
                e.printStackTrace();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.createbook, container, false);

        // Dialog cimenek beallitasa
        getDialog().setTitle("Create Book");

        bookTitle = (EditText) root.findViewById(R.id.bookTitle);
        bookAuthor = (EditText) root.findViewById(R.id.bookAuthor);
        bookIsbn = (EditText) root.findViewById(R.id.bookIsbn);
        bookNumberOfPages = (EditText) root.findViewById(R.id.bookNumberOfPages);
        bookPublishDate = (EditText) root.findViewById(R.id.bookPublishDate);

        Button btnOk = (Button) root.findViewById(R.id.btnCreateBook);
        btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (listener != null) {

                    Book b = new Book();
                    if (!bookIsbn.getText().toString().equals("")){
                        b.setIsbn(Integer.parseInt(bookIsbn.getText().toString()));
                    } else{
                        b.setIsbn(0);
                    }
                    if (!bookNumberOfPages.getText().toString().equals("")){
                        b.setNumberOfPages(Integer.parseInt(bookNumberOfPages.getText().toString()));
                    } else{
                        b.setNumberOfPages(0);
                    }

                    b.setAuthor(bookAuthor.getText().toString());
                    b.setTitle(bookTitle.getText().toString());
                    b.setPublishDate(bookPublishDate.getText().toString());

                    listener.onBookCreated(b);
                }

                dismiss();
            }
        });

        Button btnCancel = (Button) root.findViewById(R.id.btnCancelCreateBook);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dismiss();
            }
        });

        return root;
    }

    // Listener interface
    public interface IBookCreateFragment {
        public void onBookCreated(Book newBook);
    }


}