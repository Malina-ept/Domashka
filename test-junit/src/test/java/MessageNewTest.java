import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessageNewTest {
    protected static WebDriver driver;
    private final Logger logger = LogManager.getLogger(SampleTest.class);
    // private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
    }

    @Test
    public void checkMessage() throws InterruptedException {
        By button = By.xpath("//button[contains(text(),'Change message')]");
        By alert = By.xpath("//ngb-alert[contains(text(), 'Message successfully changed')]");
        final String URL = "https://ng-bootstrap.github.io/#/components/alert/examples";

        driver.get(URL);
        getElement(button).click();
        String messageFirst = getElement(alert).getText();

        Thread.sleep(1500);

        getElement(button).click();
        String messageSecond = getElement(alert).getText();

        Assert.assertNotEquals(messageFirst, messageSecond);


    }

    private WebElement getElement(By locator) {
        return new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}