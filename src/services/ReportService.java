package services;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ReportService {
    private final ScheduledExecutorService scheduler;

    public ReportService() {
        scheduler = Executors.newScheduledThreadPool(1);
    }

    public void startMonthlyReport() {
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("\n [AUTO] Monthly Financial Report:");
            System.out.println(" Total Income: Rs. " + FinanceManager.getInstance().getTotalIncome());
            System.out.println(" Total Expenses: Rs. " + FinanceManager.getInstance().getTotalExpenses());
            System.out.println(" Net Balance: Rs. " + 
                (FinanceManager.getInstance().getTotalIncome() - FinanceManager.getInstance().getTotalExpenses()));
        }, 0, 30, TimeUnit.DAYS);
    }

    public void stopReportService() {
        scheduler.shutdown();
    }
}

