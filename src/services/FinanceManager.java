package services;

import java.util.ArrayList;
import java.util.List;
import models.Transaction;

public class FinanceManager {
    private final List<Transaction> transactions;
    private static FinanceManager instance;

    private FinanceManager() {
        transactions = new ArrayList<>();
    }

    
    public static FinanceManager getInstance() {
        if (instance == null) {
            instance = new FinanceManager();
        }
        return instance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> viewAllTransactions() {
        return transactions;
    }
    public void deleteTransaction(int id)
    {
        transactions.removeIf(transaction -> transaction.getId() == id);
        System.out.println("Transaction with ID " + id + " deleted.");
    }
    


    public double getTotalIncome() {
        return transactions.stream()
                .filter(t -> t.getCategory().equalsIgnoreCase("income"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public double getTotalExpenses() {
        return transactions.stream()
                .filter(t -> t.getCategory().equalsIgnoreCase("expense"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }
}
