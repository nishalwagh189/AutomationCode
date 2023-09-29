package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IMDBRating {
    ChromeDriver driver;

    public IMDBRating(){
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

    public void movieRating(){
        // navigate to URL by .get()  https://www.imdb.com/chart/top/
        driver.get("https://www.imdb.com/chart/top/");
        
        // Find the first number movie rating Using Locator "XPath" //ul[contains(@class,'ipc-metadata-list')]/child::li[1]/descendant::span[6][contains(@aria-label,'IMDb rating:')]
        WebElement highestRatedMovie = driver.findElement(By.xpath("//ul[contains(@class,'ipc-metadata-list')]/child::li[1]/descendant::span[6][contains(@aria-label,'IMDb rating:')]"));
        
        // Print the value by using .getText()  
        System.out.println("Rating of highest rated movie is: " + highestRatedMovie.getText());
        
        // Find the number of movies on the table  Using Locator "XPath" //ul[contains(@class,'compact-list-view')]/child::li
        List <WebElement> numberOfMovies = driver.findElements(By.xpath("//ul[contains(@class,'compact-list-view')]/child::li"));
        
        // get the count of the movie list  
        System.out.println("Number of movies on table is: " + numberOfMovies.size());
        
        // Click on sort by dropdown Using Locator "ID" sort-by-selector
        WebElement sortOrderDropdown = driver.findElement(By.id("sort-by-selector"));
        sortOrderDropdown.click();

        // Select the release date option  
        Select dropdown = new Select(sortOrderDropdown);
        dropdown.selectByValue("RELEASE_DATE");        
        
        // Click on swap order button Using Locator "ID" swap-sort-order-button
        WebElement swapOrderButton = driver.findElement(By.id("swap-sort-order-button"));
        swapOrderButton.click();
        
        // Find the first number of movie (Oldest) Using Locator "XPath" //ul[contains(@class,'ipc-metadata-list')]/child::li[1]/descendant::a[2]
        WebElement oldestMovie = driver.findElement(By.xpath("//ul[contains(@class,'ipc-metadata-list')]/child::li[1]/descendant::a[2]"));

        // Print the oldest movie name  
        System.out.println("Oldest movie name is: " + oldestMovie.getText());        
        
        // Click on swap order button Using Locator "ID" swap-sort-order-button
        swapOrderButton.click();
        
        // Find the first number of movie (Latest) Using Locator "XPath" //ul[contains(@class,'ipc-metadata-list')]/child::li[1]/descendant::a[2]
        WebElement latestMovie = driver.findElement(By.xpath("//ul[contains(@class,'ipc-metadata-list')]/child::li[1]/descendant::a[2]"));

        // Print the latest movie name  
        System.out.println("Latest movie name is: " + latestMovie.getText());        
        
        // Click on sort by dropdown Using Locator "ID" sort-by-selector
        sortOrderDropdown.click();
        
        // Select the number of ratings option  
        dropdown.selectByValue("USER_RATING_COUNT");
        
        // Find the highest rating number  Using Locator "XPath" //ul[contains(@class,'ipc-metadata-list')]/child::li[1]/descendant::span[7]
        WebElement highestPublicRating = driver.findElement(By.xpath("//ul[contains(@class,'ipc-metadata-list')]/child::li[1]/descendant::span[7]"));
        
        // Print the most user rating  
        System.out.println("Total number of highest rating by user is: " + highestPublicRating.getText());
    }
}
