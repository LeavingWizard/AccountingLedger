package org.yearup;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AccountingLedger {
    static Scanner scanner = new Scanner(System.in);
    static TransactionManager transactionManager = new TransactionManager();
    static HashMap<String, List<Transaction>> transactionTypes = new HashMap<>();

    public static void main(String[] args) {
        transactionManager.loadTransactions();
        transactionTypes.put("deposit", new ArrayList<>());
        transactionTypes.put("payment", new ArrayList<>());

        while (true) {
            int selection = displayHomeScreen();

            if (selection == 1) {
                addDeposit();
            } else if (selection == 2) {
                makePayment();
            } else if (selection == 3) {
                displayLedger();
            } else if (selection == 0) {
                System.out.println("Exiting the application...");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
