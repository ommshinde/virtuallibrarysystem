package com.omshinde.virtuallibrarysystem.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

public class ReadBook {
    private Library library;

    String filepath, next;
    String[] data;
    public ReadBook(Library library){
        this.library=library;
    }

    public void readCSV(String filepath){
        try(
            BufferedReader br= Files.newBufferedReader(Paths.get(filepath))){
                String next;
                while((next=br.readLine())!=null){
                    data=next.split(",");

                String title=data[0].trim();
                String author=data[1].trim();
                String ISBN=data[2].trim();
                String genre=data[3].trim();
                LocalDate publicationDate=LocalDate.parse((data[4].trim()));
                int noOfCopies=Integer.parseInt(data[5].trim());

                Book book=new Book(title, author, ISBN, genre, publicationDate, noOfCopies);

                if(library.addBook(book)){
                    System.out.println("Book Added with Title - "+book.getTitle());
                }else{
                    System.err.println("Duplicate ISBN found!!! - "+book.getISBN());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
