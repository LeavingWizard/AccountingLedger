package org.yearup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private List<Transaction> transactions;
    private String filePath = "transactions.csv";

    public TransactionManager() {
        transactions = new ArrayList<>();
    }

    public List<Transaction> loadTransactions() {
        List<Transaction> loadedTransactions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                String date = parts[0].trim();
                String time = parts[1].trim();
                String description = parts[2].trim();
                String vendor = parts[3].trim();
                double amount = Double.parseDouble(parts[4].trim());

                Transaction transaction = new Transaction(date, time, description, vendor, amount);
                loadedTransactions.add(transaction);
            }
        } catch (IOException e) {
            System.err.println("Error reading transactions file: " + e.getMessage());
        }

        return loadedTransactions;
    }

    public void saveTransaction(Transaction transaction) {
        transactions.add(transaction);
        // Implement saving transactions to a file or another source
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
