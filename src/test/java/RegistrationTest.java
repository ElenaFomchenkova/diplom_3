import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import pom.LoginPage;
import pom.MainPage;
import pom.RegisterPage;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    String name = RandomStringUtils.randomAlphabetic(5);
    String email = String.format(RandomStringUtils.randomAlphabetic(5) + "@yandex.ru");
    String password = RandomStringUtils.randomAlphabetic(6);

    String shortPassword = RandomStringUtils.randomAlphabetic(5);

    @Test
    @DisplayName("Registration of user")
    public void registrationMyAccountTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitClickable(mainPage.getButtonMyAccount()).clickLoginButton(mainPage.getButtonMyAccount());
        LoginPage loginPage = new LoginPage(driver);
        sleep(200);
        loginPage.waitClickable(loginPage.getButtonRegisterLink()).clickRegister();
        RegisterPage registerPage = new RegisterPage(driver);
        sleep(200);
        boolean result = registerPage.waitClickable(registerPage.getInputName()).typeInput(registerPage.getInputName(),
                        name)
                .clickElement(registerPage.getInputEmail()).typeInput(registerPage.getInputEmail(),
                        email)
                .clickElement(registerPage.getInputPassword()).typeInput(registerPage.getInputPassword(),
                        password)
                .clickRegister().isDisplayedEnterSign();
        assertTrue(result);
    }

    @Test
    @DisplayName("Registration not possible with password shorter then 6 chars")
    public void registrationNotPossibleWithShortPassword() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitClickable(mainPage.getButtonMyAccount()).clickLoginButton(mainPage.getButtonMyAccount());
        LoginPage loginPage = new LoginPage(driver);
        sleep(200);
        loginPage.waitClickable(loginPage.getButtonRegisterLink()).clickRegister();
        RegisterPage registerPage = new RegisterPage(driver);
        sleep(200);
        registerPage.waitClickable(registerPage.getInputName()).typeInput(registerPage.getInputName(),
                        email)
                .clickElement(registerPage.getInputPassword()).typeInput(registerPage.getInputPassword(),
                        shortPassword)
                .clickElement(registerPage.getInputEmail()).typeInput(registerPage.getInputEmail(),
                        email);
        String actual = registerPage.getElementText(registerPage.getIncorrectPassword());
        String expected = "Некорректный пароль";
        assertEquals(actual, expected);
    }
}
