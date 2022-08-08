package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {
    //локатор любой строки из списка
    private final By question = By.className("accordion__item");
    //локатор кнопки закрытия нотификации о куках
    private final By closeCookiesNotificationButton = By.id("rcc-confirm-button");
    //локатор кнопки заказать в хедере
    private final By headerOrderButton = By.xpath("(//*[text()='Заказать'])[1]");
    //локатор кнопки заказать в середине страницы
    private final By pageOrderButton = By.xpath("(//*[text()='Заказать'])[2]");

        private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToFAQ() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(question));
    }

    public void clickQuestion(String question) {
        driver.findElement(By.xpath("//*[text()='"+question+"']")).click();
    }

    public void closeCookiesNotification() {
        driver.findElement(closeCookiesNotificationButton).click();
    }

    public boolean isDisplayedAnswer(String answer) {
        return driver.findElements(By.xpath("//*[not(@hidden) and text()='"+answer+"']")).size() == 1;
    }

    public ClientDataPage pressHeaderOrderButton(){
        driver.findElement(headerOrderButton).click();
        return new ClientDataPage(driver);

    }

    public ClientDataPage pressPageOrderButton(){
        driver.findElement(pageOrderButton).click();
        return new ClientDataPage(driver);
    }
}

