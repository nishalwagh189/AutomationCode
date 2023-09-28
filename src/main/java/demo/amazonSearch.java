package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazonSearch {
    ChromeDriver driver;
    public amazonSearch(){
        System.out.println("Constructor: amazonSearch");   
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest(){
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    public void amazonSearchResult(){
        // navigate to chrome search bar using .get()  https://www.google.com/
        driver.get("https://www.google.com/");

        // Type amazon in search bar  Using Locator "ID" APjFqb | [amazon]
        WebElement googleSearchBar = driver.findElement(By.id("APjFqb"));
        googleSearchBar.sendKeys("amazon");

        // Click on search button Using Locator "XPath" APjFqb | [amazon]
        WebElement searchButton = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/descendant::input[@value='Google Search']"));
        searchButton.click();

        // wait until page get loaded  
        // find the amazon.in or amazon.com Using Locator "XPath" //*[contains(text(),'amazon.in') or contains(text(),'amazon.com')]
        boolean status = driver.findElement(By.xpath("//*[contains(text(),'amazon.in') or contains(text(),'amazon.com')]")).isDisplayed();

        // return amazon.in or amazon.com  
        if (status){
            System.out.println(status);
        }
    }
}
