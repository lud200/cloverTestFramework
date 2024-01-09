package org.cloverTest.com.tests;

import org.cloverTest.com.context.WebDriverContext;
import org.cloverTest.com.listeners.LogListener;
import org.cloverTest.com.listeners.ReportListener;
import org.cloverTest.com.util.LoggerUtil;
import org.cloverTest.com.util.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Every test class should extend this class.
 *
 * @author UdayaDuvvuri
 * */

@Listeners({ ReportListener.class, LogListener.class })
public class BaseTest {
    protected WebDriver driver;
    /**
     * Global setup.
     */
    @BeforeSuite(alwaysRun = true)
    public void globalSetup() {
        LoggerUtil.log("************************** Test Execution Started ************************************");
        TestProperties.loadAllProperties();
    }

    /**
     * Setup.
     */
    @BeforeClass
    protected void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverContext.setDriver(driver);
    }

    /**
     * Wrap all up.
     *
     * @param context the context
     */
    @AfterSuite(alwaysRun = true)
    public void wrapAllUp(ITestContext context) {
        int total = context.getAllTestMethods().length;
        int passed = context.getPassedTests().size();
        int failed = context.getFailedTests().size();
        int skipped = context.getSkippedTests().size();
        LoggerUtil.log("Total number of testcases : " + total);
        LoggerUtil.log("Number of testcases Passed : " + passed);
        LoggerUtil.log("Number of testcases Failed : " + failed);
        LoggerUtil.log("Number of testcases Skipped  : " + skipped);
    }

    /**
     * Wrap up.
     */
    @AfterClass
    public void wrapUp() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }


}
