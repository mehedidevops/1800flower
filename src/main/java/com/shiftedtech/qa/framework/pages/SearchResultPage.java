package com.shiftedtech.qa.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import javax.swing.text.html.CSS;
import java.util.List;

/**
 * Created by Mehedi on 5/20/2017.
 */
public class SearchResultPage extends PageBase {

    //protected WebDriver driver;

    @FindBy(xpath="//span[@class='topLinks']/a")
    private WebElement topLinks;

    @FindAll(@FindBy(xpath = "//div[@id='SubCollectionDiv']//div[@class='SubProductThumb']/div/div/div/span/a"))
    private List<WebElement>specialProductList;

    @FindBys(@FindBy(xpath = "//div[@id='SubCollectionDiv']//div[@class='SubProductThumb']/div/div/div/span/a/../../span[@class='blueProductScrollPrice']"))
    private List<WebElement>specialProductPriceList;

    public SearchResultPage(WebDriver driver) {
        //this.driver = driver;
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }
    public void verifyTitle(){
        String title = driver.getTitle();
        Assert.assertEquals("Send Roses: Rose Delivery & Rose Bouquets | 1800Flowers.com", title);
    }

    public void verifyTopLinks(String expected){
        String actual = topLinks.getText();
        Assert.assertEquals(expected,actual);
    }

    public void verifySpecialProductName(int index, String ExpectedName) {
        WebElement element = specialProductList.get(index);
        jsScrollElementIntoView(element);
        highlight(element);
        String actualName = element.getText();
        Assert.assertEquals(ExpectedName, actualName);
    }
    public void verifySpecialProductPrice(int index, String ExpectedPrice) {
        WebElement element = specialProductPriceList.get(index);
        highlight(element);
        String actualName = element.getText();
        Assert.assertEquals(ExpectedPrice, actualName);
    }

    public void selectSpecialProduct(int index) {
        WebElement element = specialProductList.get(index);
        element.click();
    }
}