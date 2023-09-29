package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.sdk.logs.data.Body;

public class nestedFrames {
    ChromeDriver driver;

    public nestedFrames(){
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

    public void printFrameText(){  
        // navigate to nested frame URL by using .get()  https://the-internet.herokuapp.com/nested_frames
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        
        // Switch to top frame  Using Locator "Name" [frame-top]
        WebElement topFrame = driver.findElement(By.name("frame-top"));
        driver.switchTo().frame(topFrame);
        
        // Switch to left frame  Using Locator "Name" [frame-top]
        WebElement leftFrame = driver.findElement(By.name("frame-left"));
        driver.switchTo().frame(leftFrame);
        
        // Find the element of Left text Using Locator "Tag Name" body
        WebElement leftText = driver.findElement(By.tagName("Body"));
        
        // Print the text   
        System.out.println("Left side frame text on top frame is: " + leftText.getText());
        
        // Switch to parent frame (Top Frame) Using Locator "Name" [frame-top]
        driver.switchTo().parentFrame();
        
        // Switch to middle frame  Using Locator "Name" [frame-middle]
        WebElement midFrame = driver.findElement(By.name("frame-middle"));
        driver.switchTo().frame(midFrame);
        
        // Find the element of Middle text Using Locator "ID" content
        WebElement middleText = driver.findElement(By.id("content"));
        
        // Print the text   
        System.out.println("Middle frame text on top frame is: " + middleText.getText());
        
        // Switch to parent frame (Top Frame)  [frame-top]
        driver.switchTo().parentFrame();
        
        // Switch to right frame  Using Locator "Name" frame-right
        WebElement rightFrame = driver.findElement(By.name("frame-right"));
        driver.switchTo().frame(rightFrame);
        
        // Find the element of Right text Using Locator "Tag Name" body 
        WebElement rightText = driver.findElement(By.tagName("body"));
        
        // Print the text   
        System.out.println("Right side frame text name of top frame is: " + rightText.getText());
        
        // Switch to default content  
        driver.switchTo().defaultContent();
        
        // Switch to bottom frame Using Locator "Name" frame-bottom
        WebElement bottomFrame = driver.findElement(By.name("frame-bottom"));
        driver.switchTo().frame(bottomFrame);
        
        // Find the element of bottom text  Using Locator "Tag Name" frame-bottom
        WebElement bottomText = driver.findElement(By.tagName("body"));
        System.out.println("Bottom frame text is: " + bottomText.getText());
        
        // switch to default content  
        driver.switchTo().defaultContent();
        System.out.println("Successfully come out from the frame..!!!");
    }
}
