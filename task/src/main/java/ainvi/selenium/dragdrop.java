//package ainvi.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragdrop {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/droppable/");
        WebElement test=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement test2=driver.findElement(By.xpath("//div[@class='drop-box ui-droppable']"));
        Actions box=new Actions(driver);
        box.dragAndDrop(test,test2).perform();
    }


}
