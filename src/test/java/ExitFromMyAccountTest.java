import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import pom.AccountProfilePage;
import pom.LoginPage;
import pom.MainPage;
import pom.RegisterPage;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExitFromMyAccountTest extends BaseTest{
    String name = RandomStringUtils.randomAlphabetic(5);
    String email = String.format(RandomStringUtils.randomAlphabetic(5) + "@yandex.ru");
    String password = RandomStringUtils.randomAlphabetic(6);


    @Test
    @DisplayName("Exit from my account")
    public void exitFromMyAccountTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        sleep(1000);
        mainPage.waitClickable(mainPage.getButtonMyAccount()).clickLoginButton(mainPage.getButtonMyAccount());
        LoginPage loginPage = new LoginPage(driver);
        sleep(1000);
        loginPage.waitClickable(loginPage.getButtonRegisterLink()).clickRegister();
        RegisterPage registerPage = new RegisterPage(driver);
        sleep(1000);
        //Создание пользователя
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
        accountProfilePage.waitClickable(accountProfilePage.getButtonExit()).clickExit();
        sleep(1000);
        boolean isDisplayedEnter = loginPage.isDisplayedEnterSign();
        assertTrue(isDisplayedEnter);
    }
}
