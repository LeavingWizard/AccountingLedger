package org.yearup;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountingLedger {
    static Scanner scanner = new Scanner(System.in);
    static TransactionManager transactionManager = new TransactionManager();

    static ArrayList<Transaction> transactions = new ArrayList<>();
    static int counter = 0;

    public static void main(String[] args) {
        loadTransactions();

        while (true) {
            int selection = displayHomeScreen();

            if (selection == 1) {
                addDeposit();
            } else if (selection == 2) {
                makePayment();
            } else if (selection == 3) {
                displayLedgerMenu();
            } else if (selection == 0) {
                System.out.println("Exiting the application...");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void loadTransactions() {
        transactions.addAll(transactionManager.loadTransactions());
        counter = transactions.size() - 1;
    }

    private static int displayHomeScreen() {
        System.out.println("\nHome");
        System.out.println("---------------------------------------------------------------");
        System.out.println("\nWhat do you want to do?");
        System.out.println("1) Add Deposit");
        System.out.println("2) Make Payment (Debit)");
        System.out.println("3) Ledger");
        System.out.println("0) Exit");
        System.out.print("Enter your option: ");
        int selection = scanner.nextInt();
        scanner.nextLine();
        return selection;
    }

    private static void addDeposit() {
        System.out.println("\nAdd Deposit");
        System.out.println("---------------------------------------------------------------");

        System.out.print("Date (yyyy-MM-dd): ");
        String date = scanner.nextLine();
        System.out.print("Time (HH:mm:ss): ");
        String time = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Vendor: ");
        String vendor = scanner.nextLine();
        System.out.print("Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Transaction deposit = new Transaction(date, time, description, vendor, amount);
        transactionManager.saveTransaction(deposit);
        transactions.add(deposit);
        counter++;
    }

    private static void makePayment() {
        System.out.println("\nMake Payment (Debit)");
        System.out.println("---------------------------------------------------------------");

        System.out.print("Date (yyyy-MM-dd): ");
        String date = scanner.nextLine();
        System.out.print("Time (HH:mm:ss): ");
        String time = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Vendor: ");
        String vendor = scanner.nextLine();
        System.out.print("Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Transaction payment = new Transaction(date, time, description, vendor, amount);
        transactionManager.saveTransaction(payment);
        transactions.add(payment);
        counter++;
    }

    private static void displayLedgerMenu() {
        while (true) {
            System.out.println("\nLedger Menu");
            System.out.println("---------------------------------------------------------------");
            System.out.println("1) All - Display all entries");
            System.out.println("2) Deposits - Display only the entries that are deposits");
            System.out.println("3) Payments - Display only the negative entries (or payments)");
            System.out.println("4) Back - Return to the main menu");
            System.out.print("Enter your option: ");
            int selection = scanner.nextInt();
            scanner.nextLine();

            if (selection == 1) {
                displayLedger("All");
            } else if (selection == 2) {
                displayLedger("Deposits");
            } else if (selection == 3) {
                displayLedger("Payments");
            } else if (selection == 4) {
                return;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }


    private static void displayLedger(String type) {
        System.out.println("\nLedger");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i <= counter; i++) {
            Transaction transaction = transactions.get(i);

            if (type.equals("All") || (type.equals("Deposits") && transaction.getAmount() > 0) || (type.equals("Payments") && transaction.getAmount() < 0)) {
                displayTransaction(transaction);
            }
        }
    }

    private static void displayTransaction(Transaction transaction) {
        System.out.printf("%s | %s | %-20s | %-20s | %10.2f\n",
                transaction.getDate(),
                transaction.getTime(),
                transaction.getDescription(),
                transaction.getVendor(),
                transaction.getAmount());
    }
}