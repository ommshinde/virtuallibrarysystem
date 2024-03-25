package com.omshinde.virtuallibrarysystem.admin;
import com.omshinde.virtuallibrarysystem.models.Book;

import com.omshinde.virtuallibrarysystem.models.Book;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
}
