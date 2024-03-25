package com.omshinde.virtuallibrarysystem.admin;
import com.omshinde.virtuallibrarysystem.models.Book;

import com.omshinde.virtuallibrarysystem.models.Book;

import java.io.*;
import java.time.LocalDate;

public class TransactionLog {
    private static final String LOG_FILE_PATH = "src/main/java/com/omshinde/virtuallibrarysystem/resources/log.txt";

    public static void logTransaction(Book book, String userID) {
        String logMessage = String.format("User %s borrowed book with ISBN %s on %s%n",
                userID, book.getISBN(), LocalDate.now());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {
            writer.write(logMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void displayTransactionLog() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the transaction log: " + e.getMessage());
        }
    }
}
