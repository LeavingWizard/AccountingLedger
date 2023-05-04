# 📘 Accounting Ledger

A simple console-based accounting ledger application for managing transactions, built using Java. The application allows users to effortlessly track their financial transactions, making it easy to maintain an organized and up-to-date ledger.

![Home Screen](/Users/leavingwizard/Desktop/HomeScreen.png)

## ✨ Features

- 💰 Add deposits
- 📉 Make payments (debits)
- 📖 Display all transactions, deposits, or payments in the ledger
- 🔍 Custom search for transactions based on date, description, vendor, or amount

## 🧩 Interesting Piece of Code

One interesting piece of code in this project is the method for displaying transactions based on the type (All, Deposits, or Payments). It filters transactions and formats the output with appropriate colors for better readability.

```java
private static void displayLedger(String type) {
    System.out.println("\n\033[1mLedger\033[0m");
    System.out.println("---------------------------------------------------------------");

    for (int i = 0; i <= counter; i++) {
        Transaction transaction = transactions.get(i);

        if (type.equals("All") || (type.equals("Deposits") && transaction.getAmount() > 0) || (type.equals("Payments") && transaction.getAmount() < 0)) {
            displayTransaction(transaction);
        }
    }
}
