package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RestoreForgotedPasswordPage {

    WebDriver driver;

    public RestoreForgotedPasswordPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//a[text()='Войти']")
    //Кнопка войти в форме восстановления пароля
    private WebElement buttonEnterOnRestorePasswordPage;

    public WebElement getButtonEnterOnRestorePasswordPage() {
        return buttonEnterOnRestorePasswordPage;
    }

    public LoginPage clickEnter(){ //клик на кнопку Зарегистрироваться
        buttonEnterOnRestorePasswordPage.click();
        return new LoginPage(driver);
    }

    public RestoreForgotedPasswordPage waitClickable(WebElement element){ //ждем, пока элемент станет кликабельным
        new WebDriverWait(driver, Duration.ofSeconds(600))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }
}
