package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    public void clickQuestionByIndex(int index) {
        driver.findElements(question).get(index).click();
    }

    public void closeCookiesNotification() {
        driver.findElement(closeCookiesNotificationButton).click();
    }

    public boolean isDisplayedAnswerByIndex(int index) {
        return driver.findElements(By.xpath("//*[not(@hidden) and @id='accordion__panel-" + index + "']")).size() == 1;
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

