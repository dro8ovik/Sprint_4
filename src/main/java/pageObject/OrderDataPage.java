package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderDataPage {
    private final By header = By.xpath("//*[text()='Про аренду']");
    //локатор поля когда привезти самокат
    private final By dateOrder = By.xpath("//*[@placeholder =\"* Когда привезти самокат\"]");
    //локатор срок аренды
    private final By rentalPeriod = By.xpath("//*[text()='* Срок аренды']");
    //локатор для комментария курьеру
    private final By commentForTheCourier = By.xpath("//*[@placeholder =\"Комментарий для курьера\"]");
    //локатор кнопки заказать внизу страницы
    private final By pageOrderButton = By.xpath("(//*[text()='Заказать'])[2]");

    //локатор кнопки Да
    private final By yesButton = By.xpath("//*[text()='Да']");
    private final By successOrderNotification = By.xpath("//*[text()='Заказ оформлен']");

    private final WebDriver driver;

    public OrderDataPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setDateOrder(String date) {
        driver.findElement(dateOrder).click();
        driver.findElement(dateOrder).sendKeys(date);
        driver.findElement(header).click();
    }

    public void setDaysForRent(String period) {
        driver.findElement(rentalPeriod).click();
        driver.findElement(By.xpath("//*[contains(text(), '" + period + "')]")).click();
    }

    public void setColor(String color) {
        driver.findElement(By.xpath("//*[contains(text(), '" + color + "')]")).click();
    }

    public void setCommentForTheCourier(String text) {
        driver.findElement(commentForTheCourier).sendKeys(text);
    }

    public void pressPageOderButton() {
        driver.findElement(pageOrderButton).click();
    }

    public void confirmOrder() {
        driver.findElement(yesButton).click();
    }

    public boolean isSuccessOrderNotification() {
        return driver.findElements(successOrderNotification).size() == 1;
    }
}
