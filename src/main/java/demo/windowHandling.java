package demo;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowHandling {
    ChromeDriver driver;

    public windowHandling(){
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(20).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest(){
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    public void switchWindow() throws IOException{
        // navigate to URL by .get()  https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        
        // Find locator of Try it button  Using Locator "XPath" //button[@onclick='myFunction()']
        WebElement tryButton = driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
        tryButton.click();
        
        //parent window 
        String parentWindow = driver.getWindowHandle();
        
        //To handle all new windows/tabs
        Set<String> childWindow = driver.getWindowHandles();
        for (String allChildWindows : childWindow) {
            if (!parentWindow.equalsIgnoreCase(allChildWindows)){
                driver.switchTo().window(allChildWindows);
            }
        }

        // Switch to the new tab  
        // get the URL by using .getCurrentUrl()  
        System.out.println("New window url is: " + driver.getCurrentUrl());
        
        // get the title of the page by using .getTitle()  
        System.out.println("New window pagw title is: " + driver.getTitle());
        
        // take the screenshot of the page  
        TakesScreenshot srcShot = ((TakesScreenshot) driver);
        File srcFile = srcShot.getScreenshotAs(OutputType.FILE);

        File desFile = new File("C:/Users/Admin/Desktop/AutomationCode/selenium_starter/src/screenshot.png");
        FileUtils.copyFile(srcFile, desFile);
        
        // close the new tab   
        driver.close();
        
        // Switch to parent window  
        driver.switchTo().window(parentWindow); 
    }
}
