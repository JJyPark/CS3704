package com.mycompany.it;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jason\\Documents\\NetBeansProjects\\CS3704\\web\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://localhost:8080/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testCreate() throws Exception {
        driver.get(baseUrl + "CS3704/faces/index.xhtml");
        driver.findElement(By.id("JobLink")).click();
        driver.findElement(By.id("JobAppListForm:datalist:createButton")).click();
        driver.findElement(By.id("JobAppCreateForm:time")).clear();
        driver.findElement(By.id("JobAppCreateForm:time")).sendKeys("930");
        driver.findElement(By.id("JobAppCreateForm:company")).clear();
        driver.findElement(By.id("JobAppCreateForm:company")).sendKeys("VT");
        driver.findElement(By.id("JobAppCreateForm:j_idt65")).click();
        driver.findElement(By.id("JobAppCreateForm:position")).clear();
        driver.findElement(By.id("JobAppCreateForm:position")).sendKeys("SDE");
        driver.findElement(By.id("JobAppCreateForm:location")).clear();
        driver.findElement(By.id("JobAppCreateForm:location")).sendKeys("Blacksburg");
        driver.findElement(By.id("JobAppCreateForm:typeOfWork")).clear();
        driver.findElement(By.id("JobAppCreateForm:typeOfWork")).sendKeys("SDE");
        driver.findElement(By.id("JobAppCreateForm:create")).click();
        assertEquals("930", driver.findElement(By.xpath("//tbody[@id='JobAppListForm:datalist_data']/tr/td[2]")).getText());
        assertEquals("VT", driver.findElement(By.xpath("//tbody[@id='JobAppListForm:datalist_data']/tr/td[3]")).getText());
        assertEquals("SDE", driver.findElement(By.xpath("//tbody[@id='JobAppListForm:datalist_data']/tr/td[4]")).getText());
        assertEquals("Blacksburg", driver.findElement(By.xpath("//tbody[@id='JobAppListForm:datalist_data']/tr/td[5]")).getText());
        assertEquals("SDE", driver.findElement(By.xpath("//tbody[@id='JobAppListForm:datalist_data']/tr/td[6]")).getText());
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
