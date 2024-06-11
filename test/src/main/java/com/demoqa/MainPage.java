package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    private static final String ELEMENTS_CARD = "//div[@class='card-body']/h5[text()='Elements']";
    private static final String WIDGETS_CARD = "//div[@class='card-body']/h5[text()='Widgets']";
    private static final String INTERACTION_CARD = "//div[@class='card-body']/h5[text()='Interactions']";

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElementsCard() {
        WebElement elementsCard = driver.findElement(By.xpath(ELEMENTS_CARD));
        elementsCard.click();
    }

    public void clickWidgetCard() {
        WebElement widgetsCard = driver.findElement(By.xpath(WIDGETS_CARD));
        widgetsCard.click();
    }

    public void clickInteractionCard() {
        WebElement interactionsCard = driver.findElement(By.xpath(INTERACTION_CARD));
        interactionsCard.click();
    }
}