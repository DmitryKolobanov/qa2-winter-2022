package hw5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private final By SEAT = By.xpath(".//div[@onclick  = 'seat(9)']");
    private final By SEAT_BOOKED = By.xpath(".//div[@id  = 'book']//div[@class = 'line']");
    private final By RESERVATION_COMPLETED = By.xpath(".//div[@class = 'finalTxt']");
    private final By RESPONSE = By.id("response");

    private WebDriver browser;
    private WebDriverWait wait;
    String startPoint;
    String endPoint;
    String paxName;
    String paxNameOnForm;
    String startPointOnForm;
    String endPointOnForm;
    String paxNameToCompare;
    String seatNumber;
    String seatNumberBooked;
    String priceString;

    @Test
    public void reservationCheck() {
        System.setProperty("webdriver.chrome.driver", "C://QA2/chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://www.qaguru.lv:8089/tickets/");

        wait = new WebDriverWait(browser, Duration.ofSeconds(10));

//----------------- Test variables -------------

        startPoint = "RIX";
        endPoint = "SFO";
        paxName = "Vasja";
        paxNameToCompare = paxName + "!";

//---------------- Airports select ------------

        select(FROM, startPoint);
        select(TO, endPoint);

        wait.until(ExpectedConditions.elementToBeClickable(GO_BTN));
        browser.findElement(GO_BTN).click();        //proceed to form

//--------------- Checking Airports on Form --------------

        List<WebElement> bookData = browser.findElements(DATA_ON_FORM);

        startPointOnForm = bookData.get(0).getText();
        Assertions.assertEquals(startPoint, startPointOnForm, "Start point on form is not correct!");

        endPointOnForm = bookData.get(1).getText();
        Assertions.assertEquals(endPoint, endPointOnForm, "End point on form is not correct!");

//-------------- Filling book form ----------------

        type(FIRST_NAME, paxName);
        type(LAST_NAME, "Kolobok");
        type(DISCOUNT, "Hacker");
        type(ADULTS, "3");
        type(CHILDREN, "2");
        type(BAG, "1");
        select(FLIGHT, "13");

        wait.until(ExpectedConditions.elementToBeClickable(GET_PRICE_BTN));
        browser.findElement(GET_PRICE_BTN).click();  //proceed to prices

// ---------- Checking Airports and Name after price calculated --------

        wait.until(ExpectedConditions.presenceOfElementLocated(DATA_AFTER_PRICES));
        List<WebElement> bookDataPriced = browser.findElements(DATA_AFTER_PRICES);

        paxNameOnForm = (bookDataPriced.get(0).getText());
        Assertions.assertEquals(paxNameToCompare, paxNameOnForm, "Pax name on form is not correct!");

        startPointOnForm = (bookDataPriced.get(1).getText());
        Assertions.assertEquals(startPointOnForm, startPoint, "Start point on form is not correct!");

        endPointOnForm = (bookDataPriced.get(2).getText());
        Assertions.assertEquals(endPointOnForm, endPoint, "End point on form is not correct!");

// -------------------- Set price check -----------------

        priceString = browser.findElement(RESPONSE).getText();

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(priceString);

        boolean isPriceFound = false;
        if (m.find()) {                             //only first match needed
            isPriceFound = true;
        }
        Assertions.assertTrue(isPriceFound, "No price set!");

        wait.until(ExpectedConditions.elementToBeClickable(BOOK_BTN));
        browser.findElement(BOOK_BTN).click();  //proceed to seats

// ------------------------ Select seat ------------------------------

        wait.until(ExpectedConditions.presenceOfElementLocated(SEAT));
        seatNumber = browser.findElement(SEAT).getText();
        browser.findElement(SEAT).click();  //selecting seat

// ------------------------ Seat check -------------------------------

        wait.until(ExpectedConditions.presenceOfElementLocated(SEAT_BOOKED));
        seatNumberBooked = browser.findElement(SEAT_BOOKED).getText().substring(14);
        Assertions.assertEquals(seatNumberBooked, seatNumber, "Booked seat number is not correct!");

//---------------- Check if booking is successful --------------------

        wait.until(ExpectedConditions.elementToBeClickable(BOOK_LAST_BTN));
        browser.findElement(BOOK_LAST_BTN).click();  //proceed to book

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(RESERVATION_COMPLETED));
            System.out.println("Reservation is successful. All tests passed!");
        } catch (TimeoutException e) {
            System.out.println("No confirmation message displayed. Test is not passed!");
        }
    }

    private void select(By locator, String value) {
        WebElement we = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Select select = new Select(we);
        select.selectByValue(value);
    }

    private void type(By locator, String text) {
        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        input.clear();
        input.sendKeys(text);
    }

    @AfterEach
    public void closeBrowser() {
        browser.close();
    }
}
