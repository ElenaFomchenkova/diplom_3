package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
