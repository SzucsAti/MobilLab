package com.example.attila.mobilszoftlab.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BooksResult   {

    @SerializedName("count")
    private Integer count = null;

    @SerializedName("books")
    private List<Book> books = new ArrayList<Book>();


    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }


}
