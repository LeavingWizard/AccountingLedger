# 🏦 Accounting Ledger

A command-line interface (CLI) application to track financial transactions for a business or personal use. The application reads transactions from a CSV file named `transactions.csv` and saves them to a list.

## 📸 Application Screens

### 🏠 Main Menu

![Main Menu Screenshot](/Users/leavingwizard/Desktop/MainMenu.png)

The main menu provides options to:

- 📥 Add deposits
- 💳 Make payments
- 📘 View the ledger
- 🚪 Exit the application

### 📖 Ledger Screen

![Ledger Screen Screenshot](/Users/leavingwizard/Desktop/LedgerScreen.png)

The ledger screen displays transactions and provides options to:

- 📋 Filter by deposit
- 💸 Filter by payment

## 💻 Interesting Code

The `TransactionManager` class handles loading transactions from a CSV file and saving them to a list. The `loadTransactions()` method reads the CSV file and creates a list of `Transaction` objects.

```java
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
