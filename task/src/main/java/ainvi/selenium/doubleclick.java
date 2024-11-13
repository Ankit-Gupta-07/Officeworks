//package ainvi.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class doubleclick {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://mousetester.com/");
        driver.manage().window().maximize();
        WebElement textclick=driver.findElement(By.xpath("//div/p[text()='CLICK ME!']"));
        Actions act=new Actions(driver);
        act.doubleClick(textclick).perform();
        Thread.sleep(200);
        act.contextClick(textclick).build().perform();
        Thread.sleep(1000);
        driver.close();

    }
}
