import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.ClientDataPage;
import pageObject.MainPage;

import static org.junit.Assert.assertTrue;

public class HeaderTest {
    private WebDriver driver;
    @Before
    public void setup() {
        driver = Driver.setDriver("chrome");
    }

    @Test
    public void headerOrderButtonTest() {
        driver.get("https://qa-scooter.praktikum-services.ru");
        MainPage mainPage = new MainPage(driver);
        mainPage.closeCookiesNotification();
        ClientDataPage clientDataPage = mainPage.pressHeaderOrderButton();
        assertTrue(clientDataPage.isClientDataPageOpened());
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
