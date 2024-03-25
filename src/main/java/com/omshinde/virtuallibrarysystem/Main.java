package com.omshinde.virtuallibrarysystem;

import com.omshinde.virtuallibrarysystem.models.Book;
import com.omshinde.virtuallibrarysystem.models.Library;
import com.omshinde.virtuallibrarysystem.models.ShowBooks;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library=new Library();

        library.addBook(new Book("Iron Man", "Tony Stark","99898","Fiction", LocalDate.of(2002,8,15), 0));
        library.addBook(new Book("Iron Man", "Tony Stark","99898","Fiction", LocalDate.of(2004,8,15), 150));

//        Scanner sc = new Scanner(System.in);
//        String search=sc.nextLine();
        ShowBooks sb=new ShowBooks(library);
        sb.searchBook("iron man");
    }
}
