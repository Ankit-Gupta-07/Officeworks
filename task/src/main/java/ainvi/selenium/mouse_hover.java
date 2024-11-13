//package ainvi.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class mouse_hover {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        Actions hove = new Actions(driver);
        hove.moveToElement(driver.findElement(By.xpath("//*[text()='Account & Lists']"))).perform();
        Thread.sleep(2000);
        hove.moveToElement(driver.findElement(By.xpath("//span[@class='icp-nav-link-inner']"))).perform();
        Thread.sleep(2000);
        driver.findElements(By.xpath("//i[@class='icp-radio']")).get(0).click();
        Thread.sleep(2000);
    }
}
