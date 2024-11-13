////package ainvi.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class screenshot {
    public static void main(String[] args) throws InterruptedException, IOException {

        Date current=new Date();
        String simple=current.toString().replace(" ","_").replace(":"," ");
        System.out.println(current);
        System.out.println(simple);


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();
        Thread.sleep(2000);
       File screencap=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(screencap,new File(".//ainvi.selenium.screenshot/"+simple+".png"));
       driver.close();
    }
}
