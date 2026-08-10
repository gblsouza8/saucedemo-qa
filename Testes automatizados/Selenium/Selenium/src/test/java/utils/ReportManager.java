package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {
    private static ExtentReports extent;

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("target/RelatorioTestes.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

    public static void finalizarRelatorio() {
        if (extent != null) {
            extent.flush();
        }
    }
}