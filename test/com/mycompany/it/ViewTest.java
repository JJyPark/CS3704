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

public class ViewTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jason\\Documents\\NetBeansProjects\\CS3704\\web\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://localhost:8080/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testView() throws Exception {
        driver.get(baseUrl + "CS3704/faces/index.xhtml");
        driver.findElement(By.id("JobLink")).click();
        driver.findElement(By.xpath("//tbody[@id='JobAppListForm:datalist_data']/tr/td[3]")).click();
        driver.findElement(By.id("JobAppListForm:datalist:viewButton")).click();
        assertEquals("930", driver.findElement(By.cssSelector("span[title=\"Time\"]")).getText());
        assertEquals("VT", driver.findElement(By.cssSelector("span[title=\"Company\"]")).getText());
        assertEquals("SDE", driver.findElement(By.cssSelector("span[title=\"Position\"]")).getText());
        assertEquals("Blacksburg", driver.findElement(By.cssSelector("span[title=\"Location\"]")).getText());
        assertEquals("SDE", driver.findElement(By.cssSelector("span[title=\"Type Of Work\"]")).getText());
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
