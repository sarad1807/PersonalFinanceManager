package utils;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import models.Transaction;

public class FilePersistence {
    public void saveTransactionsToFile(List<Transaction> transactions) {
        try (FileWriter writer = new FileWriter("transactions.txt")) {
            for (Transaction transaction : transactions) {
                writer.write(transaction.toString() + "\n");
            }
            System.out.println(" Transactions saved to file successfully.");
        } catch (IOException e) {
            System.err.println(" Error: Unable to save transactions to file - " + e.getMessage());
        }
    }
}

