package HW_4;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Amazon {
    private final By ACCEPT_COOKIES_BTN = By.id("sp-cc-accept");
    private final By NO_ADDRESS_CHANGE = By.xpath("//span[contains(text(), 'CONTINUE')]/parent::span");
    private final By PROCEED_TO_BEST_SELLERS = By.linkText("Best Sellers");
    private final By PROCEED_TO_BOOKS = By.xpath("//div[@id= 'nav-xshop']/a[text()= 'Books']");

    @Test
    public void amazonBooks() {
        System.setProperty("webdriver.chrome.driver", "C://QA2/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http:///www.amazon.de/");

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));
        browser.findElement(ACCEPT_COOKIES_BTN).click();

        wait.until(ExpectedConditions.elementToBeClickable(NO_ADDRESS_CHANGE));
        browser.findElement(NO_ADDRESS_CHANGE).click();

        wait.until(ExpectedConditions.elementToBeClickable(PROCEED_TO_BEST_SELLERS));
        browser.findElement(PROCEED_TO_BEST_SELLERS).click();

        wait.until(ExpectedConditions.elementToBeClickable(PROCEED_TO_BOOKS));
        browser.findElement(PROCEED_TO_BOOKS).click();

    }
}
