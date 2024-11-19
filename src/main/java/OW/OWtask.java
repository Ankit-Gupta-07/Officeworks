package OW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
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
    public static BufferedWriter wr;
    public static String productName, processorName, storageName, memoryName, tradePrice;
    public static int processorSize = 0, storageSize = 0, productSize = 0, memorySize = 0, totalSize = 0, sno = 1,datafetched=480;
    public static int memoryCounter = 0, storageCounter = 0, processorCounter = 0, productCounter = 19, totalCounter = 0;

    public static void main(String[] args) throws IOException, InterruptedException {
//  load all resource bundles
        locator = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/OW/locators.properties");
        locator.load(fis);
        config = new Properties();
        FileInputStream con = new FileInputStream("src/main/java/OW/config.properties");
        config.load(con);

// Excel
        wr = new BufferedWriter(new FileWriter("Mac.csv",true));
        wr.write("SNO,Product Name,Processor,Storage,RAM,Trade in value");
        wr.newLine();
        wr.close();
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

    public static void tempProductLoop() throws IOException, InterruptedException {
        product = new ArrayList<>();
        product = driver.findElements(By.xpath(locator.getProperty("productList")));
        productSize = product.size();
        if (productCounter < productSize) {
            System.out.println("S.no " + (productCounter + 1) + " PRODUCT NAME: " + product.get(productCounter).getText());
            productName = product.get(productCounter).getText();          //product name stored
            driver.findElements(By.xpath(locator.getProperty("selectOption"))).get(productCounter).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            //To check if product have content or not
            List<WebElement> contentCheck = new ArrayList<>();
            try {
                contentCheck = driver.findElements(By.xpath(locator.getProperty("selectProcessor")));
                Thread.sleep(200);
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
            if (contentCheck.size() == 0) {
                wr = new BufferedWriter(new FileWriter("Mac.csv", true));
                wr.write(sno + "," + productName + "," + "Processor-NO DATA,Storage-NO DATA,RAM-NO DATA,Trade in value-NO DATA");
                wr.newLine();
                wr.close();
                sno++;
                productCounter++;
//  set all other loop counter to zero
                processorSize = 0;
                storageSize = 0;
                productSize = 0;
                memorySize = 0;
                totalSize = 0;
                memoryCounter = 0;
                storageCounter = 0;
                processorCounter = 0;
                totalCounter = 0;
                System.out.println("\nProduct " + productName + " found empty========\n");
                driver.findElement(By.xpath(locator.getProperty("cancel"))).click();
                tempProductLoop();
//                processorCountLoop();
            } // if content check ends
            else {
                totalSizeCalc();
            }
        } else {
            System.out.println("All product under given Category>>Brand are covered." + "\n Total product searched: " + productCounter);
            driver.quit();
        }
    }

    private static void totalSizeCalc() throws InterruptedException {
        processorList = new ArrayList<>();
        processorList = driver.findElements(By.xpath(locator.getProperty("eachButton")));

        for (int a = 0; a < processorList.size(); a++) {
            processorList.get(a).click();
            storageList = new ArrayList<>();
            storageList = driver.findElements(By.xpath(locator.getProperty("eachButton")));
            for (int b = processorList.size(); b < storageList.size(); b++) {
                storageList.get(b).click();
                memoryList = new ArrayList<>();
                memoryList = driver.findElements(By.xpath(locator.getProperty("eachButton")));
                totalSize = totalSize + (memoryList.size() - storageList.size());
            }
        }
        System.out.println("totalSizeCalc size=" + totalSize);
        driver.findElement(By.xpath(locator.getProperty("cancel"))).click();
        Thread.sleep(500);
        driver.findElements(By.xpath(locator.getProperty("selectOption"))).get(productCounter).click();
    }

    public static void processorCountLoop() throws InterruptedException, IOException {
        processorList = new ArrayList<>();
        processorList = driver.findElements(By.xpath(locator.getProperty("eachButton")));
        processorSize = processorList.size();
        for (int j = 0; j < processorSize; j++) {
            processorCounter++;
            if (processorCounter <= processorSize) {
                processorList = driver.findElements(By.xpath(locator.getProperty("eachButton")));
                System.out.println("-Processor " + (j + 1) + ". " + processorList.get(j).getText());
                processorName = processorList.get(j).getText();     //stored processor name to string
                processorList.get(j).click(); //till now user clicked on processor name and then storage fields visible to user
                Thread.sleep(100);
            } else {
                System.out.println("---------------------------------------------------");
            }
            storageCountLoop();
        }
    }

    public static void storageCountLoop() throws InterruptedException, IOException {
        storageList = new ArrayList<>();
        storageList = driver.findElements(By.xpath(locator.getProperty("eachButton")));
        storageSize = storageList.size();
        storageCounter = processorSize;
        for (int k = processorSize; k < storageSize; k++) { //loop to read storage text
            storageCounter++;
            if (storageCounter <= storageSize) {
                storageList = driver.findElements(By.xpath(locator.getProperty("eachButton")));
                System.out.println("---Storage " + (k + 1 - processorSize) + ". " + storageList.get(k).getText());
                storageName = storageList.get(k).getText();     //stored storage name to string
                storageList.get(k).click();//till now user clicked on storage name and now memory field is visible to user
                Thread.sleep(100);
            } else {
                System.out.println("storageCount:" + storageSize + "\n" + "storageCounter:" + storageCounter + "\n");
                break;
            }
            memoryCountLoop();
        }
    }

    public static void memoryCountLoop() throws InterruptedException, IOException {
        memoryList = new ArrayList<>();
        memoryList = driver.findElements(By.xpath(locator.getProperty("eachButton")));
        memorySize = memoryList.size();
        memoryCounter = storageSize;

        for (int l = storageSize; l < memorySize; l++) {
            //loop for reading memory element text
            memoryCounter++;
            totalCounter++;
            System.out.println(", Total Counter - " + totalCounter + " / " + totalSize);
            if (memoryCounter <= memorySize) {
                wr = new BufferedWriter(new FileWriter("Mac.csv", true));
                memoryList = driver.findElements(By.xpath(locator.getProperty("eachButton")));
                Thread.sleep(300);
                memoryList.get(l).click();
                memoryName = memoryList.get(l).getText();     //stored Ram memory to string
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
                processorSize = 0;
                storageSize = 0;
                productSize = 0;
                memorySize = 0;
                totalSize = 0;
                memoryCounter = 0;
                storageCounter = 0;
                processorCounter = 0;
                totalCounter = 0;

                driver.findElement(By.xpath(locator.getProperty("cancel"))).click();
                tempProductLoop();
                processorCountLoop();
            }
        }
    }

    public static void yesAndPrintPrice() throws InterruptedException, IOException {
        while (true) { // clicking Yes button until its available
            try {
                driver.findElement(By.xpath(locator.getProperty("yesButton"))).click();
                Thread.sleep(500);
            } catch (Exception e) {
                if (e.getMessage().contains("Unable to locate element")) {
                    break;
                } else {
                    throw e;
                }
            }
        }
        String priceProduct = driver.findElement(By.xpath(locator.getProperty("priceText"))).getText();
        System.out.print(" :-PRICE:" + priceProduct);
        tradePrice = priceProduct;
        datafetched++;
        System.out.println("  ---Total Data Fetched="+datafetched);

        writeAllData(); //writing to CSV file

        driver.navigate().refresh(); //to move back to product list
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElements(By.xpath(locator.getProperty("selectOption"))).get(productCounter).click();
        reopenTillMemory();
    }

    private static void writeAllData() throws IOException {
        wr = new BufferedWriter(new FileWriter("Mac.csv", true));
        String stringSno = Integer.toString(sno);
        wr.write(stringSno + "," + productName + "," + processorName + "," + storageName + "," + memoryName + "," + tradePrice);
        wr.newLine();
        sno++;
        wr.close();
    }

    public static void reopenTillMemory() throws InterruptedException, IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElements(By.xpath(locator.getProperty("eachButton"))).get(processorCounter - 1).click();
        Thread.sleep(500);
        driver.findElements(By.xpath(locator.getProperty("eachButton"))).get(storageCounter - 1).click();

    }

}




