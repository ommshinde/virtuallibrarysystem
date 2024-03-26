package com.omshinde.virtuallibrarysystem.models;

import java.util.List;
import java.util.Scanner;

public class ShowBooks {
    private Library library;
    private Scanner scanner;

    public ShowBooks(Library library){
        this.library=library;
        this.scanner=new Scanner(System.in);
    }

    public void searchBook(String search){

        List<Book> searchResult=library.searchBooksByAttribute("title", search);

        if(searchResult.isEmpty()){
            System.out.println("No Books Found for " +search);
            return;
        }

        displaySearchResults(searchResult);

        // Prompt user to select a book for more details
        System.out.print("Enter the book number for more details: ");
        int selectedBookIndex = scanner.nextInt();

        // Display complete details of the selected book
        if (selectedBookIndex >= 0 && selectedBookIndex < searchResult.size()) {
            Book selectedBook = searchResult.get(selectedBookIndex);
            displayBookDetails(selectedBook);
        } else {
            System.out.println("Invalid book number.");
        }
    }

    private void displaySearchResults(List<Book> searchResults) {
        System.out.println("Search Results:");
        for (int i = 0; i < searchResults.size(); i++) {
            Book book = searchResults.get(i);
            System.out.println((i) + ". " + book.getTitle() + " by " + book.getAuthor());
        }
    }

    private void displayBookDetails(Book book) {
        System.out.println("Book Details:");
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("ISBN: " + book.getISBN());
        System.out.println("Genre: " + book.getGenre());
        System.out.println("Publication Date: " + book.getPublicationDate());
        System.out.println("Number of Copies: " + book.getNoOfCopies());
        if (book.getNoOfCopies() == 0) {
            System.out.println("Availability: Out of Stock");
        } else {
            System.out.println("Availability: Available");
        }
    }

}
