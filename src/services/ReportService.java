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
            System.out.println("Generating Monthly Financial Report...");
        }, 0, 30, TimeUnit.DAYS);
    }
}

