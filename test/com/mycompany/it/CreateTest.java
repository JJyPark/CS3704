package com.mycompany.it;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Jason You
 * Created: April 19, 2017
 * @author Justin Park
 * Updated: April 20, 2017
 * @author Chris Hill
 * Updated: April 21, 2017
 */
public class CreateTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        String driverLocation = System.getProperty("user.dir");
        String osName = System.getProperty("os.name").toLowerCase();
        
        if (osName.contains("win")) {
            driverLocation += "\\test\\testdriver\\chromedriver.exe";
        }
        else if (osName.contains("nix") || osName.contains("nux")) {
            driverLocation += "/test/testdriver/chromedriver";
        }
        
        System.setProperty("webdriver.chrome.driver", driverLocation);
        driver = new ChromeDriver();
        
        baseUrl = "http://localhost:8080/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testCreate() throws Exception {
        
        driver.get(baseUrl + "CS3704/faces/index.xhtml");
        
        driver.findElement(By.id("JobLink")).click();
        driver.findElement(By.id("JobAppListForm:datalist:createButton")).click();
        driver.findElement(By.id("JobAppCreateForm:company")).clear();
        driver.findElement(By.id("JobAppCreateForm:company")).sendKeys("VT");
        driver.findElement(By.id("JobAppCreateForm:position")).clear();
        driver.findElement(By.id("JobAppCreateForm:position")).sendKeys("Internship");
        driver.findElement(By.id("JobAppCreateForm:location")).clear();
        driver.findElement(By.id("JobAppCreateForm:location")).sendKeys("Blacksburg");
        driver.findElement(By.id("JobAppCreateForm:typeOfWork")).clear();
        driver.findElement(By.id("JobAppCreateForm:typeOfWork")).sendKeys("SDE");
        driver.findElement(By.id("JobAppCreateForm:create")).click();
        
        // Need to click twice to sort id in descending order to get the most
        // recently added job application  
        WebElement sortID = driver.findElement(By.id("JobAppListForm:datalist:sortByIDButton"));
        sortID.click();
        sortID.click();
        // Required to wait due to how DOM elements may be deleted and re-added
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody[@id='JobAppListForm:datalist_data']/tr/td[3]")));
        assertEquals("VT", driver.findElement(By.xpath("//tbody[@id='JobAppListForm:datalist_data']/tr/td[3]")).getText());
        assertEquals("Internship", driver.findElement(By.xpath("//tbody[@id='JobAppListForm:datalist_data']/tr/td[4]")).getText());
        assertEquals("Blacksburg", driver.findElement(By.xpath("//tbody[@id='JobAppListForm:datalist_data']/tr/td[5]")).getText());
        assertEquals("SDE", driver.findElement(By.xpath("//tbody[@id='JobAppListForm:datalist_data']/tr/td[6]")).getText());
        
        // Deleting the test job application
        driver.findElement(By.cssSelector("[data-ri='" + 0 + "']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("JobAppListForm:datalist:deleteButton")));
        driver.findElement(By.id("JobAppListForm:datalist:deleteButton")).click();
        driver.findElement(By.id("JobAppListForm:datalist:delete")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
