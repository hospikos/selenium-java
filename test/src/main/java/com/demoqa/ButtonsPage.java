package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ButtonsPage extends BasePage {

    private static final String DOUBLE_CLICK_BTN = "doubleClickBtn";
    private static final String DOUBLE_CLICK_MESSAGE = "doubleClickMessage";
    private static final String RIGHT_CLICK_BTN = "rightClickBtn";
    private static final String RIGHT_CLICK_MESSAGE = "rightClickMessage";

    WebDriver driver;

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnDoubleClickButton() {
        WebElement doubleClickButton = driver.findElement(By.id(DOUBLE_CLICK_BTN));
        new Actions(driver)
                .doubleClick(doubleClickButton)
                .perform();
    }

    public String getAfterDoubleClickMessage() {
        WebElement message = driver.findElement(By.id(DOUBLE_CLICK_MESSAGE));
        return message.getText();
    }

    public void clickOnRightClickButton() {
        WebElement rightClickButton = driver.findElement(By.id(RIGHT_CLICK_BTN));
        new Actions(driver)
                .contextClick(rightClickButton)
                .perform();
    }

    public String getRightClickButtonMessage() {
        WebElement message = driver.findElement(By.id(RIGHT_CLICK_MESSAGE));
        return message.getText();
    }
}
