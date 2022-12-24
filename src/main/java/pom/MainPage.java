package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get(pageUrl);
    }

    WebDriver driver;
    public final String pageUrl = "https://stellarburgers.nomoreparties.site/";

    @FindBy(xpath = ".//*[text()='Личный Кабинет']")
    //Кнопка личный кабинет (на чердаке)
    private WebElement buttonMyAccount;

    @FindBy(xpath = ".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    //Кнопка войти в аккаунт(под конструктором без логина)
    private WebElement buttonEnterAccount;

    @FindBy(xpath = ".//button[text()= 'Оформить заказ']")
    //Кнопка Оформить заказ (под конструктором с логином)
    private WebElement buttonCreateOrder;

    @FindBy(xpath = ".//span[contains(text(),'Булки')]/parent::div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']")
    //вкладка Булки в неактивном состоянии
    private WebElement bunsNonActiveCondition;

    @FindBy(xpath = ".//span[contains(text(),'Булки')]/parent::div[contains(@class,'current__2BEPc')]")
    //вкладка Булки в активном состоянии
    private WebElement bunsInActiveCondition;

    @FindBy(xpath = ".//span[contains(text(),'Соусы')]/parent::div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']")
    //вкладка Соусы в неактивном состоянии
    private WebElement sauceNonActiveCondition;

    @FindBy(xpath = ".//span[contains(text(),'Соусы')]/parent::div[contains(@class,'current__2BEPc')]")
    //вкладка Соусы в активном состоянии
    private WebElement sauceInActiveCondition;

    @FindBy(xpath = ".//span[contains(text(),'Начинки')]/parent::div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']")
    //вкладка Начинки в неактивном состоянии
    private WebElement fillingsNonActiveCondition;

    @FindBy(xpath = ".//span[contains(text(),'Начинки')]/parent::div[contains(@class,'current__2BEPc')]")
    //вкладка Начинки в активном состоянии
    private WebElement fillingsInActiveCondition;

    public MainPage clickElement(WebElement element){ //клик на любой веб.элемент
        element.click();
        return this;
    }

    public LoginPage clickLoginButton(WebElement element){ //клик на кнопку заказа с переходом на другую страницу
        element.click();
        return new LoginPage(driver);
    }

    public MainPage waitClickable(WebElement element){ //ждем, пока элемент станет кликабельным
        new WebDriverWait(driver, Duration.ofSeconds(300))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public String getElementText(WebElement element){
        return element.getText();
    }
    public WebElement getButtonMyAccount() {
        return buttonMyAccount;
    }

    public WebElement getButtonEnterAccount() {
        return buttonEnterAccount;
    }

    public WebElement getButtonCreateOrder() {
        return buttonCreateOrder;
    }

    public WebElement getBunsNonActiveCondition() {
        return bunsNonActiveCondition;
    }

    public WebElement getBunsInActiveCondition() {
        return bunsInActiveCondition;
    }

    public WebElement getSauceNonActiveCondition() {
        return sauceNonActiveCondition;
    }

    public WebElement getSauceInActiveCondition() {
        return sauceInActiveCondition;
    }

    public WebElement getFillingsNonActiveCondition() {
        return fillingsNonActiveCondition;
    }

    public WebElement getFillingsInActiveCondition() {
        return fillingsInActiveCondition;
    }

}
