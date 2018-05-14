package com.example.attila.mobilszoftlab.model;

import java.util.Objects;


import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

public class Book extends SugarRecord{

    @SerializedName("isbn")
    private Integer isbn = null;

    @SerializedName("title")
    private String title = null;

    @SerializedName("author")
    private String author = null;

    @SerializedName("publishDate")
    private String publishDate = null;

    @SerializedName("numberOfPages")
    private Integer numberOfPages = null;

    public Book (){
    }

    public Integer getIsbn() {
        return isbn;
    }
    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }


    public String getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }


    public Integer getNumberOfPages() {
        return numberOfPages;
    }
    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn) &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(publishDate, book.publishDate) &&
                Objects.equals(numberOfPages, book.numberOfPages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, author, publishDate, numberOfPages);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Book {\n");

        sb.append("    isbn: ").append(toIndentedString(isbn)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    author: ").append(toIndentedString(author)).append("\n");
        sb.append("    publishDate: ").append(toIndentedString(publishDate)).append("\n");
        sb.append("    numberOfPages: ").append(toIndentedString(numberOfPages)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}


/*
public class Book {
    private String title;
    private String author;
    private String publishDate;
    private int ISBN;
    private int numberOfPages;

    public int getIsbn(){
        return ISBN;
    }
}
*/
