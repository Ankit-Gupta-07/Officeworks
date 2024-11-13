package OW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OWtask {
    public static Properties locator;
    public static List<WebElement> product;
    public static List<WebElement> storageList;
    public static List<WebElement> memoryList;
    public static List<WebElement> processorList;
    public static WebDriver driver;
    public static int processorSize = 0, storageSize = 0, productSize = 0, memorySize = 0;
    public static int memoryCounter = 0, storageCounter = 0, processorCounter = 0,productCounter=0;

    public static void main(String[] args) throws IOException, InterruptedException {
        locator = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/OW/locators.properties");
        locator.load(fis);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(locator.getProperty("URL"));
        Thread.sleep(2000);
//product selection
        driver.findElement(By.xpath(locator.getProperty("Laptops"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(locator.getProperty("Macbook"))).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        tempProductLoop();
        processorCountLoop();
    }

    public static void tempProductLoop() throws InterruptedException {
        product = new ArrayList<>();
        productSize = product.size();
        product = driver.findElements(By.xpath(locator.getProperty("productList")));
        System.out.println(product.get(productCounter).getText());
        driver.findElements(By.xpath(locator.getProperty("selectOption"))).get(productCounter).click();
        Thread.sleep(1000);

    }

    public static void productCountLoop() throws InterruptedException {
        product = new ArrayList<>();
        product = driver.findElements(By.xpath(locator.getProperty("productList")));
        productSize = product.size();

        for (int i = 0; i < productSize; i++) {
            System.out.println((i + 1) + ". " + product.get(i).getText());
            driver.findElements(By.xpath(locator.getProperty("selectOption"))).get(i).click();
            Thread.sleep(1000);
            if (i > productCounter) {
                break;
            }
        }
    }

    public static void processorCountLoop() throws InterruptedException {
        processorList = new ArrayList<>();
        processorList = driver.findElements(By.xpath(locator.getProperty("eachButton")));
        processorSize = processorList.size();
        for (int j = 0; j < processorSize; j++) {
            processorCounter++;
            if (processorCounter <= processorSize) {
                processorList = driver.findElements(By.xpath(locator.getProperty("eachButton")));
                System.out.println("-Processor " + (j + 1) + ". " + processorList.get(j).getText());
                processorList.get(j).click(); //till now user clicked on processor name and then storage fields visible to user
                Thread.sleep(100);
            } else {
                System.out.println("---------------------------------------------------");
            }
            storageCountLoop();
        }
    }

    public static void storageCountLoop() throws InterruptedException {
        storageList = new ArrayList<>();
        storageList = driver.findElements(By.xpath(locator.getProperty("eachButton")));
        storageSize = storageList.size();
        storageCounter = processorSize;
        for (int k = processorSize; k < storageSize; k++) { //loop to read storage text
            storageCounter++;
            if (storageCounter <= storageSize) {
                storageList = driver.findElements(By.xpath(locator.getProperty("eachButton")));
                System.out.println("---Storage " + (k + 1 - processorSize) + ". " + storageList.get(k).getText());
                storageList.get(k).click();//till now user clicked on storage name and now memory field is visible to user
                Thread.sleep(100);
            } else {
                System.out.println("storageCount:" + storageSize + "\n" + "storageCounter:" + storageCounter + "\n");
                break;
            }
            memoryCountLoop();
        }
    }

    public static void memoryCountLoop() throws InterruptedException {
        memoryList = new ArrayList<>();
        memoryList = driver.findElements(By.xpath(locator.getProperty("eachButton")));
        memorySize = memoryList.size();
        memoryCounter = storageSize;
        for (int l = storageSize; l < memorySize; l++) { //loop for reading memory element text
            memoryCounter++;
            if (memoryCounter <= memorySize) {
                memoryList = driver.findElements(By.xpath(locator.getProperty("eachButton")));
                Thread.sleep(300);
                memoryList.get(l).click();
                System.out.print("------Memory " + (l + 1 - storageSize) + ". " + memoryList.get(l).getText());
                Thread.sleep(100);
                driver.findElement(By.xpath(locator.getProperty("doneButton"))).click();
                Thread.sleep(2000);
                yesAndPrintPrice();
            } else {
                System.out.println("out of memory count loop, \nMemoryCounter count=" + memoryCounter + "\n");
                System.out.println("storageCounter +1");
                memoryCounter = 0;
                storageCounter = 0;

            }
        }
    }

    public static void yesAndPrintPrice() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        while (true) { // clicking Yes button until its available
            try {
//                js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(locator.getProperty("yesButton"))));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                driver.findElement(By.xpath(locator.getProperty("yesButton"))).click();
            } catch (Exception e) {
                if (e.getMessage().contains("Unable to locate element")) {
                    break;
                } else {
                    throw e;
                }
            }
        }
        String priceProduct = driver.findElement(By.xpath(locator.getProperty("priceText"))).getText();
        System.out.println(":- PRICE: " + priceProduct);
        System.out.println();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElements(By.xpath(locator.getProperty("selectOption"))).get(0).click(); //temp for first product only
        if(processorCounter>processorSize && storageCounter>storageSize && memoryCounter>memorySize) {
            productCounter++;
            if (productCounter <= productSize) {
                tempProductLoop();
                processorCountLoop();
            }
            else{
                System.out.println("Product list ends.\n"+"Total Products: "+productSize+"\nTotal products verified: "+(productCounter-1));
            }
        }
        else {
            reopenTillMemory();
        }


//check all counters
    }

    public static void reopenTillMemory() throws InterruptedException {
        driver.findElements(By.xpath(locator.getProperty("eachButton"))).get(processorCounter - 1).click();
        Thread.sleep(500);
        driver.findElements(By.xpath(locator.getProperty("eachButton"))).get(storageCounter - 1).click();
    }

}

