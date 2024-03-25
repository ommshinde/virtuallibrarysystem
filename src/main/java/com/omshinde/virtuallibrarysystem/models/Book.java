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
//    public Book(String title, String author, String ISBN, String genre, LocalDate publicationDate){
//        this(title, author, ISBN, genre, publicationDate, 100);
//    }
//
//    public Book(String title, String author, String ISBN, String genre){
//        this(title, author, ISBN, genre, LocalDate.now(), 100);
//    }
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
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

    public LocalDate getPublicationDate() {
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
