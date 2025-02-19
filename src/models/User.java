package models;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private ArrayList<Transaction> transactions= new ArrayList<>() {
        
    };

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.transactions = new ArrayList<>();
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public List<Transaction> getTransactions() { return transactions; }
    public void addTransaction(Transaction transaction) { transactions.add(transaction); }
}

