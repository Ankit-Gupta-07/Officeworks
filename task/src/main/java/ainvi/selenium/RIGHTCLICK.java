//package ainvi.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RIGHTCLICK {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement xyz=driver.findElements(By.xpath("//*[@class='nav-a nav-a-2   nav-progressive-attribute']")).get(0);
        Actions hover=new Actions(driver);
        hover.moveToElement(xyz).perform();
        System.out.println("Hover done");
        WebElement xyzright=driver.findElements(By.xpath("//*[@class='nav-action-inner' and text()='Sign in']")).get(0);
        Actions right=new Actions(driver);
        right.contextClick(xyzright).perform();
        Thread.sleep(1);
        System.out.println("Right click successful");

    }
}
