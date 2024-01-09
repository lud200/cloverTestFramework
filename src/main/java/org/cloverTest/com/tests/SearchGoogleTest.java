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

public class SearchGoogleTest extends BaseTest {

    private String url;

    public void loadProperties() throws IOException {

        //Load properties from properties file
        ReportUtil.logMessage("Load properties", "Load properties from config/testLogin.properties file");
        Properties prop = new Properties();
        InputStream stream = Files.newInputStream(Paths.get(Constants.TEST_PROPERTY_FILE_PATH));

        prop.load(stream);
        url = prop.getProperty("googleURL");
    }

    @Test
    public void searchGoogleTest() throws IOException {

        loadProperties();

        ReportUtil.logMessage("Search", "Load the google search page");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        String homePage = driver.getTitle();
        assertEquals("Google", homePage);

        // Load google search page
        ReportUtil.logMessage("Search Text", "Enter Search text clover");
        SearchPage sp = PageInstanceFactory.getInstance(SearchPage.class);
        assert sp != null;
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        sp.enterGoogleSearchText("clover\n");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        ReportUtil.logMessage("Verify Title", "Verify the first search text");
        WebElement searchText = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3"));
        assertEquals(searchText.getText(), "Clover: Credit Card Processing for Small Businesses | POS ...");

        ReportUtil.logMessage("Verify Description", "Verify search description");
        WebElement searchDesc = driver.findElement(By.cssSelector("#rso > div.hlcw0c > div > div > div > div > div > div > div > div.IsZvec > div"));
        String text = "Save time and grow sales with a trusted small business credit card processor. Get a $450 statement credit when you buy Station, Mini, or Flex.";

        assertEquals(searchDesc.getText(), text);
    }
}
