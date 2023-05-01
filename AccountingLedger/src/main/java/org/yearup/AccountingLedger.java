package org.yearup;

import java.util.Scanner;

public class AccountingLedger {
    // Global variables for use in multiple functions
    public Scanner scanner = new Scanner(System.in);
    public TransactionManager transactionManager = new TransactionManager();
    public HashMap<String, List<Transaction>> transactionTypes = new HashMap<>();

    public void run() {
        // Load transactions from the csv file
        transactionManager.loadTransactions();
        // Initialize transaction types
        transactionTypes.put("deposit", new ArrayList<>());
        transactionTypes.put("payment", new ArrayList<>());
        // Start the loop and display the home screen
        homeScreen();
    }
}
