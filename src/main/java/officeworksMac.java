import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class officeworksMac {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://officeworks.moorup.com.au/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//div[text()=\"Laptops\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//div[text()=\"MacBook\"]")).click();
        Thread.sleep(10000);
        driver.findElements(By.xpath(".//button[text()=\"Select options\"]")).get(0).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//button[text()=\"M2 Pro 10-core CPU 16-core GPU\"]")).click();
        Thread.sleep(300);
        driver.findElement(By.xpath(".//button[text()=\"512GB SSD\"]")).click();
        Thread.sleep(300);
        driver.findElement(By.xpath(".//button[text()=\"16GB\"]")).click();
        Thread.sleep(300);
        driver.findElement(By.xpath(".//button[text()=\"Done\"]")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(".//button[text()=\"YES\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//button[text()=\"YES\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//button[text()=\"YES\"]")).click();

        String price=driver.findElement(By.xpath(".//h1[@class=\"font-bold text-4xl md:text-6xl text-center my-2 text-primary\"]")).getText();

        System.out.println("Price: "+price);

    }
}
