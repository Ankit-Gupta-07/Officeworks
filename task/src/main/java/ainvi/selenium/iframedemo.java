//package ainvi.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iframedemo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver() ;
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
        System.out.println("1");
        driver.manage().window().maximize();
        System.out.println("2");

        driver.switchTo().frame(driver.findElement(By.id("w3loginbtn")));
        System.out.println("3");
        driver.findElement(By.xpath("//a[@title='Login to your account']")).click();
        System.out.println("endddd");
    }
}
