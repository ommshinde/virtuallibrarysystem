package com.omshinde.virtuallibrarysystem.models;
import com.omshinde.virtuallibrarysystem.models.Book;
import java.util.HashMap;
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
}
