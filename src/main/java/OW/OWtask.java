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
    public static Properties config;
    public static List<WebElement> product;
    public static List<WebElement> storageList;
    public static List<WebElement> memoryList;
    public static List<WebElement> processorList;
    public static WebDriver driver;
    public static int processorSize = 0, storageSize = 0, productSize = 0, memorySize = 0, totalSize = 0;
    public static int memoryCounter = 0, storageCounter = 0, processorCounter = 0, productCounter = 0, totalCounter = 0;

    public static void main(String[] args) throws IOException, InterruptedException {
//  load all resource bundles
        locator = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/OW/locators.properties");
        locator.load(fis);
        config = new Properties();
        FileInputStream con = new FileInputStream("src/main/java/OW/config.properties");
        config.load(con);

//  Webdriver Launch
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(config.getProperty("URL"));
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
        product = driver.findElements(By.xpath(locator.getProperty("productList")));
        productSize = product.size();
        if (productCounter < productSize) {
//            product = driver.findElements(By.xpath(locator.getProperty("productList")));
            System.out.println("S.no " + (productCounter + 1) + " PRODUCT NAME: " + product.get(productCounter).getText());

            driver.findElements(By.xpath(locator.getProperty("selectOption"))).get(productCounter).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        } else {
            System.out.println("All product under given Category>>Brand are covered." + "\n Total product searched: " + productCounter);
            driver.quit();
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

        totalSize = processorSize * (storageSize - processorSize) * (memorySize - storageSize); //calc size to break loop according

        memoryCounter = storageSize;
        for (int l = storageSize; l < memorySize; l++) {
            //loop for reading memory element text
            memoryCounter++;
            totalCounter++;
            System.out.println("total counter - "+totalCounter);
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
//   Else- reset the counter of memory and storage
                memoryCounter = 0;
                storageCounter = 0;
            }
            if (totalCounter >= totalSize) {
                System.out.println("totalCounter==totalSize");
                productCounter++;
                processorSize = 0; storageSize = 0; productSize = 0; memorySize = 0; totalSize = 0;
                memoryCounter = 0; storageCounter = 0; processorCounter = 0; totalCounter = 0;

                driver.findElement(By.xpath(".//button[text()=\"Cancel\"]")).click();
                tempProductLoop();
                processorCountLoop();
            }
        }
    }

    public static void yesAndPrintPrice() throws InterruptedException {
        while (true) { // clicking Yes button until its available
            try {
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
        System.out.println(" :-PRICE:" + priceProduct);
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElements(By.xpath(locator.getProperty("selectOption"))).get(productCounter).click();
        reopenTillMemory();
    }

    public static void reopenTillMemory() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElements(By.xpath(locator.getProperty("eachButton"))).get(processorCounter - 1).click();
        Thread.sleep(500);
        driver.findElements(By.xpath(locator.getProperty("eachButton"))).get(storageCounter - 1).click();
    }

}

