package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class imageURL {

    ChromeDriver driver;
    public imageURL(){
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

    public void printURLs(){

        // navigate to URL by using .get()  https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");

        // Find the all Recommended Movies image URLs Using Locator "XPath" //*[contains(@class,'kcFNYT')]/descendant::div[4]/img
        List <WebElement> recommendedMovies = driver.findElements(By.xpath("//*[contains(@class,'kcFNYT')]/descendant::div[4]/img"));
        
        // print all the Recommended Movies image URLs  //*[contains(@class,'kcFNYT')]/descendant::div[4]/img
        for (WebElement imageURLs : recommendedMovies) {
            System.out.println("Recommended movies image URLs are: " + imageURLs.getAttribute("src"));               
        }
        
        // Print language of 2nd Premiere movie Using Locator "XPath" //*[contains(@class,'kABGwO')]/a[2]/descendant::div[2]/following-sibling::div[2]/child::div[2]
        WebElement languageOf2ndMovie = driver.findElement(By.xpath("//*[contains(@class,'kABGwO')]/a[2]/descendant::div[2]/following-sibling::div[2]/child::div[1]"));
        System.out.println("Language of 2nd movie is: " + languageOf2ndMovie.getText());
        
        // Print name of 2nd Premiere movie 
        WebElement nameOf2ndMovie = driver.findElement(By.xpath("//*[contains(@class,'kABGwO')]/a[2]/descendant::div[2]/following-sibling::div[2]/child::div[2]"));
        System.out.println("Language of 2nd movie is: " + nameOf2ndMovie.getText());
    }
    
}
