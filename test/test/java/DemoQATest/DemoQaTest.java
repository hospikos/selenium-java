package DemoQATest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class DemoQaTest {

    private static final String START_STOP_BUTTON = "startStopButton";
    private static final String DOUBLE_CLICK_MESSAGE = "doubleClickMessage";
    private static final String SHOW_SMALL_MODAL = "showSmallModal";
    private static final String ELEMENTS_CARD = "//div[@class='card-body']/h5[text()='Elements']";
    private static final String BUTTONS_MENU_ITEM = ("item-4");
    private static final String DOUBLE_CLICK_BTN = "doubleClickBtn";
    private static final String RIGHT_CLICK_BTN = "rightClickBtn";
    private static final String RIGHT_CLICK_MESSAGE = "rightClickMessage";
    private static final String MOADL_MENU_ITEM = "//div[@class='header-text' and contains(text(),'Alerts, Frame & Windows')]";
    private static final String MOADL_DIALOGS_BUTTON = "//li[@id='item-4' and contains(span, 'Modal Dialogs')]";
    private static final String SMAL_MODAL_TEXT = "example-modal-sizes-title-sm";
    private static final String LARGE_MODAL = "showLargeModal";
    private static final String LARGE_MODAL_TEXT = "example-modal-sizes-title-lg";
    private static final String RADIO_MENU_ITEM = ("item-2");
    private static final String YES_RADIO = "custom-control-label";
    private static final String YES_RADIO_MESSAGE = "text-success";
    private static final String WIDGETS_CARD = "//div[@class='card-body']/h5[text()='Widgets']";
    private static final String PROGRESS_BAR_MANU_ITEM = "//li[contains(@id, 'item-4')]//span[contains(text(), 'Progress Bar')]";
    private static final String DYNAMIC_PROPERTIES_MENU_ITEM = "//li[contains(@id, 'item-8')]//span[contains(text(), 'Dynamic Properties')]";
    private static final String PROGRESS_BAR = "progressBar";
    private static final String RESET_BUTTON = "resetButton";
    private static final String VISIBLE_AFTER_BUTTON = "visibleAfter";
    private static final String COLOR_CHANGE_BUTTON = "colorChange";
    private static final String COLOR_CHANGE_BUTTON_VALUE = "mt-4 text-danger btn btn-primary";

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        Dimension dm = new Dimension(1440, 1080);
        driver.manage().window().setSize(dm);
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }

    @Test
    void testDoubleClickButton() {
        WebElement elementsCard = driver.findElement(By.xpath(ELEMENTS_CARD));
        elementsCard.click();

        WebElement buttonsMenuItem = driver.findElement(By.id(BUTTONS_MENU_ITEM));
        buttonsMenuItem.click();

        WebElement doubleClickButton = driver.findElement(By.id(DOUBLE_CLICK_BTN));
        new Actions(driver)
                .doubleClick(doubleClickButton)
                .perform();

        WebElement message = driver.findElement(By.id(DOUBLE_CLICK_MESSAGE));
        String actualMessage = message.getText();
        assertEquals("You have done a double click", actualMessage);
    }

    @Test
    void testRightClick() {
        WebElement elementsCard = driver.findElement(By.xpath(ELEMENTS_CARD));
        elementsCard.click();

        WebElement buttonsMenuItem = driver.findElement(By.id(BUTTONS_MENU_ITEM));
        buttonsMenuItem.click();

        WebElement rightClickButton = driver.findElement(By.id(RIGHT_CLICK_BTN));
        new Actions(driver)
                .contextClick(rightClickButton)
                .perform();

        WebElement message = driver.findElement(By.id(RIGHT_CLICK_MESSAGE));
        String actualMessage = message.getText();
        assertEquals("You have done a right click", actualMessage);
    }

    @Test
    void testSmallModal() {
        WebElement elementsCard = driver.findElement(By.xpath(ELEMENTS_CARD));
        elementsCard.click();

        WebElement modalMenuItem = driver.findElement(By.xpath(MOADL_MENU_ITEM));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", modalMenuItem);
        modalMenuItem.click();

        WebElement modalDialogs = driver.findElement(By.xpath(MOADL_DIALOGS_BUTTON));
        modalDialogs.click();

        WebElement smallModal = driver.findElement(By.id(SHOW_SMALL_MODAL));
        smallModal.click();

        WebElement smallModalText = driver.findElement(By.id(SMAL_MODAL_TEXT));
        String actualMessage = smallModalText.getText();
        assertEquals("Small Modal", actualMessage);
    }

    @Test
    void testLargeModal() {
        WebElement elementsCard = driver.findElement(By.xpath(ELEMENTS_CARD));
        elementsCard.click();

        WebElement modalMenuItem = driver.findElement(By.xpath(MOADL_MENU_ITEM));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", modalMenuItem);
        modalMenuItem.click();

        WebElement modalDialogs = driver.findElement(By.xpath(MOADL_DIALOGS_BUTTON));
        modalDialogs.click();

        WebElement largeModal = driver.findElement(By.id(LARGE_MODAL));
        largeModal.click();

        WebElement largeModalText = driver.findElement(By.id(LARGE_MODAL_TEXT));
        String actualMessage = largeModalText.getText();
        assertEquals("Large Modal", actualMessage);
    }

    @Test
    void testRadioButton() throws InterruptedException {
        WebElement elementCard = driver.findElement(By.xpath(ELEMENTS_CARD));
        elementCard.click();

        WebElement radioButtonMenuItem = driver.findElement(By.id(RADIO_MENU_ITEM));
        radioButtonMenuItem.click();

        WebElement yesRadio = driver.findElement(By.className(YES_RADIO));
        yesRadio.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement yesRadioMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(YES_RADIO_MESSAGE)));
        String actualMessage = yesRadioMessage.getText();
        assertEquals("Yes", actualMessage);
    }

    @Test
    void testProgressBar() {
        WebElement widgetsCard = driver.findElement(By.xpath(WIDGETS_CARD));
        widgetsCard.click();

        WebElement progressBarMenuItem = driver.findElement(By.xpath(PROGRESS_BAR_MANU_ITEM));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", progressBarMenuItem);
        progressBarMenuItem.click();

        WebElement startStopButton = driver.findElement(By.id(START_STOP_BUTTON));
        startStopButton.click();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(11));
        wait.until(textToBe(By.id(PROGRESS_BAR), "100%"));

        WebElement resetButton = driver.findElement(By.id(RESET_BUTTON));
        assertTrue(resetButton.isDisplayed());
    }

    @Test
    void testWaitButton() {
        WebElement elementCard = driver.findElement(By.xpath(ELEMENTS_CARD));
        elementCard.click();

        WebElement dynamicPropertiesMenuItem = driver.findElement(By.xpath(DYNAMIC_PROPERTIES_MENU_ITEM));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", dynamicPropertiesMenuItem);
        dynamicPropertiesMenuItem.click();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement visibilityAfterButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(VISIBLE_AFTER_BUTTON)));

        assertTrue(visibilityAfterButton.isDisplayed());
    }

    @Test
    void testColorChange() {
        WebElement elementCard = driver.findElement(By.xpath(ELEMENTS_CARD));
        elementCard.click();

        WebElement dynamicPropertiesMenuItem = driver.findElement(By.xpath(DYNAMIC_PROPERTIES_MENU_ITEM));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", dynamicPropertiesMenuItem);
        dynamicPropertiesMenuItem.click();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement colorChangeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(COLOR_CHANGE_BUTTON)));
        wait.until(ExpectedConditions.attributeToBe(colorChangeButton, "class", COLOR_CHANGE_BUTTON_VALUE));
        String changedColor = colorChangeButton.getCssValue("color");

        assertEquals("rgba(220, 53, 69, 1)", changedColor);
    }

}
