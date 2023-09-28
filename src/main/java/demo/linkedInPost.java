package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class linkedInPost {
    ChromeDriver driver;
    public linkedInPost(){
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

    public void postOnLinkedin(){
        // Navigate to Linkedin login page URL by using .get() method  | https://www.linkedin.com/
        driver.get("https://www.linkedin.com/");

        // Click on email or phone text box and enter the valid email id or phone number Using Locator "ID" and insert email or phone 
        WebElement emailTextBox = driver.findElement(By.id("session_key"));
        emailTextBox.sendKeys("nishalwagh189@gmail.com");
        
        // Click on password text box and enter the valid password  Using Locator "ID" session_password and enter password
        WebElement passwordTextBox = driver.findElement(By.id("session_password"));
        passwordTextBox.sendKeys("DummyPassword");
        
        // Click on Sign In button Using Locator "XPath" //button[normalize-space(text())='Sign in']
        WebElement signInButton = driver.findElement(By.xpath("//button[normalize-space(text())='Sign in']"));
        signInButton.click();

        // wait till linkedin home page is get loaded  
        driver.get("https://www.linkedin.com/in/nishal-wagh-b10700103/");
        
        // Print the count of "who's viewed your profile" Using Locator "XPath" //*[text()="Who's viewed your profile"]/../../following-sibling::div
        WebElement countOfViewProfile = driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/me/profile-views' and contains(@class,'flex-column')]/descendant::div[2]"));
        System.out.println("Count of view profile is: " + countOfViewProfile);
        
        // Print the count of "Impressions of your post" Using Locator "XPath" //span[text()='Impressions of your post']/../../following-sibling::div
        WebElement countOfPostImpression = driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/in/nishal-wagh-b10700103/detail/recent-activity/shares/' and contains(@class,'flex-column')]/descendant::div[2]"));
        System.out.println("Count of Post Impression is: " + countOfPostImpression);
        
        // Click on Start a post field  Using Locator "XPath" //div[@class='share-box-feed-entry__top-bar']/button
        driver.get("https://www.linkedin.com/feed/");
        
        WebElement startField = driver.findElement(By.xpath("//div[@class='share-box-feed-entry__top-bar']/button"));
        startField.click();
        
        // wait till popup get displayed  
        // Click on user dropdown Using Locator "XPath" //h2[@id='share-to-linkedin-modal__header']/child::button
       WebElement dropdownIcon = driver.findElement(By.xpath("//h2[@id='share-to-linkedin-modal__header']/child::button"));
       dropdownIcon.click();
       
        // Select the Connections only radio button  Using Locator "ID" CONNECTIONS_ONLY
        WebElement connectionOnlyButton = driver.findElement(By.id("CONNECTIONS_ONLY"));
        connectionOnlyButton.click();

        //Click on done button
        WebElement doneButton = driver.findElement(By.xpath("//*[contains(@class,'share-box-footer__primary-btn')]"));
        doneButton.click();

        // Write text in text field Using Locator "XPath" //*[@data-placeholder='What do you want to talk about?'] | [Test]
        WebElement textField = driver.findElement(By.xpath("//*[@data-placeholder='What do you want to talk about?']"));
        textField.sendKeys("TEST...!!!");
        
        // Click on Post button Using Locator "Class" Name share-box_actions
        WebElement postButton = driver.findElement(By.className("share-box_actions"));
        postButton.click();

        // Wait until text visible   
        // Verify the post successful popup visible  Using Locator "Class" Name artdeco-toast-item__message
        WebElement successMessage = driver.findElement(By.className("artdeco-toast-item__message"));
        
        if (successMessage.isDisplayed()){
            System.out.println("Post is succesfully uploaded");
        }
    }
}
