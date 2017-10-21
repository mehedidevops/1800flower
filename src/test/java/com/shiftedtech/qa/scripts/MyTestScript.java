package com.shiftedtech.qa.scripts;

import com.shiftedtech.qa.framework.ScriptBase;
import com.shiftedtech.qa.framework.pages.HomePage;
import com.shiftedtech.qa.framework.pages.SearchResultPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by Mehedi on 5/20/2017.
 */
public class MyTestScript extends ScriptBase {


    @Test
    public void test1() {
        WebElement searchTextbox = driver.findElement(By.id("SearchBox"));
        searchTextbox.sendKeys("rose");

        WebElement searchButton = driver.findElement(By.cssSelector(".searchbtn>a"));
        searchButton.click();
    }

    @Test
    public void test2() {
        WebElement searchTextbox = driver.findElement(By.id("SearchBox"));
        searchTextbox.sendKeys("Spray");

        WebElement searchButton = driver.findElement(By.cssSelector(".searchbtn>a"));
        searchButton.click();
    }


    //(test 3 = Page Object Model "POM")
    @Test
    public void verifySpecialProductInfoForSearchResult() {
        //(Outside)PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),homePage);
        //homePage.verifyTitle();

        homePage.verifyTitle("Flowers | Flower Delivery | Fresh Flowers Online | 1-800-FLOWERS.COM");
        homePage.search("rose");

        searchResultPage.verifyTitle();
        searchResultPage.verifyTopLinks("Roses");
        delayFor(4000);
        searchResultPage.verifySpecialProductName(0, "Rose Elegance™ Premium Long Stem Red Roses");
        //searchResultPage.selectSpecialProduct(0);
        searchResultPage.verifySpecialProductPrice(0, "$59.99-$99.99");


        searchResultPage.verifySpecialProductName(1, "Blooming Love™ Premium Red Roses");
        searchResultPage.verifySpecialProductPrice(1, "$64.99-$89.99");


        searchResultPage.verifySpecialProductName(2, "Ultimate Elegance™ Premium Long Stem Red Roses");
        searchResultPage.verifySpecialProductPrice(2, "$119.99-$209.99");


        searchResultPage.verifySpecialProductName(3, "100 Premium Long Stem Red Roses");
        searchResultPage.verifySpecialProductPrice(3, "$349.99");
    }
}