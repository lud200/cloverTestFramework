package org.cloverTest.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(id = "APjFqb")
    private WebElement searchGoogle;

    @FindBy(xpath = "//*[@id=\"sb_form_q\"]")
    private WebElement searchBing;

    @FindBy(id = "text")
    private WebElement searchYandex;

    /**
     * Enter text into Google Search box
     */
    public void enterGoogleSearchText(String googleSearchText) {
        searchGoogle.sendKeys(googleSearchText);
    }

    /**
     * Enter text into Bing Search box
     */
    public void enterBingSearchText(String bingSearchText) {
        searchBing.sendKeys(bingSearchText);
    }

    /**
     * Enter text into Yahoo Search box
     */
    public void enterYandexSearchText(String yandexSearchText) {
        searchYandex.sendKeys(yandexSearchText);
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
