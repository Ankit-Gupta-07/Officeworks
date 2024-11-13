//package ainvi.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.Set;

public class windowPopUpHandle {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='newWindowsBtn']")).click();
        System.out.println("clicked");
        Set<String> idxyz=driver.getWindowHandles();
        System.out.println(idxyz);
        Iterator<String> iterator=idxyz.iterator();
        String parent=iterator.next();
//        String child1=iterator.next();
//        String child2=iterator.next();
//        String child3=iterator.next();
//        String child4=iterator.next();
        System.out.println("Parent" +parent);
//        driver.switchTo().window(child3);
//        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("test");
        Thread.sleep(2000);
//        driver.close();



    }
}
