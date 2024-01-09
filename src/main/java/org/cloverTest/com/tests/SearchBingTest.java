package org.cloverTest.com.tests;

import org.cloverTest.com.context.Constants;
import org.cloverTest.com.factory.PageInstanceFactory;
import org.cloverTest.com.pages.SearchPage;
import org.cloverTest.com.util.ReportUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

import static org.testng.Assert.*;

public class SearchBingTest extends BaseTest {

    private String url;

    public void loadProperties() throws IOException {

        //Load properties from properties file
        ReportUtil.logMessage("Load properties", "Load properties from config/testLogin.properties file");
        Properties prop = new Properties();
        InputStream stream = Files.newInputStream(Paths.get(Constants.TEST_PROPERTY_FILE_PATH));

        prop.load(stream);
        url = prop.getProperty("bingURL");
    }

    @Test
    public void searchBingTest() throws IOException, InterruptedException {

        loadProperties();

        ReportUtil.logMessage("Search", "Load the bing search page");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        String homePage = driver.getTitle();
        assertEquals("Bing", homePage);

        // Load bing search page
        ReportUtil.logMessage("Search Text", "Enter Search text clover");
        SearchPage sp = PageInstanceFactory.getInstance(SearchPage.class);
        assert sp != null;
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        sp.enterBingSearchText("Clover Network\n");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        ReportUtil.logMessage("Verify Title", "Verify the first search text");
        WebElement searchText = driver.findElement(By.xpath("//*[@id=\"b_results\"]/li[2]/h2/a"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        System.out.println(searchText.getText());
        assertEquals(searchText.getText(), "Credit Card Processing for Small Businesses | POS Solutions");

        ReportUtil.logMessage("Verify Description", "Verify search description");
        WebElement searchDesc = driver.findElement(By.xpath("//*[@id=\"b_results\"]/li[2]/div[3]/p"));
        assertNotNull(searchDesc.getText());
    }
}
