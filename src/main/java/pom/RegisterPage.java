package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//label[text()='Имя']/parent::div/input")
    //Поле Имя
    private WebElement inputName;

    @FindBy(xpath = ".//label[text()='Email']/parent::div/input")
    //Поле Email
    private WebElement inputEmail;

    @FindBy(xpath = ".//input[@name='Пароль']")
    //Поле Пароль
    private WebElement inputPassword;

    @FindBy(xpath = ".//p[text()='Некорректный пароль']")
    //Надпись некорректный пароль
    private WebElement incorrectPassword;

    @FindBy(xpath = ".//button[text()='Зарегистрироваться']")
    //Кнопка зарегистрироваться
    private WebElement buttonRegister;

    @FindBy(xpath = ".//a[text()='Войти']")
    //Войти (под кнопкой зарегистрироваться)
    private WebElement buttonEnter;

    @FindBy(xpath = ".//p[text()='Личный Кабинет']")
    //кнопка Личный кабинет
    private WebElement buttonMyAccount;

    public String getElementText(WebElement element){
        return element.getText();
    }

    public RegisterPage waitClickable(WebElement element){ //ждем, пока элемент станет кликабельным
        new WebDriverWait(driver, Duration.ofSeconds(600))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public RegisterPage typeInput(WebElement element, String value) {
        element.sendKeys(value);
        return this;
    }

    public RegisterPage clickElement(WebElement element){ //клик на любой веб.элемент
        element.click();
        return this;
    }

    public LoginPage clickRegister(){ //клик на кнопку Зарегистрироваться
        buttonRegister.click();
        return new LoginPage(driver);
    }

    public LoginPage clickEnter(){ //клик на кнопку Зарегистрироваться
        buttonEnter.click();
        return new LoginPage(driver);
    }

    public WebElement getInputEmail() {
        return inputEmail;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getIncorrectPassword() {
        return incorrectPassword;
    }

    public WebElement getButtonRegister() {
        return buttonRegister;
    }

    public WebElement getButtonEnter() {
        return buttonEnter;
    }

    public WebElement getButtonMyAccount() {
        return buttonMyAccount;
    }

        public WebElement getInputName() {
            return inputName;
        }
}


