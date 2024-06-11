package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SliderMenuBar {

    private static final String BUTTONS_MENU_ITEM = ("item-4");
    private static final String PROGRESS_BAR_MANU_ITEM = "//li[contains(@id, 'item-4')]//span[contains(text(), 'Progress Bar')]";
    private static final String ALERT_MENU_ITEM = "//div[@class='header-text' and contains(text(),'Alerts, Frame & Windows')]";
    private static final String MOADL_DIALOGS_BUTTON = "//li[@id='item-4' and contains(span, 'Modal Dialogs')]";
    private static final String RADIO_MENU_ITEM = ("item-2");
    private static final String DYNAMIC_PROPERTIES_MENU_ITEM = "//li[contains(@id, 'item-8')]//span[contains(text(), 'Dynamic Properties')]";
    private static final String FRAMES_MENU_ITEM = "//li[@id='item-2' and contains(span, 'Frames')]";
    private static final String DROPPABLE_MENU_ITEM = "//li[@id='item-3']//span[text()='Droppable']";

    WebDriver driver;

    public SliderMenuBar(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonMenuItem() {
        WebElement buttonsMenuItem = driver.findElement(By.id(BUTTONS_MENU_ITEM));
        buttonsMenuItem.click();
    }

    public void clickProgressBarMenuItem() {
        WebElement progressBarMenuItem = driver.findElement(By.xpath(PROGRESS_BAR_MANU_ITEM));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", progressBarMenuItem);
        progressBarMenuItem.click();
    }

    public void clickAlertMenuItem() {
        WebElement modalMenuItem = driver.findElement(By.xpath(ALERT_MENU_ITEM));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", modalMenuItem);
        modalMenuItem.click();
    }

    public void clickModalDialogsButton() {
        WebElement modalDialogs = driver.findElement(By.xpath(MOADL_DIALOGS_BUTTON));
        modalDialogs.click();
    }

    public void clickRadioMenuItem() {
        WebElement radioButtonMenuItem = driver.findElement(By.id(RADIO_MENU_ITEM));
        radioButtonMenuItem.click();
    }

    public void clickDynamicPropertiesMenuItem() {
        WebElement dynamicPropertiesMenuItem = driver.findElement(By.xpath(DYNAMIC_PROPERTIES_MENU_ITEM));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", dynamicPropertiesMenuItem);
        dynamicPropertiesMenuItem.click();
    }

    public void clickFramesMenuItem() {
        WebElement framesButton = driver.findElement(By.xpath(FRAMES_MENU_ITEM));
        framesButton.click();
    }

    public void clickDroppableMenuItem() {
        WebElement droppableMenuItem = driver.findElement(By.xpath(DROPPABLE_MENU_ITEM));
        droppableMenuItem.click();
    }
}
