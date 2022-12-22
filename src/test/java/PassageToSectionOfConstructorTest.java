import org.junit.Test;
import pom.MainPage;

import static org.junit.Assert.assertTrue;

public class PassageToSectionOfConstructor extends BaseTest {
    @Test
    public void passageToSectionSauceTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitClickable(mainPage.getSauceNonActiveCondition())
                .clickElement(mainPage.getSauceNonActiveCondition());
        boolean result = mainPage.getSauceInActiveCondition().isDisplayed();
        assertTrue(result);
    }

    @Test
    public void passageToSectionFillingsTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitClickable(mainPage.getFillingsNonActiveCondition())
                .clickElement(mainPage.getFillingsNonActiveCondition());
        boolean result = mainPage.getFillingsInActiveCondition().isDisplayed();
        assertTrue(result);
    }

    @Test
    public void passageToSectionBunsTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitClickable(mainPage.getFillingsNonActiveCondition())
                .clickElement(mainPage.getFillingsNonActiveCondition())
                .waitClickable(mainPage.getBunsNonActiveCondition())
                .clickElement(mainPage.getBunsNonActiveCondition())
                .waitClickable(mainPage.getBunsInActiveCondition());
        boolean result = mainPage.getBunsInActiveCondition().isDisplayed();
        assertTrue(result);
    }
}
