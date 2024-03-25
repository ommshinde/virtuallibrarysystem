package com.omshinde.virtuallibrarysystem.models;
import com.omshinde.virtuallibrarysystem.models.Book;
import java.util.HashMap;
public class Library {
    HashMap<String, Book> booklist=new HashMap<>();

    public boolean addBook(Book book){
        if(!booklist.containsKey(book.getISBN())){
            booklist.put(book.getISBN(), book);
            return true;
        }
        return false;
    }

    public boolean isISBNUnique(String ISBN){
        return !booklist.containsKey(ISBN);
    }
}
