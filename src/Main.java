
import java.util.Scanner;
import models.Transaction;
import services.FinanceManager;
import services.ReportService;
import utils.FilePersistence;

public class Main {
    public static void main(String[] args) {
        FinanceManager financeManager = FinanceManager.getInstance();
        FilePersistence filePersistence = new FilePersistence();
        ReportService reportService = new ReportService();  
        reportService.startMonthlyReport();  

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n Personal Finance Manager");
                System.out.println("1. Add Transaction");
                System.out.println("2. View Transactions");
                System.out.println("3. Delete Transaction");
                System.out.println("4. View Total Income");
                System.out.println("5. View Total Expenses");
                System.out.println("6. Generate Monthly Report");
                System.out.println("7. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Date (YYYY-MM-DD): ");
                        String date = scanner.nextLine();
                        System.out.print("Enter Amount: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Enter Category (income/expense): ");
                        String category = scanner.nextLine();
                        System.out.print("Enter Description: ");
                        String description = scanner.nextLine();

                        Transaction transaction = new Transaction(id, date, amount, category, description);
                        financeManager.addTransaction(transaction);
                    }
                    case 2 -> {
                        System.out.println("\n Transactions:");
                        for (Transaction t : financeManager.viewAllTransactions()) {
                            System.out.println(t);
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter Transaction ID to delete: ");
                        int deleteId = scanner.nextInt();
                        financeManager.deleteTransaction(deleteId);
                    }
                    case 4 -> System.out.println("Total Income: Rs. " + financeManager.getTotalIncome());
                    case 5 -> System.out.println(" Total Expenses: Rs. " + financeManager.getTotalExpenses());
                    case 6 -> {
                        System.out.println("\n Monthly Financial Report:");
                        System.out.println(" Total Income: Rs. " + financeManager.getTotalIncome());
                        System.out.println(" Total Expenses: Rs. " + financeManager.getTotalExpenses());
                        System.out.println(" Net Balance: Rs. " + 
                            (financeManager.getTotalIncome() - financeManager.getTotalExpenses()));
                    }
                    case 7 -> {
                        System.out.println("🔚 Exiting...");
                        filePersistence.saveTransactionsToFile(financeManager.viewAllTransactions());
                        reportService.stopReportService(); 
                        return;
                    }
                    default -> System.out.println(" Invalid option! Please try again.!");
                }
            }
        }
    }
}
