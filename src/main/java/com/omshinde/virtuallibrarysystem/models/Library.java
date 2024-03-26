package com.omshinde.virtuallibrarysystem.models;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    HashMap<String, Book> bookList=new HashMap<>();
    private int addedBook=0, skippedBook=0;

    public boolean addBook(Book book){
        if(!bookList.containsKey(book.getISBN())){
            bookList.put(book.getISBN(), book);
            addedBook++;
            return true;
        }
        skippedBook++;
        return false;
    }
    public boolean isISBNUnique(String ISBN){
        return !bookList.containsKey(ISBN);
    }

    public String status(){
        return "No of Books added : "+addedBook+" & no of Books skipped : "+skippedBook;
    }

    public List<Book> searchByTitle(String title) {
        return bookList.values().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    public List<Book> searchByAuthor(String author) {
        return bookList.values().stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Book> searchByISBN(String ISBN) {
        return bookList.values().stream()
                .filter(book -> book.getISBN().equalsIgnoreCase(ISBN))
                .collect(Collectors.toList());
    }

    public List<Book> searchByPublicationDate(LocalDate publicationDate) {
        return bookList.values().stream()
                .filter(book -> book.getPublicationDate().equals(publicationDate))
                .collect(Collectors.toList());
    }

    public List<Book> searchBooksByAttribute(String attribute, String criteria) {
        List<Book> matchingBooks = new ArrayList<>();

        switch (attribute.toLowerCase()) {
            case "title":
                matchingBooks = searchByTitle(criteria);
                break;
            case "author":
                matchingBooks = searchByAuthor(criteria);
                break;
            case "isbn":
                matchingBooks = searchByISBN(criteria);
                break;
            case "publicationdate":
                matchingBooks = searchByPublicationDate(LocalDate.parse(criteria));
                break;
            default:
                break;
        }

        return matchingBooks;
    }

    private String generateSearchResultMessage(List<Book> matchingBooks, String attribute, String criteria) {
        if (matchingBooks.isEmpty()) {
            return "No books found with the " + attribute + ": " + criteria;
        } else {
            return matchingBooks.toString();
        }
    }
//    public List<Book> searchBook(String search){
//        List<Book> booksFound=new ArrayList<>();
//        String lowerCaseSearch=search.toLowerCase();
//        LocalDate searchDate= LocalDate.parse(search);
//
//        for(Book book:bookList.values()){
//            String title=book.getTitle().toLowerCase();
//            String author=book.getAuthor().toLowerCase();
//            String ISBN=book.getISBN().toLowerCase();
//            String genre= book.getGenre().toLowerCase();
//            String copies= String.valueOf(book.getNoOfCopies());
//            LocalDate publicationDate=book.getPublicationDate();
//
//            if(title.contains(search.toLowerCase())||author.contains(search.toLowerCase())||ISBN.contains(search.toLowerCase())||genre.contains(search.toLowerCase())||copies.contains(search)){
//                booksFound.add(book);
//            }
//        }
//
//        if (booksFound.isEmpty()){
//            System.out.println("No books found.");
//        }
//        return booksFound;
//    }

    
}
