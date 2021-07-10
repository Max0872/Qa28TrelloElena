
package com.max.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTrelloTests {
    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        // Capabilities caps = new DesiredCapabilities();
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.get("https://trello.com");
    }


    @Test
    public void loginTest() throws InterruptedException {
//clickOnLoginButton
        // wd.findElement(By.xpath("//a[@href='/login']")).click();
        click(By.xpath("//a[@href='/login']"));

        //fillLoginForm
//        click(By.xpath("//*[@name='user']"));
//        wd.findElement(By.xpath("//*[@name='user']")).clear();
//        wd.findElement(By.xpath("//*[@name='user']")).sendKeys("rochman.elena@gmail.com");

        type(By.xpath("//*[@name='user']"), "maxmay0872@gmail.com");

        Thread.sleep(2000);
        // wd.findElement(By.xpath("//input[@id='login']")).click();
        click(By.xpath("//input[@id='login']"));

//        click(By.xpath("//*[@name='password']"));
//        wd.findElement(By.xpath("//*[@name='password']")).clear();
//        wd.findElement(By.xpath("//*[@name='password']")).sendKeys("12345.com");
        type(By.xpath("//*[@name='password']"), "rfrnec12");

        //confirmLogin
        click(By.xpath("//button[@id='login-submit']"));

        new WebDriverWait(wd, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//ul[@class = 'boards-page-board-section-list']")));
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void type(By locator, String text){
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
}