/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;
import java.io.IOException;
import java.net.MalformedURLException;


public class App {
    public void getGreeting() throws InterruptedException, IOException {
        //TestCases tests = new TestCases(); // Initialize your test class
        //amazonSearch search = new amazonSearch();
        //countHyperLinks counts = new countHyperLinks();
        //linkedInPost post = new linkedInPost();
        //imageURL printURL = new imageURL();
        //nestedFrames printText = new nestedFrames();
        //IMDBRating ratings = new IMDBRating();
        windowHandling handling = new windowHandling();
        

        //TODO: call your test case functions one after other here
        //tests.testCase01();
        //search.amazonSearchResult();
        //counts.countOfLinks();
        //post.postOnLinkedin();
        //printURL.printURLs();
        //printText.printFrameText();
        //ratings.movieRating();
        handling.switchWindow();

        //END Tests
        //tests.endTest(); // End your test by clearning connections and closing browser
        //search.endTest();
        //counts.endTest();
        //post.endTest();
        //printURL.endTest();
        //printText.endTest();
        //ratings.endTest();
        handling.endTest();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        new App().getGreeting();
    }
}
