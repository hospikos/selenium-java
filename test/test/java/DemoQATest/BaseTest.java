package DemoQATest;


import com.demoqa.ConfigFileReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class BaseTest {

    ConfigFileReader appProperties = new ConfigFileReader();
    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        Dimension dm = new Dimension(1440, 1080);
        driver.manage().window().setSize(dm);
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
