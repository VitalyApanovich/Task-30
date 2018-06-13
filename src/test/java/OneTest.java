import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OneTest {
    private static final String LOGIN = "EugenBorisik";
    private static final String PASS = "qwerty12345";
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("acceptInsecureCerts", true);
        driver = new ChromeDriver(caps);
        driver.get(LoginPage.URL);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void testOneTest() {
        LoginPage.login(driver, LOGIN, PASS);
        Assert.assertTrue(driver.findElement(HomePage.HOME_MENU).isDisplayed(), "Home Menu is not displayed");
    }

}
