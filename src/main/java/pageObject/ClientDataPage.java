package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClientDataPage {

    private final By header = By.xpath("//*[text()='Для кого самокат']");
    private final By clientName = By.xpath("//*[@placeholder =\"* Имя\"]");
    //локатор поля фамилия клиента
    private final By clientSurname = By.xpath("//*[@placeholder =\"* Фамилия\"]");
    //локатор адрес доставки
    private final By clientAddress = By.xpath("//*[@placeholder =\"* Адрес: куда привезти заказ\"]");
    //локатор станции метро
    private final By clientMetroStation = By.className("select-search__input");
    //локатор телефона клиента
    private final By clientPhoneNumber = By.xpath("//*[@placeholder =\"* Телефон: на него позвонит курьер\"]");
    //локатор кнопки далее
    private final By nextButton = By.xpath("//*[text()='Далее']");

    private final WebDriver driver;

    public ClientDataPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(clientName).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(clientSurname).sendKeys(surname);
    }

    public void setClientAddress(String address) {
        driver.findElement(clientAddress).sendKeys(address);
    }

    public void setClientMetroStation(String metroStation) {
        driver.findElement(clientMetroStation).click();
        driver.findElement(By.xpath("//*[contains(text(), '" + metroStation + "')]")).click();
    }

    public void setClientPhoneNumber(String phoneNumber) {
        driver.findElement(clientPhoneNumber).sendKeys(phoneNumber);
    }

    public OrderDataPage goNextPage() {
        driver.findElement(nextButton).click();
        return new OrderDataPage(driver);
    }

    public boolean isClientDataPageOpened() {
        return driver.findElements(header).size() == 1;
    }
}

