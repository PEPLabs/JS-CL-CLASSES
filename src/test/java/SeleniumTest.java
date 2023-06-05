
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    private WebDriver driver;
    /**
     * set up selenium web driver.
     * NOTE: the selenium web driver might not be properly configured for your environment.
     * If you get an issue involving being unable to run the exe, a mismatched chromedriver version, or any sort of
     * null driver or inability for the Selenium webdriver to start, disregard any failed tests and continue to test
     * the lab manually via the browser.
     */
    @Before
    public void setUp() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        // Create a new ChromeDriver instance
        driver = new ChromeDriver();
        File file = new File("index.html");
        // Open the HTML file
        driver.get(file.getAbsolutePath());
    }
    @Test
    public void testCreateOnBulb() {
        // Click the 'on' bulb button
        WebElement onButton = driver.findElement(By.id("onBulb"));
        onButton.click();

        // Find the dynamically created elements
        WebElement title = driver.findElement(By.xpath("//h2[text()='Lightbulb 1']"));
        WebElement description = driver.findElement(By.xpath("//p[contains(text(),'The bulb is')]"));

        // Assert the elements' text values
        assertEquals("Lightbulb 1", title.getText());
        assertTrue(description.getText().contains("on"));
        assertFalse(description.getText().contains("off"));
    }
    @Test
    public void testCreateOffBulb() {
        // Click the 'on' bulb button
        WebElement onButton = driver.findElement(By.id("offBulb"));
        onButton.click();

        // Find the dynamically created elements
        WebElement title = driver.findElement(By.xpath("//h2[text()='Lightbulb 1']"));
        WebElement description = driver.findElement(By.xpath("//p[contains(text(),'The bulb is')]"));

        // Assert the elements' text values
        assertEquals("Lightbulb 1", title.getText());
        assertTrue(description.getText().contains("off"));
        assertFalse(description.getText().contains("on"));
    }

}