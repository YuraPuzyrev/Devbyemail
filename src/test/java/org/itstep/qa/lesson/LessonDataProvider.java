package org.itstep.qa.lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LessonDataProvider {

    WebDriver driver;

    @BeforeClass
    public void initSetDriver(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void closeBrowser(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test(dataProvider = "testValue", dataProviderClass = DataValue.class)
    public void testLesson(String get, String check) {
        driver.navigate().to("https://dev.by/registration");
        WebElement pageHeader = driver.findElement(By.cssSelector(".header-logo"));
        Assert.assertTrue(pageHeader.isDisplayed(), "Окно регистрации не открывается");
        WebElement email = driver.findElement(By.id("user_email"));
        Assert.assertTrue(email.isDisplayed(), "Поле емейла не отображается");
        email.sendKeys(get);
        if (get.equals("test@test.ru")) {
            System.out.println("Позитивный тест пройден!");
        } else {
            WebElement formError = driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[4]/div/div/div/div[1]"));
            Assert.assertTrue(formError.isDisplayed(), "Ошибка поля емейла не отображается");
            Assert.assertEquals(check + "* Неверный формат email", formError.getText());
        }
    }
}
