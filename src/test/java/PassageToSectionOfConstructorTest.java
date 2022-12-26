import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pom.MainPage;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class PassageToSectionOfConstructorTest extends BaseTest {
    @Test
    @DisplayName("Passage to section Sauce of Constructor")
    public void passageToSectionSauceTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        sleep(1000);
        mainPage.waitClickable(mainPage.getSauceNonActiveCondition())
                .clickElement(mainPage.getSauceNonActiveCondition());
        sleep(1000);
        boolean result = mainPage.getSauceInActiveCondition().isDisplayed();
        assertTrue(result);
    }

    @Test
    @DisplayName("Passage to section Fillings of Constructor")
    public void passageToSectionFillingsTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        sleep(1000);
        mainPage.waitClickable(mainPage.getFillingsNonActiveCondition())
                .clickElement(mainPage.getFillingsNonActiveCondition());
        sleep(1000);
        boolean result = mainPage.getFillingsInActiveCondition().isDisplayed();
        assertTrue(result);
    }

    @Test
    @DisplayName("Passage to section Buns of Constructor")
    public void passageToSectionBunsTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        sleep(1000);
        mainPage.waitClickable(mainPage.getFillingsNonActiveCondition())
                .clickElement(mainPage.getFillingsNonActiveCondition())
                .waitClickable(mainPage.getBunsNonActiveCondition())
                .clickElement(mainPage.getBunsNonActiveCondition())
                .waitClickable(mainPage.getBunsInActiveCondition());
        sleep(1000);
        boolean result = mainPage.getBunsInActiveCondition().isDisplayed();
        assertTrue(result);
    }
}
