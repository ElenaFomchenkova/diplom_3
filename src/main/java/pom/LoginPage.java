package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//*[text()='Конструктор']")
    //Кнопка Конструктор (на чердаке)
    private WebElement buttonConstructor;

    @FindBy(xpath = ".//*[@class='AppHeader_header__logo__2D0X2']")
    //Логотип stellarburgers
    private WebElement stellarburgersLogo;

    @FindBy(xpath = ".//input[@name = 'name']")
    //Поле Email
    private WebElement inputEmail;

    @FindBy(xpath = ".//input[@name = 'Пароль']")
    //Поле Пароль
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[@class= 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    //Кнопка войти
    private WebElement buttonEnter;

    @FindBy(xpath = ".//a[text()='Зарегистрироваться']")
    //Зарегистрироваться
    private WebElement buttonRegisterLink;

    @FindBy(xpath = ".//a[text()='Восстановить пароль']")
    //Восстановить пароль
    private WebElement buttonRestorePassword;

    @FindBy(xpath = ".//*[text()='Вход']")
    //Надпись вход
    private WebElement signEnter;

    public LoginPage waitClickable(WebElement element){ //ждем, пока элемент станет кликабельным
        new WebDriverWait(driver, Duration.ofSeconds(600))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public LoginPage typeInput(WebElement element, String value) {
        element.sendKeys(value);
        return this;
    }

    public MainPage clickEnter() {
        buttonEnter.click();
        return new MainPage(driver);
    }

    public RegisterPage clickRegister() {
        buttonRegisterLink.click();
        return new RegisterPage(driver);
    }

    public MainPage clickBurger() {
        stellarburgersLogo.click();
        return new MainPage(driver);
    }

    public LoginPage clickElement(WebElement element){ //клик на любой веб.элемент
        element.click();
        return this;
    }

    public RestoreForgotedPasswordPage clickRestorePassword() {
        buttonRestorePassword.click();
        return new RestoreForgotedPasswordPage(driver);
    }

    public boolean isDisplayedEnterSign(){
        return getSignEnter().isDisplayed();
    }

    public WebElement getButtonConstructor() {
        return buttonConstructor;
    }

    public WebElement getStellarburgersLogo() {
        return stellarburgersLogo;
    }

    public WebElement getInputEmail() {
        return inputEmail;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getButtonEnter() {
        return buttonEnter;
    }

    public WebElement getButtonRegisterLink() {
        return buttonRegisterLink;
    }

    public WebElement getButtonRestorePassword() {
        return buttonRestorePassword;
    }

    public WebElement getSignEnter() {
        return signEnter;
    }

}
