package com.omshinde.virtuallibrarysystem;
import com.omshinde.virtuallibrarysystem.admin.TransactionLog;
import com.omshinde.virtuallibrarysystem.models.Book;
import com.omshinde.virtuallibrarysystem.models.Borrow;
import com.omshinde.virtuallibrarysystem.models.Library;
import com.omshinde.virtuallibrarysystem.models.ShowBooks;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library=new Library();
        library.addBook(new Book("Iron Man", "Tony Stark","99898","Fiction", LocalDate.of(2002,8,15), 0));
        library.addBook(new Book("Spider Man", "Peter Parker","9998","Fiction", LocalDate.of(2004,8,15), 150));

        ShowBooks sb=new ShowBooks(library);

        Borrow b=new Borrow(library);

        TransactionLog.displayTransactionLog();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Main Menu:");
            System.out.println("1. Search for a book");
            System.out.println("2. Borrow a book");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the Title to Search : ");
                    String search=scanner.nextLine();
                    sb.searchBook(search);
                    break;
                case 2:
                    b.borrowByISBN();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }
    }
}
