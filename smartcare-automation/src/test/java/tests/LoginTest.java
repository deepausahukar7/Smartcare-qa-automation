package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(
        dataProvider = "loginData",
        dataProviderClass = TestDataProvider.class,
        groups = {"regression"}
    )
    public void verifyLoginWithMultipleData(
            String username,
            String password,
            String expectedResult) {

        // ✅ Ensure we are always on Login page
        driver.get(prop.getProperty("url"));

        LoginPage login = new LoginPage(driver);
        login.login(username, password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        if (expectedResult.equalsIgnoreCase("success")) {

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h6[text()='Dashboard']")
            ));

            Assert.assertTrue(
                driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed(),
                "Dashboard not visible after valid login"
            );

        } else {

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(@class,'oxd-alert-content-text')]")
            ));

            Assert.assertTrue(
                driver.findElement(
                    By.xpath("//p[contains(@class,'oxd-alert-content-text')]")
                ).isDisplayed(),
                "Error message not displayed for invalid login"
            );
        }
    }
}
