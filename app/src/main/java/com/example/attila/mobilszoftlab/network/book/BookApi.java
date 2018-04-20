package com.example.attila.mobilszoftlab.network.book;

import com.example.attila.mobilszoftlab.model.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.*;


public interface BookApi {

    /**
     * Get all books from the list
     *
     * @return Call<List<Book>>
     */

    @GET("book/")
    Call<List<Book>> getBooks();



    /**
     * Add a new book to the list
     *
     * @param body Book object that needs to be added to the list
     * @return Call<Void>
     */

    @POST("book/")
    Call<Void> addBook(
            @Body Book body
    );


    /**
     * Get an existing book from the list
     *
     * @param isbn Numeric ID of the book
     * @return Call<List<Book>>
     */

    @GET("book/{isbn}")
    Call<List<Book>> getBook(
            @Path("isbn") Integer isbn
    );


    /**
     * Delete an existing book from the list
     *
     * @param isbn Numeric ID of the book
     * @return Call<Book>
     */

    @DELETE("book/{isbn}")
    Call<Book> deleteBook(
            @Path("isbn") Integer isbn
    );


}
