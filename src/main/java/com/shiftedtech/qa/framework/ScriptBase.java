package com.shiftedtech.qa.framework;

import com.shiftedtech.qa.framework.pages.HomePage;
import com.shiftedtech.qa.framework.pages.SearchResultPage;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Mehedi on 5/20/2017.
 */
public class ScriptBase {

    protected WebDriver driver;
    protected HomePage homePage = null;
    protected SearchResultPage searchResultPage = null;


    @Before
    public void setUp(){
       // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
       // driver = new ChromeDriver();

        //System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "/firefoxdriver.exe");
       driver = new FirefoxDriver();

        //System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/MicrosoftWebDriver.exe");
        //driver = new EdgeDriver();

        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.navigate().to("https://www.1800flowers.com");
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
    }


    public void delayFor(int timeInMili) {
       try{
            Thread.sleep(timeInMili);
        }catch(InterruptedException e){
           e.printStackTrace();
       }
    }


    @After
    public void teardown(){
        driver.close();
        //driver.quit();
    }
}
