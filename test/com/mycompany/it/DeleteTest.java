package com.mycompany.it;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\test\\testdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://localhost:8080/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testDelete() throws Exception {
        driver.get(baseUrl + "CS3704/faces/index.xhtml");
        driver.findElement(By.id("JobLink")).click();
        driver.findElement(By.xpath("//tbody[@id='JobAppListForm:datalist_data']/tr/td[4]")).click();
        driver.findElement(By.id("JobAppListForm:datalist:deleteButton")).click();
        driver.findElement(By.id("JobAppListForm:datalist:delete")).click();
        assertEquals("No records found.", driver.findElement(By.cssSelector("tr.ui-widget-content.ui-datatable-empty-message > td")).getText());
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
