package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountProfilePage {

    WebDriver driver;

    public AccountProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//*[text()='Конструктор']")
    //Кнопка Конструктор (на чердаке)
    private WebElement constructorLink;

    @FindBy(xpath = ".//*[@class='AppHeader_header__logo__2D0X2']")
    //Логотип stellarburgers
    private WebElement stellarburgersLogo;

    @FindBy(xpath = ".//*[text()='Выход']")
    //Кнопка Выйти в личном кабинете
    private WebElement buttonExit;

    @FindBy(xpath = ".//*[@class='Account_text__fZAIn text text_type_main-default']")
    //Надпись В этом разделе вы можете изменить свои персональные данные
    private WebElement signPersonalInformation;

    public String getElementText(WebElement element){
        return element.getText();
    }

    public LoginPage clickExit() {
        buttonExit.click();
        return new LoginPage(driver);
    }

    public MainPage clickElement(WebElement element) {
        element.click();
        return new MainPage(driver);
    }

    public AccountProfilePage waitClickable(WebElement element){ //ждем, пока элемент станет кликабельным
        new WebDriverWait(driver, Duration.ofSeconds(300))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public WebElement getConstructorLink() {
        return constructorLink;
    }

    public WebElement getStellarburgersLogo() {
        return stellarburgersLogo;
    }

    public WebElement getButtonExit() {
        return buttonExit;
    }

    public WebElement getSignPersonalInformation() {
        return signPersonalInformation;
    }
}
