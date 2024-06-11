package DemoQATest;

import com.demoqa.ButtonsPage;
import com.demoqa.MainPage;
import com.demoqa.SliderMenuBar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class DemoQaTest extends BaseTest {

    private static final String START_STOP_BUTTON = "startStopButton";
    private static final String SHOW_SMALL_MODAL = "showSmallModal";
    private static final String SMAL_MODAL_TEXT = "example-modal-sizes-title-sm";
    private static final String LARGE_MODAL = "showLargeModal";
    private static final String LARGE_MODAL_TEXT = "example-modal-sizes-title-lg";
    private static final String YES_RADIO = "custom-control-label";
    private static final String YES_RADIO_MESSAGE = "text-success";
    private static final String PROGRESS_BAR = "progressBar";
    private static final String RESET_BUTTON = "resetButton";
    private static final String VISIBLE_AFTER_BUTTON = "visibleAfter";
    private static final String COLOR_CHANGE_BUTTON = "colorChange";
    private static final String COLOR_CHANGE_BUTTON_VALUE = "mt-4 text-danger btn btn-primary";
    private static final String SECOND_FRAME = "frame2";
    private static final String SECOND_FRAME_TEXT = "sampleHeading";
    private static final String FRAMES_HEADER = "text-center";
    private static final String DRAGGABLE = "draggable";
    private static final String DROPPABLE = "droppable";
    private static final String DROPPABLE_TEXT = "#droppable > p";

    ButtonsPage buttonPage;
    MainPage mainPage;
    SliderMenuBar sliderMenuBar;

    @BeforeEach
    void precondition() {
        driver.get(appProperties.getBaseUrl());
        buttonPage = new ButtonsPage(driver);
        mainPage = new MainPage(driver);
        sliderMenuBar = new SliderMenuBar(driver);
    }

    @Test
    void testDoubleClickButton() {
        mainPage.clickElementsCard();

        sliderMenuBar.clickButtonMenuItem();

        buttonPage.clickOnDoubleClickButton();

        String actualMessage = buttonPage.getAfterDoubleClickMessage();
        assertEquals("You have done a double click", actualMessage);
    }

    @Test
    void testRightClick() {
        mainPage.clickElementsCard();

        sliderMenuBar.clickButtonMenuItem();

        buttonPage.clickOnRightClickButton();

        buttonPage.getRightClickButtonMessage();
        String actualMessage = buttonPage.getRightClickButtonMessage();
        assertEquals("You have done a right click", actualMessage);
    }

    @Test
    void testSmallModal() {
        mainPage.clickElementsCard();

        sliderMenuBar.clickAlertMenuItem();

        sliderMenuBar.clickModalDialogsButton();

        WebElement smallModal = driver.findElement(By.id(SHOW_SMALL_MODAL));
        smallModal.click();

        WebElement smallModalText = driver.findElement(By.id(SMAL_MODAL_TEXT));
        String actualMessage = smallModalText.getText();
        assertEquals("Small Modal", actualMessage);
    }

    @Test
    void testLargeModal() {
        mainPage.clickElementsCard();

        sliderMenuBar.clickAlertMenuItem();

        sliderMenuBar.clickModalDialogsButton();

        WebElement largeModal = driver.findElement(By.id(LARGE_MODAL));
        largeModal.click();

        WebElement largeModalText = driver.findElement(By.id(LARGE_MODAL_TEXT));
        String actualMessage = largeModalText.getText();
        assertEquals("Large Modal", actualMessage);
    }

    @Test
    void testRadioButton() {
        mainPage.clickElementsCard();

        sliderMenuBar.clickRadioMenuItem();

        WebElement yesRadio = driver.findElement(By.className(YES_RADIO));
        yesRadio.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement yesRadioMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(YES_RADIO_MESSAGE)));
        String actualMessage = yesRadioMessage.getText();
        assertEquals("Yes", actualMessage);
    }

    @Test
    void testProgressBar() {
        mainPage.clickWidgetCard();

        sliderMenuBar.clickProgressBarMenuItem();

        WebElement startStopButton = driver.findElement(By.id(START_STOP_BUTTON));
        startStopButton.click();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(11));
        wait.until(textToBe(By.id(PROGRESS_BAR), "100%"));

        WebElement resetButton = driver.findElement(By.id(RESET_BUTTON));
        assertTrue(resetButton.isDisplayed());
    }

    @Test
    void testWaitButton() {
        mainPage.clickElementsCard();

        sliderMenuBar.clickDynamicPropertiesMenuItem();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement visibilityAfterButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(VISIBLE_AFTER_BUTTON)));

        assertTrue(visibilityAfterButton.isDisplayed());
    }

    @Test
    void testColorChange() {
        mainPage.clickElementsCard();

        sliderMenuBar.clickDynamicPropertiesMenuItem();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement colorChangeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(COLOR_CHANGE_BUTTON)));
        wait.until(ExpectedConditions.attributeToBe(colorChangeButton, "class", COLOR_CHANGE_BUTTON_VALUE));
        String changedColor = colorChangeButton.getCssValue("color");

        assertEquals("rgba(220, 53, 69, 1)", changedColor);
    }

    @Test
    void testFrame() {
        mainPage.clickElementsCard();

        sliderMenuBar.clickAlertMenuItem();

        sliderMenuBar.clickFramesMenuItem();

        WebElement iFrame = driver.findElement(By.id(SECOND_FRAME));
        driver.switchTo().frame(iFrame);

        WebElement frameText = driver.findElement(By.id(SECOND_FRAME_TEXT));
        String actualText = frameText.getText();
        assertEquals("This is a sample page", actualText);

        driver.switchTo().defaultContent();
        WebElement framePageHeader = driver.findElement(By.className(FRAMES_HEADER));
        framePageHeader.isDisplayed();
    }

    @Test
    void testDrugAndDrop() {
        mainPage.clickInteractionCard();

        sliderMenuBar.clickDroppableMenuItem();

        WebElement source = driver.findElement(By.id(DRAGGABLE));
        WebElement target = driver.findElement(By.id(DROPPABLE));

        new Actions(driver)
                .dragAndDrop(source, target)
                .perform();

        WebElement droppableMessage = driver.findElement(By.cssSelector(DROPPABLE_TEXT));
        String actualMessage = droppableMessage.getText();
        assertEquals(actualMessage, "Dropped!");
    }
}
