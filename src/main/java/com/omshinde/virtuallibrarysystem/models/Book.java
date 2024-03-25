package com.omshinde.virtuallibrarysystem.models;

import java.time.LocalDate;

public class Book {
    private String title, author, ISBN, genre;
    private LocalDate publicationDate;
    private int noOfCopies;

    public Book(String title, String author, String ISBN, String genre, LocalDate publicationDate, int noOfCopies){
        this.title=title;
        this.author=author;
        this.ISBN=ISBN;
        this.genre=genre;
        this.publicationDate=publicationDate;
        this.noOfCopies=noOfCopies;
    }
    public String getTitle(){
        return title;
    }

    public void setTitle(){
        this.title=title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getpublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getNoOfCopies() {
        return noOfCopies;
    }

    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

}
