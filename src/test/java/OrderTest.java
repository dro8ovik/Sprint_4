import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pageObject.MainPage;
import pageObject.ClientDataPage;
import pageObject.OrderDataPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String dateOrder;
    private final String period;
    private final String color;
    private final String comment;
    private WebDriver driver;

    public OrderTest(String name, String surname, String address, String metroStation, String phoneNumber, String dateOrder, String period, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.dateOrder = dateOrder;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Спанч", "Боб", "Бикини Боттом", "Черкизовская", "89607050166", "01.09.2022", "сутки", "чёрный жемчуг", "Вы готовы дети?"},
                {"Инна", "Дробовик", "Подковырова 14", "Черкизовская", "89607050100", "01.09.2022", "двое суток", "серая безысходность", "Домофон не работает"},
        };
    }

    @Before
    public void setup() {
        driver = Driver.setDriver("chrome");
    }


    @Test
    public void happyPassOrderTest() {
        driver.get("https://qa-scooter.praktikum-services.ru");
        MainPage mainPage = new MainPage(driver);
        mainPage.closeCookiesNotification();
        ClientDataPage clientDataPage = mainPage.pressPageOrderButton();
        clientDataPage.setName(name);
        clientDataPage.setSurname(surname);
        clientDataPage.setClientAddress(address);
        clientDataPage.setClientMetroStation(metroStation);
        clientDataPage.setClientPhoneNumber(phoneNumber);
        OrderDataPage orderDataPage = clientDataPage.goNextPage();
        orderDataPage.setDateOrder(dateOrder);
        orderDataPage.setDaysForRent(period);
        orderDataPage.setColor(color);
        orderDataPage.setCommentForTheCourier(comment);
        orderDataPage.pressPageOderButton();
        orderDataPage.confirmOrder();
        assertTrue("Сообщение об успешном заказе отсутствует", orderDataPage.isSuccessOrderNotification());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

