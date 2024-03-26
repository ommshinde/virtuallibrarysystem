package com.omshinde.virtuallibrarysystem.models;
import com.omshinde.virtuallibrarysystem.admin.TransactionLog;

import java.util.Scanner;

public class Borrow {
    private Library library;
    Scanner scanner=new Scanner(System.in);
    public Borrow(Library library) {
        this.library = library;
    }
    public void borrowByISBN(){
        System.out.println("Enter ISBN : ");
        String userISBN= scanner.nextLine().trim();

        Book book=library.bookList.getOrDefault(userISBN,null);

        if(book==null){
            System.out.println("No book found for "+userISBN+" ISBN");
        }else if(book.getNoOfCopies()>0) {
            System.out.println("Title : " + book.getTitle());
            System.out.println("Do you want to borrow the Book? [s/n] : ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("s")) {
                if (book.getNoOfCopies() >= 1) {
                    System.out.println(book.getTitle() + " Book Borrowed ✅ ");
                    book.setNoOfCopies(book.getNoOfCopies() - 1);
                    TransactionLog.logTransaction(book, "exampleUserID");

                } else {
                    System.err.println("Book out of Stock");
                }
            } else if (choice.equals("n")) {
                System.out.println("Borrow Canceled ");
            } else {
                System.out.println("Invalid Input.");
            }
        }else{
            System.err.println("Book out of Stock");
        }
    }

}
