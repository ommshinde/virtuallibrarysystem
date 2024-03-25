package com.omshinde.virtuallibrarysystem.models;
import com.omshinde.virtuallibrarysystem.models.Book;
import java.util.HashMap;
public class Library {
    HashMap<String, Book> bookList=new HashMap<>();

    public boolean addBook(Book book){
        if(!bookList.containsKey(book.getISBN())){
            bookList.put(book.getISBN(), book);
            return true;
        }
        return false;
    }

    public boolean isISBNUnique(String ISBN){
        return !bookList.containsKey(ISBN);
    }
}
