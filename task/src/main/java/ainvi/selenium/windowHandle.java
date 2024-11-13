//package ainvi.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.Set;

public class windowHandle {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/popup.php");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@target='_blank']")).click();
        Thread.sleep(2000);
        Set<String> winHandle=driver.getWindowHandles();
//        System.out.println(winHandles); //prints windo Handles id
//        driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("gaurav.2n@gmail.com");
//        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        Thread.sleep(2000);
        Iterator<String> iterator=winHandle.iterator();
        String parentWindow= iterator.next();
        String childWindow= iterator.next();
        driver.switchTo().window(parentWindow);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//img[@alt='Guru99 Demo Sites']")).click();
        System.out.println("Guru 99 click");
        Thread.sleep(2000);
        driver.switchTo().window(childWindow);
        Thread.sleep(2000);
        System.out.println(winHandle); //prints windo Handles id
        driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("gaurav.2n@gmail.com");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        Thread.sleep(2000);


    }
}
