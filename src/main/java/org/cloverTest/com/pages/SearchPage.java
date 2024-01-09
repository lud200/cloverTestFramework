package org.cloverTest.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

    @FindBy(id = "APjFqb")
    private WebElement searchGoogle;

    @FindBy(xpath = "//*[@id=\"sb_form_q\"]")
    private WebElement searchBing;

    /**
     * Enter text into Google Search box
     *
     * @param fName
     */
    public SearchPage enterGoogleSearchText(String fName) {
        searchGoogle.sendKeys(fName);
        return this;
    }

    /**
     * Enter text into Bing Search box
     *
     * @param fName
     */
    public SearchPage enterBingSearchText(String fName) {
        searchBing.sendKeys(fName);
        return this;
    }

    /**
     * Instantiates a new base page.
     *
     * @param driver the driver
     */
    public SearchPage(WebDriver driver) {
        super(driver);
    }
}
