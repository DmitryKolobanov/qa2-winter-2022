package ticketsbackend.pages;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.std.NumberSerializer;
import io.cucumber.java.eo.Se;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import ticketsbackend.BaseFunc;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Objects;

public class SeatSelectPage {
    private final By SEAT = By.xpath(".//div[@class = 'seat']");
    private final By SEAT_BOOKED = By.xpath(".//div[@id  = 'book']//div[@class = 'line']");
    private final By BOOK_LAST_BTN = By.id("book3");
    private int seatPosition = 10;
    private BaseFunc baseFunc;

    public SeatSelectPage(BaseFunc baseFunc) {

        this.baseFunc = baseFunc;
    }

    public String getSeatNumber() {
        baseFunc.waitForElementsCountToBe(SEAT, 32);
        return baseFunc.findElements(SEAT).get(seatPosition).getText();
    }

    public void clickSelectedSeat() {
        baseFunc.waitForElementsCountToBe(SEAT, 32);
        baseFunc.findElements(SEAT).get(seatPosition).click();
    }

    public void clickSeatByNumber(String seatNumber) {
        baseFunc.waitForElementsCountToBe(SEAT, 32);
        List<WebElement> Seats = baseFunc.findElements(SEAT);
        boolean isSeatFound = false;
        for (WebElement we : Seats) {
            if (we.getText().equals(seatNumber)) {
                isSeatFound = true;
                we.click();
                break;
            }
        }
        Assertions.assertTrue(isSeatFound, "Seat not available!");
    }

    public String getSelectedSeat() {
        return baseFunc.findElement(SEAT_BOOKED).getText().substring(14);
    }

    public void clickLastBook() {
        baseFunc.findElement(BOOK_LAST_BTN);
        baseFunc.click(BOOK_LAST_BTN);              //proceed to final page
    }

}
