import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pageObject.MainPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class FAQTest {

    private WebDriver driver;
    private final int index;

    public FAQTest(int index) {
        this.index = index;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {0},
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7}
        };
    }

    @Test
    public void openAnswersForFAQTest(){
        driver = Driver.setDriver("chrome");
        driver.get("https://qa-scooter.praktikum-services.ru");
        MainPage mainPage = new MainPage(driver);
        mainPage.closeCookiesNotification();
        mainPage.scrollToFAQ();
        mainPage.clickQuestionByIndex(index);
        assertTrue(mainPage.isDisplayedAnswerByIndex(index));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
