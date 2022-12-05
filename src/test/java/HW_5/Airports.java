package HW_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Airports {
    private final By FROM = By.id("afrom");
    private final By TO = By.id("bfrom");
    private final By GO_BTN = By.xpath(".//span[@class = 'gogogo']");
    private final By GET_PRICE_BTN = By.xpath(".//span[@onclick = 'setLang();']");
    private final By DATA_ON_FORM = By.xpath(".//span[@class = 'bTxt']");
    private final By DATA_AFTER_PRICES = By.xpath(".//div[@id = 'response']//span[@class = 'bTxt']");
    private final By BOOK_BTN = By.id("book2");
    private final By BOOK_LAST_BTN = By.id("book3");
    private final By FIRST_NAME = By.id("name");
    private final By LAST_NAME = By.id("surname");
    private final By DISCOUNT = By.id("discount");
    private final By ADULTS = By.id("adults");
    private final By CHILDREN = By.id("children");
    private final By BAG = By.id("bugs");
    private final By FLIGHT = By.id("flight");

    private WebDriver browser;
    private WebDriverWait wait;
    String name;
    String startPoint;
    String endPoint;
    String paxName;
    String paxNameOnForm;
    String startPointOnForm;
    String endPointOnForm;

    @Test
    public void reservationCheck() {
        System.setProperty("webdriver.chrome.driver", "C://QA2/chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://www.qaguru.lv:8089/tickets//");

        wait = new WebDriverWait(browser, Duration.ofSeconds(10));

//----------------- Test variables -------------

        startPoint = "RIX";
        endPoint = "SFO";
        paxName = "Vasya";

//---------------- Airports select ------------

        select(FROM, startPoint);        //вызов метода select с передачей в него параметров
        select(TO, endPoint);

        browser.findElement(GO_BTN).click();        //proceed to form

//--------------- Checking Airports on Form --------------

        List<WebElement> bookData = browser.findElements(DATA_ON_FORM);

        startPointOnForm = bookData.get(0).getText();
        Assertions.assertEquals(startPoint, startPointOnForm, "Start point on form is not correct!");

        endPointOnForm = bookData.get(1).getText();
        Assertions.assertEquals(endPoint, endPointOnForm, "End point on form is not correct!");

//-------------- Filling book form ----------------

        type(FIRST_NAME, paxName);     //вызов метода type с заполнением полей
        type(LAST_NAME, "Kolobok");
        type(DISCOUNT, "Hacker");
        type(ADULTS, "3");
        type(CHILDREN, "2");
        type(BAG, "1");
        select(FLIGHT, "13");

        browser.findElement(GET_PRICE_BTN).click();  //proceed to prices

// ---------- Checking Airports and Name after perice calculated --------

//        List<WebElement> bookDataPriced = browser.findElements(DATA_AFTER_PRICES);

//        paxNameOnForm = bookDataPriced.get(0).getText();
//        System.out.println(paxNameOnForm);






//        browser.findElement(BOOK_BTN).click();
    }

    private void select(By locator, String value)  {
        WebElement we = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Select select = new Select(we);
        select.selectByValue(value);
    }

    private void type (By locator, String text) {
        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        input.clear();
        input.sendKeys(text);
    }
}
