
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import static java.lang.Thread.sleep;


public class BaseTest {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(600));
    }

    @After
    public void tearDown() throws InterruptedException {
        driver.quit();
        sleep(200);
        // Закрыть браузер
    }
}