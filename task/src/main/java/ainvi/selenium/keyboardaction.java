//package ainvi.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class keyboardaction {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://text-compare.com/");
        WebElement test=driver.findElement(By.xpath("//textarea[@name='text1']"));
        test.sendKeys("This is a test comparision for Keyboard actions");
        Actions box=new Actions(driver);
        box.keyDown(test, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
        WebElement test2=driver.findElement(By.xpath("//textarea[@name='text2']"));
        box.click().keyDown(test2,Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='compareButtonText']")).click();
    }

}
