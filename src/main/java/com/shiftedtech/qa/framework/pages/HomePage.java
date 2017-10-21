package com.shiftedtech.qa.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mehedi on 5/20/2017.
 */
public class HomePage extends PageBase {

    //protected WebDriver driver;

    @FindBy(how = How.ID,using = "SearchBox")
    private WebElement searchTextbox;
    @FindBy(css = ".searchbtn>a")
    private WebElement searchButton;


    public HomePage(WebDriver driver){
        //this.driver = driver;
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
        //PageFactory.initElements(driver, this);
    }

    public void verifyTitle(){
        String title = driver.getTitle();
        Assert.assertEquals("Flowers | Flower Delivery | Fresh Flowers Online | 1-800-FLOWERS.COM",title);
    }

    public void verifyTitle(String titleShouldBe){
        String title = driver.getTitle();
        Assert.assertEquals(titleShouldBe, title);
    }
    public void search(String textToSearch){
        highlight(searchTextbox);
        searchTextbox.sendKeys(textToSearch);
        highlight(searchButton);
        //searchButton.click();
        jsClick(searchButton);

        Wait<WebDriver>wait = new FluentWait<WebDriver>(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(100,TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("TB_closeWindowButton")));
        driver.findElement(By.id("TB_closeWindowButton")).click();

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".fsrClosebtn")));
        }catch (Exception ex){

        }
}

}
