package services;
import java.util.ArrayList;
import java.util.List;
import models.*;

public class FinanceManager {
    private ArrayList<Transaction> transactions = new ArrayList<>();


    public FinanceManager() {
        this.transactions = new ArrayList<>();
    }

    // Add Transaction
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        System.out.println("Transaction added: " + transaction);
    }

    // Update Transaction
    public void updateTransaction(int id, Transaction updatedTransaction) {
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getId() == id) {
                transactions.set(i, updatedTransaction);
                System.out.println("Transaction updated.");
                return;
            }
        }
        System.out.println("Transaction not found.");
    }

    // View All Transactions
    public List<Transaction> viewAllTransactions() {
        return transactions;
    }

    // Delete Transaction
    public void deleteTransaction(int id) {
        transactions.removeIf(transaction -> transaction.getId() == id);
        System.out.println("Transaction deleted.");
    }

    // Calculate Total Income
    public double getTotalIncome() {
        return transactions.stream()
                .filter(t -> t.getCategory().equalsIgnoreCase("income"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    // Calculate Total Expenses
    public double getTotalExpenses() {
        return transactions.stream()
                .filter(t -> t.getCategory().equalsIgnoreCase("expense"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }
}
