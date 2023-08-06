package listeners;

import com.codeborne.selenide.Selenide;
import com.epam.reportportal.service.ReportPortal;
import io.qameta.allure.Allure;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Calendar;

import static org.openqa.selenium.OutputType.FILE;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        ReportPortal.emitLog("Screenshot", "ERROR", Calendar.getInstance().getTime(), Selenide.screenshot(FILE));


//        try {
//            Allure.addAttachment("screenshot", new FileInputStream(Selenide.screenshot(FILE)));
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
