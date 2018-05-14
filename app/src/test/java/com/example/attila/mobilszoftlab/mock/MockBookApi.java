package com.example.attila.mobilszoftlab.mock;

import com.example.attila.mobilszoftlab.model.Book;
import com.example.attila.mobilszoftlab.model.BooksResult;
import com.example.attila.mobilszoftlab.network.book.BookApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

public class MockBookApi implements BookApi {
    @Override
    public Call<BooksResult> getBooks() {
        final BooksResult booksResult=new BooksResult();
        ArrayList<Book> books = new ArrayList<Book>();

        Book b1 = new Book();
        b1.setIsbn(10);
        b1.setAuthor("NewAuthor1");
        b1.setTitle("NewTitle1");

        Book b2 = new Book();
        b2.setIsbn(10);
        b2.setAuthor("NewAuthor2");
        b2.setTitle("NewTitle2");

        books.add(b1);
        books.add(b2);

        booksResult.setBooks(books);
        booksResult.setCount(books.size());

        Call<BooksResult> call=new Call<BooksResult>() {
            @Override
            public Response<BooksResult> execute() throws IOException {
                return Response.success(booksResult);
            }

            @Override
            public void enqueue(Callback<BooksResult> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<BooksResult> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };

        return call;
    }

    @Override
    public Call<Void> addBook(Book body) {
        return null;
    }

    @Override
    public Call<List<Book>> getBook(Integer isbn) {
        return null;
    }

    @Override
    public Call<Book> deleteBook(Integer isbn) {
        return null;
    }
}
