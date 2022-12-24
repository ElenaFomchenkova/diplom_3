import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import pom.AccountProfilePage;
import pom.LoginPage;
import pom.MainPage;
import pom.RegisterPage;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class PassageFromMyAccountToConstructorTest extends BaseTest{

    String name = RandomStringUtils.randomAlphabetic(5);
    String email = String.format(RandomStringUtils.randomAlphabetic(5) + "@yandex.ru");
    String password = RandomStringUtils.randomAlphabetic(6);


    @Test
    @DisplayName("Passage from my account to constructor")
    public void passageFromMyAccountToConstructorTest() throws InterruptedException {
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
        sleep(200);
        mainPage.waitClickable(mainPage.getButtonMyAccount())
                .clickLoginButton(mainPage.getButtonMyAccount());
        //Заходим в Личный кабинет
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        sleep(200);
        accountProfilePage.waitClickable(accountProfilePage.getConstructorLink())
                //клик по кнопке Конструктор
                .clickElement(loginPage.getButtonConstructor());
        String actual = mainPage.getElementText(mainPage.getButtonCreateOrder());
        String expected = "Оформить заказ";
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Passage from my account to Stellar Logo")
    public void passageFromMyAccountToStellarBurgersLogoTest() throws InterruptedException {
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
        sleep(200);
        mainPage.waitClickable(mainPage.getButtonMyAccount())
                .clickLoginButton(mainPage.getButtonMyAccount());
        //Заходим в Личный кабинет
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        sleep(200);
        accountProfilePage.waitClickable(accountProfilePage.getStellarburgersLogo())
                //клик по лого бургеров
                .clickElement(loginPage.getStellarburgersLogo());
        String actual = mainPage.getElementText(mainPage.getButtonCreateOrder());
        String expected = "Оформить заказ";
        assertEquals(actual, expected);
    }
}
