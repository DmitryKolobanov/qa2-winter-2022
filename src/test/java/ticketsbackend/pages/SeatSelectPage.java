package ticketsbackend.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import ticketsbackend.BaseFunc;
import org.openqa.selenium.By;

import java.util.List;

public class SeatSelectPage {
    private final By SEAT = By.xpath(".//div[@class = 'seat']");
    private final By SEAT_BOOKED = By.xpath(".//div[@id  = 'book']//div[@class = 'line']");
    private final By BOOK_LAST_BTN = By.id("book3");
    private BaseFunc baseFunc;

    public SeatSelectPage(BaseFunc baseFunc) {

        this.baseFunc = baseFunc;
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
