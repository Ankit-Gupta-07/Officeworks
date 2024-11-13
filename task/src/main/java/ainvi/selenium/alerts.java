// ainvi.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alerts {
        @Test
        public void alerts() throws InterruptedException {
                WebDriverManager.chromedriver().setup();
                WebDriver driver=new ChromeDriver();
                driver.manage().window().maximize();
                driver.get("https://demo.guru99.com/test/delete_customer.php");
                Thread.sleep(2000);
                //Click on submit, alert pops up. User dismisses the alert
                driver.findElement(By.xpath("//input[@name='submit']")).click();
                Thread.sleep(1500);
                String con1=driver.switchTo().alert().getText();
                String compare1="Do you really want to delete this Customer?";
                        if(con1.equals(compare1))
                        {
                                driver.switchTo().alert().accept();
                                Thread.sleep(1500);
                                driver.switchTo().alert().accept();
                                System.out.println("if part, first alert message is : " +con1);
                        }
                        else
                        {
                                driver.switchTo().alert().dismiss();
                                Thread.sleep(1500);
                                System.out.println(" Else part, first alert message is : " +con1);
                        }


        }

}

