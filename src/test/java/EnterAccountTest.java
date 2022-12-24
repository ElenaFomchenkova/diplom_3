import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import pom.LoginPage;
import pom.MainPage;
import pom.RegisterPage;
import pom.RestoreForgotedPasswordPage;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EnterAccountTest extends BaseTest {

    String name = RandomStringUtils.randomAlphabetic(5);
    String email = String.format(RandomStringUtils.randomAlphabetic(5) + "@yandex.ru");
    String password = RandomStringUtils.randomAlphabetic(6);


    @Test
    public void enterAccountTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitClickable(mainPage.getButtonMyAccount()).clickLoginButton(mainPage.getButtonMyAccount());
        LoginPage loginPage = new LoginPage(driver);
        sleep(200);
        loginPage.waitClickable(loginPage.getButtonRegisterLink()).clickRegister();
        RegisterPage registerPage = new RegisterPage(driver);
        //Создание пользователя
        sleep(200);
        registerPage.waitClickable(registerPage.getInputName()).typeInput(registerPage.getInputName(), name)
                .clickElement(registerPage.getInputEmail()).typeInput(registerPage.getInputEmail(), email)
                .clickElement(registerPage.getInputPassword()).typeInput(registerPage.getInputPassword(), password)
                .clickRegister();
        //ввод почты и пароля на странице Логин
        sleep(200);
        loginPage.waitClickable(loginPage.getInputEmail()).clickElement(loginPage.getInputEmail())
                .typeInput(loginPage.getInputEmail(), email)
                .clickElement(loginPage.getInputPassword()).typeInput(loginPage.getInputPassword(), password)
                .clickEnter();
        String actual = mainPage.getElementText(mainPage.getButtonCreateOrder());
        String expected = "Оформить заказ";
        System.out.println(actual);
        assertEquals(actual, expected);
    }

    @Test
    public void enterAccountThroughButtonEnterAccountOnMainPageTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitClickable(mainPage.getButtonMyAccount()).clickLoginButton(mainPage.getButtonMyAccount());
        LoginPage loginPage = new LoginPage(driver);
        sleep(200);
        loginPage.waitClickable(loginPage.getButtonRegisterLink()).clickRegister();
        //Создание пользователя
        RegisterPage registerPage = new RegisterPage(driver);
        sleep(200);
        registerPage.waitClickable(registerPage.getInputName()).typeInput(registerPage.getInputName(), name)
                .clickElement(registerPage.getInputEmail()).typeInput(registerPage.getInputEmail(), email)
                .clickElement(registerPage.getInputPassword()).typeInput(registerPage.getInputPassword(), password)
                .clickRegister();
        sleep(200);
        loginPage.waitClickable(loginPage.getStellarburgersLogo()).clickBurger();
        //Переход на главную страницу
        sleep(200);
        mainPage.waitClickable(mainPage.getButtonEnterAccount()).clickLoginButton(mainPage.getButtonEnterAccount());
        //Переходим по кнопке Войти в аккаунт на главной странице
        sleep(200);
        loginPage.waitClickable(loginPage.getInputEmail()).clickElement(loginPage.getInputEmail())
                .typeInput(loginPage.getInputEmail(), email)
                .clickElement(loginPage.getInputPassword()).typeInput(loginPage.getInputPassword(), password)
                .clickEnter();
        String actual = mainPage.getElementText(mainPage.getButtonCreateOrder());
        String expected = "Оформить заказ";
        assertEquals(actual, expected);
    }

    @Test
    public void enterAccountThroughUpperButtonOnMainPageTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitClickable(mainPage.getButtonMyAccount()).clickLoginButton(mainPage.getButtonMyAccount());
        LoginPage loginPage = new LoginPage(driver);
        sleep(200);
        loginPage.waitClickable(loginPage.getButtonRegisterLink()).clickRegister();
        //Создание пользователя
        RegisterPage registerPage = new RegisterPage(driver);
        sleep(200);
        registerPage.waitClickable(registerPage.getInputName()).typeInput(registerPage.getInputName(), name)
                .clickElement(registerPage.getInputEmail()).typeInput(registerPage.getInputEmail(), email)
                .clickElement(registerPage.getInputPassword()).typeInput(registerPage.getInputPassword(), password)
                .clickRegister();
        sleep(200);
        loginPage.waitClickable(loginPage.getStellarburgersLogo()).clickBurger();
        //Переход на главную страницу
        sleep(200);
        mainPage.waitClickable(mainPage.getButtonMyAccount()).clickLoginButton(mainPage.getButtonMyAccount());
        //Переходим по кнопке Личный кабинет на главной странице
        sleep(200);
        loginPage.waitClickable(loginPage.getInputEmail()).clickElement(loginPage.getInputEmail())
                .typeInput(loginPage.getInputEmail(), email)
                .clickElement(loginPage.getInputPassword()).typeInput(loginPage.getInputPassword(), password)
                .clickEnter();
        String actual = mainPage.getElementText(mainPage.getButtonCreateOrder());
        String expected = "Оформить заказ";
        assertEquals(actual, expected);
    }

    @Test
    public void enterAccountThroughButtonOnRegisterPageTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitClickable(mainPage.getButtonMyAccount()).clickLoginButton(mainPage.getButtonMyAccount());
        LoginPage loginPage = new LoginPage(driver);
        sleep(200);
        loginPage.waitClickable(loginPage.getButtonRegisterLink()).clickRegister();
        //Создание пользователя
        RegisterPage registerPage = new RegisterPage(driver);
        sleep(200);
        registerPage.waitClickable(registerPage.getInputName()).typeInput(registerPage.getInputName(), name)
                .clickElement(registerPage.getInputEmail()).typeInput(registerPage.getInputEmail(), email)
                .clickElement(registerPage.getInputPassword()).typeInput(registerPage.getInputPassword(), password)
                .clickRegister();
        sleep(200);
        loginPage.waitClickable(loginPage.getButtonRegisterLink()).clickRegister();
        //Переход на страницу логин
        sleep(200);
        registerPage.waitClickable(registerPage.getButtonEnter()).clickEnter();
        sleep(200);
        loginPage.waitClickable(loginPage.getInputEmail()).clickElement(loginPage.getInputEmail())
                .typeInput(loginPage.getInputEmail(), email)
                .clickElement(loginPage.getInputPassword()).typeInput(loginPage.getInputPassword(), password)
                .clickEnter();
        String actual = mainPage.getElementText(mainPage.getButtonCreateOrder());
        String expected = "Оформить заказ";
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Enter account through button on restore password page")
    public void enterAccountThroughButtonOnRestorePasswordPageTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitClickable(mainPage.getButtonMyAccount()).clickLoginButton(mainPage.getButtonMyAccount());
        LoginPage loginPage = new LoginPage(driver);
        sleep(200);
        loginPage.waitClickable(loginPage.getButtonRegisterLink()).clickRegister();
        //Создание пользователя
        RegisterPage registerPage = new RegisterPage(driver);
        sleep(200);
        registerPage.waitClickable(registerPage.getInputName()).typeInput(registerPage.getInputName(), name)
                .clickElement(registerPage.getInputEmail()).typeInput(registerPage.getInputEmail(), email)
                .clickElement(registerPage.getInputPassword()).typeInput(registerPage.getInputPassword(), password)
                .clickRegister();
        sleep(200);
        loginPage.waitClickable(loginPage.getButtonRestorePassword()).clickRestorePassword();
        //Переход на страницу восстановления пароля
        RestoreForgotedPasswordPage restoreForgotedPasswordPage = new RestoreForgotedPasswordPage(driver);
        sleep(200);
        restoreForgotedPasswordPage.waitClickable(restoreForgotedPasswordPage.getButtonEnterOnRestorePasswordPage())
                .clickEnter();
        //переходим на страницу логина
        sleep(200);
        loginPage.waitClickable(loginPage.getInputEmail()).clickElement(loginPage.getInputEmail())
                .typeInput(loginPage.getInputEmail(), email)
                .clickElement(loginPage.getInputPassword()).typeInput(loginPage.getInputPassword(), password)
                .clickEnter();
        String actual = mainPage.getElementText(mainPage.getButtonCreateOrder());
        String expected = "Оформить заказ";
        assertEquals(actual, expected);
    }

}
