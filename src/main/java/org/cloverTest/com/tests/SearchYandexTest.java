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

import static org.testng.Assert.assertEquals;

public class SearchYandexTest extends BaseTest {

    private String url;

    public void loadProperties() throws IOException {

        //Load properties from properties file
        ReportUtil.logMessage("Load properties", "Load properties from config/testLogin.properties file");
        Properties prop = new Properties();
        InputStream stream = Files.newInputStream(Paths.get(Constants.TEST_PROPERTY_FILE_PATH));

        prop.load(stream);
        url = prop.getProperty("yandexURL");
    }

    @Test
    public void searchYahooTest() throws IOException {

        loadProperties();

        ReportUtil.logMessage("Search", "Load the yandex search page");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        String homePage = driver.getTitle();
        System.out.println(homePage);
        assertEquals("Yandex", homePage);

        // Load search page
        ReportUtil.logMessage("Search Text", "Enter Search text clover");
        SearchPage sp = PageInstanceFactory.getInstance(SearchPage.class);
        assert sp != null;
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        sp.enterYandexSearchText("Clover Network\n");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        ReportUtil.logMessage("Verify Title", "Verify the first search text");
        WebElement searchText = driver.findElement(By.xpath("//*[@id=\"search-result\"]/li[1]/div/div[1]/a/h2/span"));
        assertEquals(searchText.getText(), "Credit Card Processing for Small Businesses | Clover");

        ReportUtil.logMessage("Verify Description", "Verify search description");
        WebElement searchDesc = driver.findElement(By.xpath("//*[@id=\"search-result\"]/li[1]/div/div[3]/div[1]"));
        String text = "Learn more about Clover for restaurants. Easy payments and exchanges Accept credit, debit, gift cards, and contactless payments, plus fast refunds, returns, and exchanges.";

        assertEquals(searchDesc.getText(), text);
    }
}
