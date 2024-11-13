package revision;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class alert {
    public static WebDriver driver;
    static Actions obj;

    public static void mhover() {
        obj = new Actions(driver);

    }

    @Test
    public void m1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        Thread.sleep(500);
        mhover();
        //Hover

        obj.moveToElement(driver.findElement(By.xpath("//a[@class=\"nav-a nav-a-2   nav-progressive-attribute\" and @data-csa-c-type=\"link\"]"))).perform();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[text()=\"Memberships & Subscriptions\"]")).click();


    }


}
