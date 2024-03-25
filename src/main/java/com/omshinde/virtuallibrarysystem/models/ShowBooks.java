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
        System.out.println("Availability: " + (book.getNoOfCopies() > 0 ? "Available" : "Out of Stock"));
    }

    public void borrowByISBN(){
        System.out.println("Enter ISBN : ");
        String userISBN= scanner.nextLine().trim();

        Book book=library.bookList.getOrDefault(userISBN,null);

        if(book==null){
            System.out.println("No book found for "+userISBN+" ISBN");
        }else{
            System.out.println("Title : "+book.getTitle());
            System.out.println("Do you want to borrow the Book? [s/n] : ");
            String choice=scanner.nextLine().trim().toLowerCase();

            if(choice.equals("s")){
                if(book.getNoOfCopies()>=1) {
                    System.out.println(book.getTitle() + " Book Borrowed ✅ ");
                    book.setNoOfCopies(book.getNoOfCopies() - 1);
                }else{
                    System.err.println("Book out of Stock");
                }
            }else if (choice.equals("n")){
                System.out.println("Borrow Canceled ");
            }else{
                System.out.println("Invalid Input.");
            }

        }
    }

}
