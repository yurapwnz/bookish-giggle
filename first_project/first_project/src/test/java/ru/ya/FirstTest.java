package ru.ya;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.util.Set;




public class FirstTest  {



    public ChromeDriver driver;
    @Before
    public void setUP() {
        System.setProperty("webdriver.chrome.driver","/Users/Taihan/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void first_project() {


        driver.get("https://yandex.ru/");








        WebElement input = driver.findElement(By.id("text"));
        input.sendKeys("росэлторг");
        WebElement button1 = driver.findElement(By.tagName("button"));
        button1.click();


        //String originalWindow = driver.getWindowHandle();
        final Set<String> oldWindowsSet = driver.getWindowHandles();


        WebElement roseltorg = driver.findElement(By.linkText("Roseltorg.ru"));
        roseltorg.click();

        String newWindow = (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set<String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );

        driver.switchTo().window(newWindow);
        WebElement reg = driver.findElement(By.xpath("/html/body/div[1]/header/div/div/button[1]"));
        reg.click();
        WebElement sup = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/a[2]"));
        sup.click();
        WebElement edin = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div/div[2]/a"));
        edin.click();
        System.out.println("Page title is: " + driver.getCurrentUrl());







            }






        //driver.switchTo().window(originalWindow);
        //System.out.println("Old window title: " + driver.getTitle());


    @After public void q() {
    driver.quit();
}


    }



















