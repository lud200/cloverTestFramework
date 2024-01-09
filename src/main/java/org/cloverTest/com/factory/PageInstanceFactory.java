package org.cloverTest.com.factory;

import org.cloverTest.com.context.WebDriverContext;
import org.cloverTest.com.pages.BasePage;
import org.openqa.selenium.WebDriver;
import java.lang.reflect.InvocationTargetException;

/**
 * A factory for creating PageInstances objects.
 *
 *
 * @author UdayaDuvvuri
 */
public class PageInstanceFactory {
    public static <T extends BasePage> T getInstance(Class<T> type) {
        try {
            return type.getConstructor(WebDriver.class).newInstance(WebDriverContext.getDriver());
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException |
                 InvocationTargetException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
            return null;
        }
    }
}
