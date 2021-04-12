import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class lesson3 {

    private Logger logger = LogManager.getLogger(lesson3.class);
    protected static WebDriver driver;

    @BeforeMethod
    public void StartUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
    }

    @AfterMethod
    public void End(){
        if (driver!=null)
            driver.quit();
    }

    @Test
    public void LogExample(){
        logger.info("Тест старт");
    }

    @Test
    public void WebDriverTest(){
        driver.get("https://otus.ru");
        logger.info("Сайт открыт");
    }
}


