import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import pom.AccountProfilePage;
import pom.LoginPage;
import pom.MainPage;
import pom.RegisterPage;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class PassageToMyAccountTest extends BaseTest {
    String name = RandomStringUtils.randomAlphabetic(5);
    String email = String.format(RandomStringUtils.randomAlphabetic(5) + "@yandex.ru");
    String password = RandomStringUtils.randomAlphabetic(6);


    @Test
    @DisplayName("Passage to my account with authorization")
    public void passageToMyAccountWithAuthorizationTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        sleep(1000);
        mainPage.waitClickable(mainPage.getButtonMyAccount()).clickLoginButton(mainPage.getButtonMyAccount());
        LoginPage loginPage = new LoginPage(driver);
        sleep(1000);
        loginPage.waitClickable(loginPage.getButtonRegisterLink()).clickRegister();
        RegisterPage registerPage = new RegisterPage(driver);
        //Создание пользователя
        sleep(1000);
        registerPage.waitClickable(registerPage.getInputName()).typeInput(registerPage.getInputName(), name)
                .clickElement(registerPage.getInputEmail()).typeInput(registerPage.getInputEmail(), email)
                .clickElement(registerPage.getInputPassword()).typeInput(registerPage.getInputPassword(), password)
                .clickRegister();
        //ввод почты и пароля на странице Логин
        sleep(1000);
        loginPage.waitClickable(loginPage.getInputEmail()).clickElement(loginPage.getInputEmail())
                .typeInput(loginPage.getInputEmail(), email)
                .clickElement(loginPage.getInputPassword()).typeInput(loginPage.getInputPassword(), password)
                .clickEnter();
        sleep(1000);
        mainPage.waitClickable(mainPage.getButtonMyAccount())
                .clickLoginButton(mainPage.getButtonMyAccount());
        //Заходим в Личный кабинет
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        sleep(1000);
        String actual = accountProfilePage.waitClickable(accountProfilePage.getSignPersonalInformation())
                .getElementText(accountProfilePage.getSignPersonalInformation());
        String expected = "В этом разделе вы можете изменить свои персональные данные";
        assertEquals(actual, expected);
    }
}
